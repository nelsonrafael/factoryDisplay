package informationRetrieval;

import dataStructure.*;
import misc.*;

public class CompareLineCode {
	
	private Line[] linesToDisplay;
	
	public CompareLineCode(CSVReader reader) {
		
		linesToDisplay = new Line[Constants.lineCodesToDisplay.length];
		
		for(int i=0; i<Constants.lineCodesToDisplay.length; i++) {
			for(int j=0; j<reader.getLineList().size(); j++) {
				if(Constants.lineCodesToDisplay[i]==reader.getLineList().get(j).get_cTrab()) {
					linesToDisplay[i]=reader.getLineList().get(j);
				}
			}
		}
	}
	
	public Line[] getLinesToDisplay() {
		return this.linesToDisplay;
	}

}
