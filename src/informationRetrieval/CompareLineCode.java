package informationRetrieval;

import dataStructure.*;
import misc.*;

public class CompareLineCode {
	
	private Line[] linesToDisplay;
	
	public CompareLineCode(CSVReader reader) {
		
		linesToDisplay = new Line[Constants.LINE_CODES_TO_DISPLAY.length];
		
		for(int i=0; i<Constants.LINE_CODES_TO_DISPLAY.length; i++) {
			for(int j=0; j<reader.getLineList().size(); j++) {
				if(Constants.LINE_CODES_TO_DISPLAY[i]==reader.getLineList().get(j).get_cTrab()) {
					linesToDisplay[i]=reader.getLineList().get(j);
				}
			}
		}
	}
	
	public Line[] getLinesToDisplay() {
		return this.linesToDisplay;
	}

}
