package tile.ongroundtiles;

import gfx.Sources;

public class StoneFlooring extends OnGroundTile
{

	public StoneFlooring()
	{
		super(50, Sources.STONE_FLOORING, "Stone Flooring", 1);
	}
	public boolean renderFirst()
	{
		return true;
	}
}
