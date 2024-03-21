package com.pestano.pkg;

public class Spell {

    int spellNum = 0;
    double spellDamage;
    String spellClass;

    public Spell(int num, double spellDamage, String spellClass){
        this.spellNum = num;
        this.spellDamage = spellDamage;
        this.spellClass = spellClass;
    }
}
