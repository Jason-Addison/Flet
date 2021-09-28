package tile.ongroundtiles;

import gfx.Sources;

public class Glass extends OnGroundTile
{

	public Glass()
	{
		super(60, Sources.GLASS, "Glass", 1);
	}
	public void onRightClick()
	{
		System.out.println("rightcliec!");
	}
}
