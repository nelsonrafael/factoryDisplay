package screenDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dataStructure.*;
import informationRetrieval.FetchSAP;

public class SimplePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int TIME_COUNT_TOTAL = 300;
	private static final int TIME_COUNT_ROTATIVE = 30;
	private Timer timer;
	private int rotativeCount;
	private int count;

	private Line[] lines;
	
	SimpleLabel[] labels = new SimpleLabel[5];

	double width;
	double height;

	int onePerCent;
	int twoPerCent;
	int twentyTwoHalfPerCent;
	int thirtyFourPerCent;
	int sixtyThreePercent;
	int ninetyOnePerCent;

	int[] xPos = new int[5];
	int[] yPos = new int[5];
	int[] xSize = new int[5];
	int[] ySize = new int[5];

	String font = "Serif";
	int fontSize = 40;
	int borderSize = 12;

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

		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				rotativeCount++;
				
		        if (rotativeCount < TIME_COUNT_ROTATIVE) {
		          System.out.println(rotativeCount);
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

		this.onePerCent = (int) (width / 100);
		this.twoPerCent = (int) (height / 50);
		this.twentyTwoHalfPerCent = (int) (height * 22.5 / 100);
		this.thirtyFourPerCent = (int) (width * 34 / 100);
		this.sixtyThreePercent = (int) (width * 63 / 100);
		this.ninetyOnePerCent = (int) (height * 91 / 100);

		/*
		 * System.out.println(onePerCent); System.out.println(twoPerCent);
		 * System.out.println(twentyTwoHalfPerCent);
		 * System.out.println(thirtyFourPerCent); System.out.println(sixtyThreePercent);
		 * System.out.println(ninetyOnePerCent);
		 */
	}

	void setArrays() {

		this.xPos[0] = this.onePerCent;
		this.xPos[1] = this.onePerCent + this.sixtyThreePercent;
		this.xPos[2] = this.xPos[1];
		this.xPos[3] = this.xPos[1];
		this.xPos[4] = this.xPos[1];

		this.yPos[0] = this.twoPerCent;
		this.yPos[1] = this.twoPerCent;
		this.yPos[2] = this.twoPerCent * 2 + this.twentyTwoHalfPerCent;
		this.yPos[3] = this.twoPerCent * 3 + this.twentyTwoHalfPerCent * 2;
		this.yPos[4] = this.twoPerCent * 4 + this.twentyTwoHalfPerCent * 3;

		this.xSize[0] = this.sixtyThreePercent;
		this.xSize[1] = this.thirtyFourPerCent;
		this.xSize[2] = this.xSize[1];
		this.xSize[3] = this.xSize[1];
		this.xSize[4] = this.xSize[1];

		this.ySize[0] = this.ninetyOnePerCent;
		this.ySize[1] = this.twentyTwoHalfPerCent;
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
