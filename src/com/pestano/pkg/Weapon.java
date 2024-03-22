package com.pestano.pkg;

public class Weapon {

    public String getWeaponName() {
        return weaponName;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public String weaponName = "Sword";
    public double weaponDamage;
    public String weaponClass;

    public Weapon(String weaponName, double weaponDamage){
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
    }

    public Weapon() {
        this.weaponDamage = 50.0;
    }

}
