package com.pestano.pkg.entities;


import com.pestano.pkg.Entity;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.health.EnemyHealth;

public class Enemy extends Entity {
    final String enemyDefaultName = "Superuser";
    private final EnemyHealth health = new EnemyHealth();

    public EnemyHealth getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health.setHealthPoints(health);
    }

    public Enemy(String name, double health, Weapon weapon) {
        super(name,weapon);
        getHealth().setHealthPoints(health);
    }

    public Enemy(double health, Weapon weapon) {
        super(weapon);

    }

    public void attack(Player player) {
        player.health.calculateHitPoints(super.getWeapon().getWeaponDamage());
    }

}
