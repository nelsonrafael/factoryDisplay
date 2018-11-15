package dataStructure;

import java.awt.Graphics;

public class Circle extends Shape{
	
	
	public Circle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, width, height);
	}
}
