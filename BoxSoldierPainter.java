import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.*;

public class BoxSoldierPainter extends JPanel
{
	BoxSoldier[] boxy;
	
	public void setBoxSoldiers(BoxSoldier[] b )
	{
		for(int i =0; i < b.length; i++)
		{
			boxy[i] =  b[i];
		}
	}
	
	public BoxSoldierPainter( int l)
	{
		boxy = new BoxSoldier[l];
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	}
	
	public void paint(Graphics g)
	{	
		
		Random rand = new Random();
		
		for(int i = 0; i < boxy.length; i++ )
		{	
			g.setColor(boxy[i].getColor());
			g.fillRoundRect( 	(int) boxy[i].getX(), 
								(int) boxy[i].getY(),
								(int) boxy[i].getxSize(),
								(int) boxy[i].getySize(),
								(int) boxy[i].getxSize()/3,
								(int) boxy[i].getySize()/3);
		}
	}
}
