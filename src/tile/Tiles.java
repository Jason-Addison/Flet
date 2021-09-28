package tile;

import java.awt.Color;

import abovegroundtiles.TestFloat;
import engine.Handler;
import engine.Material;
import furniture.StoneWallDouble;
import furniture.WoodenDoorBottom;
import items.IronAxe;
import items.IronPickaxe;
import items.item_misc.SpawnChicken;
import items.tools.IronBucket;
import ressources.ItemStone;
import tile.animated.DeepWater;
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
import tile.ongroundtiles.WorkbenchLeft;
import tile.ongroundtiles.WorkbenchRight;

public class Tiles 
{

	public static Material[] MATERIALS = new Material[4096];
	
	public void loadMaterials()
	{
		for(int i = 0; i < MATERIALS.length; i++)
		{
			MATERIALS[i] = new Filler();
		}
		MATERIALS[0] = new Air();
		MATERIALS[1] = new Grass();
		MATERIALS[2] = new Dirt();
		MATERIALS[3] = new StoneTile();
		MATERIALS[4] = new Sand();
		MATERIALS[5] = new Hole();
		MATERIALS[6] = new Filler();
		MATERIALS[7] = new Filler();
		MATERIALS[8] = new Filler();
		MATERIALS[9] = new WoodenPlanks();
		MATERIALS[10] = new DeepWater();
		MATERIALS[11] = new WoodenPlanks();
		MATERIALS[12] = new Filler();
		MATERIALS[13] = new Filler();
		MATERIALS[14] = new Filler();
		MATERIALS[15] = new Filler();
		MATERIALS[16] = new TestFloat();
		MATERIALS[17] = new WoodenDoorBottom();
		MATERIALS[18] = new Filler();
		MATERIALS[19] = new Filler();
		MATERIALS[20] = new Log();
		MATERIALS[21] = new OakStump();
		MATERIALS[22] = new SmallChest();
		MATERIALS[23] = new Pebbles();
		MATERIALS[24] = new OakSapling();
		MATERIALS[25] = new Glass();
		MATERIALS[26] = new StoneWall();
		MATERIALS[27] = new Sign();
		MATERIALS[28] = new Black();
		MATERIALS[29] = new Stick();
		MATERIALS[30] = new DarkGrass();
		MATERIALS[31] = new WorkbenchLeft();
		MATERIALS[32] = new WorkbenchRight();
		MATERIALS[33] = new StoneFlooring();
		MATERIALS[34] = new WoodenBarrel();
		MATERIALS[35] = new Log();
		
		MATERIALS[520] = new ItemStone();
		MATERIALS[521] = new IronBucket();
		MATERIALS[522] = new SpawnChicken();
		MATERIALS[523] = new IronAxe();
		MATERIALS[524] = new IronPickaxe();
		MATERIALS[525] = new StoneWallDouble();
		MATERIALS[526] = new Rock();
		MATERIALS[527] = new Rock();
		MATERIALS[528] = new Rock();
		MATERIALS[529] = new Rock();
		MATERIALS[530] = new Rock();
	}
	public int getIdFromMaterial(Material material)
	{
		for(int i = 0; i < MATERIALS.length; i++)
		{
			if(MATERIALS[i].getClass().equals(material.getClass()))
			{
				return i;
			}
		}
		return 0;
	}
	public Material getMaterialFromId(int id)
	{
		if(MATERIALS[id] instanceof Filler)
		{
			Handler.util.chatMsg(Color.RED, "Warning ! ", "id " + id + " was not found!", 500);
		}
		try
		{
			return MATERIALS[id].getClass().newInstance();
		} 
		catch (InstantiationException e)
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
