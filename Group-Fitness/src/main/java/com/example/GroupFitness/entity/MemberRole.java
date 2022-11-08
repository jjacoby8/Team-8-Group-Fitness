package com.example.GroupFitness.entity;

public enum MemberRole {
    USER("User"),
    ADMIN("Admin");

    private final String displayValue;

    MemberRole(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
