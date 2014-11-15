import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class BoxPanel extends JPanel
{
	/*knr c*/
	private BoxSoldier[] boxes;
	private int width;
	private int height;
	final int BOXSOLDIER_COUNT = 100;
	private double spazRate;
	
	public BoxPanel() throws InterruptedException
	{
		
		width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		Random rand = new Random();
	
		
		
		
		
		boxes = new BoxSoldier[BOXSOLDIER_COUNT];
		
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
		this.add(painter);
		
		
		double dx;
		double dy;
				
	}
	
	public void setSpazRate(double s)
	{
		spazRate = s;
	}
	
	public void paint(Graphics g)
	{	
		//g.clearRect(0, 0, width, height);
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, width, height);
				
		for(int i = 0; i < BOXSOLDIER_COUNT; i++)
		{
			double dx = boxes[i].getxCenter() - (width/2);
			double dy = boxes[i].getyCenter() - (height/2);
			
			
			if( (boxes[i].getxCenter() < 0) || (boxes[i].getxCenter() > width) || (boxes[i].getyCenter() < 0) || (boxes[i].getyCenter() > height) )
			{
				
				if( boxes[i].getxCenter() < 0)
				{
					boxes[i].setAngle(0);
					
				}
				if( boxes[i].getxCenter() > width)
				{
					boxes[i].setAngle(Math.PI);
					
				}
				if( boxes[i].getyCenter() < 0)
				{
					boxes[i].setAngle(Math.PI/2);
					
				}
				if( boxes[i].getyCenter() > height)
				{
					boxes[i].setAngle(-Math.PI/2);
					
				}
			}
			else
			{
				boxes[i].turnRandom(Options.getTurnRate()/100);
			}
			boxes[i].move(Options.getSpeed()/10);
			boxes[i].colorWarp((int) Options.getColorChangeRate());
			boxes[i].sizeAccelWarp(Options.getSpazRate(),200);
			g.setColor(boxes[i].getColor());
			g.fillRoundRect( 	(int) boxes[i].getX(), 
								(int) boxes[i].getY(),
								(int) boxes[i].getxSize(),
								(int) boxes[i].getySize(),
								(int) boxes[i].getxSize()/3,
								(int) boxes[i].getySize()/3);
	}
	}
	
	
}
