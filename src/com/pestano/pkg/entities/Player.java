package com.pestano.pkg.entities;

//import com.pestano.pkg.mana.PlayerMana;

import com.pestano.pkg.Entity;
import com.pestano.pkg.Spell;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.health.PlayerHealth;

public class Player extends Entity {
    public PlayerHealth health = new PlayerHealth();
    //public PlayerMana playerMana = new PlayerMana();
    public Spell playerSpell;
    private Enemy target;

    public void attack(Enemy enemy) {
        enemy.health.calculateHitPoints(super.getWeapon().getWeaponDamage());
    }



    public Player(String playerName, double HealthPoints, Weapon weapon) {
        super.setName(playerName);
        super.setWeapon(weapon);
        this.health.setHealthPoints(HealthPoints);
    }

    public Player(Weapon weapon) {
        this.setWeapon(weapon);
    }

}