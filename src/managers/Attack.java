package managers;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import entities.Player;
import gfx.Sources;

public class Attack
{

	public static int frame = 0;
	int frameMax = 3;
	int tick = 0;
	double angleMem = 0;
	//int angle = 0;
	public void tick()
	{
		if(tick > 60)
		{
			tick = 0;
			frame++;
			if(frame > 2)
			{
				frame = 0;
			}
		}
		if(angle < 0)
		{
			//angle = 360;
		}
	
	}
	public static int angle = 150;
	public void render(Graphics2D g)
	{
		AffineTransform backup = g.getTransform();
		AffineTransform trans = new AffineTransform();
		
		int yOffset = 0;
		/*if(frame == 0 && angle < 300)
		{
			angle = 100;
			yOffset = 100;
		}
		if(frame == 1)
		{
			angle = 250;
			yOffset = 200;
		}
		if(frame == 2)
		{
			angle = 400;
			yOffset = 300;
		}*/
		angle--;
		trans.rotate(Math.toDegrees(angle) / 500, Player.player.x + 50, Player.player.y + 20); 
		
		g.transform( trans );
		if((angle) < 150)
		{
			g.drawImage(Sources.scytheR, (int) Player.player.x - 50, (int) Player.player.y + 20, 100, 70, null);  
		}
		g.setTransform( backup );
	}
	public int getAttackFrame()
	{
		return frame;
	}
}
