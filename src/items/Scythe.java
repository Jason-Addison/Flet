package items;

import java.awt.image.BufferedImage;

import entities.Entity;
import entities.EntityManager;
import entities.Player;
import entities.TallGrass;
import gfx.Sources;
import input.KeyManager;
import managers.Attack;

public class Scythe extends Tool
{

	public int cooldown;
	
	public Scythe(int id, int coolDown, boolean coolDownLock, String name, BufferedImage texture)
	{
		super(id, coolDown, coolDownLock, name, texture);
		this.texture = Sources.scythe;
		
	}
	public void onUse()
	{
		
		if(coolDown > 0)
		{
			for(int x = Player.playerTileX; x < Player.playerTileX + 2; x++)
			{
				for(int y = Player.playerTileY - 3; y < Player.playerTileY; y++)
				{
					//World.mapOverlay[x][y].id =  0;
				}
			}
			for(int i = 0; i < EntityManager.entities.size(); i++)
			{
				if(EntityManager.entities.get(i) instanceof TallGrass)
				{
					TallGrass tallgrass = null;

					Entity q = (EntityManager.entities.get(i)); 

					tallgrass = ((TallGrass)q);
					//if(World.mapOverlay[tallgrass.x][tallgrass.y].id != 60)
					{
						//EntityManager.entities.remove(i);
					}
				}
			}
			KeyManager.itemUse = true;
			coolDown--;
			coolDownLock = true;
			//World.mapOverlay[Player.boundsTileBL.x + 1][Player.boundsTileBL.y + 1].id =  4;
		}
		else
		{
			Attack.angle = 150;
			KeyManager.itemUse = false;
			coolDown = 70;
			coolDownLock = false;
		}
		
	}
	public boolean isItemInUse()
	{
		return coolDownLock;
	}
	public void removeGrass(int index)
	{
		
	}
}
