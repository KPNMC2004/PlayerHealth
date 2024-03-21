package com.pestano.pkg.enemy;

import com.pestano.data.game.Weapon.Sword;
import com.pestano.pkg.Entity;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.health.EnemyHealth;
import com.pestano.pkg.health.Health;


public class Enemy extends Entity {
    final String enemyDefaultName = "Joe";
    EnemyHealth health = new EnemyHealth();

    public Enemy(String name, double health, Weapon weapon) {

        this.weapon = weapon;

    }

    @Override
    public void attack() {

    }

    public Enemy() {
    }

}
