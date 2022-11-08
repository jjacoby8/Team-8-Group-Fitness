package com.example.GroupFitness.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProgressTest {
    
    // Getters

    @Test
    void testGetId() {
        
        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);

        assertEquals((long) 0, p.getId());
    }

    @Test
    void testNewValue() {
        
        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);

        assertEquals("nv", p.getNewValue());
    }

    @Test
    void testDateOfUpdate() {
        
        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);

        assertEquals("dou", p.getDateOfUpdate());
    }

    @Test
    void testGoalId() {
        
        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);

        assertEquals((long) 1, p.getGoalId());
    }

    @Test
    void testMemberId() {
        
        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);

        assertEquals((long) 2, p.getMemberId());
    }

    // Setters

    @Test
    void setIdChangesTheIdToTargetId() {

        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);
        long target = 3;

        assertNotEquals(target, p.getId());

        p.setId(target);

        assertEquals(target, p.getId());
    }

    @Test
    void setNewValueChangesTheNewValueToTargetNewValue() {

        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);
        String target = "newvalue";

        assertNotEquals(target, p.getNewValue());

        p.setNewValue(target);

        assertEquals(target, p.getNewValue());
    }

    @Test
    void setDateOfUpdateChangesTheDateOfUpdateToTargetDateOfUpdate() {

        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);
        String target = "dateofupdate";

        assertNotEquals(target, p.getDateOfUpdate());

        p.setDateOfUpdate(target);

        assertEquals(target, p.getDateOfUpdate());
    }

    @Test
    void setGoalIdChangesTheGoalIdToTargetGoalId() {

        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);
        long target = 4;

        assertNotEquals(target, p.getGoalId());

        p.setGoalId(target);

        assertEquals(target, p.getGoalId());
    }

    @Test
    void setMemberIdChangesTheMemberIdToTargetMemberId() {

        Progress p = new Progress((long) 0, "nv", "dou", (long) 1, (long) 2);
        long target = 3;

        assertNotEquals(target, p.getMemberId());

        p.setMemberId(target);

        assertEquals(target, p.getMemberId());
    }

}
