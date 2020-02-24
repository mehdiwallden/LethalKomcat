import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tournament {
    Scanner input;
    Fighter player1;
    Fighter player2;
    int rounds = 3;

    public Tournament(Fighter p1, Fighter p2){
        input = new Scanner(System.in);
        player1 = p1;
        player2 = p2;
    }

    public void start() {
        game();
    }

    public void game(){

            for (int i = 0; i < rounds; i++) {
                player1.revive();
                player2.revive();

                System.out.println();
                displayScore();
                System.out.println("Round " + (i + 1) + " Fight!!!");
                System.out.println();

                boolean yourTurn = true;

                while (player1.isAlive() && player2.isAlive()) {

                    if (yourTurn) {

                        //choosing power
                        System.out.println("Choose Attack power");
                        int chosen;

                        int y = 1;

                        for (Powers p : Powers.values()) {
                            System.out.println(" " + y + " - " + p);
                            y++;
                        }

                        chosen = input.nextInt();

                        //power affecting enemy
                        switch (chosen) {
                            case 1:
                                player2.hurt(10);
                                System.out.println(player1.name  + " caused a damage of 10 to " + player2.name);
                                displayScore();
                                break;
                            case 2:
                                player2.hurt(25);
                                System.out.println(player1.name + " caused a damage of 25 to " + player2.name);
                                displayScore();
                                break;
                            case 3:
                                player2.hurt(37);
                                System.out.println(player1.name + " caused a damage of 37 to " + player2.name);
                                displayScore();
                                break;

                            default:

                                player1.hurt(10);
                                System.out.println("Congratulations, you played yourself and suffered a damage of 10");
                                displayScore();
                                break;
                        }

                        //enemys turn
                        yourTurn = false;

                        try {
                            thinking();
                        } catch (Exception e) {

                        }


                    }

                    if (!yourTurn) {

                        //enemy choosing power
                        Random rand = new Random();
                        int chosen = rand.nextInt(3) + 1;

                        //power affecting player
                        switch (chosen) {
                            case 1:
                                player1.hurt(10);
                                System.out.println(player2.name + " caused a damage of 10 to " + player1.name);
                                displayScore();
                                break;
                            case 2:
                                player1.hurt(25);
                                System.out.println(player2.name + " caused a damage of 25 to " + player1.name);
                                displayScore();
                                break;
                            case 3:
                                player1.hurt(37);
                                System.out.println(player2.name + " caused a damage of 37 to " + player1.name);
                                displayScore();
                                break;

                            default:
                                break;
                        }

                        //your turn
                        yourTurn = true;


                    }

                    if (player1.health > 0 && player2.health <= 0) {
                        player2.die();
                        player1.won();

                        System.out.println(player1.name + " win");
                        System.out.println(player1.motto);

                    } else if (player2.health > 0 && player1.health <= 0) {

                        player2.die();
                        player1.won();

                        System.out.println(player2.name + " win");
                        System.out.println(player2.motto);
                    }
                }


                if (player1.winPerRound > 1 || player2.winPerRound > 1){
                    if (player1.winPerRound > 1) {
                        System.out.println("\u001B[35m" + player1.name + " - WINNER!!!" + "\u001B[0m");
                        break; //break out from the last occuring loop
                    } else {
                        System.out.println("\u001B[35m" + player2.name + " - WINNER!!!" + "\u001B[0m");
                        break; //break out from the last occuring loop
                    }
                }
            }
    }


    private void displayScore(){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        System.out.println(ANSI_CYAN + player1.name + " " + player1.health + " VS " + player2.name + " " + player2.health + ANSI_RESET);
        System.out.println(ANSI_PURPLE + player1.name + " Round won " + player1.winPerRound + " VS " + player2.name + " round won " + player2.winPerRound + ANSI_RESET);
        System.out.print("\n \n \n");
    }

    private void thinking() throws Exception{
        String anim = "|/-\\";
        for (int x = 0 ; x < 100 ; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(5);
        }
    }


}
