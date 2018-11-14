package screenDisplay;

import misc.Constants;

public class MainArea {
	
	double width, height;	
	int xCoords[], yCoords[];
	SimpleLabel[] labels;
	SimpleLabel[] names;
	
	public MainArea(double width, double height) {
		this.width = width;
		this.height = height;
		this.labels = new SimpleLabel[Constants.MAIN_AREA_NUMBER_OF_LABELS];
		this.names = new SimpleLabel[Constants.MAIN_AREA_NAMES.length];
		generateCoords();
		generateLabels();
	}
	
	public void generateCoords() {
		int counter=1;
		this.xCoords = new int[Constants.MAIN_AREA_NUMBER_OF_LABELS];
		this.yCoords = new int[Constants.MAIN_AREA_NUMBER_OF_LABELS];		
		this.xCoords[0] = (int) (Constants.BORDER_SIZE + Constants.BIG_GAP_X);
		this.yCoords[0] = (int) (Constants.BORDER_SIZE);		
		for (int i=1; i<Constants.MAIN_AREA_SIZE_Y; i++) {
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
			SimpleLabel l = new SimpleLabel(xCoords[i+1], yCoords[i+1]
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
	
}
