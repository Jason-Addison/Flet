package entities;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class TallGrass extends StaticEntity
{
	public int health;
	public BufferedImage texture;
	public Rectangle2D.Double pos;
	public Rectangle2D.Double bounds;
	public int x;
	public int y;
	public boolean collided;
	public int tick;
	public int frame;
	public boolean left;
	public boolean right;
	public int maxFrame;
	public Point2D.Double origin;
	@Deprecated public TallGrass(BufferedImage texture, Rectangle2D.Double pos, Rectangle2D.Double bounds, int health, boolean collided, int x, int y, int frame, int tick, boolean left, boolean right, int maxFrame, Point2D.Double origin)
	{
		super(texture, health);
		this.pos = pos;
		this.texture = texture;
		this.bounds = bounds;
		this.collided = collided;
		this.health = health;
		this.x = x;
		this.y = y;
		this.tick = tick;
		this.frame = frame;
		this.left = left;
		this.right = right;
		this.maxFrame = maxFrame;
		this.origin = origin;
	}
	public void nudge(int index)
	{
		System.out.println("SAasddsD");
	}
}
