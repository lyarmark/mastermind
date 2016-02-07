package mastermind;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GuessPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ResultsPanel results;
	private Peg[] pegs;

	public GuessPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(255, 192, 203));
		this.results = new ResultsPanel();
		this.results.setSize(1500, 40);
		pegs = new Peg[4];

		add(results);
		
		for(int i = 0; i < 4; i++){
			pegs[i] = new Peg(Color.white);
			pegs[i].addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					
				}
				
			});
			add(pegs[i]);
		}
	}
}
