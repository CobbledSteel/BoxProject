import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class ControlPanel extends JPanel
{
	JSlider spazSlider, 
			bound1Slider,
			bound2Slider,
			colorRateSlider,
			speedSlider,
			turnRateSlider,
			waitTimeSlider;
	
	JPanel 	spazSliderPanel, 		spazReportPanel, 		spazMainPanel,
			bound1SliderPanel,		bound1ReportPanel,		bound1MainPanel,
			bound2SliderPanel,		bound2ReportPanel,		bound2MainPanel,
			colorRateSliderPanel, 	colorRateReportPanel, 	colorRateMainPanel,
			speedSliderPanel,		speedReportPanel,		speedMainPanel,
			turnRateSliderPanel,	turnRateReportPanel,	turnRateMainPanel,
			waitTimeSliderPanel, 	waitTimeReportPanel, 	waitTimeMainPanel;
	
	JLabel 	spazLabelLeft, 			spazLabelRight, 		spazLabelReport,
			bound1LabelLeft,		bound1LabelRight,		bound1LabelReport,	
			bound2LabelLeft,		bound2LabelRight,		bound2LabelReport,	
			colorRateLabelLeft, 	colorRateLabelRight, 	colorRateLabelReport,
			speedLabelLeft,			speedLabelRight,		speedLabelReport,
			turnRateLabelLeft,		turnRateLabelRight,		turnRateLabelReport,
			waitTimeLabelLeft, 		waitTimeLabelRight, 	waitTimeLabelReport;
	
	TitledBorder	spazTitle,
					bound1Title,
					bound2Title,
					colorRateTitle,
					speedTitle,
					turnRateTitle,
					waitTimeTitle;
	
	Border blackline;
	
	public ControlPanel()
	{	
		// Go with the flow
		this.setLayout(new GridLayout(8, 1));
		
		blackline = BorderFactory.createLineBorder(Color.black);
		
		
			spazTitle = BorderFactory.createTitledBorder(
		    blackline, "Spaz Coefficent Changer");
			spazTitle.setTitleJustification(TitledBorder.CENTER);
			spazMainPanel = new JPanel();
			spazMainPanel.setBorder(spazTitle);
			spazMainPanel.setLayout(new BoxLayout(spazMainPanel, BoxLayout.Y_AXIS));
				spazSliderPanel = new JPanel();
					spazSlider = new JSlider();
					spazSlider.setValue(0);
					spazSlider.addChangeListener(new SliderListener());
					spazLabelLeft = new JLabel("0.0");
					spazLabelRight = new JLabel("100.0");
				spazSliderPanel.add(spazLabelLeft);
				spazSliderPanel.add(spazSlider);
				spazSliderPanel.add(spazLabelRight);
			spazMainPanel.add(spazSliderPanel);
				spazReportPanel = new JPanel();
					spazLabelReport = new JLabel("Spaz Coefficient: 0.0");
				spazReportPanel.add(spazLabelReport);
			spazMainPanel.add(spazReportPanel);
			
			bound1Title = BorderFactory.createTitledBorder(
				    blackline, "X Average Changer");
					bound1Title.setTitleJustification(TitledBorder.CENTER);
					bound1MainPanel = new JPanel();
					bound1MainPanel.setBorder(bound1Title);
					bound1MainPanel.setLayout(new BoxLayout(bound1MainPanel, BoxLayout.Y_AXIS));
						bound1SliderPanel = new JPanel();
							bound1Slider = new JSlider();
							bound1Slider.setValue(1);
							bound1Slider.setMaximum(500);
							bound1Slider.addChangeListener(new SliderListener());
							bound1LabelLeft = new JLabel("0.0");
							bound1LabelRight = new JLabel("500.0");
						bound1SliderPanel.add(bound1LabelLeft);
						bound1SliderPanel.add(bound1Slider);
						bound1SliderPanel.add(bound1LabelRight);
					bound1MainPanel.add(bound1SliderPanel);
						bound1ReportPanel = new JPanel();
							bound1LabelReport = new JLabel("X Average: 1.0");
						bound1ReportPanel.add(bound1LabelReport);
					bound1MainPanel.add(bound1ReportPanel);
					
			bound2Title = BorderFactory.createTitledBorder(
				    blackline, "Y Average Changer");
					bound2Title.setTitleJustification(TitledBorder.CENTER);
					bound2MainPanel = new JPanel();
					bound2MainPanel.setBorder(bound2Title);
					bound2MainPanel.setLayout(new BoxLayout(bound2MainPanel, BoxLayout.Y_AXIS));
						bound2SliderPanel = new JPanel();
							bound2Slider = new JSlider();
							bound2Slider.setValue(1);
							bound2Slider.setMaximum(500);
							bound2Slider.addChangeListener(new SliderListener());
							bound2LabelLeft = new JLabel("0.0");
							bound2LabelRight = new JLabel("500.0");
						bound2SliderPanel.add(bound2LabelLeft);
						bound2SliderPanel.add(bound2Slider);
						bound2SliderPanel.add(bound2LabelRight);
					bound2MainPanel.add(bound2SliderPanel);
						bound2ReportPanel = new JPanel();
							bound2LabelReport = new JLabel("Y Average: 1.0");
						bound2ReportPanel.add(bound2LabelReport);
					bound2MainPanel.add(bound2ReportPanel);
			
			colorRateTitle = BorderFactory.createTitledBorder(
			blackline, "Color Change Rate Changer");
			colorRateTitle.setTitleJustification(TitledBorder.CENTER);
			colorRateMainPanel = new JPanel();
			colorRateMainPanel.setBorder(colorRateTitle);
			colorRateMainPanel.setLayout(new BoxLayout(colorRateMainPanel, BoxLayout.Y_AXIS));
				colorRateSliderPanel = new JPanel();
					colorRateSlider = new JSlider();
					colorRateSlider.setValue(0);
					colorRateSlider.addChangeListener(new SliderListener());
					colorRateLabelLeft = new JLabel("0.0");
					colorRateLabelRight = new JLabel("100.0");
				colorRateSliderPanel.add(colorRateLabelLeft);
				colorRateSliderPanel.add(colorRateSlider);
				colorRateSliderPanel.add(colorRateLabelRight);
			colorRateMainPanel.add(colorRateSliderPanel);
				colorRateReportPanel = new JPanel();
					colorRateLabelReport = new JLabel("Color Change Rate: 0.0");
				colorRateReportPanel.add(colorRateLabelReport);
			colorRateMainPanel.add(colorRateReportPanel);
			
			speedTitle = BorderFactory.createTitledBorder(
					blackline, "Speed Changer");
					speedTitle.setTitleJustification(TitledBorder.CENTER);
					speedMainPanel = new JPanel();
					speedMainPanel.setBorder(speedTitle);
					speedMainPanel.setLayout(new BoxLayout(speedMainPanel, BoxLayout.Y_AXIS));
						speedSliderPanel = new JPanel();
							speedSlider = new JSlider();
							speedSlider.setValue(0);
							speedSlider.addChangeListener(new SliderListener());
							speedLabelLeft = new JLabel("0.0");
							speedLabelRight = new JLabel("100.0");
						speedSliderPanel.add(speedLabelLeft);
						speedSliderPanel.add(speedSlider);
						speedSliderPanel.add(speedLabelRight);
					speedMainPanel.add(speedSliderPanel);
						speedReportPanel = new JPanel();
							speedLabelReport = new JLabel("Speed: 0.0");
						speedReportPanel.add(speedLabelReport);
					speedMainPanel.add(speedReportPanel);
					
			turnRateTitle = BorderFactory.createTitledBorder(
					blackline, "Turn Rate Changer");
					turnRateTitle.setTitleJustification(TitledBorder.CENTER);
					turnRateMainPanel = new JPanel();
					turnRateMainPanel.setBorder(turnRateTitle);
					turnRateMainPanel.setLayout(new BoxLayout(turnRateMainPanel, BoxLayout.Y_AXIS));
						turnRateSliderPanel = new JPanel();
							turnRateSlider = new JSlider();
							turnRateSlider.setValue(0);
							turnRateSlider.addChangeListener(new SliderListener());
							turnRateLabelLeft = new JLabel("0.0");
							turnRateLabelRight = new JLabel("100.0");
						turnRateSliderPanel.add(turnRateLabelLeft);
						turnRateSliderPanel.add(turnRateSlider);
						turnRateSliderPanel.add(turnRateLabelRight);
					turnRateMainPanel.add(turnRateSliderPanel);
						turnRateReportPanel = new JPanel();
							turnRateLabelReport = new JLabel("Turn Rate: 0.0");
						turnRateReportPanel.add(turnRateLabelReport);
					turnRateMainPanel.add(turnRateReportPanel);
			
			waitTimeTitle = BorderFactory.createTitledBorder(
					blackline, "Frame Time Changer");
					waitTimeTitle.setTitleJustification(TitledBorder.CENTER);
					waitTimeMainPanel = new JPanel();
					waitTimeMainPanel.setBorder(waitTimeTitle);
					waitTimeMainPanel.setLayout(new BoxLayout(waitTimeMainPanel, BoxLayout.Y_AXIS));
						waitTimeSliderPanel = new JPanel();
							waitTimeSlider = new JSlider();
							waitTimeSlider.setValue(100);
							waitTimeSlider.setMinimum(1);
							waitTimeSlider.setMaximum(100);
							waitTimeSlider.addChangeListener(new SliderListener());
							waitTimeLabelLeft = new JLabel("1ms");
							waitTimeLabelRight = new JLabel("Stop");
						waitTimeSliderPanel.add(waitTimeLabelLeft);
						waitTimeSliderPanel.add(waitTimeSlider);
						waitTimeSliderPanel.add(waitTimeLabelRight);
					waitTimeMainPanel.add(waitTimeSliderPanel);
						waitTimeReportPanel = new JPanel();
							waitTimeLabelReport = new JLabel("Frame Time: Forever");
						waitTimeReportPanel.add(waitTimeLabelReport);
					waitTimeMainPanel.add(waitTimeReportPanel);
			
		JPanel actionsMainPanel = new JPanel(new GridLayout(1, 1));
		actionsMainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JButton quitButton = new JButton("Quit Spaz-o-matic");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		actionsMainPanel.add(quitButton);
		
		this.add(spazMainPanel);
		this.add(bound1MainPanel);
		this.add(bound2MainPanel);
		this.add(colorRateMainPanel);
		this.add(speedMainPanel);
		this.add(turnRateMainPanel);
		this.add(waitTimeMainPanel);
		this.add(actionsMainPanel);
	}
	
	
	class SliderListener implements ChangeListener 
	{ 
		public void stateChanged(ChangeEvent e)
		{
			JSlider source = (JSlider)e.getSource();
			if( source == spazSlider )
			{
				Options.setSpazRate(source.getValue());	
				spazLabelReport.setText("Spaz Coefficient:" + Options.getSpazRate());
			}
			if( source == colorRateSlider )
			{
				Options.setColorChangeRate(source.getValue());
				colorRateLabelReport.setText("Color Change Rate: " + Options.getColorChangeRate());
			}
			if( source == waitTimeSlider )
			{
				Options.setwaitTime(source.getValue());
				if( Options.getWaitTime() < 100 )
				{
					String fps = (Options.getWaitTime() == 0) ? "?" : "" + (int)(1000.0 / Options.getWaitTime());
					waitTimeLabelReport.setText(String.format("Frame Time: %dms, FPS: %s", ((int) Options.getWaitTime()), fps));
				}
				else
				{
					waitTimeLabelReport.setText("Frame Time: Forever");
				}
				
			}
			if( source == speedSlider )
			{
				Options.setSpeed(source.getValue());
				speedLabelReport.setText("Speed: "+ Options.getSpeed());	
			}
			if( source == turnRateSlider )
			{
				Options.setTurnRate(source.getValue());
				turnRateLabelReport.setText("Turn Rate: "  + Options.getTurnRate());
			}
			if( source == bound1Slider )
			{
				Options.setXAverage(source.getValue());
				bound1LabelReport.setText("Bound 1: " + Options.getXAverage());
			}
			if( source == bound2Slider )
			{
				Options.setYAverage(source.getValue());
				bound2LabelReport.setText("Bound 2: " + Options.getYAverage());
			}
		}
	}
}
