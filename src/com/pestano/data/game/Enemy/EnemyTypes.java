package com.pestano.data.game.Enemy;

import com.pestano.data.game.WeaponList;
import com.pestano.pkg.enemy.Enemy;
import com.pestano.pkg.Weapon;

import java.util.HashMap;
public class EnemyTypes {
    private static String[] enemyNameList = {"Knight", "Archer", "Wizard"};
    private static Double[] enemyHealthList = {500.0, 100.0, 600.0};
    public static WeaponList[]  = WeaponList.;

    public static HashMap<String, Enemy> enemyHashMap = new HashMap<>();

    public static void mapEnemyTypeHashMap(String[] enemyNameList, Double[] enemyHealthList, Weapon[] enemyWeaponList) {
        for(int i = 0; i < enemyNameList.length; i++) {
            enemyHashMap.put(enemyNameList[i], new Enemy(enemyNameList[i], enemyHealthList[i], enemyWeaponList[i]));
        }
    }

    public EnemyTypes() {
        mapEnemyTypeHashMap(enemyNameList, enemyHealthList, enemyWeaponList);
    }

    public static void printEnemyList() {
        for (String enemy : enemyHashMap.keySet()) {
            System.out.println(enemy + " " + enemyHashMap.get(enemy));
        }
    }

    public static void main(String[] args) {
        mapEnemyTypeHashMap(enemyNameList, enemyHealthList, enemyWeaponList);
        printEnemyList();
    }


}