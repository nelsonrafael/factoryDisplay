package dataStructure;

import java.awt.Color;
import java.awt.Graphics;

import misc.Constants;

public abstract class Shape {
	
	protected int x, y, width, height;
	protected Color c;
	
	public Shape(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = Constants.COLOR_BLACK;
	}
	
	public void setColor(Color c) {
		this.c=c;
	}
	
	abstract public void draw(Graphics g);
	
}
