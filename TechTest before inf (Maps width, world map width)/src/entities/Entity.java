package entities;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import engine.Utilities;

public class Entity
{
	public transient BufferedImage texture;
	public Rectangle2D.Double pos;
	public int health;
	public boolean loaded;
	public int previousX;
	public int previousY;
	protected Utilities util = new Utilities();
	public Entity(BufferedImage texture, Rectangle2D.Double pos, int health)
	{
		this.texture = texture;
		this.pos = pos;
		this.health = health;
	}
	
	public void dropItems(Entity entity, int min, int max)
	{
	
		
	}
	
	public boolean isSolid()
	{
		return false;
	}
	public void roam()
	{
		
	}
	public boolean hasShadow()
	{
		return false;
	}
	
	public boolean hasHealth()
	{
		return false;
	}
	public void render(Graphics2D g)
	{
		
	}
	public void remove(int index)
	{
		EntityManager.entities.remove(index);
	}
	public boolean isPlayer()
	{
		return false;
	}
	public void setPos(Double x, Double y)
	{
		pos.x = x;
		pos.y = y;
	}
	public boolean tileCollision()
	{
		return false;
	}
	public boolean entityCollision()
	{
		return false;
	}
	public boolean permLoad()
	{
		//This is for things that never get unloaded such as the player
		return false;
	}
	public int xOffset()
	{
		return 0;
	}
	public int yOffset()
	{
		return 0;
	}
	public double getSpeedX()
	{
		return 0;
	}
	public double getSpeedY()
	{
		return 0;
	}
	public Rectangle2D.Double collision()
	{
		return null;
	}
	public int xRenderOffset()
	{
		return 0;
	}
	public int yRenderOffset()
	{
		return 0;
	}
	public void setPos(Point2D.Double position)
	{
		pos.x = position.x;
		pos.y = position.y;
	}
	public Object getObject()
	{
		return null;
	}
	public boolean renderOverride()
	{
		return false;
	}
}
