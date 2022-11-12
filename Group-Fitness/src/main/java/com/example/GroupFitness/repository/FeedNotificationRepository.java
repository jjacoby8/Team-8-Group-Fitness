package com.example.GroupFitness.repository;

import com.example.GroupFitness.entity.FeedNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedNotificationRepository extends JpaRepository<FeedNotification, Long> {
}
