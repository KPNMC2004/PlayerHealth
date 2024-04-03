package com.pestano.pkg.entities;


import com.pestano.pkg.Entity;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.health.EnemyHealth;

public class Enemy extends Entity {
    protected final String enemyDefaultName = "Superuser";
    protected EnemyHealth health;
    public void setHealth(double health) {
        this.health = new EnemyHealth(health);
    }

    public EnemyHealth getHealth() {
        return health;
    }

    public Enemy(String name, double health, Weapon weapon) {
        super(name,weapon);
        setHealth(health);
    }

    public Enemy(double healthPoints, Weapon weapon) {
        super(weapon);
        setHealth(healthPoints);
    }

    public void attack(Player player) {
        player.getHealth().calculateHitPoints(getWeapon().getWeaponDamage());
    }

}
