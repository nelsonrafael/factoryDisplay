package screenDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;
import dataStructure.*;
import dataStructure.Shape;
import informationRetrieval.CSVReader;
import informationRetrieval.CompareLineCode;
import misc.Constants;

@SuppressWarnings("serial")
public class SimplePanel extends JPanel {

	CSVReader reader;

	private BufferedImage logoVicaima;
	
	int logoX, logoY;

	private Timer timer;
	private int rotativeCount;
	private int shiftCount;
	private int count;

	Line[][] lines;

	Shape[] shapes = new Shape[5];
	int[] shapeX = new int[5];
	int[] shapeY = new int[5];

	int[] newShapeW = new int[5];
	int[] newShapeH = new int[5];

	MainArea mainArea;

	SecondaryArea[] secondaryArea;

	SimpleLabel[] labels = new SimpleLabel[5];
	SimpleLabel timeDateLabel;
	Shape timeDateShape;

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

	public SimplePanel() {

		startReader();

		setDimension();

		setPercentages();

		setArrays();

		setLayout(null);

		createMainLabels();

		loadLogo();

		timer = new Timer(Constants.TIME_COUNT_UNIT, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				count++;
				shiftCount++;
				rotativeCount++;

				Calendar now = Calendar.getInstance();
				// System.out.println(dateFormat.format(now.getTime()));
				timeDateLabel.setText(Constants.DATE_FORMAT.format(now.getTime()), Constants.COLOR_BLACK,
						Constants.TIME_DATE_FONT, Constants.TIME_DATE_FONT_SIZE);

				if (shiftCount < Constants.TIME_COUNT_SHIFT) {
					// System.out.println(shiftCount);
				} else {
					// ((Timer) (e.getSource())).stop();
					shiftCount = shiftCount - Constants.TIME_COUNT_SHIFT;

					displayMainArea();

					displaySecondaryArea();

					setAndShowShapes();

					repaint();

					changeShift();

				}

				if (rotativeCount < Constants.TIME_COUNT_ROTATIVE) {
					// System.out.println(rotativeCount);
				} else {
					// ((Timer) (e.getSource())).stop();
					rotativeCount = rotativeCount - Constants.TIME_COUNT_ROTATIVE;

					changeOrder();

				}

				if (count < Constants.TIME_COUNT_TOTAL) {
					// System.out.println(count);
				} else {
					// ((Timer) (e.getSource())).stop();
					count = count - Constants.TIME_COUNT_TOTAL;

					startReader();
				}

			}
		});
		timer.setInitialDelay(0);
		timer.start();

	}

	void loadLogo() {
		try {
			logoVicaima = ImageIO.read(new File("resources/logo.png"));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	void startReader() {
		try {
			reader = new CSVReader(Constants.FILE_PATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompareLineCode compare = new CompareLineCode(reader);

		this.lines = compare.getLinesToDisplay();
	}

	void setAndShowShapes() {

		for (int i = 0; i < 5; i++) {
			// shapes[i] = new Square(shapeX[i], shapeY[i], Constants.HUNDRED_VAR,
			// Constants.HUNDRED_VAR);
			shapes[i] = new Square(xPos[i], yPos[i], newShapeW[i], newShapeH[i]);
			String state;
			if (i == 0) {
				state = lines[0][0].get_status();
			} else
				state = lines[i][3].get_status();
			if (state.equals("Em PRODUÇÃO"))
				shapes[i].setColor(Constants.COLOR_GREEN);
			else if (state.equals("PARADO"))
				shapes[i].setColor(Constants.COLOR_YELLOW);
			else if (state.equals("IMPRODUTIVO"))
				shapes[i].setColor(Constants.COLOR_RED);
			else if (state.equals("SETUP"))
				shapes[i].setColor(Constants.COLOR_BLUE);
			else if (state.equals("REWORKS"))
				shapes[i].setColor(Constants.COLOR_CYAN);
		}

	}

	void createMainLabels() {
		for (int i = 0; i < labels.length; i++) {
			SimpleLabel l = new SimpleLabel(xPos[i], yPos[i], xSize[i], ySize[i]);
			l.setBorder(Constants.COLOR_BLACK, Constants.BORDER_SIZE);
			labels[i] = l;
			this.add(l);
		}
		timeDateLabel = new SimpleLabel(timeDateX, timeDateY, timeDateWidth, timeDateHeight);
		timeDateShape = new Square(0, bigY, bigX, (int) (height - bigY));
		timeDateShape.setColor(Constants.COLOR_WHITE);
		this.add(timeDateLabel);
		this.mainArea = new MainArea(bigX, bigY);
		for (int i = 0; i < mainArea.getLabels().length; i++) {
			this.add(mainArea.getLabel(i));
		}
		for (int i = 0; i < mainArea.getNames().length; i++) {
			this.add(mainArea.getName(i));
		}
		this.secondaryArea = new SecondaryArea[4];
		for (int i = 0; i < secondaryArea.length; i++) {
			double tempY = i * smallY - Constants.BORDER_SIZE * i;
			this.secondaryArea[i] = new SecondaryArea(smallX, smallY, bigX, tempY);
			for (int j = 0; j < secondaryArea[i].getLabels().length; j++) {
				this.add(secondaryArea[i].getLabel(j));
			}
			for (int j = 0; j < secondaryArea[i].getNames().length; j++) {
				this.add(secondaryArea[i].getName(j));
			}
		}

	}

	void changeOrder() {
		Line[] l = lines[0];
		lines[0] = lines[1];
		lines[1] = lines[2];
		lines[2] = lines[3];
		lines[3] = lines[4];
		lines[4] = l;
	}

	void changeShift() {
		Line l = lines[0][0];
		lines[0][0] = lines[0][1];
		lines[0][1] = lines[0][2];
		lines[0][2] = lines[0][3];
		lines[0][3] = l;
	}

	void displayMainArea() {

		String[] mainInfoToDisplay = new String[Constants.MAIN_AREA_NUMBER_OF_LABELS];

		mainInfoToDisplay[0] = lines[0][0].get_descritivo();
		mainInfoToDisplay[1] = lines[0][0].get_turno();
		mainInfoToDisplay[2] = String.valueOf(lines[0][0].get_qtProd());
		mainInfoToDisplay[3] = String.valueOf(lines[0][0].get_qtRwk());
		mainInfoToDisplay[4] = String.valueOf(lines[0][0].get_objHora());
		mainInfoToDisplay[5] = String.valueOf(lines[0][0].get_realHora());
		mainInfoToDisplay[6] = String.valueOf(lines[0][0].get_tTot());
		mainInfoToDisplay[7] = String.valueOf(lines[0][0].get_tAbert());
		mainInfoToDisplay[8] = String.valueOf(lines[0][0].get_tA());
		mainInfoToDisplay[9] = String.valueOf(lines[0][0].get_tProd());
		mainInfoToDisplay[10] = String.valueOf(lines[0][0].get_tP());
		mainInfoToDisplay[11] = String.valueOf(lines[0][0].get_tUtil());
		mainInfoToDisplay[12] = String.valueOf(lines[0][0].get_tU());

		mainArea.getLabel(0).setText(mainInfoToDisplay[0], Constants.COLOR_BLACK, Constants.TITLE_FONT,
				Constants.TITLE_FONT_SIZE);

		for (int i = 1; i < Constants.MAIN_AREA_NUMBER_OF_LABELS; i++) {
			mainArea.getLabel(i).setText(mainInfoToDisplay[i], Constants.COLOR_BLACK, Constants.MAIN_FONT,
					Constants.MAIN_FONT_SIZE);
		}

		for (int i = 0; i < Constants.MAIN_AREA_NAMES.length; i++) {
			mainArea.getName(i).setText(Constants.MAIN_AREA_NAMES[i], Constants.COLOR_GREY, Constants.MAIN_FONT,
					Constants.SECONDARY_FONT_SIZE);
		}

	}

	void displaySecondaryArea() {

		String[][] secondaryInfoToDisplay = new String[4][Constants.SECONDARY_AREA_NUMBER_OF_LABELS];

		for (int i = 0; i < 4; i++) {
			secondaryInfoToDisplay[i][0] = lines[i + 1][3].get_descritivo();
			secondaryInfoToDisplay[i][1] = String.valueOf(lines[i + 1][3].get_qtProd());
			secondaryInfoToDisplay[i][2] = String.valueOf(lines[i + 1][3].get_objHora());
			secondaryInfoToDisplay[i][3] = String.valueOf(lines[i + 1][3].get_realHora());
			secondaryInfoToDisplay[i][4] = String.valueOf(lines[i + 1][3].get_tP());
			secondaryInfoToDisplay[i][5] = lines[i + 1][3].get_status();
		}

		for (int i = 0; i < secondaryArea.length; i++) {
			secondaryArea[i].getLabel(0).setText(secondaryInfoToDisplay[i][0], Constants.COLOR_BLACK,
					Constants.SECONDARY_FONT, Constants.SECONDARY_FONT_SIZE);
			for (int j = 1; j < Constants.SECONDARY_AREA_NUMBER_OF_LABELS; j++) {
				secondaryArea[i].getLabel(j).setText(secondaryInfoToDisplay[i][j], Constants.COLOR_BLACK,
						Constants.AUXILIARY_FONT, Constants.SECONDARY_FONT_SIZE);
			}
			for (int j = 0; j < Constants.SECONDARY_AREA_NAMES.length - 1; j++) {
				secondaryArea[i].getName(j).setText(Constants.SECONDARY_AREA_NAMES[j], Constants.COLOR_GREY,
						Constants.AUXILIARY_FONT, Constants.AUXILIARY_FONT_SIZE);
			}
		}

	}

	void setPercentages() {

		this.widthGap = (int) (width * 0);
		this.heightGap = (int) (height * 0);
		this.smallY = (int) (height * 26 / 100);
		this.smallX = (int) (width * 38 / 100);
		this.bigX = (int) (width * 63 / 100);
		this.bigY = (int) (height * 89 / 100);

		this.timeDateHeight = (int) (height * 6 / 100);
		this.timeDateWidth = (int) (width / 2);
		this.timeDateX = (int) (width / 3 - Constants.SECONDARY_AREA_LABEL_SIZE_Y);
		this.timeDateY = (int) (height * 23 / 25);
	}

	void setArrays() {

		this.xPos[0] = this.widthGap;
		this.xPos[1] = this.widthGap + this.bigX - Constants.BORDER_SIZE;
		this.xPos[2] = this.xPos[1];
		this.xPos[3] = this.xPos[1];
		this.xPos[4] = this.xPos[1];

		this.yPos[0] = this.heightGap;
		this.yPos[1] = this.heightGap;
		this.yPos[2] = this.heightGap + this.smallY - Constants.BORDER_SIZE;
		this.yPos[3] = this.heightGap + this.smallY * 2 - Constants.BORDER_SIZE * 2;
		this.yPos[4] = this.heightGap + this.smallY * 3 - Constants.BORDER_SIZE * 3;

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

		this.shapeX[0] = this.bigX - Constants.HUNDRED_VAR - Constants.SHAPE_ADJUSTER * 5;
		this.shapeX[1] = (int) (this.width - Constants.HUNDRED_VAR - Constants.SHAPE_ADJUSTER);
		this.shapeX[2] = shapeX[1];
		this.shapeX[3] = shapeX[1];
		this.shapeX[4] = shapeX[1];

		this.shapeY[0] = Constants.BORDER_SIZE + Constants.SECONDARY_AREA_LABEL_SIZE_Y;
		this.shapeY[1] = shapeY[0] - Constants.BORDER_SIZE * 3;
		this.shapeY[2] = shapeY[1] + smallY - Constants.BORDER_SIZE;
		this.shapeY[3] = shapeY[2] + smallY - Constants.BORDER_SIZE;
		this.shapeY[4] = shapeY[3] + smallY - Constants.BORDER_SIZE;

		this.newShapeW[0] = bigX;
		this.newShapeW[1] = smallX;
		this.newShapeW[2] = smallX;
		this.newShapeW[3] = smallX;
		this.newShapeW[4] = smallX;

		this.newShapeH[0] = bigY;
		this.newShapeH[1] = smallY;
		this.newShapeH[2] = smallY;
		this.newShapeH[3] = smallY;
		this.newShapeH[4] = smallY;
		
		this.logoX = Constants.BORDER_SIZE * 4;
		this.logoY = this.bigY + 10;

	}

	void setDimension() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.width = screenSize.getWidth();
		this.height = screenSize.getHeight();

		/*
		 * System.out.println(width); System.out.println(height);
		 */
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		timeDateShape.draw(g);
		g.drawImage(logoVicaima, logoX, logoY, this);
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null)
				shapes[i].draw(g);
		}
	}

}
