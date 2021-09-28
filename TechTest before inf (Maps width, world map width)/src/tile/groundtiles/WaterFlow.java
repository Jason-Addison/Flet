package tile.groundtiles;

import engine.Handler;
import gfx.Sources;
import input.MouseManager;
import tile.Air;
import tile.BasicTile;
import tile.ongroundtiles.OnGroundTile;

public class WaterFlow extends OnGroundTile
{

//	int level = 10;
	public WaterFlow()
	{
		super(2, Sources.WATER_FLOW, "Water Flowable", 10000);
	}
	public void onPlace()
	{
		
	}
	public void pos(int x, int y)
	{
		//System.out.println(level);
		if(Handler.world.map[x - 1][y].tileOnGround instanceof Air && x > 2 && Handler.world.map[x][y].tileOnGround.getInt() > 1)
		{
			//Handler.world.map[x - 1][y].tileOnGround = new WaterFlow();
			Handler.world.map[x - 1][y].tileOnGround.pos(x - 1, y);
			//Handler.world.map[x - 1][y].tileOnGround.intfunction(level - 1);
			
			
		}
	}
	public void placeWater(int x, int y, int level)
	{
		if(level > 0)
		{
			WaterFlow water = null;//(WaterFlow) Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround;

			BasicTile basic = Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround; 
			
			water = (WaterFlow)basic;
			if(Handler.world.map[x - 1][y].tileOnGround instanceof Air)
			{
				Handler.world.map[x - 1][y].tileOnGround = new WaterFlow();
				water.placeWater(x - 1, y, level - 1);
			}
			if(Handler.world.map[x + 1][y].tileOnGround instanceof Air)
			{
				Handler.world.map[x + 1][y].tileOnGround = new WaterFlow();
				water.placeWater(x + 1, y, level - 1);
			}
			if(Handler.world.map[x][y - 1].tileOnGround instanceof Air)
			{
				Handler.world.map[x][y - 1].tileOnGround = new WaterFlow();
				water.placeWater(x, y - 1, level - 1);
			}
			if(Handler.world.map[x][y + 1].tileOnGround instanceof Air)
			{
				Handler.world.map[x][y + 1].tileOnGround = new WaterFlow();
				water.placeWater(x, y + 1, level - 1);
			}
			System.out.println(level);
		}
	}
	public void intfunction(int function)
	{
		//level = function;
	}
	public int getInt()
	{
		return 3;
	}
	public void onRightClick()
	{
		System.out.println(3);
	}
}
