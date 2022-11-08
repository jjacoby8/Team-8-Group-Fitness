package com.example.GroupFitness.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.GroupFitness.entity.Progress;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProgressRepositoryTest {

    @Autowired
    private ProgressRepository repo;

    @Test
    void testFindProgressByGoalId() {

        long goalId = 0;

        Progress prog = new Progress();
            prog.setNewValue("newValue");
            prog.setDateOfUpdate("dateOfUpdate");
            prog.setGoalId(goalId);

        repo.save(prog);

        Progress result = new Progress();
        for (Progress p : repo.findProgressByGoalId(goalId))
            result = p;

        assertEquals(prog, result);

        repo.deleteById(result.getId());
    }

    @Test
    void testFindProgressByMemberId() {

        long memberId = 0;

        Progress prog = new Progress();
            prog.setNewValue("newValue");
            prog.setDateOfUpdate("dateOfUpdate");
            prog.setMemberId(memberId);

        repo.save(prog);

        Progress result = new Progress();
        for (Progress p : repo.findProgressByMemberId(memberId))
            result = p;

        assertEquals(prog, result);

        repo.deleteById(result.getId());
    }
}
