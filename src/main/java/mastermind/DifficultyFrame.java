package mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DifficultyFrame extends JFrame implements ActionListener{
	JButton easy, medium, hard;
	
	public DifficultyFrame(){
		setTitle("Choose Difficulty");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		easy = new JButton("Easy - 4 pieces in solution");
		easy.addActionListener(this);
		medium = new JButton("Medium - 5 pieces in solution");
		medium.addActionListener(this);
		hard = new JButton("Hard - 6 pieces in solution");
		hard.addActionListener(this);
		setVisible(true);
		
		add(easy);
		add(medium);
		add(hard);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == easy){
			new Board(4);
			this.dispose();
		} else if(e.getSource() == medium){
			new Board(5);
			this.dispose();
		} else if(e.getSource() == hard){
			new Board(6);
			this.dispose();
		}
		
	}
}
