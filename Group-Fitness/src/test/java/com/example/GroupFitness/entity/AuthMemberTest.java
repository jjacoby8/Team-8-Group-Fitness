package com.example.GroupFitness.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthMemberTest {

    // Getters

    @Test
    void getEmailReturnsRightEmail() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        
        assertEquals("email", entity.getEmail());
    }

    @Test
    void getUsernameReturnsRightUsername() {
        
        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        
        assertEquals("email", entity.getUsername());
    }

    @Test
    void getIdReturnsRightId() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);

        assertEquals((long) 0, entity.getId());
    }

    @Test
    void getFirstNameReturnsRightFirstName() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        
        assertEquals("fn", entity.getFirstName());
    }

    @Test
    void getLastNameReturnsRightLastName() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        
        assertEquals("ln", entity.getLastName());
    }

    @Test
    void getMemberRoleReturnsRightMemberRole() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        
        assertEquals(MemberRole.USER, entity.getMemberRole());
    }

    @Test
    void getPasswordReturnsRightPassword() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        
        assertEquals("password", entity.getPassword());
    }

    @Test
    void isAccountNonLockedReturnsTrueForNonLockedAccount() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        
        assertTrue(entity.isAccountNonLocked());
    }

    @Test
    void isAccountEnabledReturnsTrueForEnabledAccount() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, true);
        
        assertTrue(entity.isEnabled());
    }

    @Test
    void isAccountLockedReturnsFalseForNotLockedAccount() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);

        assertFalse(entity.isLocked());
    }

    // Setters

    @Test
    void setIdChangesTheIdToTargetId() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        long targetID = 1;

        assertNotEquals(targetID, entity.getId());

        entity.setId(targetID);

        assertEquals(targetID, entity.getId());
    }

    @Test
    void setFirstNameChangesTheFirstNameToTargetFirstName() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        String firstName = "firstName";

        assertNotEquals(firstName, entity.getFirstName());

        entity.setFirstName(firstName);

        assertEquals(firstName, entity.getFirstName());
    }

    @Test
    void setLastNameChangesTheLastNameToTargetLastName() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        String lastName = "lastName";

        assertNotEquals(lastName, entity.getLastName());

        entity.setLastName(lastName);

        assertEquals(lastName, entity.getLastName());
    }

    @Test
    void setEmailChangesTheEmailToTargetEmail() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        String email = "email@fake.com";

        assertNotEquals(email, entity.getEmail());

        entity.setEmail(email);

        assertEquals(email, entity.getEmail());
    }

    @Test
    void setPasswordChangesThePasswordToTargetPassword() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        String password = "pwd";

        assertNotEquals(password, entity.getPassword());

        entity.setPassword(password);

        assertEquals(password, entity.getPassword());
    }

    @Test
    void setMemberRoleChangesTheMemberRoleToTargetMemberRole() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        MemberRole memberRole = MemberRole.ADMIN;

        assertNotEquals(memberRole, entity.getMemberRole());

        entity.setMemberRole(memberRole);

        assertEquals(memberRole, entity.getMemberRole());
    }

    @Test
    void setLockedChangesLockedToTargetBoolean() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        boolean targetLocked = true;

        assertNotEquals(targetLocked, entity.isLocked());

        entity.setLocked(targetLocked);

        assertEquals(targetLocked, entity.isLocked());
    }

    @Test
    void setEnabledChangesEnabledToTargetBoolean() {

        AuthMember entity = new AuthMember((long) 0, "fn", "ln", "email", "password", MemberRole.USER, false, false);
        boolean targetEnabled = true;

        assertNotEquals(targetEnabled, entity.isEnabled());

        entity.setEnabled(targetEnabled);

        assertEquals(targetEnabled, entity.isEnabled());
    }
    
}
