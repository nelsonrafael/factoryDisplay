package screenDisplay;

import javax.swing.*;

import dataStructure.Line;
import misc.DragListener;

public class SimpleWindow {
	
	public static void createWindow(Line[] lines) {
		
		JFrame frame = new JFrame("InitialWindow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.getContentPane().add(new SimplePanel(lines));
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		DragListener drag = new DragListener();
		frame.addMouseListener(drag);
		frame.addMouseMotionListener(drag);
	}
}
