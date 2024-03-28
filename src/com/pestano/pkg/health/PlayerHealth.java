package com.pestano.pkg.health;

import com.pestano.pkg.Health;

public class PlayerHealth extends Health {

    // Constants
    final double LIFE_COST = 0.02;

    // When Hitted
//    public void calculateHitPoints(double weaponDmg, double spellDmg) {
//        double totalHealth = super.getHealthPoints();
//
//        totalHealth = (weaponDmg + spellDmg + (LIFE_COST * totalHealth) ) - totalHealth;
//
//        super.setHealthPoints(totalHealth);
//    }

//    public void calculateHitPoints(double weaponDmg) {
//        double totalHealth = super.getHealthPoints();
//
//        totalHealth = (weaponDmg + (LIFE_COST * totalHealth) ) - totalHealth;
//
//        this.setHealthPoints(totalHealth);
//    }

    // Health Regen
    public void calculateRegeneration(int healthGained) {
        this.setHealthPoints(healthGained);
    }


    public PlayerHealth(double health) {
        super.setHealthPoints(health);
    }

    // Keep default health when no args
    public PlayerHealth() {
    }


}

