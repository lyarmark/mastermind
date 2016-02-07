package mastermind;

public class GuessNotFullException extends RuntimeException{
	public GuessNotFullException(){
		super("You have not filled all the slots");
	}
}
