
package finalproject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 *
 * @author Luke Schaefer 18186970
 * A standard 52 card deck
 */
public class Deck {
    
    List<Card> deck;
    
    public Deck() {
        deck = new ArrayList<>();
        int i = 0;
        for(Suit suit : Suit.values()) {
            for(Face value : Face.values()) {
                deck.add(new Card(suit, value));
            }
        }
        Collections.shuffle(deck);
    }
    
    public Card dealCard() {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public void printDeck() {
        int i = 0;
        for(Card card : deck) {
            System.out.println(card);
            i++;
        }
        System.out.println("Number of cards in deck: " + i);
    }
}
