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
		super(Sources.pinetree, 100);
		pos = new Rectangle2D.Double(0, 0, Maps.tileScale * 3.0, 310);
		fallTree();
	}
	
	public Rectangle2D.Double offset()
	{
		return null;
	}
	public Rectangle2D.Double getPos()
	{
		return pos;
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
		return -270;
	}
	public int xOffset()
	{
		return -33;
	}
	public int yOffset()
	{
		return -270;
	}
	public void setTile(int tileX, int tileY)
	{
		pos.x = (int) ((Math.floor(tileX * Maps.tileScale)));
		pos.y = (int) ((Math.floor(tileY * Maps.tileScale)));
		//System.out.println(pos.y);
	}
	public void render(Graphics2D g)
	{
		//System.out.println(pos.x);
		g.drawImage(Sources.pinetree, (int) pos.x + (int) Handler.cam.getX() + xOffset(), (int) pos.y + (int) Handler.cam.getY()  + yOffset(), (int) pos.width, (int) pos.height, null);
	}
}
