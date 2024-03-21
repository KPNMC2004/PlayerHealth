package com.pestano.pkg.health;

import java.util.HashMap;

public class PlayerHealth extends Health {

    // Constants
    final double LIFE_COST = 0.02;

    // When Hitted
    public void calculateHitPoints(double weaponDmg, double spellDmg) {
        double totalHealth = this.getHealthPoints();

        totalHealth = (weaponDmg + spellDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.setHealthPoints(totalHealth);
    }

    // Health Regen
    public void calculateRegeneration(int healthGained) {
        this.setHealthPoints(healthGained);
    }


    public PlayerHealth(double health) {
        this.setHealthPoints(health);
    }

    // Keep default health when no args
    public PlayerHealth() {

    }


}

