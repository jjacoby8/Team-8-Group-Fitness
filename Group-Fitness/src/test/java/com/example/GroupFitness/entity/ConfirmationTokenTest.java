package com.example.GroupFitness.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ConfirmationTokenTest {

    @Test
    void testGetAuthMember() {

        AuthMember am = new AuthMember(); 
            am.setId((long) 1);

        ConfirmationToken ct = new ConfirmationToken();
            ct.setAuthMember(am);

        assertEquals(am, ct.getAuthMember());
    }

    @Test
    void testGetConfirmedAt() {

        LocalDateTime ldt = LocalDateTime.now();

        ConfirmationToken ct = new ConfirmationToken();
            ct.setConfirmedAt(ldt);

        assertEquals(ldt, ct.getConfirmedAt());
    }

    @Test
    void testGetCreatedAt() {

        LocalDateTime ldt = LocalDateTime.now();

        ConfirmationToken ct = new ConfirmationToken();
            ct.setCreatedAt(ldt);

        assertEquals(ldt, ct.getCreatedAt());
    }

    @Test
    void testGetExpiresAt() {

        LocalDateTime ldt = LocalDateTime.now();

        ConfirmationToken ct = new ConfirmationToken();
            ct.setExpiresAt(ldt);

        assertEquals(ldt, ct.getExpiresAt());
    }

    @Test
    void testGetId() {

        long id = 1;

        ConfirmationToken ct = new ConfirmationToken();
            ct.setId(id);

        assertEquals(id, ct.getId());
    }

    @Test
    void testGetToken() {

        String tkn = "token";

        ConfirmationToken ct = new ConfirmationToken();
            ct.setToken(tkn);

        assertEquals(tkn, ct.getToken());
    }

    @Test
    void testSetAuthMember() {

        AuthMember targetAM = new AuthMember();
            targetAM.setId((long) 1);
        AuthMember originalAM = new AuthMember();
            targetAM.setId((long) 0);
        ConfirmationToken ct = new ConfirmationToken();
            ct.setAuthMember(originalAM);

        assertNotEquals(targetAM, ct.getAuthMember());

        ct.setAuthMember(targetAM);

        assertEquals(targetAM, ct.getAuthMember());
    }

    @Test
    void testSetConfirmedAt() {

        LocalDateTime original = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.now().minusDays((long) 1);

        ConfirmationToken ct = new ConfirmationToken();
            ct.setConfirmedAt(original);

        assertNotEquals(target, ct.getConfirmedAt());

        ct.setConfirmedAt(target);

        assertEquals(target, ct.getConfirmedAt());
    }

    @Test
    void testSetCreatedAt() {

        LocalDateTime original = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.now().minusDays((long) 1);

        ConfirmationToken ct = new ConfirmationToken();
            ct.setCreatedAt(original);

        assertNotEquals(target, ct.getCreatedAt());

        ct.setCreatedAt(target);

        assertEquals(target, ct.getCreatedAt());
    }

    @Test
    void testSetExpiresAt() {

        LocalDateTime original = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.now().minusDays((long) 1);

        ConfirmationToken ct = new ConfirmationToken();
            ct.setExpiresAt(original);

        assertNotEquals(target, ct.getExpiresAt());

        ct.setExpiresAt(target);

        assertEquals(target, ct.getExpiresAt());
    }

    @Test
    void testSetId() {
        
        ConfirmationToken ct = new ConfirmationToken();
            ct.setId((long) 0);
        long targetID = 1;

        assertNotEquals(targetID, ct.getId());

        ct.setId(targetID);

        assertEquals(targetID, ct.getId());
    }

    @Test
    void testSetToken() {

        ConfirmationToken ct = new ConfirmationToken();
            ct.setToken("token");
        String target = "tkn";

        assertNotEquals(target, ct.getToken());

        ct.setToken(target);

        assertEquals(target, ct.getToken());
    }
}
