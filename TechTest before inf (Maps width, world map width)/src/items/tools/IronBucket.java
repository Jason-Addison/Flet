package items.tools;

import engine.Handler;
import gfx.Sources;
import input.MouseManager;
import items.BasicItem;
import tile.BasicTile;
import tile.groundtiles.WaterFlow;

public class IronBucket extends BasicItem
{

	boolean hasWater = true;
	public IronBucket()
	{
		super(2, Sources.IRON_BUCKET, "Iron Bucket");
	}
	public void onLeftClick()
	{
		Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround = new WaterFlow();
		Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround.onPlace();
		Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround.pos(MouseManager.xM, MouseManager.yM);
		WaterFlow water = null;

		BasicTile basic = Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround; 
		
		water = (WaterFlow)basic;
		water.placeWater(MouseManager.xM, MouseManager.yM, 5);
	}
}
