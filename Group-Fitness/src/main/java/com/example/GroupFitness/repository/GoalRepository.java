package com.example.GroupFitness.repository;

import com.example.GroupFitness.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    public List<Goal> findGoalsByMemberId(Long memberId);
}
