package tile;

import java.awt.image.BufferedImage;

public class Tiles 
{

	//This is for the block database
	
	public String name; // for ref purposes
	public int id;
	public boolean growable;
	public BufferedImage texture;
	public boolean entityTile;
	public boolean isSolid;
	public int layer; //0 = floor 1 = onFloor 2 = overlay
	public Tiles(String name, BufferedImage texture, int id, boolean isSolid, boolean entityTile, boolean growable, int layer)
	{
		this.texture = texture;
		this.name = name;
		this.id = id;
		this.growable = growable;
		this.entityTile = entityTile;
		this.isSolid = isSolid;
		this.layer = layer;
	}
	
}
