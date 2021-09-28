package tile.tools;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import items.Item;

public class Pickaxe extends Item
{

	//public Rectangle2D.Double bounds;
	public Pickaxe(BufferedImage texture, Rectangle2D.Double pos, Rectangle2D.Double bounds, int health)
	{
		super(bounds, bounds, texture, health);
	}
	
}
