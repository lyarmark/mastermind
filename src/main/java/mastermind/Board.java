package mastermind;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel heading;
	private JPanel guessesPanel;
	private GuessPanel guesses[];
	private JButton check;

	private Game game;

	public Board() {
		setTitle("Mastermind");
		setSize(800, 600); // the frame will be the size of the computer screen.
							// these numbers are for arguments sake
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		this.heading = new JLabel("Mastermind");
		this.guessesPanel = new JPanel();
		this.guessesPanel.setLayout(new GridLayout(10, 1));
		this.guesses = new GuessPanel[10];

		for (GuessPanel g : this.guesses) {
			g = new GuessPanel();
			guessesPanel.add(g);
		}

		this.check = new JButton("CHECK/DONE/GUESS?");
		this.check.setSize(200, 50);
		check.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				game.addGuess(null);
			}
			
		});
		this.game = new Game();

		add(heading, BorderLayout.NORTH);
		add(guessesPanel, BorderLayout.CENTER);
		add(check, BorderLayout.SOUTH);
	}

}
