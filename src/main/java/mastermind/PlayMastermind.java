package mastermind;


public class PlayMastermind {
	public static void main(String[] args) {
		Board board = new Board(4);
		new DifficultyDialog(board);
	}
}
