public class PlayerHealth {

    // Constants
    final double LIFE_COST = 0.02;
    double health;
    public double getHealth() {
        return health;
    }

    // When Hitted
    public void calculateHitPoints(int weaponDmg, int spellDmg) {
        double totalHealth = this.health;

        totalHealth = (weaponDmg + spellDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.health = totalHealth;
    }

    // Health Regen
    public void calculateRegeneration(int healthGained) {
        this.health += healthGained;
    }


    public PlayerHealth(double health) {
        this.health = health;
    }

    // Keep default health when no args
    public PlayerHealth() {
        this.health = 2000;
    }


}

