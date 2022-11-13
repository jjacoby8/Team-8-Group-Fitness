package com.example.GroupFitness.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GoalTest {
    @Test
    void testGetDeadline() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        
        assertEquals("deadline", g.getDeadline());
    }

    @Test
    void testGetGoalType() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        
        assertEquals(GoalType.BODY_WEIGHT, g.getGoalType());
    }

    @Test
    void testGetId() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        
        assertEquals((long) 0, g.getId());
    }

    @Test
    void testGetMemberId() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        
        assertEquals((long) 1, g.getMemberId());
    }

    @Test
    void testGetName() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        
        assertEquals("name", g.getName());
    }

    @Test
    void testGetProgress() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        
        assertEquals("progress", g.getProgress());
    }

    @Test
    void testGetTarget() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        
        assertEquals("target", g.getTarget());
    }

    @Test
    void testSetDeadline() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        String target = "g";

        assertNotEquals(target, g.getDeadline());

        g.setDeadline(target);

        assertEquals(target, g.getDeadline());
    }

    @Test
    void testSetGoalType() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        GoalType target = GoalType.MAX_REPS;

        assertNotEquals(target, g.getGoalType());

        g.setGoalType(target);

        assertEquals(target, g.getGoalType());
    }

    @Test
    void testSetId() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        long target = 2;

        assertNotEquals(target, g.getId());

        g.setId(target);

        assertEquals(target, g.getId());
    }

    @Test
    void testSetMemberId() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        long target = 3;

        assertNotEquals(target, g.getMemberId());

        g.setMemberId(target);

        assertEquals(target, g.getMemberId());
    }

    @Test
    void testSetName() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        String target = "n";

        assertNotEquals(target, g.getName());

        g.setName(target);

        assertEquals(target, g.getName());
    }

    @Test
    void testSetProgress() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        String target = "p";

        assertNotEquals(target, g.getProgress());

        g.setProgress(target);

        assertEquals(target, g.getProgress());
    }

    @Test
    void testSetTarget() {

        Goal g = new Goal((long) 0, "name", "target", "progress", "deadline", (long) 1, GoalType.BODY_WEIGHT, false, true);
        String target = "t";

        assertNotEquals(target, g.getTarget());

        g.setTarget(target);

        assertEquals(target, g.getTarget());
    }
}
