package entities.structures;

import java.awt.geom.Rectangle2D;

import entities.Entity;
import gfx.Sources;

public class Firepit extends Entity
{

	public int x;
	public int y;
	public boolean lit;
	public Firepit(int x, int y, Rectangle2D.Double pos, Rectangle2D.Double bounds, boolean lit)
	{
		super(null, y);
		this.x = x;
		this.y = y;
		this.lit = lit;
		//this.texture = Sources.tiles[25].texture;
	}
	
}
