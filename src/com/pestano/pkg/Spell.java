package com.pestano.pkg;

public class Spell {
    private final String spellId;
    private final String name;
    private final int damage;
    public String getSpellId() {
        return spellId;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public Spell(String name, int damage) {
        this.spellId = name.substring(0,3).toUpperCase();
        this.name = name;
        this.damage = damage;
    }



}
