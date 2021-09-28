package tile.ongroundtiles;

import engine.Handler;
import gfx.Sources;
import items.BasicItem;
import items.Container;
import items.EntityItem;
import items.IronAxe;
import maps.Maps;
import ressources.ItemStone;
import tile.Air;

public class Rock extends OnGroundTile
{

	public Rock()
	{
		super(5, Sources.ROCK, "Rock", 200);
	}
	
	public boolean isSolid()
	{
		return true;
	}
	//EntityItem item = new EntityItem(new Container(new ItemStone(), 1));
	
	//Handler.util.dropItems(item, x, y);
	public BasicItem bestItem()
	{
		return new IronAxe();
	}
	public Container getDrops()
	{
		return new Container(new ItemStone(), 5);
	}
}
