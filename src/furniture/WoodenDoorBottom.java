package furniture;

import engine.Handler;
import gfx.Sources;
import tile.ongroundtiles.OnGroundTile;

public class WoodenDoorBottom extends OnGroundTile
{

	int dir = 0;
	boolean open = false;
	public WoodenDoorBottom()
	{
		super(0, Sources.WOODEN_DOOR_CLOSED, "Wooden Door", 1);
	}
	public void function()
	{
		
	}
	public void onPlace()
	{
		//System.out.println(x + " " + y);
		//Handler.chunk.setTile(new WoodenDoorTop(), x, y - 1);
	}
	public void onRightClick()
	{
		if(open)
		{
			texture = Sources.WOODEN_DOOR_CLOSED;
			open = false;
		}
		else
		{
			texture = Sources.WOODEN_DOOR_OPEN;
			open = true;
		}
		if(Handler.chunk.getTile(x, y - 1).tileAboveGround instanceof WoodenDoorTop)
		{
			//Handler.chunk.functionOnGround(x, y - 1);
		}
	}
	public Object getSpecialArgs()
	{
		return open;
	}
	public void specialArgs(Object doorState)
	{
		open = (boolean) doorState;
	}
	public boolean isSolid()
	{
		if(!open)
		{
			return true;
		}
		return false;
	}
	public int getYOffset()
	{
		return -100;
	}
	public int getYScaleOffset()
	{
		return 100;
	}
}
