package commands;

import tile.BasicTile;

public class SetTile extends BasicCommand
{

	public int x;
	public int y;
	public BasicTile tile;
	
	public SetTile(int x, int y, BasicTile tile)
	{
		super("/setTile");
		this.x = x;
		this.y = y;
		this.tile = tile;
	}
	
}
