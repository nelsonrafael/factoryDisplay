package misc;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constants {

	public static final String FILE_PATH = "\\\\vicaim02\\Download\\factoryDisplayFile\\linesToDisplay.csv";
	
	public static final int[] LINE_CODES_TO_DISPLAY = { 50010, 50030, 50050, 50060, 50190 };
	
	public static final String[] MAIN_AREA_NAMES = { "", "Qt.Prod.", "Qt.Rwk", "Obj/Hora", "Real/Hora", "T.Tot.",
			"T.Abert.", "T.A%", "T.Prod", "T.P%", "T.Util", "T.U%" };
	public static final String[] SECONDARY_AREA_NAMES = { "Qt.Prod.", "Real/Hora", "Obj/Hora", "T.P%", "Status" };
	public static final String[] SHIFT_NAMES = { "TURNO 1", "TURNO 2", "TURNO 3", "GERAL" };
	
	public static final int MAIN_AREA_NAMES_VAR = 50;
	public static final int SECONDARY_AREA_SIZE_X = 5;
	public static final int SECONDARY_AREA_SIZE_Y = 2;
	public static final int MAIN_AREA_SIZE_X = 3;
	public static final int MAIN_AREA_SIZE_Y = 5;
	public static final int MAIN_AREA_LABEL_SIZE_X = 800;
	public static final int MAIN_AREA_LABEL_SIZE_Y = 200;
	public static final int SECONDARY_AREA_LABEL_SIZE_X = 500;
	public static final int SECONDARY_AREA_LABEL_SIZE_Y = 50;
	public static final int BIG_GAP_X = 30;
	public static final int HUNDRED_VAR = 100;
	public static final int SHAPE_ADJUSTER = 50;
	public static final int MAIN_AREA_NUMBER_OF_LABELS = 13;
	public static final int SECONDARY_AREA_NUMBER_OF_LABELS = 6;
	
	public final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final int TIME_COUNT_UNIT = 1000;
	public static final int TIME_COUNT_TOTAL = 400;
	public static final int TIME_COUNT_ROTATIVE = 8;
	public static final int TIME_COUNT_SHIFT = 2;
	
	public static final int BORDER_SIZE = 12;
	
	public static final String TITLE_FONT = "Monospace";
	public static final int TITLE_FONT_SIZE = 70;
	
	public static final String MAIN_FONT = "Monospace";
	public static final int MAIN_FONT_SIZE = 60;
	
	public static final String SECONDARY_FONT = "Monospace";
	public static final int SECONDARY_FONT_SIZE = 40;
	
	public static final String AUXILIARY_FONT = "Monospace";
	public static final int AUXILIARY_FONT_SIZE = 20;
	
	public static final String TIME_DATE_FONT = "Monospace";
	public static final int TIME_DATE_FONT_SIZE = 60;

	public static final Color COLOR_BLACK = new Color(0, 0, 0);
	public static final Color COLOR_RED = new Color(255, 0, 0);
	public static final Color COLOR_GREEN = new Color(0, 255, 0);
	public static final Color COLOR_BLUE = new Color(0, 0, 255);
	public static final Color COLOR_YELLOW = new Color(255, 255, 0);
	public static final Color COLOR_ORANGE = new Color(255, 140, 0);
	public static final Color COLOR_GREY = new Color(96, 96, 96);
	public static final Color COLOR_CYAN = new Color(0, 255, 255);
	public static final Color COLOR_WHITE = new Color(255, 255, 255);

}
