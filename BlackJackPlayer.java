package finalproject;
import java.util.ArrayList;
import java.util.ListIterator;

/*
 *
 * @author Luke Schaefer 18186970
 */
public class BlackJackPlayer extends Player {
    
    protected int score;
    protected boolean inPlay;
    protected ArrayList<Card> hand;
    
    public BlackJackPlayer(String n) {
        super(n);
        score = 0;
        inPlay = true;
        hand = new ArrayList<>();
    }
    
    public boolean isInPlay() {
        return inPlay;
    }
    
    public int getScore() {
        return score;
    }
    
    public void stand() {
        inPlay = false;
    }
    
    public void sit() {
        inPlay = true;
    }
   
    //calculates score of a hand using blackjack logic
    public int calculateScore() {
        int sum = 0;
        Card tmp;
        int aces = 0;
        ListIterator<Card> iterator = hand.listIterator();
        while(iterator.hasNext()) {
            tmp = iterator.next();
            if(tmp.getFace() == Face.Ace) {
                aces++;
            }
            else {
                int faceVal = tmp.getFaceVal();
                if(faceVal > 10) {
                    faceVal = 10;
                }
                sum += faceVal;
            }
        }
        if(aces > 0) {
            if(sum + 11 + aces - 1 > 21) {
                sum += aces;
            }
            else {
                sum += 11 + aces - 1;
            }
        } 
        return sum;
    }
    
    //adds any number of cards to a hand
    public void recieveCards(Card...cards) {
        for(Card card : cards) {
            hand.add(card);
            score = calculateScore();
            if(score >= 21) {
                inPlay = false;
            }  
        }
        
    }

    public void clearHand() {
        hand = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String s = super.toString();
        s+= "Hand: ";
        for(Card card : hand) {
            s+= card + ", ";
        }
        s+= "\n";
        if(score > 21) {
            s+= "Bust!\n";
        }
        else {
            s+= "Score: " + score + "\n";
        }
        return s;
    }  
}
