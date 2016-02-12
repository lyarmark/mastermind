package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Board extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel heading;
	private JPanel guessesPanel;
	private GuessPanel guesses[];
	private JButton check;
	private JButton undo;
	private JButton newGame;
	private int row;
	private Color lastColor;

	private Game game;

	public Board() {
		setTitle("Mastermind");
		setSize(400, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(255, 192, 203));
		setLayout(new BorderLayout());
		try {
		    setIconImage(ImageIO.read(new File("marbles.jpg")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		showInstructions();
		setUpGUI();
	}

	public Color getLastColor() {
		return lastColor;
	}

	private void playAgain(String message, ImageIcon icon) {
		Object[] options = { "Play Again", "EXIT" };
		int choice = JOptionPane.showOptionDialog(null, message, "Game Over", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

		if (choice == 0) {
			game = new Game();

			this.getContentPane().removeAll();
			this.setUpGUI();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();

		} else if (choice == 1) {
			this.dispose();
		}
	}

	private void setUpGUI() {
		this.heading = new JLabel("Mastermind");
		this.heading.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		this.heading.setHorizontalAlignment(JLabel.CENTER);
		this.heading.setBackground(new Color(255, 192, 203));

		this.guessesPanel = new JPanel();
		this.guessesPanel.setLayout(new GridLayout(10, 1));
		this.guessesPanel.setBackground(new Color(255, 192, 203));

		this.guesses = new GuessPanel[10];

		this.row = 9; // holds what panel we're up to.

		for (int i = 0; i < guesses.length; i++) {
			guesses[i] = new GuessPanel();
			guessesPanel.add(guesses[i]);
		}

		this.check = new JButton("CHECK");
		this.check.setSize(200, 50);
		this.check.addActionListener(this);

		this.game = new Game();

		JPanel bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));

		JPanel colorSelection = new JPanel();
		colorSelection.setLayout(new GridLayout(1, 6));
		Color[] colors = game.getColors();

		for (int i = 0; i < colors.length; i++) {
			final JButton button = new JButton(" ");
			button.setBackground(colors[i]);
			button.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			lastColor = colors[i];
			button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					guesses[row].setGuess(button.getBackground());
					repaint();
				}
			});

			colorSelection.add(button);
		}

		undo = new JButton("Undo");
		undo.addActionListener(this);
		newGame = new JButton("New Game");
		newGame.addActionListener(this);

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		
		buttons.add(undo);
		buttons.add(check);
		buttons.add(newGame);

		bottom.add(colorSelection);
		bottom.add(buttons);

		add(heading, BorderLayout.NORTH);
		add(guessesPanel, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}

	private void showInstructions() {
		JTextArea instructions = new JTextArea();
		instructions.setText("Welcome to MasterMind!\n" + "The object of the game is to solve the secret code.\n"
				+ "How to play:\n" + "Choose 4 colors from the row of buttons on the bottom.\n"
				+ "Once you have made your selection, press the 'Check' button.\n"
				+ "The panel of 4 colored circles to the left will demonstrate how many are correct.\n"
				+ "A red circle means there is a color in the correct place.\n"
				+ "A white circle means there is a correct color but it is not in the correct place.\n"
				+ "If all four circles turn gray, there are no correct colors on the row.\n"
				+ "If you mistakenly chose a color, select the undo button to delete the move.\n"
				+ "Click 'OK' to continue.\n" + "Good Luck!\n");
		JOptionPane.showMessageDialog(null, instructions);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check) {
			try {
				Color[] results = game.addGuess(guesses[row].getGuess());
				guesses[row].setResults(results);
				row--;
				// you won- because all 4 results are red
				// checking if the last result is read because all results are
				// filled at they are sorted with red first
				if (results[results.length - 1] == Color.red) {
					// fireworks
					ImageIcon fireworks = new ImageIcon("Animated-fireworks-changing-colors.gif");
					playAgain("You Won!", fireworks);
				}
				if (row < 0) {
					playAgain("Sorry! You did not guess the secret code.", null);
				}
			} catch (GuessNotFullException e1) {
				JOptionPane.showMessageDialog(null, "You have not filled up the required number of guesses.");
			}
		} else if (e.getSource() == undo) {
			undo();
		} else if (e.getSource() == newGame) {
			game = new Game();

			this.getContentPane().removeAll();
			this.setUpGUI();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
	}

	public void undo() {
		guesses[row].undo();
	}
}
