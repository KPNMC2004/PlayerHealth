package Enemy;

public class EnemyHealth {

    // Constants
    final double LIFE_COST = 0.02;
    double health = 100;
    public double getHealth() {
        return health;
    }

    // When Hitted
    public void calculateHitPoints(double weaponDmg, double spellDmg) {
        double totalHealth = this.health;

        totalHealth = (weaponDmg + spellDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.health = totalHealth;
    }

    public void calculateHitPoints(double weaponDmg) {
        double totalHealth = this.health;

        totalHealth = (weaponDmg + (this.LIFE_COST * totalHealth) ) - totalHealth;

        this.health = totalHealth;
    }

    // Health Regen
    public void calculateRegeneration(int healthGained) {
        this.health += healthGained;
    }


    public EnemyHealth(double health) {
        this.health = health;
    }

    // Keep default health when no args
    public EnemyHealth() {
    }


}

