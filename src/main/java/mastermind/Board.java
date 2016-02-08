package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel heading;
	private JPanel guessesPanel;
	private GuessPanel guesses[];
	private JButton check;
	private int row;
	private Color lastColor;

	private Game game;

	public Board() {
		setTitle("Mastermind");
		setSize(400, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(255, 192, 203));
		setLayout(new BorderLayout());

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
		/*
		 * check.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent arg0) { try {
		 * game.addGuess(guesses[row].getGuess()); row--; } catch
		 * (GuessNotFullException e) { JOptionPane.showMessageDialog(null,
		 * "You have not filled up the required number of guesses."); } }
		 * 
		 * });
		 */
		this.game = new Game();

		JPanel bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));

		JPanel colorSelection = new JPanel();
		colorSelection.setLayout(new BoxLayout(colorSelection, BoxLayout.X_AXIS));
		Color[] colors = game.getColors();

		for (int i = 0; i < colors.length; i++) {
			final JButton button = new JButton();
			button.setBackground(colors[i]);
			lastColor = colors[i];
			button.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					guesses[row].setGuess(button.getBackground());
					repaint();
				}
			});

			colorSelection.add(button);
		}

		bottom.add(colorSelection);
		bottom.add(check);

		add(heading, BorderLayout.NORTH);
		add(guessesPanel, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}

	public Color getLastColor() {
		return lastColor;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check) {
			try {
				game.addGuess(guesses[row].getGuess());
				row--;
			} catch (GuessNotFullException e1) {
				JOptionPane.showMessageDialog(null, "You have not filled up the required number of guesses.");
			}
		}
	}

}
