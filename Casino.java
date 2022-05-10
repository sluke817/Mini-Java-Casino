
package finalproject;

import java.util.Scanner;

/**
 *
 * @author Luke Schaefer 18186970
 * This is the main running class. This class runs the games and manages the overall calling
 */
public class Casino {
    
    public static void main(String[] args) {
        
        System.out.println("***** Welcome to Luke's Casino! *****");
        System.out.println("Please enter a player name:");
        
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        
        //determines the game of choice
        boolean yorn;
        System.out.println("**********");
        System.out.println(name + ", welcome to the casino. What would you like to play?");
        
        do {
            
            System.out.println("    Blackjack - please enter BJ");
            System.out.println("    Baccarat - please enter BA");
            System.out.println("    Casino War - please enter CW");

            String response = Game.getInput("bj", "ba", "cw");

            switch(response) {
                case "bj" -> {
                    System.out.println("******");
                    System.out.println("Lets play Blackjack!");
                    play(new BlackJackGame(name));
                    
                }
                case "ba" -> {
                    System.out.println("******");
                    System.out.println("Lets play Baccarat!");
                    play(new BaccaratGame(name));
                }
                case "cw" -> {
                    System.out.println("******");
                    System.out.println("Lets play Casino War!");
                    play(new CasinoWarGame(name));
                }
            }
            //determines if player would like to play again
            System.out.println("**********");
            System.out.println("Would you like to play another game? Y/n:");
            yorn = Game.getYesOrNo();
            if(yorn) {
                System.out.println("**********");
                System.out.println(name + ", what would you like to play?");
            }
            else {
                System.out.println("Thank you for playing " + name + ". Goodbye!");
            }
        }while(yorn);
        
        
        
    }
    
    
    public static void play(Game game) {
        boolean playAgain;
        do {
            System.out.println("**********");
            game.getBet(1);
            game.playGame();
            game.clearTable();
            playAgain = game.determinePlayAgain();
        }while(playAgain);
        
        String name = game.getPlayer().getName();
        int balance = game.getPlayer().getBalance();
        
        if(balance > 0) {
            System.out.println(name + " won a total of " + balance + "$");
        }
        else if(balance < 0) {
            System.out.println(name + " lost a total of " + balance * -1 + "$");
        }
        else {
            System.out.println(name + " broke even!");
        }
    }
}
