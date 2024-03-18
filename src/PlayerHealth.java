public class PlayerHealth {

    final double LIFE_COST = 0.02;

    // Starting health
    int health = 2000;

    public int calculateDamage (int[] args) {
        int damage = 0;

        for ( int i : args) {
            damage += i;
        }

        return damage;
    }

    // When Hitted
    public void calculateHitPoints(int weaponDmg = 0, int spellDmg = 0, int handDmg) {
        double totalHealth = this.health;

        totalHealth = (handDmg + weaponDmg + spellDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.health;
    }

    // Health Regen

    //
    public PlayerHealth(int health) {
        this.health = health;

    }


}

