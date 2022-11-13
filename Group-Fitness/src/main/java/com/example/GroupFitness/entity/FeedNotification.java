package com.example.GroupFitness.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="tbl_feed_notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeedNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long memberId;

    private String userFullName;

    private String goalCurVal;

    private String goalTarVal;

    private String goalLabel;

    private String goalName;

    private String dateOfUpdate;

    private boolean goalCompleted;

    private boolean goalJustCreated;
}
