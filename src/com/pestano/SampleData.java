package com.pestano;

import com.pestano.pkg.entities.Enemy;
import com.pestano.pkg.Weapon;

public class SampleData {
    public Weapon[] getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(Weapon[] weaponList) {
        this.weaponList = weaponList;
    }

    public Enemy getTestEnemy() {
        return testEnemy;
    }

    public void setTestEnemy(Enemy testEnemy) {
        this.testEnemy = testEnemy;
    }

    private static Weapon[] weaponList = new Weapon[3];
    private static Enemy testEnemy;

    public SampleData() {
        weaponList = new Weapon[] {
                new Weapon("test1", 500),
                new Weapon("test2", 2),
                new Weapon("test3", 3)
        };

        testEnemy = new Enemy("Superuser", 50, weaponList[0]);
    }

}
