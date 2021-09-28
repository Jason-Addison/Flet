package tile.ongroundtiles;

import gfx.Sources;
import items.BasicItem;
import items.IronPickaxe;

public class Stick extends OnGroundTile
{

	public Stick()
	{
		super(0, Sources.STICK, "Stick", 1000);
	}
	
	public boolean isSolid()
	{
		return true;
	}
	public BasicItem bestItem()
	{
		return new IronPickaxe();
	}
}
