package screenDisplay;

import misc.Constants;

public class SecondaryArea {
	
	double width, height, gapX, gapY;	
	int xCoords[], yCoords[];
	SimpleLabel[] labels;
	SimpleLabel[] names;
	
	public SecondaryArea(double width, double height, double gapX, double gapY) {
		this.width = width;
		this.height = height;
		this.gapX = gapX;
		this.gapY = gapY;
		this.labels = new SimpleLabel[Constants.SECONDARY_AREA_NUMBER_OF_LABELS];
		this.names = new SimpleLabel[Constants.SECONDARY_AREA_NAMES.length];
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
	
}
