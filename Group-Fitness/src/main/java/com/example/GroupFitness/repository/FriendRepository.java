package com.example.GroupFitness.repository;

import com.example.GroupFitness.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface FriendRepository extends JpaRepository<Friend, Long> {
    @Transactional
    @Modifying
    @Query("SELECT f FROM Friend f WHERE f.secondMemberId = ?1 OR f.firstMemberId = ?1 AND f.acceptedRequest = true")
    List<Friend> getFriendsOfMember(Long memberId);

    @Transactional
    @Modifying
    @Query("SELECT f FROM Friend f WHERE f.secondMemberId = ?1 AND f.acceptedRequest = false")
    List<Friend> getIncomingFriendRequestsForMember(Long memberId);

    @Transactional
    @Query("SELECT f FROM Friend f WHERE f.firstMemberId = ?1 AND f.secondMemberId = ?2")
    Friend getRequestByFriendId(Long currentMemberId, Long friendId);

    @Transactional
    @Query("SELECT f FROM Friend f WHERE (f.firstMemberId = ?1 AND f.secondMemberId = ?2) OR (f.firstMemberId = ?2 AND f.secondMemberId = ?1)")
    Friend getFriendRelation(Long currentMemberId, Long friendId);
}
