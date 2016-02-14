package mastermind;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

	@Test
	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void testSomeCorrect() {
		Color[] solution = new Color[4];
		solution[0] = Color.YELLOW;
		solution[1] = Color.black;
		solution[2] = Color.PINK;
		solution[3] = Color.RED;

		Game game = new Game(4);
		game.setSolution(solution);

		Color[] guess = new Color[4];
		guess[0] = Color.YELLOW;
		guess[1] = Color.BLUE;
		guess[2] = Color.BLACK;
		guess[3] = Color.GRAY;

		Color[] results = game.addGuess(guess);
		Color[] checkResults = new Color[4];
		checkResults[0] = Color.RED;
		checkResults[1] = Color.WHITE;

		Assert.assertArrayEquals(results, checkResults);
	}

	@Test
	public void testAllCorrect() {
		Color[] solution = new Color[4];
		solution[0] = Color.YELLOW;
		solution[1] = Color.BLACK;
		solution[2] = Color.PINK;
		solution[3] = Color.RED;

		Game game = new Game(4);
		game.setSolution(solution);

		Color[] guess = new Color[4];
		guess[0] = Color.YELLOW;
		guess[1] = Color.BLACK;
		guess[2] = Color.PINK;
		guess[3] = Color.RED;

		Color[] results = game.addGuess(guess);
		Color[] checkResults = new Color[4];
		for (int i = 0; i < 4; i++) {
			checkResults[i] = Color.RED;
		}

		Assert.assertArrayEquals(results, checkResults);
	}

	@Test
	public void testNoneCorrect() {
		Color[] solution = new Color[4];
		solution[0] = Color.YELLOW;
		solution[1] = Color.BLACK;
		solution[2] = Color.PINK;
		solution[3] = Color.RED;

		Game game = new Game(4);
		game.setSolution(solution);

		Color[] guess = new Color[4];
		guess[0] = Color.ORANGE;
		guess[1] = Color.WHITE;
		guess[2] = Color.BLUE;
		guess[3] = Color.GRAY;

		Color[] results = game.addGuess(guess);
		Color[] checkResults = new Color[4];

		Assert.assertArrayEquals(results, checkResults);
	}

	@Test
	public void testAllCorrectWrongPlace() {
		Color[] solution = new Color[4];
		solution[0] = Color.YELLOW;
		solution[1] = Color.BLACK;
		solution[2] = Color.PINK;
		solution[3] = Color.RED;

		Game game = new Game(4);
		game.setSolution(solution);

		Color[] guess = new Color[4];
		guess[0] = Color.PINK;
		guess[1] = Color.RED;
		guess[2] = Color.YELLOW;
		guess[3] = Color.BLACK;

		Color[] results = game.addGuess(guess);
		Color[] checkResults = new Color[4];
		for (int i = 0; i < 4; i++) {
			checkResults[i] = Color.WHITE;
		}

		Assert.assertArrayEquals(results, checkResults);
	}

	@Test
	public void testDoubles() {
		Color[] solution = new Color[4];
		solution[0] = Color.YELLOW;
		solution[1] = Color.BLACK;
		solution[2] = Color.PINK;
		solution[3] = Color.RED;

		Game game = new Game(4);
		game.setSolution(solution);

		Color[] guess = new Color[4];
		guess[0] = Color.YELLOW;
		guess[1] = Color.YELLOW;
		guess[2] = Color.PINK;
		guess[3] = Color.RED;

		Color[] results = game.addGuess(guess);
		Color[] checkResults = new Color[4];
		for (int i = 0; i < 3; i++) {
			checkResults[i] = Color.RED;
		}

		Assert.assertArrayEquals(results, checkResults);
	}

	@Test
	public void testOnlyDouble() {
		Color[] solution = new Color[4];
		solution[0] = Color.YELLOW;
		solution[1] = Color.BLACK;
		solution[2] = Color.PINK;
		solution[3] = Color.RED;

		Game game = new Game(4);
		game.setSolution(solution);

		Color[] guess = new Color[4];
		guess[0] = Color.YELLOW;
		guess[1] = Color.YELLOW;
		guess[2] = Color.YELLOW;
		guess[3] = Color.YELLOW;

		Color[] results = game.addGuess(guess);
		Color[] checkResults = new Color[4];
		checkResults[0] = Color.RED;

		Assert.assertArrayEquals(results, checkResults);
	}
}
