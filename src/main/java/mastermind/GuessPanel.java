package mastermind;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GuessPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ResultsPanel results;
	private Peg[] pegs;

	public GuessPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(255, 192, 203));
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.results = new ResultsPanel();
		this.results.setSize(1500, 40);
		pegs = new Peg[4];

		add(results);

		for (int i = 0; i < 4; i++) {
			pegs[i] = new Peg(Color.white, 'a');
			add(pegs[i]);
		}
	}

	public Color[] getGuess() {
		Color[] guesses = new Color[4];

		for (int i = 0; i < 4; i++) {
			if (pegs[i].getColor() == Color.white) {
				throw new GuessNotFullException();
			}
			guesses[i] = pegs[i].getColor();
		}

		return guesses;
	}
}
