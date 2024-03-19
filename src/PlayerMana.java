public class PlayerMana {
    public double manaQty;

    public void useMana(double manaUsed) {
        manaQty -= manaUsed;
    }

    public void gainMana(double manaUsed) {
        manaQty += manaUsed;
    }

    public double getManaQty() {
        return manaQty;
    }

    public PlayerMana(double qty) {
        this.manaQty = qty;
    }

    public PlayerMana() {
        this.manaQty = 1000;
    }
}
