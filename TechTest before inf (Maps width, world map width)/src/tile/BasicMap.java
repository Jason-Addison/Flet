package tile;

import java.util.ArrayList;

import entities.Entity;

public class BasicMap implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x;
	public int y;
	public BasicTile tileOnGround;
	public BasicTile tile;
	public ArrayList<Entity> entities;
	public boolean LOADED;
	public String name;
	public BasicMap(BasicTile tile, BasicTile tileOnGround, ArrayList<Entity> entities, int x, int y)
	{
		this.tile = tile;
		this.tileOnGround = tileOnGround;
		this.x = x;
		this.y = y;
		entities = new ArrayList<Entity>();
		this.entities = entities;
	}
	
}
