package items;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Wood extends Item
{

	public BufferedImage texture;
	Rectangle2D.Double pos;
	Rectangle2D.Double bounds;
	public Wood(Rectangle2D.Double pos, Rectangle2D.Double bounds, BufferedImage texture, int health)
	{
		super(bounds, bounds, texture, health);
		this.pos = pos;
		this.bounds = bounds;
		this.texture = texture;
	}
	
}
