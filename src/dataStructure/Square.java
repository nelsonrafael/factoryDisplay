package dataStructure;

import java.awt.Graphics;

public class Square extends Shape {

	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

}
