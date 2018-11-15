package informationRetrieval;

import dataStructure.*;
import misc.*;

public class CompareLineCode {

	private Line[][] linesToDisplay;

	public CompareLineCode(CSVReader reader) {

		linesToDisplay = new Line[Constants.LINE_CODES_TO_DISPLAY.length][4];

		for (int i = 0; i < Constants.LINE_CODES_TO_DISPLAY.length; i++) {
			for (int j = 0; j < reader.getLineList().size(); j++) {
				for (int k = 0; k < Constants.SHIFT_NAMES.length; k++) {
					if (Constants.LINE_CODES_TO_DISPLAY[i] == reader.getLineList().get(j).get_cTrab()) {
						if (Constants.SHIFT_NAMES[k].equals(reader.getLineList().get(j).get_turno())) {
							linesToDisplay[i][k] = reader.getLineList().get(j);
						}
					}
				}
			}
		}
	}

	public Line[][] getLinesToDisplay() {
		return this.linesToDisplay;
	}

}
