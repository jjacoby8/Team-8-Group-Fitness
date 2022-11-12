package com.example.GroupFitness.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_friends")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long firstMemberId;

    private Long secondMemberId;

    private boolean acceptedRequest;
}
