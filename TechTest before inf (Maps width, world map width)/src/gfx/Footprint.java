package gfx;

import java.awt.geom.Rectangle2D;

public class Footprint 
{

	public Rectangle2D.Double pos;
	public double tick;
	public double tickMax;
	public float opacity = 1;
	
	public Footprint(Rectangle2D.Double pos, double tick, double tickMax, float opacity)
	{
		this.opacity = opacity;
		this.pos = pos;
		this.tick = tick;
		this.tickMax = tickMax;
	}
	
}
