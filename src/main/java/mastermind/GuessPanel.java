package mastermind;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GuessPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ResultsPanel results;
	private Peg[] pegs;
	private int lastPiece;

	public GuessPanel(int difficulty) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(255, 192, 203));
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.results = new ResultsPanel(difficulty);
		this.results.setSize(1500, 40);
		pegs = new Peg[difficulty];
		lastPiece = 0;

		add(results);

		for (int i = 0; i < pegs.length; i++) {
			pegs[i] = new Peg(Color.white, 'a');
			add(pegs[i]);
		}
	}

	public void setResults(Color[] resultArray) {
		results.setResults(resultArray);
	}

	public void undo() {
		if (lastPiece > 0) {
			lastPiece--;
			pegs[lastPiece].setColor(Color.WHITE);
			repaint();
		}
		//won't do anything if you press undo when there's nothing there to do
	}

	public Color[] getGuess() {
		Color[] guesses = new Color[pegs.length];

		for (int i = 0; i < pegs.length; i++) {
			if (pegs[i].getColor() == Color.white) {
				throw new GuessNotFullException();
			}
			guesses[i] = pegs[i].getColor();
		}

		return guesses;
	}

	public void setGuess(Color color) {
		if (lastPiece == pegs.length) {
			// do nothing. guess is full
		} else {
			pegs[lastPiece].setColor(color);
			lastPiece++;
		}
	}
}
