package finalproject;

/**
 *
 * @author Luke Schaefer 18186970
 * A standard playing card with a face and suit
 */
public class Card implements Comparable{
    
    private final Suit suit;
    private final Face face;
    
    public Card(Suit s, Face f) {
        suit = s;
        face = f;
    }
    
    public Card(Card card) {
        suit = card.getSuit();
        face = card.getFace();
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public Face getFace() {
        return face;
    }
    
    //gets the numeric value of the card 1-12
    public int getFaceVal() {
        return face.getNum();
    }
    
    @Override
    public int compareTo(Object card) {
        Card c2 = (Card)card;
        if(face.getNum() == c2.getFaceVal()) {
            return 0;
        }
        else if(face.getNum() > c2.getFaceVal()) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        String s = face + " of " + suit;
        return s;
    }
}
