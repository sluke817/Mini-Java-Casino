
package finalproject;

/**
 *
 * @author Luke Schaefer
 * Intended to be used in a Blackjack game.
 * 
 */
public class BlackJackDealer extends BlackJackPlayer{
    
    public BlackJackDealer() {
        super("Dealer");
    }
    
    @Override 
    public void recieveCards(Card...cards) {
        for(Card card : cards) {
            hand.add(card);
            score = calculateScore();
            if(score > 16) {
                inPlay = false;
            }
        }
    }
    
    public Card showOne() {
        return hand.get(0);
    }
}
