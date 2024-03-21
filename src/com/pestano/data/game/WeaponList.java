package com.pestano.data.game;

import com.pestano.data.game.Weapon.Bat;
import com.pestano.data.game.Weapon.Bow;
import com.pestano.data.game.Weapon.Sword;
import com.pestano.pkg.Weapon;

import java.util.HashMap;

public class WeaponList {

    Weapon[] weaponList;
    public WeaponList() {
        this.weaponList = new Weapon[3];

        weaponList[0] = new Sword();
        weaponList[1] = new Bow();
        weaponList[2] = new Bat();

    }

}