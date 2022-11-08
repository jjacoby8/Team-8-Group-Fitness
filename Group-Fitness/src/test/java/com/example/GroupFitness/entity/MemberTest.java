package com.example.GroupFitness.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MemberTest {

    // Getters

    @Test
    void getEmailReturnsRightEmail() {

        Member entity = new Member((long) 0, "name", "email", false);
        
        assertEquals("email", entity.getEmail());
    }

    @Test
    void getIdReturnsRightId() {

        Member entity = new Member((long) 0, "name", "email", false);

        assertEquals((long) 0, entity.getId());
    }

    @Test
    void getNameReturnsRightName() {

        Member entity = new Member((long) 0, "name", "email", false);
        
        assertEquals("name", entity.getName());
    }

    @Test
    void isAdminReturnsFalseForNonAdminAccount() {

        Member entity = new Member((long) 0, "name", "email", false);
        
        assertFalse(entity.getIsAdmin());
    }

    // Setters

    @Test
    void setIdChangesTheIdToTargetId() {

        Member entity = new Member((long) 0, "name", "email", false);
        long targetID = 1;

        assertNotEquals(targetID, entity.getId());

        entity.setId(targetID);

        assertEquals(targetID, entity.getId());
    }

    @Test
    void setNameChangesTheFirstNameToTargetName() {

        Member entity = new Member((long) 0, "name", "email", false);
        String name = "n";

        assertNotEquals(name, entity.getName());

        entity.setName(name);

        assertEquals(name, entity.getName());
    }

    @Test
    void setEmailChangesTheEmailToTargetEmail() {

        Member entity = new Member((long) 0, "name", "email", false);
        String email = "email@fake.com";

        assertNotEquals(email, entity.getEmail());

        entity.setEmail(email);

        assertEquals(email, entity.getEmail());
    }

    @Test
    void setIsAdminChangesIsAdminToTargetBoolean() {

        Member entity = new Member((long) 0, "name", "email", false);
        boolean target = true;

        assertNotEquals(target, entity.getIsAdmin());

        entity.setIsAdmin(target);

        assertEquals(target, entity.getIsAdmin());
    }
    
}
