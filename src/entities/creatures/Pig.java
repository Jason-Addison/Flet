package entities.creatures;

import java.awt.geom.Rectangle2D;

import entities.Entity;
import entities.EntityCollision;
import entities.Player;
import gfx.Sources;

public class Pig extends Entity
{

	public int health;
	public Pig()
	{
		super(Sources.MOB_PIG, 100);
	}
	public void roam()
	{
		double xDiffrence = Player.playerPosMem.x + (Player.playerPosMem.width / 2) - pos.x;
		double yDiffrence = Player.playerPosMem.y + (Player.playerPosMem.height / 2) - pos.y;
		double hypotenuse = Math.sqrt((Math.pow(xDiffrence, 2)) + (Math.pow(yDiffrence, 2)));
		//System.out.println(hypotenuse + "  |  " + xDiffrence / hypotenuse + "   |   " + yDiffrence / hypotenuse);
		double xOffset = xDiffrence / hypotenuse;
		double yOffset = yDiffrence / hypotenuse;
		//if(!EntityCollision.rightLock && xOffset > 0)
		{
			pos.x += xOffset;
		}
		//else if (!EntityCollision.leftLock && xOffset < 0)
		{
			pos.x += xOffset;
		}
		//if(!EntityCollision.upLock && yOffset < 0)
		{
			pos.y += yOffset;
		}
		// if(!EntityCollision.downLock && yOffset > 0)
		{
			pos.y += yOffset;
		}
	}
}
