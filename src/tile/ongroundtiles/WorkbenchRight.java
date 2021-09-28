package tile.ongroundtiles;

import engine.Handler;
import gfx.Sources;
import items.BasicItem;
import tile.Air;

public class WorkbenchRight extends OnGroundTile
{

	int x; int y;
	public WorkbenchRight()
	{
		super(0, Sources.WORKBENCH_RIGHT, "Workbench", 100);
	}
	public boolean isSolid()
	{
		return true;
	}
	public void pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void onRightClick()
	{
		
	}
	public void onBreak()
	{
		System.out.println(x);
		if(x > 0 && y > 0)
		{
			if(Handler.world.map[x - 1][y].tileOnGround instanceof WorkbenchLeft)
			{
				Handler.world.map[x - 1][y].tileOnGround = new Air();
			}
		}
	}
	public BasicItem bestItem()
	{
		return null;
	}
}
	
