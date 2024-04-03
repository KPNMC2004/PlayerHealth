package com.pestano.pkg;

public class Weapon {

    private final String weaponId;
    private final String name;

    public String getWeaponId() {
        return weaponId;
    }
    public String getName() {
        return name;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }
    private final double weaponDamage;



    public Weapon(String weaponName, double weaponDamage){
        this.weaponId = weaponName.substring(0,3).toUpperCase();
        this.name = weaponName;
        this.weaponDamage = weaponDamage;
    }
    public Weapon(String weaponId, String weaponName, double weaponDamage){
        this.weaponId = weaponId.substring(0,3).toUpperCase();
        this.name = weaponName;
        this.weaponDamage = weaponDamage;
    }

}
