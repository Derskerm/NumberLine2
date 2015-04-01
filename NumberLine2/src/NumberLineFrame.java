import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class NumberLineFrame extends JFrame {
	
	public NumberLineFrame() {
		setLayout(new BorderLayout());
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawingPanel panel = new DrawingPanel();
		WidgetPanel controls = new WidgetPanel();
		controls.setControlListener(panel);
		
		add(panel, BorderLayout.CENTER);
		add(controls, BorderLayout.SOUTH);
		
		setResizable(true);
	}
	
	

}