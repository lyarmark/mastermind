package mastermind;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ResultsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Peg[] pegs;
	
	public ResultsPanel() {
		setLayout(new GridLayout(2, 2));

		setBackground(Color.cyan);
		
		for(int i = 0; i < 4; i++){
			pegs[i] = new Peg(Color.black);
			add(pegs[i]);
		}
	}
	
	public void setResults(Color[] results){
		for(int i = 0; i < 4; i++){
			if(results[i] == null){
				break;
			} else{
				pegs[i].setColor(results[i]);
			}
		}
		repaint();
	}
}
