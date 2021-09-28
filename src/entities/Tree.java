package entities;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import gfx.Sources;
import items.Wood;

public class Tree extends StaticEntity
{

	public BufferedImage texture;
	Rectangle2D.Double pos;
	Rectangle2D.Double bounds;
	int health;
	public int x;
	public int y;
	@Deprecated public Tree(BufferedImage texture, Rectangle2D.Double pos, Rectangle2D.Double bounds, int health, int x, int y)
	{
		super(texture, health);
		this.texture = texture;
		this.pos = pos;
		this.bounds = bounds;		
		this.health = health;
	}

	public void remove(int index)
	{
		dropItem(index, 100, 1, util.randomNumber(5, 1));
		EntityManager.entities.remove(index);
		dropItems();
		
	}
	public void dropItem(int index, int max, int min, int dropCount)
	{
		for(int i = 0; i < dropCount; i++)
		{
			int x = util.randomNumber(max, min);
			int y = util.randomNumber(max, min);
		EntityManager.entities.add(new Wood(null, new Rectangle2D.Double(EntityManager.entities.get(index).pos.x  + 30 + (x - (max / 2)), EntityManager.entities.get(index).pos.y + 30 + (y - (max / 2)) + 320, 64, 64), Sources.wood, 0));
		}
	}
	
}
