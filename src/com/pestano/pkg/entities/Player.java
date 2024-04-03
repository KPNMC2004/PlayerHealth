package com.pestano.pkg.entities;

import com.pestano.data.SpellList;
import com.pestano.pkg.Entity;
import com.pestano.pkg.Spell;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.gameMechanics.PlayerChoice;
import com.pestano.pkg.health.PlayerHealth;

import java.util.Scanner;

public abstract class Player extends Entity implements PlayerChoice {
    protected String className;
    protected PlayerHealth health;
    protected Enemy target;

    protected Spell spell;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setHealth(double health) {
        this.health = new PlayerHealth(health);
    }

    public void setTarget(Enemy target) {
        this.target = target;
    }

    public Enemy getTarget() {
        return target;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public PlayerHealth getHealth() {
        return health;
    }

    public Spell getSpell() {
        return spell;
    }

    // Attack
    public void attack(Enemy enemy) {
        enemy.health.calculateHitPoints(getWeapon().getWeaponDamage());
    }

    public Player(String playerName, double healthPoints, Weapon weapon) {
        super(playerName, weapon);
        setHealth(healthPoints);

    }

    public Player(String playerName, String className, double healthPoints) {
        super(playerName);
        setClassName(className);
        setHealth(healthPoints);
    }

    public Player(Weapon weapon) {
        super(weapon);
    }

}