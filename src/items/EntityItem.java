package items;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import engine.Handler;
import entities.Entity;

public class EntityItem extends Entity
{

	double xSpeed = 3;
	double ySpeed = 3;
	Point2D.Double destination = new Point2D.Double(0, 0);
	public EntityItem(Container container)
	{
		super(null, 10);
		texture = container.material.texture;
		Point2D.Double random = newRandom();
		destination = new Point2D.Double(random.x + pos.x, random.y + pos.y);
	}
	public void roam()
	{
		accX();
		accY();
	}
	public double x = 100;
	public double y = 100;
	public double maxX;
	public double maxY;
	public void accX()
	{
		
		if(x > 0)
		{
			pos.x += x;
			x-=5;
		}
	}
	public void accY()
	{
		
		if(y > 0)
			{
			pos.y += y;
			y-=5;
			}
	}
	public void max(double xMax, double yMax)
	{
		maxX = xMax;
		maxY = yMax;
	}
	public Point2D.Double newRandom()
	{
		int ranX = Handler.util.randomNumber(1000, 0);
		int ranY = Handler.util.randomNumber(1000, 0);
		Point2D.Double point = new Point2D.Double(ranX - 500, ranY - 500);
		return point;
	}
}
