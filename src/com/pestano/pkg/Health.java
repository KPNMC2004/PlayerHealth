package com.pestano.pkg;

public abstract class Health {
    protected double maxHealth;
    protected double healthPoints;

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    private void setMaxHealthPoints(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public double getMaxHealthPoints() {
        return maxHealth;
    }

    public void calculateHitPoints(double weaponDmg) {
        double totalHealth = getHealthPoints();

        totalHealth -= weaponDmg;

        setHealthPoints(totalHealth);
    }
    public void calculateHitPoints(double weaponDmg, double spellDmg) {
        double totalHealth = getHealthPoints();

        totalHealth -= (weaponDmg + spellDmg);

        if (totalHealth < 0) {

        setHealthPoints(0);
        } else {
            setHealthPoints(totalHealth);
        }
    }

    public Health(double healthPoints) {
        setMaxHealthPoints(healthPoints);
        setHealthPoints(healthPoints);
    }

    public Health() {
        final double DEFAULT = 2000;

        setMaxHealthPoints(DEFAULT);
        setHealthPoints(DEFAULT);

    }
}

