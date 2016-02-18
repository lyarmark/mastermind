package mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Color[] solution; // solution set
	private Color[] colors; // colors to choose from
	private Color[] tempGuesses;
	private int difficulty; //the difficulty - 4 = easy, 5 = medium, 6 = hard

	public Game(int difficultyLevel) {
		difficulty = difficultyLevel;
		colors = new Color[8];
		solution = new Color[difficulty];

		colors[0] = Color.YELLOW;
		colors[1] = Color.BLUE;
		colors[2] = Color.RED;
		colors[3] = Color.GREEN;
		colors[4] = new Color(255, 114, 86);
		colors[5] = new Color(255, 0, 255);
		colors[6] = new Color(186, 85, 211);
		colors[7] = new Color(0, 229, 238);

		Random rand = new Random();

		// Create the solution set - get a random int, match it up to the
		// colors, then add that color to the solution set;
		for (int i = 0; i < difficulty; i++) {
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
		Color[] results = new Color[difficulty];
		int counter = 0; // what position we're up to in the results array
		for (int i = 0; i < difficulty; i++) {
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
			for (int i = 0; i < difficulty; i++) {
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

	//for the tests
	public void setSolution(Color[] solution) {
		this.solution = solution;
	}
	
	public Color[] getSolution(){
		return solution;
	}
}
