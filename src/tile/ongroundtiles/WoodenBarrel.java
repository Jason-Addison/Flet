package tile.ongroundtiles;

import engine.Handler;
import engine.Material;
import gfx.Sources;
import tile.Air;
import tile.Filler;

public class WoodenBarrel extends ContainerTile
{

	int containerCount = 0;
	
	public WoodenBarrel()
	{
		super(0, Sources.WOODEN_BARREL, "Wooden Barrel", 300, 10, 3);
		//inventory = new Inventory(name, width, height);
	}
	public void onPlace()
	{
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < height; col++)
			{
				Material m = Handler.materials.getMaterialFromId(Handler.util.randomNumber(200, 0));
				if(m instanceof Filler)
				{
					m = new Air();
				}
				inventory.container[row][col].material = m;
				inventory.container[row][col].count = Handler.util.randomNumber(999, 0);
			}
		}
	}
	public boolean isSolid()
	{
		return true;
	}
}
