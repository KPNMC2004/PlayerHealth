import Enemy.*;

import java.util.Scanner;
import Enemy.*;

public class Player {
    PlayerHealth playerHealth = new PlayerHealth();
    PlayerMana playerMana = new PlayerMana();
    String name = "Joe";

    public static void attackEnemy(Enemy enemy, Weapon weapon) {
        enemy.
    }



    public void playerChoice() {
        Scanner playerInput = new Scanner(System.in);


        while (true) {
            int playerChoice = playerInput.nextInt();

            switch (playerChoice) {
                case 1:
                    this.attackEnemy();
                    break;
                case 2:
                    this.switchWeapons();
                    break;
                case 3:
                    this.useSpell();
                    break;
                case 4:
                    System.out.println("You skipped a turn!");
                    break;
                default:
                    System.out.println("Invalid Input!");
                    continue;
            }
        }
    }


    public Player(double playerHealth, String playerName, String playerWeapon ) {



    }
}