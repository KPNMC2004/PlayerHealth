package com.pestano.pkg.health;

public abstract class Health {
    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    private double healthPoints = 2000;

}
