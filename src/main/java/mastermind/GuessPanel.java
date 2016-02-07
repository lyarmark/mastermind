package mastermind;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GuessPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ResultsPanel results;

	public GuessPanel() {
		setLayout(new GridLayout(1, 5));
		this.results = new ResultsPanel();

		add(results);
		add(new Peg(Color.WHITE));
		add(new Peg(Color.WHITE));
		add(new Peg(Color.WHITE));
		add(new Peg(Color.WHITE));
	}
}
