package furniture;

import gfx.Sources;
import tile.ongroundtiles.OnGroundTile;

public class StoneWallDouble extends OnGroundTile
{

	public StoneWallDouble()
	{
		super(0, Sources.STONE_WALL_DOUBLE, "Stone Wall (Double)", 100);
	}
	public boolean isSolid()
	{
		return true;
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
