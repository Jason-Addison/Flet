package managers;

import engine.Handler;
import maps.Maps;
import tile.animated.DeepWater;

public class Generator
{
	boolean con = false;
	public void generateWorld()
	{
		for(int row = 0; row < Maps.mapWidth; row++)
		{
			for(int col = 0; col < Maps.mapHeight; col++)
			{
				int ran = Handler.util.randomNumber(100, 0);
				if(ran == 9)
				{
					Handler.world.map[row][col].tile = new DeepWater();
				}
				if(Handler.world.map[row][col].tile instanceof DeepWater)
				{
					int random = Handler.util.randomNumber(53, 0);
					if(random > 2)
					{
						int randomNum = Handler.util.randomNumber(2, 0);
						int randomX = 1;
						int randomY = 1;
						if(randomNum == 1)
						{
							randomX = Handler.util.randomNumber(3, 0);
						}
						else
						{
							randomY = Handler.util.randomNumber(3, 0);
						}
						if(row + randomX - 1 > 0 && col + randomY - 1 > 0 && row + randomX - 1 < Maps.mapWidth && col + randomY - 1 < Maps.mapHeight)
						{
							Handler.world.map[row + randomX - 1][col + randomY - 1].tile = new DeepWater();
						}
						con = true;
					}
					else
					{
						con = false;
					}
				}
			}
		}
		if(con)
		{
			generateWorld();
		}
		else
		{
			
		}
	}
	
}
