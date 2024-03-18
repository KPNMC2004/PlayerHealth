import java.util.Scanner;

public class Player {
    final int MAX_HEALTH;

    PlayerHealth health = new PlayerHealth(MAX_HEALTH);

    public static void attackEnemy(Enemy enemy, ) {

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
                    this.useMagic();
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


    public Player() {


    }
}