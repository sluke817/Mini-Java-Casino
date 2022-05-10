
package finalproject;

/**
 *
 * @author Luke Schaefer 18186970
 * This player is intended to be used to play Baccarat
 */
public class BaccaratPlayer extends Player{
    
    private boolean handSelect;
    
    public BaccaratPlayer(String n) {
        super(n);
    }
    
    public boolean getSelection() {
        return handSelect;
    }
    
    public void setSelection(boolean x) {
        handSelect = x;
    }
    
    @Override
    public String toString() {
        String s = super.toString();
        
        if(handSelect) {
            s += "Playing the Robber Hand\n";
        }
        else {
            s += "Playing the Banker Hand\n"; 
        }
        return s;
    } 
}
