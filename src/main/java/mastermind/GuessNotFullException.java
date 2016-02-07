package mastermind;

public class GuessNotFullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GuessNotFullException() {
		super("You have not filled all the slots");
	}
}
