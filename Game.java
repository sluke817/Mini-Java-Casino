
package finalproject;
import java.util.*;

/**
 *
 * @author Luke Schaefer 18186970
 * Abstract class that is used to generalize one player casino games
 */
public abstract class Game {
    
    //every game will have a deck, player, and playAgain control variable
    protected Deck deck;
    protected boolean playAgain;
    protected Player player;
    
    //abstract methods
    public abstract void playGame();
    public abstract void deal();
    public abstract void clearTable();
    public abstract void determineWinner();
    
    public boolean getPlayAgain() {
        return playAgain;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public boolean determinePlayAgain() {
        
        System.out.println(player.getName() + ", do you want to play again? Y/n:");
        boolean yorn = getYesOrNo();
        return yorn;
    }
    
    //a function to determine if the bet entered is valid
    public int getBetHelper(int minBet) throws BadInputException {
        System.out.println("Please enter a bet. Bet must be at least " + minBet + "$");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().trim().toLowerCase();
        try{
            int bet = Integer.parseInt(response);
            if(bet < minBet) {
                System.out.println("Does not meet minimum bet. Bet set to 0$");
                bet = 0;
            }
            return bet;
        }
        catch (NumberFormatException e) {
            throw new BadInputException("Bad input - " + response + " - is invalid.");
        }
        
    }
    
    //a method to get the correct bet if there is an invalid response
    public void getBet(int minBet) {
        int bet;
        try {
            bet = getBetHelper(minBet);
        }
        catch (BadInputException e){
            e.printError("Bet set to 0$");
            bet = 0;
        }
        player.placeBet(bet);
    }
    
    //a static method to recieve input of a list of strings. The list of strings must match the input by user
    public static String getInput(String...strings) {
        boolean badInput;
        String response = new String();
        do {
            try {
                response = getInputHelper(strings);
                badInput = false;
            }
            catch(BadInputException e) {
                e.printError("Please try again.");
                badInput = true;
            }
        }while(badInput);
        return response;
    }
    
    //a helper method for getInput
    public static String getInputHelper(String...strings) throws BadInputException {
        Scanner scanner = new Scanner(System.in);
        boolean badInput = true;
        String response = scanner.nextLine().trim().toLowerCase();
        for(String string : strings) {
            if(string.equals(response)) {
                badInput = false;
            }
        }
        if(badInput) {
            throw new BadInputException("Bad input - " + response + " - is invalid.");
        }
        return response;
    }
    
    //a more specified getInput method, in which only determines yes or no answers
    public static boolean getYesOrNo() {
        
        String response = getInput("y", "n", "yes", "no");
        if(response.equals("y") || response.equals("yes")) {
            return true;
        }
        else {
            return false;
        }
    }
}
