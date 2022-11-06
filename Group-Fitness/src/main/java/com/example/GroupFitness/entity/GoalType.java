package com.example.GroupFitness.entity;

public enum GoalType {
    BODY_WEIGHT("Body Weight", "lbs."),
    MAX_REPS("Max Reps", "reps"),
    WEIGHT_MAX("Weight Max", "lbs.");

    private final String displayValue;
    private final String unit;

    GoalType(String displayValue, String unit) {
        this.displayValue = displayValue;
        this.unit = unit;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getUnit() {
        return unit;
    }
}
