package screenDisplay;

import dataStructure.Shape;
import dataStructure.Square;
import misc.Constants;

public class SecondaryArea {
	
	private double width, height, gapX, gapY;	
	private int xCoords[], yCoords[];
	private SimpleLabel[] labels, names;
	private Shape top, bottom;
	
	public SecondaryArea(double width, double height, double gapX, double gapY, int[] topShape, int[] bottomShape) {
		this.width = width;
		this.height = height;
		this.gapX = gapX;
		this.gapY = gapY;
		this.labels = new SimpleLabel[Constants.SECONDARY_AREA_NUMBER_OF_LABELS];
		this.names = new SimpleLabel[Constants.SECONDARY_AREA_NUMBER_OF_NAMES];
		this.top = new Square(topShape[0], topShape[1], topShape[2], topShape[3]);
		this.bottom = new Square(bottomShape[0], bottomShape[1], bottomShape[2], bottomShape[3]);
		this.bottom.setColor(Constants.COLOR_WHITE);
		generateCoords();
		generateLabels();
	}
	
	public void generateCoords() {
		int counter=1;
		this.xCoords = new int[Constants.SECONDARY_AREA_NUMBER_OF_LABELS];
		this.yCoords = new int[Constants.SECONDARY_AREA_NUMBER_OF_LABELS];		
		this.xCoords[0] = (int) (Constants.BORDER_SIZE * 2 + Constants.BIG_GAP_X + gapX);
		this.yCoords[0] = (int) (Constants.BORDER_SIZE + gapY);		
		for (int i=1; i<Constants.SECONDARY_AREA_SIZE_Y; i++) {
			for (int j=0; j<Constants.SECONDARY_AREA_SIZE_X; j++) {
				this.xCoords[counter] = (int) ((width / (Constants.SECONDARY_AREA_SIZE_X - 1)) * j 
						+ Constants.BORDER_SIZE * 2 + Constants.BIG_GAP_X + gapX);
				this.yCoords[counter] = (int) (height / (Constants.SECONDARY_AREA_SIZE_Y) * i + gapY + Constants.MAIN_AREA_NAMES_VAR);
				counter++;
			}
		}
		//this.xCoords[Constants.SECONDARY_AREA_NUMBER_OF_LABELS - 1] = (int) (Constants.BORDER_SIZE * 2 + Constants.BIG_GAP_X + gapX);
		//this.yCoords[Constants.SECONDARY_AREA_NUMBER_OF_LABELS - 1] = (int) ((height * 3 / 4)  + gapY );	
	}
	
	public void generateLabels() {		
		for(int i=0; i<Constants.SECONDARY_AREA_NUMBER_OF_LABELS; i++) {		
			SimpleLabel l = new SimpleLabel(xCoords[i], yCoords[i], Constants.SECONDARY_AREA_LABEL_SIZE_X,
					Constants.SECONDARY_AREA_LABEL_SIZE_Y);
			//System.out.println(i + "(" + xCoords[i] + "," + yCoords[i] + ")");
			this.labels[i] = l;
		}
		
		for(int i=0; i<Constants.SECONDARY_AREA_NAMES.length; i++) {		
			SimpleLabel l = new SimpleLabel(xCoords[i+1], yCoords[i+1]
					-Constants.MAIN_AREA_NAMES_VAR, Constants.SECONDARY_AREA_LABEL_SIZE_X, Constants.SECONDARY_AREA_LABEL_SIZE_Y);
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
