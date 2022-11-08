package com.example.GroupFitness.repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.GroupFitness.entity.Goal;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GoalRepositoryTest {

    @Autowired 
    GoalRepository repo;

    @Test
    void testFindGoalsByMemberId() {

        long memberId = 0;

        Goal goal1 = new Goal();
            goal1.setMemberId(memberId);
        Goal goal2 = new Goal();
            goal2.setMemberId(memberId);
        Goal goal3 = new Goal();
            goal3.setMemberId(memberId);

        List<Goal> list = new ArrayList<Goal>();
        list.add(goal1);
        list.add(goal2);
        list.add(goal3);

        repo.save(goal1);
        repo.save(goal2);
        repo.save(goal3);

        List<Goal> result = repo.findGoalsByMemberId(memberId);

        assertArrayEquals(list.toArray(), result.toArray());
        
        repo.deleteAll(result);
    }
}
