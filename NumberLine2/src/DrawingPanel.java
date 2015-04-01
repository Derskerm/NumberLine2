import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawingPanel extends JPanel implements ControlListener {
	// TODO Your Instance Variables Here

	private final int absoluteWidth;
	private Font font;
	private double number;
	private int myShape;
	
	public DrawingPanel() {
		super();
		setBackground(Color.WHITE);
		absoluteWidth = 640;
		font = new Font("Sans Serif",Font.BOLD,16);
		number = 50.0;
		myShape = ControlListener.CIRCLE;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background

		int width = getWidth();
		double scale = (double)width/absoluteWidth;
		
		g.setColor(Color.CYAN);
		g.fillRect((int)(64 * scale), 95, (int)((absoluteWidth - 128)*scale), 10);
		g.setColor(Color.BLACK);
		g.drawLine((int)(64 * scale), 100, (int)((absoluteWidth - 64)*scale), 100);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		
		for (int i = 0; i <= 10; i++) {
			g.drawLine((int)((64 + 51.2*i) * scale), 90, (int)((64 + 51.2*i) * scale), 110);
			width = fm.stringWidth(i*10 + "");
			g.drawString(i*10 + "", (int)((64 + 51.2*i) * scale) - width/2, 70);
		}
		
		g.setColor(Color.RED);
		if (myShape == ControlListener.CIRCLE)
			g.fillOval((int)((64 + 5.12*number - 5) * scale) - 5 + (int)(5 * scale), 95, 10, 10);
		if (myShape == ControlListener.TRIANGLE)
			g.fillPolygon(new int[]{(int)((64 + 5.12*number - 5) * scale) - 5 + (int)(5 * scale), (int)((64 + 5.12*number - 5) * scale) + (int)(5 * scale), (int)((64 + 5.12*number - 5) * scale) + 5 + (int)(5 * scale)}, new int[]{105,95,105}, 3);
		if (myShape == ControlListener.SQUARE)
			g.fillRect((int)((64 + 5.12*number - 5) * scale) - 5 + (int)(5 * scale), 95, 10, 10);
		
		// TODO Draw on the panel here
	}
	
	@Override
	public void setFont(boolean bold, boolean italics, boolean underlined) {
		int add = 0;
		if (bold) {
			add += Font.BOLD;
		}
		if (italics) {
			add += Font.ITALIC;
		}
		font = new Font("Sans Serif", add, 16);
		if (underlined) {
			Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
			map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			font = font.deriveFont(map);
		}
		repaint();
	}

	@Override
	public void setShape(int shape) {
		myShape = shape;
		repaint();
	}

	@Override
	public void setNumber(double num) {
		number = num;
		repaint();
	}

	
}