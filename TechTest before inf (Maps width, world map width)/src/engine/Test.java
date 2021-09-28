package engine;

import java.util.ArrayList;

import entities.Entity;
import tile.Air;
import tile.BasicMap;
import tile.groundtiles.Dirt;

public class Test 
{

	public BasicMap[][] map;
	public Test()
	{
		
		//for(int row = 0; row < w; row++)
		{
			//for(int col = 0; col < h; col++)
			{
				//if (row % 2 == 0) {
					//map[row][col] = Handler.world.map[row][col];
					//map[row][col] = new BasicMap(new Dirt(), new Air(), new ArrayList<Entity>(), row, col);
					//} else {
						//map[row][col] = new BasicMap(new Grass(), new Air(), new ArrayList<Entity>(), row, col);
					//}
				
				//map[row][col].name = map[row][col].tile.getClass().getCanonicalName();
			}
		}
	}
	public void init()
	{
		int w = 150, h = 150;
		map = new BasicMap[w][h];
		for(int row = 0; row < w; row++)
		{
			for(int col = 0; col < h; col++)
			{
				
				map[row][col] = new BasicMap(new Dirt(), new Air(), new ArrayList<Entity>(), row, col);
			}
		}
	}
	
}
