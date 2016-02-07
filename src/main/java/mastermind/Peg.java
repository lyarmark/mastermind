package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Peg extends JComponent {
	private static final long serialVersionUID = 1L;
	private Color color;

	public Peg(Color color) {
		this.color = color;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(this.color);
		g.fillOval(0, 0, 50, 50);
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
