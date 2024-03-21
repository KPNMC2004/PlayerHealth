package com.pestano.pkg.health;

public class EnemyHealth extends Health {

    // Constants
    final double LIFE_COST = 0.02;


    // When Hitted
    public void calculateHitPoints(double weaponDmg, double spellDmg) {
        double totalHealth = this.getHealthPoints();

        totalHealth = (weaponDmg + spellDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.setHealthPoints(totalHealth);
    }

    public void calculateHitPoints(double weaponDmg) {
        double totalHealth = this.getHealthPoints();

        totalHealth = (weaponDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.setHealthPoints(totalHealth);
    }

    // Health Regen
    public void calculateRegeneration(int healthGained) {

    }


    public EnemyHealth(double health) {
        this.health = health;
    }

    // Keep default health when no args
    public EnemyHealth() {
        this.health = DEFAULT_HEALTH;
    }


}

