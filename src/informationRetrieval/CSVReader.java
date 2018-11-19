package informationRetrieval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dataStructure.*;

public class CSVReader {

	private List<Line> lineList;

	public CSVReader(String filePath) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = null;
		Scanner scanner = null;
		int index = 0;
		int lineNumber = 0;
		lineList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			Line l = new Line();
			scanner = new Scanner(line);
			scanner.useDelimiter(";");
			while (scanner.hasNext() && lineNumber != 0) {
				String data = scanner.next();
				l.set_id(lineNumber);
				if (index == 0)
					l.set_cTrab(Integer.parseInt(data));
				else if (index == 1)
					l.set_descritivo(data);
				else if (index == 2)
					l.set_turno(data);
				else if (index == 3)
					l.set_qtProd(Integer.parseInt(data));
				else if (index == 4)
					l.set_qtRwk(Integer.parseInt(data));
				else if (index == 5)
					l.set_objHora(Integer.parseInt(data));
				else if (index == 6)
					l.set_realHora(Integer.parseInt(data));
				else if (index == 7)
					l.set_tTot(Double.parseDouble(data.replaceAll(",", ".")));
				else if (index == 8)
					l.set_tAbert(Double.parseDouble(data.replaceAll(",", ".")));
				else if (index == 9)
					l.set_tA(Integer.parseInt(data));
				else if (index == 10)
					l.set_tProd(Double.parseDouble(data.replaceAll(",", ".")));
				else if (index == 11)
					l.set_tP(Integer.parseInt(data));
				else if (index == 12)
					l.set_tUtil(Double.parseDouble(data.replaceAll(",", ".")));
				else if (index == 13)
					l.set_tU(Integer.parseInt(data));
				else if (index == 14)
					l.set_traffic(data);
				else if (index == 15)
					l.set_status(data);
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			lineNumber++;
			l.set_dif(l.get_realHora()-l.get_objHora());
			lineList.add(l);
		}
		reader.close();
	}

	public List<Line> getLineList() {
		return this.lineList;
	}

}
