package mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DifficultyFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton easy, medium, hard;
	Board board;

	public DifficultyFrame(Board board) {
		setTitle("Choose Difficulty");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		this.board = board;

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
