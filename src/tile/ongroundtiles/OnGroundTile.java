package tile.ongroundtiles;

import java.awt.image.BufferedImage;

import tile.BasicTile;

public class OnGroundTile extends BasicTile
{
	public int health;
	public OnGroundTile(int id, BufferedImage texture, String name, int health)
	{
		super(id, texture, name);
		this.health = health;
	}
	public boolean isSolid()
	{
		return false;
	}
	public void decreaseHealth(int x, int y, int amount)
	{
		health -= amount;
	}
	public void onRightClick()
	{
		
	}
}
