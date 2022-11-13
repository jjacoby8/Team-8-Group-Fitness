package com.example.GroupFitness.entity;

public enum GoalType {
    BODY_WEIGHT("Body Weight", "lbs.", true),
    MAX_REPS("Max Reps", "reps", false),
    WEIGHT_MAX("Weight Max", "lbs.", false);

    private final String displayValue;
    private final String unit;

    private final boolean progressDecreases;

    GoalType(String displayValue, String unit, boolean progressDecreases) {
        this.displayValue = displayValue;
        this.unit = unit;
        this.progressDecreases = progressDecreases;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getUnit() {
        return unit;
    }

    public boolean getProgressDecreases() { return progressDecreases; }
}
