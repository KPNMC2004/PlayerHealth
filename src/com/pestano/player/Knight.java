package com.pestano.player;

import com.pestano.data.WeaponList;
import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.entities.Player;

public class Knight extends Player {

    @Override
    public void attack(Enemy enemy) {

    }

    // Attack
    public void stab() {

    }

    public Knight(String name, double health) {
        super(name, health);
        WeaponList weaponList = new WeaponList();

        super.setWeapon(weaponList.getWeaponsMap().get("Sword"));
    }
}
