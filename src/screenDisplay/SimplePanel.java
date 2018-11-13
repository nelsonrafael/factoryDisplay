package screenDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

import dataStructure.*;
import informationRetrieval.FetchSAP;

@SuppressWarnings("serial")
public class SimplePanel extends JPanel {
	
	final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private static final int TIME_COUNT_TOTAL = 300;
	private static final int TIME_COUNT_ROTATIVE = 5;
	private static final int TIME_COUNT_UNIT = 1000;
		
	private Timer timer;
	private int rotativeCount;
	private int count;

	private Line[] lines;
	
	SimpleLabel[] labels = new SimpleLabel[5];
	SimpleLabel timeDateLabel;
	
	int timeDateX;
	int timeDateY;
	int timeDateWidth;
	int timeDateHeight;

	double width;
	double height;

	int widthGap;
	int heightGap;
	int smallY;
	int smallX;
	int bigX;
	int bigY;

	int[] xPos = new int[5];
	int[] yPos = new int[5];
	int[] xSize = new int[5];
	int[] ySize = new int[5];

	String font = "Serif";
	int fontSize = 40;
	int borderSize = 12;
	
	String timeDateFont = "Monospace";
	int timeDateFontSize = 60;

	Color black = new Color(0, 0, 0);
	Color red = new Color(255, 0, 0);

	public SimplePanel() {
		
		setLines();

		setDimension();

		setPercentages();

		setArrays();

		setLayout(null);

		for (int i = 0; i < labels.length; i++) {
			SimpleLabel l = new SimpleLabel(xPos[i], yPos[i], xSize[i], ySize[i]);
			l.setBorder(black, borderSize);
			l.setText(lines[i].getName(), red, font, fontSize);
			labels[i] = l;
			this.add(l);
		}
		
		timeDateLabel = new SimpleLabel(timeDateX, timeDateY, timeDateWidth, timeDateHeight);
		this.add(timeDateLabel);

		timer = new Timer(TIME_COUNT_UNIT, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				count++;
				rotativeCount++;
				
				Calendar now = Calendar.getInstance();
	            //System.out.println(dateFormat.format(now.getTime()));
				timeDateLabel.setText(dateFormat.format(now.getTime()), black, timeDateFont, timeDateFontSize);
				
		        if (rotativeCount < TIME_COUNT_ROTATIVE) {
		          //System.out.println(rotativeCount);
		        } else {
		          //((Timer) (e.getSource())).stop();
		        	rotativeCount=rotativeCount-TIME_COUNT_ROTATIVE;
		        	
		        	Line l = lines[0];
		        	lines[0] = lines[1];
		        	lines[1] = lines[2];
		        	lines[2] = lines[3];
		        	lines[3] = lines[4];
		        	lines[4] = l;
		        	
		        	for (int i = 0; i < labels.length; i++) {
		        		labels[i].setText(lines[i].getName(), red, font, fontSize);
		        	}
		        	
		        }
				
		        if (count < TIME_COUNT_TOTAL) {
		        	//System.out.println(count);
		        } else {
		        	//((Timer) (e.getSource())).stop();
		        	count=count-TIME_COUNT_TOTAL;
		        	//TODO
		        }
			}
		});
		timer.setInitialDelay(0);
		timer.start();

	}

	void setLines() {
		this.lines=FetchSAP.getLines();
		
		/*
		for(int i=0; i<lines.length; i++) {
			System.out.println(lines[i].getName());
		}
		*/
	}

	void setPercentages() {

		this.widthGap = (int) (width * 3 / 200);
		this.heightGap = (int) (height / 50);
		this.smallY = (int) (height * 23 / 100);
		this.smallX = (int) (width * 33 / 100);
		this.bigX = (int) (width * 63 / 100);
		this.bigY = (int) (height * 89 / 100);

		this.timeDateHeight = (int) (height * 6 / 100);
		this.timeDateWidth = (int) (width / 2);
		this.timeDateX = (int) (width / 5);
		this.timeDateY = (int) (height * 23 / 25);
	}

	void setArrays() {

		this.xPos[0] = this.widthGap;
		this.xPos[1] = this.widthGap * 2 + this.bigX;
		this.xPos[2] = this.xPos[1];
		this.xPos[3] = this.xPos[1];
		this.xPos[4] = this.xPos[1];

		this.yPos[0] = this.heightGap;
		this.yPos[1] = this.heightGap;
		this.yPos[2] = this.heightGap * 2 + this.smallY;
		this.yPos[3] = this.heightGap * 3 + this.smallY * 2;
		this.yPos[4] = this.heightGap * 4 + this.smallY * 3;

		this.xSize[0] = this.bigX;
		this.xSize[1] = this.smallX;
		this.xSize[2] = this.xSize[1];
		this.xSize[3] = this.xSize[1];
		this.xSize[4] = this.xSize[1];

		this.ySize[0] = this.bigY;
		this.ySize[1] = this.smallY;
		this.ySize[2] = ySize[1];
		this.ySize[3] = ySize[1];
		this.ySize[4] = ySize[1];
	}

	void setDimension() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.width = screenSize.getWidth();
		this.height = screenSize.getHeight();

		/*
		 * System.out.println(width); System.out.println(height);
		 */
	}

}
