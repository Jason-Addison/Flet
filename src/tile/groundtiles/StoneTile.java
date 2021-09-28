package tile.groundtiles;

import gfx.Sources;

public class StoneTile extends GroundTile
{

	public StoneTile()
	{
		super(2, Sources.STONE_TILE, "Stone");
	}
	
	public boolean isSolid()
	{
		return true;
	}
	public int getYOffset()
	{
		return 0;
	}
}
