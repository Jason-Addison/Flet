package items;

import java.awt.image.BufferedImage;

public class Tool extends BasicItem
{

	public int coolDown;
	public boolean coolDownLock;
	
	public Tool(int id, int coolDown, boolean coolDownLock, String name, BufferedImage texture)
	{
		super(id, texture, name);
		this.coolDown = coolDown;
		this.coolDownLock = coolDownLock;
		this.name = name;
		this.texture = texture;
	}
	public boolean isItemInUse()
	{
		return false;
	}
	public void onUse()
	{
		
	}
}
