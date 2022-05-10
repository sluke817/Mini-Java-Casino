
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Luke Schaefer 18186970 
 * 
 * This class extends game and runs a game of one player betting Baccarat.
 * Please refer to the README doc to see the rules of Baccarat.
 * 
 */
public class BaccaratGame extends Game{
    
    private BaccaratPlayer player;
    private ArrayList<Card> bankerHand;
    private ArrayList<Card> robberHand;
    private int robberScore;
    private int bankerScore;
    
    public BaccaratGame(String name) {
            
        player = new BaccaratPlayer(name);
        deck = new Deck();
        playAgain = false;
        
        robberHand = new ArrayList<>();
        bankerHand = new ArrayList<>();
        
        robberScore = 0;
        bankerScore = 0;
        
        super.player = player;
    }
    
    @Override
    public void clearTable() {
        deck = new Deck();
        
        robberHand = new ArrayList<>();
        bankerHand = new ArrayList<>();
        
        robberScore = 0;
        bankerScore = 0;
    }
    
    @Override
    public void deal() {
        //adds two cards to both of the dealer and robber hands
        bankerHand.add(deck.dealCard());
        bankerHand.add(deck.dealCard());
        robberHand.add(deck.dealCard());
        robberHand.add(deck.dealCard());
    }
    
    @Override
    public void playGame() {
        
        System.out.println("Which hand would you like to play? Banker or Robber?");
        String response = getInput("banker", "robber");
        if(response.equals("banker")) {
            player.setSelection(false);
        }
        else {
            player.setSelection(true);
        }
        
        deal();
        runTable();
        determineWinner();
    }
    
    //runTable runs out the cards on the table, calculates the scores, and shows the player the cards
    public void runTable() {
        
        System.out.println("**********");
        System.out.print("Robber Hand: ");
        for(Card card : robberHand) {
            
            System.out.print(card);
            System.out.print(", ");
            robberScore += calcCard(card);
        }
        robberScore %= 10;
        System.out.println(" Score: " + robberScore);
        
        System.out.print("Banker Hand: ");
        for(Card card : bankerHand) {
            
            System.out.print(card);
            System.out.print(", ");
            bankerScore += calcCard(card);
        }
        bankerScore %= 10;
        System.out.println(" Score: " + bankerScore);
    }
    
    //calculates the score of the card.
    public int calcCard(Card card) {
        if(card.getFaceVal() < 10) {
            if(card.getFace() == Face.Ace) {
                return 1;
            }
            else {
                return card.getFaceVal();
            } 
        }
        return 0;
    }
    
    @Override
    public void determineWinner() {
        
        int rScoreCalc = Math.abs(robberScore - 9);
        int bScoreCalc = Math.abs(bankerScore - 9);
        
        System.out.println("**********");
        
        boolean playerSelect = player.getSelection();
        
        if(rScoreCalc < bScoreCalc) {
            System.out.println("Robber hand wins!");
            if(playerSelect) {
                player.announceWinOrLoss(true);
            }
            else {
                player.announceWinOrLoss(false);
            }
        }
        else if(rScoreCalc > bScoreCalc) {
            System.out.println("Banker hand wins!");
            if(!playerSelect) {
                player.announceWinOrLoss(true);
            }
            else {
                player.announceWinOrLoss(false);
            }
        }
        else {
            System.out.println("Tie! Bets back!");
        }  
    }
}
