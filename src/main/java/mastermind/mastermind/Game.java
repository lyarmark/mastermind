package mastermind.mastermind;

import java.awt.Color;
import java.util.Random;

public class Game {
	private Color[] solution; //solution set
	private Color[] colors; //colors to choose from
	private Color[] tempGuesses;
	
	public Game(){
		colors = new Color[6];
		solution = new Color[4];
		
		colors[0] = Color.YELLOW;
		colors[1] = Color.BLUE;
		colors[2] = Color.RED;
		colors[3] = Color.GREEN;
		colors[4] = Color.BLACK;
		colors[5] = Color.WHITE;
		
		Random rand = new Random();
		
		//Create the solution set - get a random int, match it up to the
		//colors, then add that color to the solution set;
		for(int i = 0; i < 4; i++){
			int color = rand.nextInt(6);
			solution[i] = colors[color];
		}
	}
	
	public Color[] getColors(){
		return colors;
	}
	//Add the new guesses
	//Returns an array of black and white
	public Color[] addGuess(Color[] guesses){
		this.tempGuesses = guesses;
		
		return checkGuess();
	}
	
	//Check the guess against the solution set.
	//Returns an array of black and white.
	private Color[] checkGuess(){
		Color[] results = new Color[4];
		int counter = 0; //what position we're up to in the results array
		for(int i = 0; i < 4; i++){
			if(tempGuesses[i].equals(solution[i])){
				results[counter] = Color.BLACK;
			}
		}
		
		return results;
	}
}
