package com.pestano.pkg.player;

import com.pestano.data.game.WeaponList;
import com.pestano.pkg.Entity;
import com.pestano.pkg.enemy.Enemy;
import com.pestano.pkg.Spell;
import com.pestano.pkg.Weapon;
import com.pestano.pkg.health.PlayerHealth;
import com.pestano.pkg.mana.PlayerMana;

public class Player extends Entity {
    String playerName = "Joe";

    PlayerHealth playerHealth;
    PlayerMana playerMana = new PlayerMana();
    Weapon playerWeapon;
    Spell playerSpell;
    private Enemy target;

    WeaponList weaponList = new WeaponList();

    @Override
    public void attack(Enemy target, Weapon weapon) {
        target.
    }

//    public void swtichWeapon() {
//        this.weaponList.printWeaponMap();
//
//    }


    public Player( String playerName, double playerHealth, String playerWeapon) {
        this.playerName = playerName;
        this.playerHealth = new PlayerHealth(playerHealth);

    }

}