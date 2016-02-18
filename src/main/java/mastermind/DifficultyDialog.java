package mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

public class DifficultyDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	JRadioButton easy, medium, hard;
	Board board;

	public DifficultyDialog(Board board) {
		setTitle("Choose Difficulty");
		setSize(300, 150);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		this.board = board;

		easy = new JRadioButton("Easy - 4 pieces in solution");
		easy.addActionListener(this);
		medium = new JRadioButton("Medium - 5 pieces in solution");
		medium.addActionListener(this);
		hard = new JRadioButton("Hard - 6 pieces in solution");
		hard.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);
		
		setVisible(true);

		add(easy);
		add(medium);
		add(hard);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == easy) {
			board.setDifficulty(4);
			this.dispose();
		} else if (e.getSource() == medium) {
			board.setDifficulty(5);
			this.dispose();
		} else if (e.getSource() == hard) {
			board.setDifficulty(6);
			this.dispose();
		}
	}
}
