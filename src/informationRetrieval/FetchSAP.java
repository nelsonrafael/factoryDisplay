package informationRetrieval;

import screenDisplay.*;
import dataStructure.*;

public class FetchSAP {
	
	private static Line[] lines = new Line[5];

	public static void main(String[] args) {

		for (int i = 1; i <= lines.length; i++) {
			Line l = new Line("Linha " + i);
			lines[i - 1] = l;
		}

		SimpleWindow.createWindow();
	}
	
	public static Line[] getLines( ) {
		return FetchSAP.lines;
	}

}
