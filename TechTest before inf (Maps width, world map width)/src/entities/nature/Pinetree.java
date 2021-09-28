package entities.nature;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import engine.Handler;
import entities.StaticEntity;
import gfx.Sources;
import maps.Maps;

public class Pinetree extends StaticEntity
{
	public double velocity;
	public double angleMem;
	public boolean fallenLeft, fallenRight;
	public boolean lock;
	public boolean left;
	public Pinetree()
	{
		super(Sources.pinetree, new Rectangle2D.Double(0, 0, Maps.tileScale * 3.0, 310), 100);
		fallTree();
	}
	
	public Rectangle2D.Double offset()
	{
		return null;
	}
	public void fallTree()
	{
		if(left)
		{
			fallenLeft = true;
			velocity += 0.00002;
			if(angleMem > 1.7)
			{
				velocity = 0;
			}
			angleMem += velocity;
		}
		else
		{
			fallenRight = true;
			velocity -= 0.00002;
			if(angleMem < -1.7)
			{
				velocity = 0;
			}
			angleMem += velocity;
			
		}
		
	}
	public int yRenderOffset()
	{
		return -200;
	}
	public int xOffset()
	{
		return -33;
	}
	public int yOffset()
	{
		return -270;
	}
	public void render(Graphics2D g)
	{
		//g.drawImage(texture, (int) pos.x + (int) Handler.cam.getX() + xOffset(), (int) pos.y + (int) Handler.cam.getY()  + yOffset(), (int) pos.width, (int) pos.height, null);
	}
}
