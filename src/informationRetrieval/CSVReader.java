package informationRetrieval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dataStructure.*;

public class CSVReader {
	
	public CSVReader(String filePath) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = null;
		Scanner scanner = null;
		int index = 0;
		int lineNumber = 0;
		List<Line> lineList = new ArrayList<>();
		
		while ((line = reader.readLine()) != null) {
			Line l = new Line();
			scanner = new Scanner(line);
			scanner.useDelimiter(";");
			while (scanner.hasNext() && lineNumber!=0) {
				String data = scanner.next();
				l.set_id(index);
				if (index == 0)
					l.set_cTrab(Integer.parseInt(data));
				else if (index == 1)//TODO
					emp.setName(data);
				else if (index == 2)
					emp.setRole(data);
				else if (index == 3)
					emp.setSalary(data);
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			lineNumber++;
			lineList.add(l);
		}
		reader.close();
		System.out.println(lineList);
	}

}
