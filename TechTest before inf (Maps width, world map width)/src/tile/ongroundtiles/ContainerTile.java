package tile.ongroundtiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.Game;
import items.Container;
import items.Inventory;

public class ContainerTile extends OnGroundTile
{

	//public int health;
	public int width;
	public int height;
	Inventory inventory;// = new Inventory(name, width, height);
	public ContainerTile(int id, BufferedImage texture, String name, int health, int width, int height)
	{
		super(id, texture, name, health);
		this.width = width;
		this.height = height;
		this.health = health;
		inventory = new Inventory(name, width, height);
		removeLayout();
	}
	public void onEscape()
	{
		inventory.isOpen = false;
		inventory.removeLayout();
		Game.frame.requestFocusInWindow();
	}
	public void addLayout()
	{
		inventory.addLayout();
	}
	public void render(Graphics2D g)
	{
		inventory.render(g);
	}
	public void onRightClick()
	{
		if(inventory.isOpen)
		{
			System.out.println("COOL");
			inventory.isOpen = false;
			inventory.removeLayout();
		}
		else
		{
			System.out.println("COODDDL");
			inventory.panel.requestFocus();
			inventory.isOpen = true;
			addLayout();
		}
	}
	public void removeLayout()
	{
		Game.frame.remove(inventory.panel);
	}
}
