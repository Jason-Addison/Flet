package items;

import gfx.Sources;
import items.tools.BasicTool;

public class IronAxe extends BasicTool
{
	public IronAxe()
	{
		super(3, Sources.TOOL_AXE_IRON, "Iron Axe", 50);
	}
	public boolean isItemInUse()
	{
		return false;
	}
	/*public void onUse()
	{
		//KeyManager.itemUse = true;
		if(tick > 20)
		{
			tick = 0;
			frame++;
			if(frame > 2)
			{
				frame = 0;
			}
		}
		int TargetX;
		int TargetY;
		if(Handler.player.getDirection() == 4)
		{
			TargetX = Player.playerTileX - 2;
			TargetY = Player.playerTileY - 1;
		}
		else
		{
			TargetX = Player.playerTileX;
			TargetY = Player.playerTileY - 1;
		}
		//System.out.println(TargetX + " " + TargetY);
		//if(TargetX == 55)
		{
			for(int i = 0; i < EntityManager.entities.size(); i++)
			{
				if(EntityManager.entities.get(i) instanceof Pinetree)
				{
					Pinetree tree = null;

					Entity q = (EntityManager.entities.get(i)); 

					tree = ((Pinetree)q);
					System.out.println(Handler.player.getDirection());
					
					if(tree.x == TargetX)
					{
						if(tree.y == TargetY)
						{
							tree.health--;
						}
					}
				}
			}
		}*/
	
}
