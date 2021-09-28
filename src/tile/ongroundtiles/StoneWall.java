package tile.ongroundtiles;

import gfx.Sources;
public class StoneWall extends OnGroundTile
{

	boolean solid = true;
	public StoneWall()
	{
		super(5, Sources.STONE_WALL, "Stone Wall", 200);
	}
	public boolean isSolid()
	{
		return solid;
		
	}
	public void onRightClick()
	{
		if(solid)
		{
			solid = false;
			texture = null;
		}
		else
		{
			solid = true;
			texture = Sources.STONE_WALL;
		}
	}
}
