package com.pestano.data;

import com.pestano.pkg.Weapon;
import com.pestano.pkg.entities.Enemy;

import java.util.ArrayList;
import java.util.HashMap;

public class EnemyList {
    private static EnemyList singleInstance = null;
    private final ArrayList<Enemy> enemyTypes = new ArrayList<>();

    public ArrayList<Enemy> getEnemyTypes() {
        return enemyTypes;
    }

    private EnemyList() {
        WeaponList weaponList = WeaponList.WeaponList();
        HashMap<String, Weapon> weaponMap = weaponList.getWeaponsMap();

        enemyTypes.add(new Enemy("Brute", 1900, weaponMap.get("FIS")));
        enemyTypes.add(new Enemy("Macero", 2500, weaponMap.get("MAC")));
        enemyTypes.add(new Enemy("Knight", 2000, weaponMap.get("SWO")));
        enemyTypes.add(new Enemy("Archer", 1250, weaponMap.get("BOW")));
    }

    public static EnemyList EnemyList(){
        if (singleInstance == null) {
            singleInstance = new EnemyList();
        }
        return singleInstance;
    }
}
