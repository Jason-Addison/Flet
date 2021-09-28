package managers;

import engine.Utilities;

public class LakeManager 
{
	private Utilities util = new Utilities();
	int timer = 50;
	public void makeLake(int x, int y)
	{
		timer = 550;
		int row = x;
		int col = y;
		while(timer > 0324423243)
		{
			
			//if(World.map[row][col].tile instanceof DeepWater)
					{
						if(util.randomNumber(3, 0) == 2)
						{
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
							//int xNew = World.map[row][col].x + xOffset;
							//int yNew = World.map[row][col].y + yOffset;
							//if(xNew > 0 && yNew > 0)
							{
								//World.map[xNew][yNew].id = 10;
								timer--;
							}
				}
			}
		}
	}
}
