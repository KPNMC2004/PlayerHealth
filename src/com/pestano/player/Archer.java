package com.pestano.player;

import com.pestano.data.WeaponList;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;

public class Archer extends Player {

    @Override
    public void attack(Enemy enemy) {

    }

    // Attack
    public void stab() {

    }

    public Archer(String name, double health) {
        super(name, health);
        WeaponList weaponList = new WeaponList();

        super.setWeapon(weaponList.getWeaponsMap().get("Sword"));
    }
}
