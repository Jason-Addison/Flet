package tile.ongroundtiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.Game;
import engine.Handler;
import items.Inventory;
import savegame.SavableContainer;

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
		//inventory.removeLayout();
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
		System.out.println(this);
		if(inventory.isOpen)
		{
			inventory.isOpen = false;
			removeLayout();
		}
		else
		{
			inventory.panel.requestFocus();
			inventory.isOpen = true;
			addLayout();
		}
	}
	public void removeLayout()
	{
		Game.frame.remove(inventory.panel);
	}
	public Object getSpecialArgs()
	{
		SavableContainer[] inv = new SavableContainer[width * height];
		for(int i = 0; i < inv.length; i++)
		{
			inv[i] = new SavableContainer();
		}
		
		int step = 0;
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < height; col++)
			{
				if(inventory.container[row][col].material != null)
				{
					inv[step].index = step;
					inv[step].id = Handler.materials.getIdFromMaterial(inventory.container[row][col].material);
					inv[step].damage = 1;
					inv[step].count = inventory.container[row][col].count;
					inv[step].meta = 0;
					step++;
				}
			}
		}
		return inv;
	}
	public void specialArgs(Object info)
	{
		SavableContainer[] s = new SavableContainer[width * height];
		s = (SavableContainer[]) Handler.util.JSONToObject(info, s);
		int step = 0; 
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < height; col++)
			{
				//if(s[step].index == step)
				{
					inventory.container[row][col].material = Handler.materials.getMaterialFromId(s[step].id);
					inventory.container[row][col].count = s[step].count;
				}
				step++;
			}
		}
		System.out.println(inventory.container[0][0].material);
	}	
}
