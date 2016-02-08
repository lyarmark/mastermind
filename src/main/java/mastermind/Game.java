package mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Color[] solution; // solution set
	private Color[] colors; // colors to choose from
	private Color[] tempGuesses;

	public Game() {
		colors = new Color[6];
		solution = new Color[4];

		colors[0] = Color.YELLOW;
		colors[1] = Color.BLUE;
		colors[2] = Color.RED;
		colors[3] = Color.GREEN;
		colors[4] = Color.BLACK;
		colors[5] = Color.PINK;

		Random rand = new Random();

		// Create the solution set - get a random int, match it up to the
		// colors, then add that color to the solution set;
		for (int i = 0; i < 4; i++) {
			int color = rand.nextInt(6);
			solution[i] = colors[color];
		}

	}

	public Color[] getColors() {
		return colors;
	}

	// Add the new guesses
	// Returns an array of black and white
	public Color[] addGuess(Color[] guesses) {
		this.tempGuesses = guesses;

		return checkGuess();
	}

	// Check the guess against the solution set.
	// Returns an array of black and white.
	private Color[] checkGuess() {
		Color[] results = new Color[4];
		int counter = 0; // what position we're up to in the results array
		for (int i = 0; i < 4; i++) {
			if (tempGuesses[i].equals(solution[i])) {
				results[counter] = Color.RED;
				counter++;
			}
		}

		int red = counter;
		int white = 0;

		ArrayList<Integer> alreadyChecked = new ArrayList<Integer>();
		// Look for the correct color, wrong place - for each color
		// in the solution set, check the guesses to see if it's in there
		for (Color color : solution) {
			for (int i = 0; i < 4; i++) {
				if (color.equals(tempGuesses[i]) && !alreadyChecked.contains(i)) {
					alreadyChecked.add(i);
					white++;
					break;
				}
			}
		}
		// The for loop picked up on the correct color & place, so
		// now subtract the total amount of total corrects from the white
		white -= red;

		while (white > 0) {
			results[counter] = Color.WHITE;
			counter++;
			white--;
		}

		// no pegs of this color
		if (counter == 0) {
			for (int i = 0; i < results.length; i++) {
				results[i] = Color.gray;
			}
		}

		return results;
	}

	// This is only for the test and should be deleted before being handed in:
	public void setSolution(Color[] solution) {
		this.solution = solution;
	}
}
