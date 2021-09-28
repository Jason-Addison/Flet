package items.tools;

import java.awt.image.BufferedImage;

import items.BasicItem;

public class BasicTool extends BasicItem
{

	int damage;
	public BasicTool(int id, BufferedImage texture, String name, int damage)
	{
		super(id, texture, name);
		this.damage = damage;
	}
	
}
