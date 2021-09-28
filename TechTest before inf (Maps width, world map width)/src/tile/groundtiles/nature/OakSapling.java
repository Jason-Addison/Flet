package tile.groundtiles.nature;

import gfx.Sources;
import tile.ongroundtiles.OnGroundTile;

public class OakSapling extends OnGroundTile
{

	public OakSapling()
	{
		super(6663, Sources.OAK_SAPLING, "Oak Sapling", 100);
	}
	
	public boolean isSolid()
	{
		return true;
	}
	public void onPlace()
	{
		
	}
}
