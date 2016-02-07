package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame implements ActionListener{

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
		setSize(800, 600); // the frame will be the size of the computer screen.
							// these numbers are for arguments sake
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(255, 192, 203));
		setLayout(new BorderLayout());

		this.heading = new JLabel("Mastermind");
		heading.setFont(new Font("Times New Roman", Font.PLAIN, 67));
		heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setBackground(new Color(255, 192, 203));
		this.guessesPanel = new JPanel();
		this.guessesPanel.setLayout(new GridLayout(10, 1));
		guessesPanel.setBackground(new Color(255, 192, 203));
		this.guesses = new GuessPanel[10];
		row = 0; //holds what panel we're up to.
		for (GuessPanel g : this.guesses) {
			g = new GuessPanel();
			guessesPanel.add(g);
		}

		this.check = new JButton("CHECK");
		this.check.setSize(200, 50);
		check.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				game.addGuess(null);
				row++;
			}
			
		});
		this.game = new Game();

		JPanel bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
		JPanel colorSelection = new JPanel();
		colorSelection.setLayout(new BoxLayout(colorSelection, BoxLayout.X_AXIS));
		Color[] colors = game.getColors();
		
		for(Color color: colors){
			colorSelection.add(new Peg(color));
		}
		
		bottom.add(colorSelection);
		bottom.add(check);
		
		JLabel space = new JLabel("                                                 ");
		JLabel eastSpace = new JLabel("                                                 ");
		space.setSize(new Dimension((getWidth()/4), getHeight()));
		add(heading, BorderLayout.NORTH);
		add(space, BorderLayout.WEST);
		add(eastSpace, BorderLayout.EAST);
		add(guessesPanel, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Peg peg = (Peg) e.getSource();
		lastColor = peg.getColor();
	}
	
	public Color getLastColor(){
		return lastColor;
	}

}
