package entities;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import gfx.BasicLight;

public class LightEntity extends Entity
{

	public BasicLight light = new BasicLight(0, 0, 500, 100);
	public LightEntity()
	{
		super(null, 1);
	}
	
	public Object getObject()
	{
		return light;
	}
	public void roam()
	{
		light.x = (int) pos.x;
		light.y = (int) pos.y;
	}
	public void pos(int x, int y)
	{
		
	}
	public void render(Graphics2D g)
	{
		light.render(g);
	}
	public boolean renderOverride()
	{
		return true;
	}
}
