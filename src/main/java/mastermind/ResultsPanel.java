package mastermind;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ResultsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public ResultsPanel() {
		setLayout(new GridLayout(2, 2));

		setBackground(Color.cyan);
		add(new Peg(Color.green));
		add(new Peg(Color.blue));
		add(new Peg(Color.pink));
		add(new Peg(Color.WHITE));
	}
}
