package mastermind;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ResultsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Peg[] pegs;
	private int difficulty;
	
	public ResultsPanel(int difficulty) {
		this.difficulty = difficulty;
		setLayout(new GridLayout(0, 2));

		setBackground(Color.cyan);
		pegs = new Peg[this.difficulty];
		
		for(int i = 0; i < pegs.length; i++){
			pegs[i] = new Peg(Color.black);
			add(pegs[i]);
		}
	}
	
	public void setResults(Color[] results){
		for(int i = 0; i < pegs.length; i++){
			if(results[i] == null){
				break;
			} else{
				pegs[i].setColor(results[i]);
			}
		}
		repaint();
	}
}
