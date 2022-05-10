
package finalproject;

/**
 *
 * @author Luke Schaefer 18186970
 */
public enum Face {
    
    Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
    
    public int getNum() {
        return this.ordinal() + 1;
    }
}

