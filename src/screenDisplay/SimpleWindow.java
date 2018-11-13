package screenDisplay;

import javax.swing.*;

import misc.DragListener;

public class SimpleWindow {
	
	public static void createWindow() {
		
		JFrame frame = new JFrame("InitialWindow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setPreferredSize(new Dimension(1920, 1080));
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.getContentPane().add(new SimplePanel());
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		DragListener drag = new DragListener();
		frame.addMouseListener(drag);
		frame.addMouseMotionListener(drag);
	}
}
