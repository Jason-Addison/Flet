package tile.groundtiles.container;

import java.awt.image.BufferedImage;

import tile.ongroundtiles.OnGroundTile;

public class BasicContainer extends OnGroundTile
{

	public BasicContainer(int id, BufferedImage texture, String name, int health)
	{
		super(health, texture, name, health);
	}
	
	//public boolean isSolid()
	{
	//	return false;
	}
}
