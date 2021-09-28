package items;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import entities.Entity;

public class Item extends Entity
{

	public BufferedImage texture;
	Rectangle2D.Double pos;
	Rectangle2D.Double bounds;
	public int health;
	public Item(Rectangle2D.Double pos, Rectangle2D.Double bounds, BufferedImage texture, int health)
	{
		super(null, null, 0);
		this.pos = pos;
		this.bounds = bounds;
		this.texture = texture;
	}
	public void KAPPA()
	{
		
	}
	
}
