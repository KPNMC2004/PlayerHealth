package com.pestano.pkg.mana;

public class PlayerMana {
    public double getManaQty() {
        return manaQty;
    }

    public void setManaQty(double manaQty) {
        this.manaQty = manaQty;
    }

    public double manaQty;

    public void useMana(double manaUsed) {
        manaQty -= manaUsed;
    }

    public void gainMana(double manaUsed) {
        manaQty += manaUsed;
    }



    public PlayerMana() {
        this.manaQty = 1000;
    }
}
