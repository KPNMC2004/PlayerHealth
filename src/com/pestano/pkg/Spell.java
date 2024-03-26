package com.pestano.pkg;

public class Spell {

    int spellId;
    double spellDamage;
    String spellClass;
    double manaCost;

    public Spell(int id, double spellDamage, String spellClass, double manaCost){
        this.spellId = id;
        this.spellDamage = spellDamage;
        this.spellClass = spellClass;
        this.manaCost = manaCost;
    }
}
