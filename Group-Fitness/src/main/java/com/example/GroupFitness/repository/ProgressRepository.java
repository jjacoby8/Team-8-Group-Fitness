package com.example.GroupFitness.repository;

import com.example.GroupFitness.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findProgressByGoalId(Long goalId);
    List<Progress> findProgressByMemberId(Long memberId);
}
