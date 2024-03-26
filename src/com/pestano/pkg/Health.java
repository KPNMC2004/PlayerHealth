package com.pestano.pkg;

public abstract class Health {
    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }


    public void calculateHitPoints(double weaponDmg) {
        double totalHealth = getHealthPoints();

        totalHealth -= weaponDmg;

        setHealthPoints(totalHealth);
    }
    public void calculateHitPoints(double weaponDmg, double spellDmg) {
        double totalHealth = getHealthPoints();

        totalHealth -= (weaponDmg + spellDmg);

        setHealthPoints(totalHealth);
    }

    // Default
    private double healthPoints = 2000;


}

