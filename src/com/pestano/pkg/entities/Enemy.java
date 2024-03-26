package com.pestano.pkg.entities;


import com.pestano.pkg.Entity;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.health.EnemyHealth;

public class Enemy extends Entity {
    final String enemyDefaultName = "Joe";
    public EnemyHealth health = new EnemyHealth();

    public Enemy(String name, double health, Weapon weapon) {
        super.setName(name);
        super.setWeapon(weapon);
    }
    public void attack(Player player) {
        player.health.calculateHitPoints(super.getWeapon().getWeaponDamage());
    }

}
