package com.example.GroupFitness.service;

import com.example.GroupFitness.entity.AuthMember;
import com.example.GroupFitness.entity.ConfirmationToken;
import com.example.GroupFitness.repository.AuthMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthMemberService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found.";
    private final static String USER_TAKEN_MSG = "User with email %s already exists.";

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthMemberRepository amRepo;

    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return amRepo.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpMember(AuthMember authMember) {
        boolean memberExists = amRepo.findByEmail(authMember.getEmail()).isPresent();
        if (memberExists) {
            throw new IllegalStateException(String.format(USER_TAKEN_MSG, authMember.getEmail()));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(authMember.getPassword());
        authMember.setPassword(encodedPassword);

        amRepo.save(authMember);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken (
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                authMember
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableMember(String email) {
        return amRepo.enableMember(email);
    }
}
