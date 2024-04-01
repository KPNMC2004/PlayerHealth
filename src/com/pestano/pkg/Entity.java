package com.pestano.pkg;

import com.pestano.data.WeaponList;
import com.pestano.pkg.entities.Enemy;

public abstract class Entity {
    protected String name = "Joe";
    protected Weapon weapon = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Entity(String name, Weapon weapon) {
        setName(name);
        setWeapon(weapon);
    }

    public Entity(String name) {
        WeaponList weaponList = new WeaponList();

        final Weapon DEFAULT_WEAPON = weaponList.getWeaponsMap().get("Fist");

        weaponList = null;
        setName(name);
        setWeapon(DEFAULT_WEAPON);
    }

    public Entity(Weapon weapon) {
        final String DEFAULT_NAME = "Joe";

        setName(DEFAULT_NAME);
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
