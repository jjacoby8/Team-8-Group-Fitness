package com.example.GroupFitness.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.security.Principal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.stubbing.OngoingStubbingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.GroupFitness.entity.AuthMember;
import com.example.GroupFitness.entity.MemberRole;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class GoalControllerTest extends AbstractTest {
    
    @MockBean
	private GoalController controller;

    @Override
    @BeforeEach
    public void setUp() { super.setUp(); }
    
    @Test
    void testAddGoalForm() {
        
        
    }

    @Test
    void testAddProgress() {

    }

    @Test
    void testDeleteGoal() {

    }

    @Test
    void testGetCurrentUser() {
        /* long membID = (long) 0;

        AuthMember memb = new AuthMember(membID, "fn", "ln", "email", "password", MemberRole.USER, false, false);

        // Setup a mock context somehow to make it so that, when the getAuthentication().getPrincipal() run in getCurrentUser(),
        // the method doesn't implode and we get an actual response.

        assertEquals(membID, controller.getCurrentUser()); */
    }

    @Test
    void testSaveGoal() {

    }

    @Test
    void testSaveProgress() {

    }

    @Test
    void testShowGoalUpdateForm() {

    }
}
