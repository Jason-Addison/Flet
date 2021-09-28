package engine;

import editor.EditorUI;
import maps.Maps;
import tile.BasicTile;
import tile.animated.DeepWater;
import tile.animated.WaterSpread;

public class WorldGenerator
{

	private Utilities util = new Utilities();
	public void generateWorld()
	{
		{
			for(int row = 0; row < Maps.mapWidth; row++)
			{
				for(int col = 0; col < Maps.mapHeight; col++)
				{
					int ran = Handler.util.randomNumber(1000, 0);
					if(ran == 1)
					{
						setTile(new DeepWater(), row, col);
					}
					if(Handler.world.map[row][col].tile instanceof DeepWater)
					{
						//int rand = Handler.util.randomNumber(10, 0);
						//if(rand < 9)
						{
							int random = Handler.util.randomNumber(2, 0);
							int ranX = 1;
							int ranY = 1;
							if(random == 1)
							{
								ranX = Handler.util.randomNumber(2, 0);
							}
							else
							{
								ranY = Handler.util.randomNumber(2, 0);
							}

							int newX = row  + (ranX - 1);
							int newY = col + (ranY - 1);
							
							if(newX > 0 && newX < Maps.mapWidth && newY > 0 && newY  < Maps.mapHeight)
							{
								setTile(new DeepWater(), newX, newY);
								int stop = Handler.util.randomNumber(100, 0);
								if(stop > 50)
								{
									//break;
								}
								else
								{
									
									
								}
							}
						}
					}
				}
				
			}
		}
		
	}
	
	public void setTile(BasicTile tile, int x, int y)
	{
		Handler.world.map[x][y].tile = tile;
	}
	public void clear()
	
		{
			for(int row = 0; row < Maps.mapWidth; row++)
			{
				for(int col = 0; col < Maps.mapHeight; col++)
				{
					//if(World.map[row][col].tile instanceof WaterSpread)
					{
						//World.map[row][col].tile = new DeepWater();
					}
				}
			}
			for(int row = 0; row < EditorUI.loadedWorld.width; row++)
			{
				for(int col = 0; col < EditorUI.loadedWorld.height; col++)
				{
					if(EditorUI.loadedWorld.map[row][col].tile instanceof WaterSpread)
					{
						EditorUI.loadedWorld.map[row][col].tile = new DeepWater();
					}
				}
			}
		}
	
	
}
