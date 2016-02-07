package mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

public class Peg extends JComponent implements ActionListener{
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
		this.width = 30;
		this.height = 30;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(this.color);
		g.fillOval(getWidth() / 2, getHeight() / 2, this.width, this.height);
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
