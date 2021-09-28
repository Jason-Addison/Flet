package items;

import java.awt.Color;
import java.awt.image.BufferedImage;

import engine.Handler;
import input.MouseManager;
import tile.Air;
import tile.BasicTile;
import tile.ongroundtiles.OnGroundTile;

public class BasicPickaxe extends BasicItem
{

	public int level;
	public int tick;
	public int tickMax;
	public boolean inUse;
	public BasicPickaxe(int id, BufferedImage texture, String name, int level, int tick, int tickMax, boolean inUse)
	{
		super(id, texture, name);
		this.level = level;
		this.tick = tick;
		this.tickMax = tickMax;
		this.inUse = inUse;
	}
		
	public void onUse() 
	{
		tick++;
		if(tick > tickMax)
		{
			tick = 0;
			if(Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround instanceof OnGroundTile)
			{
				OnGroundTile ogt = null;

				BasicTile basic = Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround; 
				
				ogt = (OnGroundTile)basic;
				//(ogt).decreaseHealth(MouseManager.xM, MouseManager.yM, 100);
				if(Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround.bestItem() instanceof BasicPickaxe)
				{
					(ogt).decreaseHealth(MouseManager.xM, MouseManager.yM, 50 * 2);
				}
				else
				{
					(ogt).decreaseHealth(MouseManager.xM, MouseManager.yM, 50);
				}
				if(ogt.health <= 0)
				{
					Handler.util.chatMsg(Color.GREEN, "Pickaxe : ", "You destroyed : " + Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround.getClass().getSimpleName(), 200);
					Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround.onBreak();
					Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround = new Air();
				}
			}
		}		
	}
}
