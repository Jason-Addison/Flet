package managers;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import engine.Utilities;
import entities.Entity;
import entities.EntityManager;
import entities.TallGrass;
import gfx.Sources;
import maps.Maps;

public class GrassManager
{

	int tick = 0;
	int maxTick = 1000;
	private Utilities util = new Utilities();
	public void tick()
	{
		tick++;
		if(tick >= maxTick)
		{
			tick = 0;
			for(int i = 0; i < EntityManager.entities.size(); i++)
			{
				if(EntityManager.entities.get(i) instanceof TallGrass)
				{
					if(util.randomNumber(3, 0) == 1)
					{
						TallGrass tallgrass = null;

						Entity q = (EntityManager.entities.get(i)); 

						tallgrass = ((TallGrass)q);
						int xRan = util.randomNumber(4, 1);
						int yRan = util.randomNumber(4, 1);
						int xOffset = 0;
						int yOffset = 0;
						
						if(xRan == 1)
						{
							xOffset = 1;
						}
						if(xRan == 2)
						{
							xOffset = -1;
						}
						if(xRan == 3)
						{
							xOffset = 0;
						}
						if(yRan == 1)
						{
							yOffset = 1;
						}
						if(yRan == 2)
						{
							yOffset = -1;
						}
						if(yRan == 3)
						{
							yOffset = 0;
						}
						int x = tallgrass.x + xOffset;
						int y = tallgrass.y + yOffset;
						//if(!(World.mapOverlay[x][y].id == 60) && !World.map[x][y].isSolid && Sources.tiles[World.map[x][y].id].growable && x < Maps.mapWidth && x > 0 &&  y < Maps.mapHeight && y > 0)
						{
						//	changeGrass(x, y);
						}
					}
				}
			}
		}
	}
	public void updateGrass()
	{
		
	}
	public void changeGrass(int x, int y)
	{
		//World.mapOverlay[x][y].entityTile = true;
		//World.mapOverlay[x][y].id = 60;
		EntityManager.entities.add(new TallGrass(Sources.tallgrass, new Rectangle2D.Double(x * Maps.tileScale - 25, y * Maps.tileScale - 25, 150, 150), 
				new Rectangle2D.Double(x * Maps.tileScale, y * Maps.tileScale, 100, 100), x, false, x, y, 0, 0, false, false, 0, new Point2D.Double(x * Maps.tileScale, y * Maps.tileScale)));
	}
}
