package tile.groundtiles.container;

import gfx.Sources;

public class SmallChest extends BasicContainer
{

	public SmallChest()
	{
		super(532, Sources.SMALL_CHEST, "Small Chest", 50);
	}
	
	public boolean isSolid()
	{
		return true;
	}
	
	public void onRightClick()
	{
		System.out.println("ayy lmao");
	}
}
