package furniture;

import abovegroundtiles.FloatTile;
import chunk.ChunkManager;
import gfx.Sources;
import tile.groundtiles.Grass;

public class WoodenDoorTop extends FloatTile
{

	int dir = 0;
	boolean open = false;
	public WoodenDoorTop()
	{
		super(0, Sources.WOODEN_DOOR_TOP, "Wooden Door Top (Not inventory Item)");
	}
	public void function()
	{
		if(open)
		{
			open = false;
		}
		else
		{
			open = true;
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
}
