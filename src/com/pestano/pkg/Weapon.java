package com.pestano.pkg;

import java.util.Locale;

public class Weapon {

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }




    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    private final double weaponDamage;

    private String id;
    private String name = "Sword";

    public Weapon(String weaponName, double weaponDamage){
        this.id = weaponName.substring(0,3).toUpperCase();
        this.name = weaponName;
        this.weaponDamage = weaponDamage;
    }
    public Weapon(String weaponId, String weaponName, double weaponDamage){
        this.id = weaponId.substring(0,3).toUpperCase();
        this.name = weaponName;
        this.weaponDamage = weaponDamage;
    }

    public Weapon() {
        this.weaponDamage = 50.0;
    }

}
