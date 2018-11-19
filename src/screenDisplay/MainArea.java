package screenDisplay;

import dataStructure.Shape;
import dataStructure.Square;
import misc.Constants;

public class MainArea {
	
	private double width, height;	
	private int xCoords[], yCoords[];
	private SimpleLabel[] labels, names;
	private Shape top, bottom;
	
	public MainArea(double width, double height, int[] topShape, int [] bottomShape) {
		this.width = width;
		this.height = height;
		this.labels = new SimpleLabel[Constants.MAIN_AREA_NUMBER_OF_LABELS];
		this.names = new SimpleLabel[Constants.MAIN_AREA_NUMBER_OF_NAMES];
		this.top = new Square(topShape[0], topShape[1], topShape[2], topShape[3]);
		this.bottom = new Square(bottomShape[0], bottomShape[1], bottomShape[2], bottomShape[3]);
		this.bottom.setColor(Constants.COLOR_WHITE);
		generateCoords();
		generateLabels();
	}
	
	public void generateCoords() {
		int counter=3;
		this.xCoords = new int[Constants.MAIN_AREA_NUMBER_OF_LABELS];
		this.yCoords = new int[Constants.MAIN_AREA_NUMBER_OF_LABELS];		
		this.xCoords[0] = (int) (Constants.BORDER_SIZE + Constants.BIG_GAP_X);
		this.yCoords[0] = - Constants.BIG_GAP_X;
		this.xCoords[1] = (int) (Constants.BORDER_SIZE + Constants.BIG_GAP_X);
		this.yCoords[1] = (int) (Constants.BORDER_SIZE + Constants.BIG_GAP_X * 2);
		this.xCoords[2] = (int) (Constants.BORDER_SIZE + Constants.BIG_GAP_X);
		this.yCoords[2] = (int) (Constants.BORDER_SIZE + Constants.BIG_GAP_X * 4);
		for (int i=3; i<Constants.MAIN_AREA_SIZE_Y; i++) {
			for (int j=0; j<Constants.MAIN_AREA_SIZE_X; j++) {
				this.xCoords[counter] = (int) ((width / Constants.MAIN_AREA_SIZE_X) * j + Constants.BORDER_SIZE + Constants.BIG_GAP_X);
				this.yCoords[counter] = (int) ((height / Constants.MAIN_AREA_SIZE_Y) * i + Constants.BORDER_SIZE);
				counter++;
			}
		}
	}
	
	public void generateLabels() {
		
		for(int i=0; i<Constants.MAIN_AREA_NUMBER_OF_LABELS; i++) {		
			SimpleLabel l = new SimpleLabel(xCoords[i], yCoords[i], Constants.MAIN_AREA_LABEL_SIZE_X, Constants.MAIN_AREA_LABEL_SIZE_Y);
			this.labels[i] = l;
		}
		
		for(int i=0; i<Constants.MAIN_AREA_NAMES.length; i++) {		
			SimpleLabel l = new SimpleLabel(xCoords[i+3], yCoords[i+3]
					-Constants.MAIN_AREA_NAMES_VAR, Constants.MAIN_AREA_LABEL_SIZE_X, Constants.MAIN_AREA_LABEL_SIZE_Y);
			this.names[i] = l;
		}
	}
	
	public SimpleLabel getLabel(int n) {
		return this.labels[n];
	}
	
	public SimpleLabel[] getLabels() {
		return this.labels;
	}

	public SimpleLabel getName(int n) {
		return this.names[n];
	}
	
	public SimpleLabel[] getNames() {
		return this.names;
	}
	
	public Shape getTopShape() {
		return this.top;
	}
	
	public Shape getBottomShape() {
		return this.bottom;
	}
	
}
