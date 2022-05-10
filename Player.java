
package finalproject;


/**
 *
 * @author Luke Schaefer 18186970
 */
public class Player {
    
    
    protected int bet;
    protected int balance;
    protected String name;
    
    public Player(String n) {
        name = n;
        bet = 0;
        balance = 0;
    }
    
    
    public String getName() {
        return name;
    }
    
    public final void placeBet(int x) {
        bet = x;
    }
    
    public int getBet() {
        return bet;
    }
    
    public int getBalance() {
        return balance;
    }
    
    //announces the win or loss then sets the total correctly
    public void announceWinOrLoss(boolean win) {
        System.out.println("**********");
        System.out.println(this);
        if(win) {
            System.out.println(name + " won " + bet + "$");
            changeBalance(true);
        }
        else {
            System.out.println(name + " lost " + bet + "$");
            changeBalance(false);
        }
    }
     
    public void changeBalance(boolean win) {
        if(win) {
            balance += bet;
        }
        else {
            balance -= bet;
        }
        
    }

    @Override
    public String toString() {
        String s = name;
        if(!name.equalsIgnoreCase("dealer")) {
            s+= " --- Bet: " + bet + "$\n";
        }
        else {
            s+= "\n";
        }
        return s;
    }
    
}
