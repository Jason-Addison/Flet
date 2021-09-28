package engine;

import java.awt.geom.Point2D;

public class LightSource
{

	public int radius;
	public Point2D.Float pos;
	public LightSource(int radius, Point2D.Float pos)
	{
		this.radius = radius;
		this.pos = pos;
	}
	
}
