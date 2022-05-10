
package finalproject;
/**
 *
 * @author Luke Schaefer
 * This class extends game and runs a game of one player betting BlackJack.
 * Please refer to the README doc to see the rules of BlackJack.
 */
public class BlackJackGame extends Game{
    
    private BlackJackPlayer player;
    private BlackJackDealer dealer;
    
    public BlackJackGame(String name) {
            
        player = new BlackJackPlayer(name);
        dealer = new BlackJackDealer();
        deck = new Deck();
        playAgain = false;
        
        super.player = player;
    }
    
    @Override
    public void clearTable() {
        deck = new Deck();
        player.clearHand();
        dealer.clearHand();
        player.sit();
        dealer.sit();
    }
    
    
    @Override
    public void playGame() {
        
        deal();
        showTable(false);
        
        while(player.isInPlay()) {
            
            System.out.println("Hit or stand?");
            String response = getInput("hit", "stand");
            if (response.equals("hit")) {
                    Card dealt = deck.dealCard();
                    player.recieveCards(dealt);
                    System.out.println("***Hit!*** Dealt: " + dealt + " - Current Score: " + player.getScore());
                }
                else {
                    player.stand();
                }
        }
        if(player.getScore() > 21) {
            System.out.println(player.getName() + " busts!");
        }
        else {
            System.out.println(player.getName() + " stands with " + player.getScore());
        }
        
        while(dealer.isInPlay()) {
        
            dealer.recieveCards(deck.dealCard());
        }
        System.out.println("**********");
        System.out.println("Final table:");
        showTable(true);
        determineWinner(); 
    }
    
    @Override
    public void determineWinner() {
        
        int cScore = player.getScore();
        int dScore = dealer.getScore();
        String name = player.getName();
        int bet = player.getBet();
        
        //both bust, or tie
        if(dScore > 21 && cScore > 21 || dScore == cScore) {
            System.out.println("Tie! Bets back!");
        }
        //player busts
        else if(cScore > 21) {
            System.out.println(name + " busted! " +  name + " lost " + bet + "$");
            player.changeBalance(false);
        }
        //dealer busts
        else if(dScore > 21) {
            System.out.println("Dealer busted! " +  name + " won " + bet + "$");
            player.changeBalance(true);
        }
        //player score higher
        else if(cScore > dScore) {
            System.out.println(name + " won! " + name + " won " + bet + "$");
            player.changeBalance(true);
        }
        //dealer score higher
        else {
            System.out.println("Dealer wins! " +  name + " lost " + bet + "$");
            player.changeBalance(false);
        } 
    }
    
    @Override
    public void deal() {
        //deals two cards to each of the decks
        player.recieveCards(deck.dealCard(), deck.dealCard());
        dealer.recieveCards(deck.dealCard(), deck.dealCard());
    }
    
    public void showTable(boolean dealerShow) {
        System.out.println("**********");
        if(dealerShow) {
            System.out.println(player);
            System.out.println(dealer);
        }
        else {
            System.out.println(player);
            System.out.println("Dealer: " + dealer.showOne());
        }
        System.out.println("**********");
    }
}
