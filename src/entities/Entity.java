package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import engine.Handler;
import engine.Material;
import engine.Utilities;
import tile.Filler;

public class Entity
{
	public transient BufferedImage texture;
	public Rectangle2D.Double pos = new Rectangle2D.Double(0, 0, 0, 0);
	public Rectangle2D.Double collision = new Rectangle2D.Double(0, 0, 0, 0);
	public transient int health;
	public transient boolean loaded;
	public transient int previousX;
	public transient int previousY;
	protected transient Utilities util = new Utilities();
	public static Entity[] ENTITIES = new Entity[4098];
	public Entity(BufferedImage texture, int health)
	{
		this.texture = texture;
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
	public void setkPos(Double x, Double y)
	{
		//pos.x = x;
		//pos.y = y;
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
	public void setPjos(Point2D.Double position)
	{
		//pos.x = position.x;
		//pos.y = position.y;
	}
	public Object getObject()
	{
		return null;
	}
	public boolean renderOverride()
	{
		return false;
	}
	/*public void initialize()
	{
		for(int i = 0; i < ENTITIES.length; i++)
		{
			ENTITIES[i] = 
		}
	}
	public int getIdFromMaterial(Material material)
	{
		for(int i = 0; i < ENTITIES.length; i++)
		{
			if(ENTITIES[i].getClass().equals(material.getClass()))
			{
				return i;
			}
		}
		return 0;
	}
	public Material getEntityFromId(int id)
	{
		if(ENTITIES[id] instanceof Filler)
		{
			Handler.util.chatMsg(Color.RED, "Warning ! ", "id " + id + " was not found!", 500);
		}
		try
		{
			return ENTITIES[id].getClass().newInstance();
		} 
		catch (InstantiationException e)
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}*/
}
