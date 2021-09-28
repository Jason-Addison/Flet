package items.item_misc;

import engine.Handler;
import entities.creatures.Chicken;
import gfx.Sources;
import items.BasicItem;

public class SpawnChicken extends BasicItem
{

	public SpawnChicken()
	{
		super(10, Sources.energybar, "Spawn Chicken");
	}
	public void onLeftClick()
	{
		Handler.util.addEntity(new Chicken(), Handler.util.getMouse().x, Handler.util.getMouse().y);
	}
	
}
