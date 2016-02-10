package mastermind;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class InstructionDialog extends JDialog {
	public InstructionDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Instructions");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(500, 300);

		JLabel welcome = new JLabel("Welcome to MasterMind!");
		add(welcome);
		JLabel object = new JLabel("The object of the game is to solve the secret code.");
		add(object);
		JLabel label1 = new JLabel("How to play:");
		JLabel label2 = new JLabel(
				"Choose 4 colors from the row of buttons on the bottom.");
		JLabel label3 = new JLabel(
				"Once you have made your selection, press the 'Check' button.");
		JLabel label4 = new JLabel(
				"The panel of 4 colored circles to the left will demonstrate how many are correct.");
		JLabel label5 = new JLabel(
				"A red circle means there is a color in the correct place.");
		JLabel label6 = new JLabel(
				"A white circle means there is a correct color but it is not in the correct place.");
		JLabel label7 = new JLabel(
				"If all four circles turn gray, there are no correct colors on the row.");
		JLabel label8 = new JLabel(
				"If you mistakenly chose a color, select the undo button to delete the move.");
		JLabel label9 = new JLabel("Good Luck!");

		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label7);
		add(label8);
		add(label9);
	}
}
