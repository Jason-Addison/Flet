package misc;

import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

import abovegroundtiles.TestFloat;
import engine.Material;
import entities.TallGrass;
import furniture.StoneWallDouble;
import furniture.WoodenDoorBottom;
import gfx.InventoryManager;
import items.Container;
import items.IronAxe;
import items.IronPickaxe;
import items.Slot;
import items.item_misc.SpawnChicken;
import items.tools.IronBucket;
import ressources.ItemStone;
import tile.animated.DeepWater;
import tile.animated.WaterSpread;
import tile.groundtiles.Black;
import tile.groundtiles.Dirt;
import tile.groundtiles.Grass;
import tile.groundtiles.Hole;
import tile.groundtiles.Sand;
import tile.groundtiles.Sign;
import tile.groundtiles.StoneTile;
import tile.groundtiles.WoodenPlanks;
import tile.groundtiles.container.SmallChest;
import tile.groundtiles.nature.DarkGrass;
import tile.groundtiles.nature.OakSapling;
import tile.groundtiles.nature.OakStump;
import tile.ongroundtiles.Glass;
import tile.ongroundtiles.Log;
import tile.ongroundtiles.Pebbles;
import tile.ongroundtiles.Rock;
import tile.ongroundtiles.Stick;
import tile.ongroundtiles.StoneFlooring;
import tile.ongroundtiles.StoneWall;
import tile.ongroundtiles.WoodenBarrel;
import tile.ongroundtiles.WoodenBridge;
import tile.ongroundtiles.WorkbenchLeft;

public class InventoryPresets
{

	public void makeInventory()
	{
		//InventoryManager.inventory[0][1] = new Slot(11, 99, 1, false, Sources.pickaxe, new Rectangle2D.Double(0, 0, 65, 65), new JButton(), null, 1, false);
		InventoryManager.inventory[1][1] = new Slot(null, 12, new Rectangle2D.Double(0, 0, 65, 65), new JButton());
		
		/*InventoryManager.inventory[0][0].container = new Container(new Grass(), 999);
    	InventoryManager.inventory[1][0].container = new Container(new Dirt(), 999);
    	InventoryManager.inventory[2][0].container = new Container(new ItemStone(), 999);
    	InventoryManager.inventory[3][0].container = new Container(new WoodenPlanks(), 999);
    	InventoryManager.inventory[4][0].container = new Container(new Rock(), 999);
    	InventoryManager.inventory[5][0].container = new Container(new DeepWater(), 999);
    	InventoryManager.inventory[6][0].container = new Container(new StoneFlooring(), 999);
    	InventoryManager.inventory[7][0].container = new Container(new Glass(), 999);
    	InventoryManager.inventory[8][0].container = new Container(new WoodenBridge(), 999);
    	InventoryManager.inventory[9][0].container = new Container(new IronPickaxe(), 999);
    	InventoryManager.inventory[0][2].container = new Container(new Log(), 999);
    	InventoryManager.inventory[1][2].container = new Container(new Sand(), 999);
    	InventoryManager.inventory[0][3].container = new Container(new Sign(), 999);
    	InventoryManager.inventory[0][4].container = new Container(new WaterSpread(), 999);
     	InventoryManager.inventory[4][2].container = new Container(new Pebbles(), 999);
     	InventoryManager.inventory[3][2].container = new Container(new SmallChest(), 999);
     	InventoryManager.inventory[2][2].container = new Container(new OakStump(), 999);
     	
     	InventoryManager.inventory[5][2].container = new Container(new OakSapling(), 999);
     	InventoryManager.inventory[6][2].container = new Container(new ItemStone(), 999);
     	InventoryManager.inventory[7][2].container = new Container(new WoodenBarrel(), 999);
     	InventoryManager.inventory[8][2].container = new Container(new IronBucket(), 1);
     	InventoryManager.inventory[9][2].container = new Container(new StoneWall(), 999);
     	InventoryManager.inventory[1][3].container = new Container(new Black(), 999);
     	InventoryManager.inventory[2][3].container = new Container(new Stick(), 999);
    	InventoryManager.inventory[3][3].container = new Container(new DarkGrass(), 999);
    	InventoryManager.inventory[4][3].container = new Container(new StoneTile(), 999);
    	InventoryManager.inventory[5][3].container = new Container(new SpawnChicken(), 999);
     	InventoryManager.inventory[6][3].container = new Container(new WorkbenchLeft(), 999);
     	InventoryManager.inventory[7][3].container = new Container(new IronAxe(), 999);*/
    	
    	
    	Material.GRASS = new Grass();
     	InventoryManager.inventory[0][0].container = new Container(Material.GRASS, 999);
    	InventoryManager.inventory[1][0].container = new Container(new StoneTile(), 999);
    	InventoryManager.inventory[2][0].container = new Container(new ItemStone(), 999);
    	InventoryManager.inventory[3][0].container = new Container(new WoodenPlanks(), 999);
    	InventoryManager.inventory[4][0].container = new Container(new Rock(), 999);
    	InventoryManager.inventory[5][0].container = new Container(new DeepWater(), 999);
    	InventoryManager.inventory[6][0].container = new Container(new StoneFlooring(), 999);
    	InventoryManager.inventory[7][0].container = new Container(new WoodenBarrel(), 999);
    	InventoryManager.inventory[8][0].container = new Container(new WoodenBridge(), 999);
    	InventoryManager.inventory[9][0].container = new Container(new IronPickaxe(), 999);
    	InventoryManager.inventory[0][2].container = new Container(new Log(), 999);
    	InventoryManager.inventory[1][2].container = new Container(new Sand(), 999);
    	InventoryManager.inventory[0][3].container = new Container(new Sign(), 999);
    	InventoryManager.inventory[0][4].container = new Container(new WaterSpread(), 999);
     	InventoryManager.inventory[4][2].container = new Container(new Pebbles(), 999);
     	InventoryManager.inventory[3][2].container = new Container(new SmallChest(), 999);
     	InventoryManager.inventory[2][2].container = new Container(new OakStump(), 999);

     	InventoryManager.inventory[5][2].container = new Container(new OakSapling(), 999);
     	InventoryManager.inventory[6][2].container = new Container(new ItemStone(), 999);
     	InventoryManager.inventory[7][2].container = new Container(new Glass(), 999);
     	InventoryManager.inventory[8][2].container = new Container(new IronBucket(), 1);
     	InventoryManager.inventory[9][2].container = new Container(new StoneWall(), 999);
     	InventoryManager.inventory[1][3].container = new Container(new Black(), 999);
     	InventoryManager.inventory[2][3].container = new Container(new Stick(), 999);
    	InventoryManager.inventory[3][3].container = new Container(new DarkGrass(), 999);
    	InventoryManager.inventory[4][3].container = new Container(new Dirt(), 999);
    	InventoryManager.inventory[5][3].container = new Container(new SpawnChicken(), 999);
     	InventoryManager.inventory[6][3].container = new Container(new WorkbenchLeft(), 999);
     	InventoryManager.inventory[7][3].container = new Container(new IronAxe(), 999);
    	InventoryManager.inventory[7][4].container = new Container(new Hole(), 999);
    	InventoryManager.inventory[7][5].container = new Container(new TestFloat(), 999);
    	InventoryManager.inventory[7][5].container = new Container(new WoodenDoorBottom(), 999);
    	InventoryManager.inventory[7][6].container = new Container(new StoneWallDouble(), 999);
	}
	
}
