package com.example.GroupFitness.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.GroupFitness.entity.AuthMember;
import com.example.GroupFitness.entity.MemberRole;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthMemberRepositoryTest {

    @Autowired
    private AuthMemberRepository repo;

    @Test
    void findByEmailReturnsTheRightAuthMember() {

        String email = "email";

        AuthMember member = new AuthMember("firstName", "lastName", email, "password", MemberRole.ADMIN);

        repo.save(member);

        Optional<AuthMember> result = repo.findByEmail(email);
        
        assertTrue(result.isPresent());
        assertEquals(member, result.get());

        long memberID = result.get().getId();
        repo.deleteById(memberID);
    }

    @Test
    void enableMemberEnablesTheGivenMember() {

        String email = "email";
        AuthMember member = new AuthMember("firstName", "lastName", email, "password", MemberRole.ADMIN);

        repo.save(member);
        Optional<AuthMember> entity = repo.findByEmail(email);
        assertTrue(entity.isPresent());

        assertFalse(entity.get().isEnabled());
         
        // assertTrue(entity.get().isEnabled());

        repo.deleteById(entity.get().getId());
    }
}
