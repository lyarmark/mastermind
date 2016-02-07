package mastermind;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GuessPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ResultsPanel results;

	public GuessPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.results = new ResultsPanel();
		this.results.setSize(1500, 40);

		add(results);
		add(new Peg(Color.white, 'a'));
		add(new Peg(Color.white, 'a'));
		add(new Peg(Color.white, 'a'));
		add(new Peg(Color.white, 'a'));
	}
}
