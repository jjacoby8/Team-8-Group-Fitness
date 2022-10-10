package com.example.GroupFitness.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String email;

    private boolean isAdmin;

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean value) {
        this.isAdmin = value;
    }
}

