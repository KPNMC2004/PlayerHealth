package com.pestano.pkg;

public abstract class Weapon {

    public String weaponName = "Sword";
    public double weaponDamage;
    public String weaponClass;

    public Weapon(String weaponName, double weaponDamage){
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
    }

}
