package com.pestano.pkg;

public abstract class Health {
    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    // Default
    private double healthPoints = 2000;


}

