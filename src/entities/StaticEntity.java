package entities;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class StaticEntity extends Entity
{
	public BufferedImage texture;
	public Rectangle2D.Double bounds;
	public int health;
	public int x;
	public int y;
	public StaticEntity(BufferedImage texture, int health)
	{
		super(texture, health);
	}
	
	public void dropItems()
	{
		
	}
	
	public boolean isSolid()
	{
		return true;
	}
	public boolean hasShadow()
	{
		return true;
	}
	public boolean hasHealth()
	{
		return true;
	}
	
	public void remove(int index)
	{
		EntityManager.entities.remove(index);
	}
}
