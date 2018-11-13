package screenDisplay;

import javax.swing.*;

public class SimpleWindow {
	
	public static void createWindow() {
		
		JFrame frame = new JFrame("InitialWindow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new SimplePanel());
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
}
