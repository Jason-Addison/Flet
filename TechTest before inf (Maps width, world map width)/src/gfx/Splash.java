package gfx;

import java.awt.geom.Rectangle2D;

public class Splash 
{

	public Rectangle2D.Double pos;
	public int tick;
	public int tickMax;
	public int frame;
	public int frameMax;
	
	public Splash(Rectangle2D.Double pos, int tick, int tickMax, int frame, int frameMax)
	{
		this.pos = pos;
		this.tick = tick;
		this.tickMax = tickMax;
		this.frame = frame;
		this.frameMax = frameMax;
	}
}
