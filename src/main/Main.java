package main;

import java.io.IOException;

import informationRetrieval.*;
import misc.*;
import screenDisplay.*;

public class Main {

	public static void main(String[] args) {
		
		CSVReader reader = null;
		
		try {
			reader = new CSVReader(Constants.FILE_PATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CompareLineCode compare = new CompareLineCode(reader);
		
		SimpleWindow.createWindow(compare.getLinesToDisplay());
		
	}	
	
}
