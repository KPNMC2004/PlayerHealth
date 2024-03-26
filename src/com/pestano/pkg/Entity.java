package com.pestano.pkg;

import com.pestano.data.WeaponList;

public abstract class Entity {
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

    private String name = "Joe";
    private Weapon weapon = null;
    @Override
    public String toString() {
        return this.name;
    }
}
