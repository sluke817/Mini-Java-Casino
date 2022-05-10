
package finalproject;

/**
 *
 * @author Luke Schaefer 18186970
 * Used to create a desired run time error for input
 */
public class BadInputException extends RuntimeException{
    public BadInputException(String errorMessage) {
        super(errorMessage);
    }
    public void printError(String postErrorMessage) {
        System.out.println("*** Error ***");
        System.out.println(this.getMessage());
        System.out.println(postErrorMessage);
    }
}
