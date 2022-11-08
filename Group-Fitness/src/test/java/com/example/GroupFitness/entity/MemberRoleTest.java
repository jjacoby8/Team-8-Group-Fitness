package com.example.GroupFitness.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MemberRoleTest {
    @Test
    void testGetDisplayValue() {

        MemberRole mr = MemberRole.ADMIN;

        assertEquals("Admin", mr.getDisplayValue());
    }
}
