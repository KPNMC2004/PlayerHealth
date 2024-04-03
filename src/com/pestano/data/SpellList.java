package com.pestano.data;

import com.pestano.pkg.Spell;
    
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.PatternSyntaxException;

public class SpellList {
    private static SpellList singleInstance = null;
    private final ArrayList<Spell> spellList = new ArrayList<>();

    private final LinkedHashMap<String, Spell> spellMap = new LinkedHashMap<>();

    public LinkedHashMap<String, Spell> getSpellMap() {
        return spellMap;
    }

    public void printSpells(){
        int colWidth = 12;

        System.out.printf("%s%s%s"," ID\t", "  Name\t",  "\t   Damage\n");
        System.out.println("=".repeat(colWidth * 2));
        for (Spell i: this.spellMap.values()) {
            System.out.printf("[%s] ", String.format(i.getSpellId()));
            System.out.printf("%s%s", i.getName(), ".".repeat( colWidth - i.getName().length()));
            System.out.printf(" %d\n",i.getDamage());
        }
    }

    private void createMap() {
        for (Spell i: spellList) {
            spellMap.put(i.getSpellId(),i);
        }
    }

    private SpellList() {
        spellList.add(new Spell("Fireball", 5));
        spellList.add(new Spell("Ice", 3));
        spellList.add(new Spell("Reflect", 8));

        createMap();
        spellList.clear();
    }

    public static SpellList SpellList() {
        if (singleInstance == null) {
            singleInstance = new SpellList();
        }
        return singleInstance;
    }

}

