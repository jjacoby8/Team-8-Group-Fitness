package com.example.GroupFitness.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tbl_goals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String target;

    private String progress;

    private String deadline;

    private Long memberId;

    private boolean completed;

    @Enumerated(EnumType.STRING)
    private GoalType goalType;
}
