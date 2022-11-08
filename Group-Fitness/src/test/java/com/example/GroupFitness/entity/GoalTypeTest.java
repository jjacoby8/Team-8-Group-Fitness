package com.example.GroupFitness.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GoalTypeTest {

    @Test
    void testGetDisplayValue() {

        GoalType gt = GoalType.BODY_WEIGHT;

        assertEquals("Body Weight", gt.getDisplayValue());
    }

    @Test
    void testGetUnit() {

        GoalType gt = GoalType.BODY_WEIGHT;

        assertEquals("lbs.", gt.getUnit());
    }
}
