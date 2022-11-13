package com.example.GroupFitness.repository;

import com.example.GroupFitness.entity.FeedNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedNotificationRepository extends JpaRepository<FeedNotification, Long> {
    List<FeedNotification> findNotificationsByMemberId(Long memberId);
}
