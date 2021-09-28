package entities.creatures;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import entities.Entity;

public class BasicCreature extends Entity
{

	public BasicCreature(BufferedImage texture, Rectangle2D.Double pos, Rectangle2D.Double collision, int health)
	{
		super(texture, pos, health);
	}
	
}
