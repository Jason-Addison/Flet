package items;

import java.awt.image.BufferedImage;

import engine.Handler;
import engine.Material;
import gfx.InventoryManager;
import input.MouseManager;
import tile.Air;

public class BasicItem extends Material
{

	public BasicItem(int id, BufferedImage texture, String name)
	{
		super(id, texture, name);
	}
	public void onUse()
	{
		
	}
	public boolean isItemInUse()
	{
		return false;
	}
	public int damage()
	{
		return 1;
	}
	
	public void onRightClick()
	{
		
	}
	public void onLeftClick()
	{
		if(!(Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround instanceof Air))
		{
			
			Material inve = InventoryManager.inventory[InventoryManager.selectedInv][0].container.material;
			if(!(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material instanceof Empty) && 
					inve.bestItem() != null)
			{
				if(Handler.world.map[MouseManager.xM][MouseManager.yM].tileOnGround.bestItem().getClass() == inve.getClass())
				{
					
				}
			}
			else if(!(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material instanceof Empty))
			{
				
			}
		}
	}
	public void useTool()
	{
		
	}
}
