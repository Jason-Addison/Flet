package tile.ongroundtiles;

import engine.Handler;
import gfx.Sources;
import tile.groundtiles.nature.DarkGrass;

public class WorkbenchLeft extends ContainerTile
{

	//int x = 0;
	//int y = 0;
	//Inventory inventory = new Inventory("Workbench", 3, 3);
	public WorkbenchLeft()
	{
		super(0, Sources.WORKBENCH_LEFT, "Workbench", 100, 3, 3);
		//removeLayout();
	}
	public void onPlace()
	{
		System.out.println(x + " " + y);
		Handler.chunk.setTile(new WorkbenchRight(), x + 1, y);
	}
	
	/*public void onEscape()
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
			inventory.isOpen = false;
			inventory.removeLayout();
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
	
	public void onPlace()
	{
		Handler.world.map[x + 1][y].tileOnGround = new WorkbenchRight();
		Handler.world.map[x + 1][y].tileOnGround.pos(x + 1, y);
		Handler.world.map[x + 1][y].tileOnGround.onPlace();
	}
	public void onBreak()
	{
		if(Handler.world.map[x + 1][y].tileOnGround instanceof WorkbenchRight)
		{
			Handler.world.map[x + 1][y].tileOnGround = new Air();
		}
	}
	
	public void pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}*/
	public boolean isSolid()
	{
		return true;
	}
	//public int width()
	{
		//return 1;
	}
}

