package gfx;

import java.awt.geom.Rectangle2D;

public class Rain
{

	public Rectangle2D.Double pos;
	public int xDeath;
	public int tick;
	public int tickMax;
	public Rain(Rectangle2D.Double pos, int xDeath, int tick, int tickMax)
	{
		this.tick = tick;
		this.tickMax = tickMax;
		this.pos = pos;
		this.xDeath = xDeath;
	}
}
