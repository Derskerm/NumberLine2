import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class WidgetPanel extends JPanel {
	
	JPanel left, right, center;
	BorderLayout layout;
	JSlider slider;
	JRadioButton rad1, rad2, rad3;
	ButtonGroup group;
	JCheckBox check1, check2, check3;
	ControlListener listener;

	public WidgetPanel() {
		super();
		setBackground(Color.WHITE);
		
		layout = new BorderLayout();
		layout.setHgap(10);
		setLayout(layout);
		
		left = new JPanel(new GridLayout(3,1));
		left.setBorder(new EtchedBorder());
		center = new JPanel(new BorderLayout());
		center.setBorder(new EtchedBorder());
		right = new JPanel(new GridLayout(3,1));
		right.setBorder(new EtchedBorder());
		
		rad1 = new JRadioButton("Circle");
		rad1.setSelected(true);
		rad1.addActionListener(new RadioButtonHandler());
		rad2 = new JRadioButton("Triangle");
		rad2.addActionListener(new RadioButtonHandler());
		rad3 = new JRadioButton("Square");
		rad3.addActionListener(new RadioButtonHandler());
		
		group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		group.add(rad3);
		
		check1 = new JCheckBox("Bold");
		check1.setSelected(true);
		check1.addActionListener(new CheckBoxHandler());
		check2 = new JCheckBox("Italic");
		check2.addActionListener(new CheckBoxHandler());
		check3 = new JCheckBox("Underline");
		check3.addActionListener(new CheckBoxHandler());
		
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setMajorTickSpacing(10);
		slider.createStandardLabels(10);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.addChangeListener(new SliderHandler());
		
		left.add(rad1);
		left.add(rad2);
		left.add(rad3);
		
		center.add(slider);
		
		right.add(check1);
		right.add(check2);
		right.add(check3);
		
		add(left,BorderLayout.WEST);
		add(center,BorderLayout.CENTER);
		add(right,BorderLayout.EAST);
	}
	
	public void setControlListener(ControlListener c) {
		listener = c;
	}
	
	private class CheckBoxHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean bold = check1.isSelected();
			boolean italics = check2.isSelected();
			boolean underlined = check3.isSelected();
			listener.setFont(bold, italics, underlined);
		}
		
	}
	
	private class SliderHandler implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			listener.setNumber(slider.getValue());
		}
		
	}
	
	private class RadioButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rad1)
				listener.setShape(ControlListener.CIRCLE);
			if (e.getSource() == rad2)
				listener.setShape(ControlListener.TRIANGLE);
			if (e.getSource() == rad3)
				listener.setShape(ControlListener.SQUARE);
			
		}
		
	}
	
}