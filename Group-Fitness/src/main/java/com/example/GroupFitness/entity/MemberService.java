package com.example.GroupFitness.entity;

import com.example.GroupFitness.registration.token.ConfirmationToken;
import com.example.GroupFitness.registration.token.ConfirmationTokenRepository;
import com.example.GroupFitness.registration.token.ConfirmationTokenService;
import com.example.GroupFitness.repository.MemberRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found.";
    private final static String USER_TAKEN_MSG = "User with email %s already exists.";

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;

    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return memberRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
    public String signUpMember(Member member){
        boolean memberExists = memberRepository
                .findByEmail(member.getEmail())
                .isPresent();
        if(memberExists){
            throw new IllegalStateException(String.format(USER_TAKEN_MSG, member.getEmail()));
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(member.getPassword());
        member.setPassword(encodedPassword);

        memberRepository.save(member);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                member
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return token;
    }

    public int enableMember(String email){
        return memberRepository.enableMember(email);
    }
}
