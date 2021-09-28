package engine;

import tile.BasicMap;

public class BasicWorld 
{

	public BasicMap[][] map;
	String name;
	public int width;
	public int height;
	public BasicWorld(String name, int width, int height)
	{
		this.map = new BasicMap[width][height];
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
}
