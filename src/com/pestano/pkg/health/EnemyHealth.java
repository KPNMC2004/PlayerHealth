package com.pestano.pkg.health;

import com.pestano.pkg.Health;

public class EnemyHealth extends Health {

    // Constants
    private final double LIFE_COST = 0.02;


    // When Hitted
    public void calculateHitPoints(double weaponDmg) {
        double totalHealth = getHealthPoints();

        totalHealth -= (weaponDmg + (this.LIFE_COST * totalHealth) );


        setHealthPoints(totalHealth);
    }

    public void calculateHitPoints(double meleeDmg, double weaponDmg) {
        double totalHealth = this.getHealthPoints();

        totalHealth -= (weaponDmg + meleeDmg + (this.LIFE_COST * totalHealth) );

        setHealthPoints(totalHealth);
    }

    public void calculateHitPoints(int spellDmg) {
        double totalHealth = getHealthPoints();

        totalHealth -= (spellDmg + (this.LIFE_COST * totalHealth) );


        setHealthPoints(totalHealth);
    }

    public EnemyHealth(double health) {
        super(health);
    }

    // Keep default health when no args
    public EnemyHealth() {
        super();
    }



}

