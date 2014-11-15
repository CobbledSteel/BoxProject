import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.Random;
import java.awt.*;

public class BoxRunner extends JFrame
{
	/*public BoxRunner()
	{
		
		
		
	}*/
	public static void main(String[] args) throws InterruptedException
	{
		final int INITIAL_FRAME_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		final int INITIAL_FRAME_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		JFrame bigFrame = new JFrame("Release the Splatterin'!");
		bigFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bigFrame.setSize(INITIAL_FRAME_WIDTH, INITIAL_FRAME_HEIGHT);
		bigFrame.getContentPane().setBackground(Color.BLACK);
		bigFrame.setVisible(true);
		
		//boxNormal(bigFrame);
		JPanel boxPanel =  new BoxPanel();
		boxPanel.setVisible(true);
	    bigFrame.add( boxPanel);
	    
	    JFrame controlFrame = new JFrame("Controls and stuff");
	    controlFrame.setVisible(true);
	    controlFrame.setSize(300,700);
	    
	    JPanel controlPanel = new ControlPanel();
	    controlFrame.add(controlPanel);
	    
	    double testValue = 0;
	    Options.setwaitTime(100);
	    Options.setXAverage(1);
	    Options.setYAverage(1);
	    while(true)
	    {
	    	if(Options.getWaitTime()<100)
	    	{
	    		boxPanel.repaint();
	    		Thread.sleep((int) Options.getWaitTime());
	    	}
	    	else
	    	{
	    		Thread.sleep(100);
	    	}
	    	
	    	
	    }
		
	}

	/**
	 * @param bigFrame
	 * @param rand
	 * @throws InterruptedException
	 */
	private static void boxNormal(JFrame bigFrame)
			throws InterruptedException 
	{
		Random rand = new Random();
		int width = (int) bigFrame.getBounds().getWidth();
		int height = (int) bigFrame.getBounds().getHeight();
		
		JFrame testFrame = new JFrame();
		testFrame.setSize(600, 100);
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*JSlider valueSlider = new JSlider();
		testFrame.add(valueSlider);
		valueSlider.setVisible(true);
		ChangeListener l = null;
		valueSlider.addChangeListener(l);*/
		
		
		final int BOXSOLDIER_COUNT = 100;
		BoxSoldier[] boxes = new BoxSoldier[BOXSOLDIER_COUNT];
		
		JLabel valueTester = new JLabel();
		valueTester = new JLabel();
		valueTester.setVisible(true);
		//testFrame.add(valueTester);
		
		Thread.sleep(10);
		
		for(int i = 0; i < BOXSOLDIER_COUNT; i++)
		{
			boxes[i] =  new BoxSoldier(		rand.nextInt(width),
											rand.nextInt(height),
											rand.nextInt(100)+50,
											rand.nextInt(100)+50, 
											rand.nextDouble()*Math.PI);
		}
		BoxSoldierPainter painter = new BoxSoldierPainter(BOXSOLDIER_COUNT);
		painter.setBoxSoldiers(boxes);
		bigFrame.getContentPane().add(painter);
		
		String danger = new String();
		
		while(true)
		{	
			double dx;
			double dy;
			for(int i = 0; i < BOXSOLDIER_COUNT; i++)
			{
				dx = boxes[i].getxCenter() - (width/2);
				dy = boxes[i].getyCenter() - (height/2);
				
				
				if( (boxes[i].getxCenter() < 0) || (boxes[i].getxCenter() > width) || (boxes[i].getyCenter() < 0) || (boxes[i].getyCenter() > height) )
				{
					danger = "!!!!verybad yo!";
					if( boxes[i].getxCenter() < 0)
					{
						boxes[i].setAngle(0);
						danger = "tooleft";
					}
					if( boxes[i].getxCenter() > width)
					{
						boxes[i].setAngle(Math.PI);
						danger = "tooright";
					}
					if( boxes[i].getyCenter() < 0)
					{
						boxes[i].setAngle(Math.PI/2);
						danger = "toohigh";
					}
					if( boxes[i].getyCenter() > height)
					{
						boxes[i].setAngle(-Math.PI/2);
						danger = "toolow";
					}
				}
				else
				{
					danger = "is cool yo";
					
					boxes[i].turn(rand.nextDouble()*.1-.05);
				}
				boxes[i].move(.4);
				boxes[i].colorWarp(20);
				boxes[i].sizeAccelWarp(200,50);
				
				valueTester.setText( "x: " + (int) boxes[i].getxCenter() + 
										", y: " + (int) boxes[i].getyCenter() + 
										", dx:" + ((int) dx ) + 
										", dy:" + ((int) dy) + 
										", Status: " + danger);	
			}
			
			Thread.sleep(2);
			bigFrame.repaint();
			
		}
	}

	
}

