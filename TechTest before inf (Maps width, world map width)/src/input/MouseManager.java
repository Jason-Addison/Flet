package input;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import editor.EditorUI;
import engine.Camera;
import engine.Handler;
import engine.Light;
import engine.Material;
import engine.Utilities;
import entities.EntityManager;
import entities.LightEntity;
import entities.Player;
import entities.TallGrass;
import gfx.BasicLight;
import gfx.InventoryManager;
import gfx.Lighting;
import gfx.Sources;
import items.BasicItem;
import managers.Attack;
import managers.LakeManager;
import maps.Maps;
import states.State;
import tile.Air;
import tile.BasicTile;
import tile.groundtiles.GroundTile;
import tile.groundtiles.Stone;
import tile.ongroundtiles.OnGroundTile;

public class MouseManager implements MouseListener, MouseWheelListener
{

	public static boolean leftClick = false;
	Rectangle2D.Double mouse = new Rectangle2D.Double(0, 0, 1, 1);
	private Camera cam = new Camera();
	private InventoryManager inv = new InventoryManager();
	private LakeManager lake = new LakeManager();
	private Light light = new Light();
	private Utilities util = new Utilities();
	private EditorUI editor = new EditorUI();
	public void launch()
	{
		
	}
	public void changeTile(int x, int y)
	{
		BasicTile newTile = (BasicTile) inv.getTile();
		if(!(inv.getTile().getClass().equals(Handler.world.map[x][y].tile.getClass())) && inv.getTile() instanceof GroundTile)
		{			
			BasicTile newInstance = newInstance(newTile);
			//newInstance.pos(x, y);
			//newInstance.onPlace();
			System.out.println("You have placed : " + newTile + " | Replacing : " + Handler.world.map[x][y].tile);
			
			Handler.world.map[x][y].tile = newInstance;
			Handler.world.map[x][y].tile.pos(x, y);
			Handler.world.map[x][y].tileOnGround.onPlace();
			inv.decreaseStackCount(InventoryManager.selectedInv, 0, 1);
			if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.count <= 0)
			{
				inv.removeItem(InventoryManager.selectedInv, 0);
			}
		}
		if(!(inv.getTile().getClass().equals(Handler.world.map[x][y].tileOnGround.getClass())) && newTile instanceof OnGroundTile)
		{

			BasicTile newInstance = newInstance(newTile);
			//newInstance.pos(x, y);
			//newInstance.onPlace();
			System.out.println("You have placed : " + newInstance + " | Replacing : " + Handler.world.map[x][y].tileOnGround);
			//Handler.world.map[x][y].tile = InventoryManager.inventory[inv.selectedInv][0].container.tile;
			
		
			Handler.world.map[x][y].tileOnGround = newInstance;
			Handler.world.map[x][y].tileOnGround.pos(x, y);
			Handler.world.map[x][y].tileOnGround.onPlace();
			inv.decreaseStackCount(InventoryManager.selectedInv, 0, 1);
			if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.count <= 0)
			{
				inv.removeItem(InventoryManager.selectedInv, 0);
			}
			
		}
		if(Handler.world.map[x][y].tile instanceof Stone)
		{
			light.changeLight(x, y, 0);
		}
		else
		{
			Light.lightCheck = false;
			light.removeLight(x, y);
		}
		//if(tile == 10)
		{
			lake.makeLake(x, y);
		}
	}
	public BasicTile newInstance(BasicTile tile)
	{
		BasicTile newInstance = null;
		try
		{
			newInstance = tile.getClass().newInstance();
		} 
		catch (InstantiationException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		return newInstance;
	}
	public void changeOverlay(int x, int y, int tile)
	{
		
		if(Sources.tiles[tile].isSolid)
		{
			//isSolid = true;
		}
		else
		{
			//isSolid = false;
		}
		if(x > 0 && KeyManager.secondLayer)
		{
			if(y > 0)
			{
				if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material == null)
				{
					//inv.decreaseStackCount(inv.selectedInv, 0, 1);
					//if(InventoryManager.inventory[inv.selectedInv][0].container.count <= 0)
					{
						//inv.removeItem(inv.selectedInv, 0);
					}
				}
			}
		}
		if(tile == 60)
		{
			EntityManager.entities.add(new TallGrass(Sources.tallgrass, new Rectangle2D.Double(x * Maps.tileScale - 20, y * Maps.tileScale - 20, 120, 120),
					new Rectangle2D.Double(x * Maps.tileScale - 20, y * Maps.tileScale - 20, 120, 120), x, false, x, y, 0, 0, false, false, 0, new Point2D.Double(x * Maps.tileScale - 20, y * Maps.tileScale - 20)));
		}
	}
	
	public static int x = 0;
	public static int y = 0;
	public static int xM = 0;
	public static int yM = 0;
	public void tick()
	{
		mouse.x = Handler.mouseX + -cam.getX() + 0;
		mouse.y = Handler.mouseY + -cam.getY()+ 0;
		tileCheck();
		x = (int) -(cam.getX() / Maps.tileScale) - 10;
		y = (int) -(cam.getY() / Maps.tileScale) - 6;
		if(x <= 0)
		{
			x = 0;
		}
		if(y <= 0)
		{
			y = 0;
		}
		xM = (int) (mouse.x / Maps.tileScale);
		yM = (int) (mouse.y / Maps.tileScale);
		if(xM <= 0)
		{
			xM = 0;
		}
		if(yM <= 0)
		{
			yM = 0;
		}
		if(itemInUse)
		{
			InventoryManager.inventory[InventoryManager.selectedInv][0].container.material.onUse();
			if(!InventoryManager.inventory[InventoryManager.selectedInv][0].container.material.isItemInUse())
			{
				Attack.frame = 0;
				itemInUse = false;
			}
		}
	}
	public void useItem(Material material)
	{
		//item.onUse();
		//InventoryManager.inventory[InventoryManager.selectedInv][0].container.material.onUse();
	}
	public static boolean itemInUse = false;
	public void tileCheck()
	{
		
		if(leftClick && InventoryManager.inventory[InventoryManager.selectedInv][0].container.material != null)
		{
			
			if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material instanceof BasicItem)
			{
				useItem(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material);
				itemInUse = true;
				
			}
		}
		if(leftClick)
		{
			useItem(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material);
		}
		
		if(leftClick && !InventoryManager.inventoryOpen && !(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material instanceof Air))
		{
			for(int i = 0; i < EntityManager.entities.size(); i++)
			{
				if(mouse.intersects(EntityManager.entities.get(i).pos) || EntityManager.entities.get(i).pos.intersects(mouse))
				{
					EntityManager.entities.get(i).health--;	
				}
			}
			for(int col = yM; col < yM + 1; col++)
			{
				for(int row = xM; row < xM + 1; row++)
				{
				
					if(inv.getTile() instanceof GroundTile)
					{
						if(!(inv.getTile() instanceof Air))
						{
							Handler.world.map[xM][yM].tile.onDestroy();
							changeTile(xM, yM);	
						}
					}
					else if(inv.getTile() instanceof OnGroundTile)
					{
						if(!(inv.getTile() instanceof Air))
						{
							if(Handler.world.map[xM][yM].tileOnGround instanceof Air)
							{
								if(xM != Player.swimPos.x || yM != Player.swimPos.y)
								{
									Handler.world.map[xM][yM].tileOnGround.onDestroy();
									changeTile(xM, yM);	
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void checkTile(int x, int y, int tile)
	{
		
	}
	public void render(Graphics g)
	{
		if(Handler.world.map[xM][yM].tileOnGround instanceof Air)
		{
			g.setColor(new Color(0, 255, 0, 100));
		}
		else
		{
			g.setColor(new Color(255, 0, 0, 100));
		}
		if(Typing.showSelectionBox)
		{
			g.fillRect(xM * Maps.tileScale + (int) cam.getX(), yM * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}
	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}
	@Override
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			leftClick = true;
			InventoryManager.inventory[InventoryManager.selectedInv][0].container.material.onLeftClick();
			//Lighting.lights.add(new BasicLight((int) Handler.mouseX, (int) Handler.mouseY, 1000, 2));
			LightEntity light = new LightEntity();
			//light.getObject().set;
			Handler.util.addEntity(light, Handler.util.getMouse().x, Handler.util.getMouse().y);
		}
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			Lighting.lights.add(new BasicLight((int) mouse.x, (int) mouse.y, 500, 500));
			if(!(Handler.world.getTileOnGround(xM, yM) instanceof Air))
			{
				Handler.world.map[xM][yM].tileOnGround.onRightClick();
				String tile = Handler.world.getMap(xM, yM).tileOnGround.getClass().getSimpleName();
				util.chatMsg(null, "Right Click : ", tile, 300);
			}
			else if(!(Handler.world.getTile(xM, yM) instanceof Air))
			{
				Handler.world.getMap(xM, yM).tile.onRightClick();
				String tile = Handler.world.getMap(xM, yM).tile.getClass().getSimpleName();
				util.chatMsg(null, "Right Click : ", tile, 300);
			}
			else
			{
				InventoryManager.inventory[InventoryManager.selectedInv][0].container.material.onRightClick();
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			leftClick = false;
		}
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		if(State.currentState == 3)
		{
			editor.zoom(e.getWheelRotation());
		}
		else
		{
			inv.setInvSelect(e.getWheelRotation());
		}
	}
}
