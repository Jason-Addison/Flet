package tile;

import java.util.ArrayList;

import entities.Entity;
import maps.Maps;

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
	public BasicTile tileAboveGround = new Air();
	public ArrayList<Entity> entities;
	public boolean LOADED;
	public String name;
	public transient int worldX;
	public transient int worldY;
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
