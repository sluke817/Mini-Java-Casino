
package finalproject;

/*
 *
 * @author Luke Schaefer 18186970
 * This class extends game and runs a game of one player betting Casino War.
 * Please refer to the README doc to see the rules of Casino War.
 */
public class CasinoWarGame extends Game{
    
    private Player player;
    private Card dealerCard;
    private Card playerCard;
    private boolean tie;
    
    public CasinoWarGame(String name) {
        player = new Player(name);
        deck = new Deck();
        playAgain = false;
        tie = false;
        
        super.player = player;
    }
    
    @Override
    public void clearTable() {
        deck = new Deck();
    }
    
    @Override
    public void deal() {
        playerCard = deck.dealCard();
        dealerCard = deck.dealCard();
    }
    
    @Override 
    public void playGame() {
        
        deal();
        
        System.out.println("**********");
        showTable();
        
        determineWinner();
        
        //determines wartime of the game
        while(tie) {
            int bet = player.getBet();
            System.out.println("Do you want to go to war (double down) or forfit now (recieve half of bet back)? Y/n:");
            boolean yorn = getYesOrNo();
            //go to war
            if(yorn) {
                for(int i = 0; i < 4; i++) {
                    deal();
                    
                }
                showTable();
                player.placeBet(bet * 2);
                determineWinner();
            }
            //forfit the war
            else {
                System.out.println(player.getName() + " gets " + bet/2 + "$ back.");
                player.placeBet(bet/2);
                player.changeBalance(false);
            }
            
        }
        
    }
   
    public void showTable() {
        System.out.println(player);
        System.out.println(player.getName() + "'s card: " + playerCard);
        System.out.println("Dealer's card: " + dealerCard);
    }
    
    @Override
    public void determineWinner() {
        
        int wlt = playerCard.compareTo(dealerCard);
        //determines the larger card
        switch(wlt) {
            case 1: 
                player.announceWinOrLoss(true);
                tie = false;
                break;
            case -1:
                player.announceWinOrLoss(false);
                tie = false;
                break;
            case 0:
                System.out.println("Tie!");
                tie = true;
                break;
        }
    }
}
