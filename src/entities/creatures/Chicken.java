package entities.creatures;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import engine.Handler;
import entities.Entity;
import entities.EntityCollision;
import entities.Player;
import gfx.Sources;
import maps.Maps;

public class Chicken extends Entity
{

	public transient boolean up, down, left, right;
	public transient int frame;
	public transient int tick;
	transient boolean  inMotion = false;
	transient double speed = 0.5;
	transient public static double MAX_SPEED = 1.16666666667;
	transient Point2D.Double offsetToDest = new Point2D.Double(0, 0);
	public Chicken()
	{
		super(Sources.MOB_CHICKEN[0][0], 3);
		double random = Handler.util.randomNumber(70, 50);
		speed = random / 60;
	}
	transient Point2D.Double currentDestination = new Point2D.Double(0, 0);
	public void roam()
	{
		//if(!inMotion)
		{
			tick--;
		}
		if(tick <= 0)
		{
			tick = Handler.util.randomNumber(1500, 1000);
			Point2D.Double random = newRandom();
			currentDestination = new Point2D.Double(random.x + pos.x, random.y + pos.y);
		}
		//offsetToDest = Handler.util.pointToPoint(new Point2D.Double(pos.x, pos.y), new Point2D.Double(Player.playerPosMem.x, Player.playerPosMem.y));
		offsetToDest = Handler.util.pointToPoint(new Point2D.Double(pos.x, pos.y), currentDestination);
		
		if(pos.x > currentDestination.x - 10 && pos.x < currentDestination.x + 10 &&
				pos.y > currentDestination.y - 10 && pos.y < currentDestination.y + 10)
		{
			offsetToDest = Handler.util.pointToPoint(new Point2D.Double(pos.x, pos.y), new Point2D.Double(pos.x, pos.y));
		}
		
		if(offsetToDest.x < 0)
		{
			if(!EntityCollision.leftLock)
			{
				pos.x += offsetToDest.x * speed;
			}
		}
		else if(offsetToDest.x > 0)
		{
			if(!EntityCollision.rightLock)
			{
				pos.x += offsetToDest.x * speed;
			}
		}
		if(offsetToDest.y > 0)
		{
			if(!EntityCollision.downLock)
			{
				pos.y += offsetToDest.y * speed;
			}
		}
		else if(offsetToDest.y < 0)
		{
			if(!EntityCollision.upLock)
			{
				pos.y += offsetToDest.y * speed;
			}
		}
		if(Double.isNaN(offsetToDest.x) && Double.isNaN(offsetToDest.y))
		{
			texture = Sources.MOB_CHICKEN[0][0];
			inMotion = false;
		}
		else
		{
			inMotion = true;
		}
		if(inMotion)
		{
			animateChicken();
		}
	}
	transient int animTick = 0;
	transient int animFrame = 0;
	public void animateChicken()
	{
		animTick--;
		
		if(animTick < 0)
		{
			animTick = (int) ((MAX_SPEED - speed) * 50);
			animFrame++;
			if(animFrame > 1)
			{
				animFrame = 0;
			}
			texture = Sources.MOB_CHICKEN[0][animFrame];
		}
	}
	public Point2D.Double newRandom()
	{
		int ranX = Handler.util.randomNumber(1000, 0);
		int ranY = Handler.util.randomNumber(1000, 0);
		Point2D.Double point = new Point2D.Double(ranX - 500, ranY - 500);
		return point;
	}
	
	public boolean tileCollision()
	{
		return true;
	}
	public void animate()
	{
		
		tick++;
		if(tick > 100)
		{
			tick = 0;
			frame++;
			if(frame > 1)
			{
				frame = 0;
			}
		}
	}
	public int yOffset()
	{
		return 0;
	}
	public int xRenderOffset()
	{
		return 0;
	}
	public int yRenderOffset()
	{
		return 50;
	}
	public int getCurrentFrame()
	{
		return frame;
	}
	public double getSpeedX()
	{
		return offsetToDest.x * speed;
	}
	public double getSpeedY()
	{
		return offsetToDest.y * speed;
	}
	public Rectangle2D.Double collision()
	{
		return new Rectangle2D.Double(pos.x + 40, pos.y + 50, 30, 30);
	}
}
