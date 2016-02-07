package mastermind;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Peg extends JComponent {
	private static final long serialVersionUID = 1L;
	private Color color;
	private int width;
	private int height;

	public Peg(Color color) {
		this.color = color;
		this.width = 20;
		this.height = 20;
	}

	public Peg(Color color, char c) {
		this.color = color;
		this.width = 40;
		this.height = 40;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(this.color);
		g.fillOval((getWidth() / 2) - this.width / 2, (getHeight() / 2) - this.height / 2, this.width, this.height);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
