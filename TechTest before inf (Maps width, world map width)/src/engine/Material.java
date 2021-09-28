package engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gfx.InventoryManager;
import gfx.Sources;
import input.MouseManager;
import items.BasicItem;
import items.Container;
import items.Empty;
import items.EntityItem;
import ressources.ItemStone;
import tile.Air;
import tile.animated.DeepWater;
import tile.groundtiles.Grass;
import tile.groundtiles.Sand;
import tile.groundtiles.nature.OakSapling;
import tile.groundtiles.nature.OakStump;
import tile.ongroundtiles.Pebbles;
import tile.ongroundtiles.Stick;
import tile.ongroundtiles.WoodenBarrel;
import tile.ongroundtiles.WorkbenchLeft;

public class Material 
{

	public int id;
	public String name;
	public transient BufferedImage texture;
	public Material(int id, BufferedImage texture, String name)
	{
		this.id = id;
		this.name = name;
		this.texture = texture;
	}
	
	public static Grass GRASS;
	public static Air AIR = new Air();
	public static Sand SAND = new Sand();
	public static OakStump OAK_STUMP = new OakStump();
	public static Pebbles PEBBLES = new Pebbles();
	public static OakSapling OAK_SAPLING = new OakSapling();
	public static ItemStone ROCK_I = new ItemStone();
	public static WoodenBarrel WOODEN_BARREL = new WoodenBarrel();
	public static Stick WOODEN_STICK = new Stick();
	public static WorkbenchLeft WORKBENCH = new WorkbenchLeft();
	public static DeepWater DEEP_WATER = new DeepWater();
	int x;
	int y;
	public BufferedImage getTexture()
	{
		return texture;
	}
	public void addRecipies()
	{
				//= Maiterial.AIR
		GRASS = new Grass();
	}
	public void function()
	{
		System.out.println("function");
	}
	public boolean isSolid()
	{
		return false;
	}
	public void onPlace()
	{
		
	}
	public void animate()
	{
		
	}
	public void onRightClick()
	{
		
	}
	public void render(Graphics2D g)
	{
		
	}
	public void onEscape()
	{
		
	}
	public void onBreak()
	{
		dropItems();
	}
	public void dropItems()
	{
		if(getDrops() != null)
		{
			Handler.util.dropItems(new EntityItem(getDrops()), x, y);
		}
	}
	public Container getDrops()
	{
		return null;
	}
	public void intfunction(int function)
	{
		
	}
	public void pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getInt()
	{
		return 0;
	}
	public BasicItem bestItem()
	{
		return null;
	}
	public int width()
	{
		return 0;
	}
	public int height()
	{
		return 0;
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
	
	public void onDestroy()
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
	public BufferedImage textureOverride()
	{
		return null;
	}
}
