package upenn.cis541.Stopwatch;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StopwatchGUI extends JFrame implements ActionListener{
	JPanel Panel;
	JPanel ButtonsPanel;
	JPanel DisplayPanel;

	JLabel Display;
	JButton Start;
	JButton Stop;
	JButton Reset;
	
	public StopwatchGUI(){
		Panel = new JPanel();
		ButtonsPanel = new JPanel();
		DisplayPanel = new JPanel();

		Display = new JLabel();
		Start = new JButton("Start");
		Start.addActionListener(this);
		Stop = new JButton("Stop");
		Stop.addActionListener(this);
		Reset = new JButton("Reset");
		Reset.addActionListener(this);
		
		Panel.setLayout(new GridLayout(0,1));
		ButtonsPanel.setLayout(new GridLayout(1,3));

		ButtonsPanel.add(Start);
		ButtonsPanel.add(Stop);
		ButtonsPanel.add(Reset);

		DisplayPanel.add(Display);
		Panel.add(DisplayPanel);
		Panel.add(ButtonsPanel);
		
		this.add(Panel);
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == Start){
			Stopwatch.start();
		} else if(event.getSource() == Stop){
			Stopwatch.stop();
		} else if(event.getSource() == Reset){
			Stopwatch.reset();
		}
	}
	
	public void refresh(){
		StringBuilder toDisplay = new StringBuilder();
		toDisplay.append(String.format("%02d",Stopwatch.hours));
		toDisplay.append(":");
		toDisplay.append(String.format("%02d",Stopwatch.minutes));
		toDisplay.append(":");
		toDisplay.append(String.format("%02d",Stopwatch.seconds));
		toDisplay.append(":");
		toDisplay.append(String.format("%02d",Stopwatch.hundredths));
		Display.setText(toDisplay.toString());
	}
}
