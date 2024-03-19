import java.nio.file.Watchable;

public class Weapon {

    int weaponNum = 0;
    double weaponDamage;
    String weaponClass;

    public Weapon(int num, double weaponDamage, String weaponClass){
        this.weaponNum = num;
        this.weaponDamage = weaponDamage;
        this.weaponClass = weaponClass;
    }

}
