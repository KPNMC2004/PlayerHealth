public class EnemyHealth {

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
    public void calculateHitPoints(int weaponDmg = 0, int spellDmg = 0, int handDmg = 0) {
        int totalHealth = this.health;
        int damage = calculateDamage(weaponDmg, spellDmg, handDmg);


    }

    // Health Regen

    //
    public EnemyHealth(int health) {
        this.health = health;

    }


}

