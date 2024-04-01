package com.pestano.pkg.health;

import com.pestano.pkg.Health;

public class EnemyHealth extends Health {

    // Constants
    final double LIFE_COST = 0.02;


    // When Hitted
    public void calculateHitPoints(double weaponDmg, double spellDmg) {
        double totalHealth = this.getHealthPoints();

        totalHealth = (weaponDmg + spellDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        super.setHealthPoints(totalHealth);
    }

    public void calculateHitPoints(double weaponDmg) {
        double totalHealth = this.getHealthPoints();

        totalHealth = (weaponDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.setHealthPoints(totalHealth);
    }

    public EnemyHealth(double health) {
        super(health);
    }

    // Keep default health when no args
    public EnemyHealth() {
        super();
    }



}

