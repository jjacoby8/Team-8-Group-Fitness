package com.example.GroupFitness.service;

import com.example.GroupFitness.entity.ConfirmationToken;
import com.example.GroupFitness.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository ctRepo;

    public void saveConfirmationToken(ConfirmationToken token) {
        ctRepo.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return ctRepo.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return ctRepo.updateConfirmedAt(token, LocalDateTime.now());
    }
}
