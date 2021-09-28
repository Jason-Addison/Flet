package input;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Rectangle2D;
import java.io.File;

import abovegroundtiles.FloatTile;
import chunk.ChunkManager;
import editor.EditorUI;
import engine.Camera;
import engine.Handler;
import engine.Light;
import engine.Material;
import engine.Utilities;
import entities.EntityManager;
import entities.LightEntity;
import entities.Player;
import gfx.InventoryManager;
import items.BasicItem;
import managers.Attack;
import managers.LakeManager;
import maps.Maps;
import states.State;
import tile.Air;
import tile.BasicTile;
import tile.groundtiles.GroundTile;
import tile.groundtiles.StoneTile;
import tile.ongroundtiles.OnGroundTile;

public class MouseManager implements MouseListener, MouseWheelListener
{

	public static boolean leftClick = false;
	public static Rectangle2D.Double mouse = new Rectangle2D.Double(0, 0, 1, 1);
	private Camera cam = new Camera();
	private InventoryManager inv = new InventoryManager();
	private LakeManager lake = new LakeManager();
	private Light light = new Light();
	private Utilities util = new Utilities();
	private EditorUI editor = new EditorUI();
	public static int mouseTileX;
	public static int mouseTileY;
	public void launch()
	{
		
	}
	public static int xC = 0;
	public static int yC = 0;
	public void changeTile(int x, int y, int xM, int yM)
	{
		BasicTile newTile = (BasicTile) inv.getTile();
		
		xM += 1;
		yM += 1;
		if(xM < 0)
		{
			xM = -xM;
		}
		if(yM < 0)
		{
			yM = -yM;
		}
		int newX = xM / Maps.tileScale;
		int newY = yM / Maps.tileScale;
		if(newX >= 16)
		{
			x++;
			newX = 0;
		}
		if(newY >= 16)
		{
			y++;
			newY = 0;
		}
		
		//ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tile = newTile;
		if(!(inv.getTile().getClass().equals(ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tile.getClass())) && inv.getTile() instanceof GroundTile)
		{			
			BasicTile newInstance = newInstance(newTile);
			
			newInstance.x = newX + (xC * 16);
			newInstance.y = newY + (yC * 16);
			ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tile = newInstance;
			//ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tile.pos(x, y);
			ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tile.onPlace();
			inv.decreaseStackCount(InventoryManager.selectedInv, 0, 1);
			if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.count <= 0)
			{
				inv.removeItem(InventoryManager.selectedInv, 0);
			}
		}
		if(!(inv.getTile().getClass().equals(ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileOnGround.getClass())) && inv.getTile() instanceof OnGroundTile)
		{			
			BasicTile newInstance = newInstance(newTile);
			newInstance.x = newX + (xC * 16);
			newInstance.y = newY + (yC * 16);
			ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileOnGround = newInstance;
			//ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileOnGround.pos(x, y);
			ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileOnGround.onPlace();
			inv.decreaseStackCount(InventoryManager.selectedInv, 0, 1);
			if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.count <= 0)
			{
				inv.removeItem(InventoryManager.selectedInv, 0);
			}
		}
		if(!(inv.getTile().getClass().equals(ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileAboveGround.getClass())) && inv.getTile() instanceof FloatTile)
		{			
			BasicTile newInstance = newInstance(newTile);
			newInstance.x = (int) ((Math.floor(newX)) + (xC * 16));
			newInstance.y = (int) ((Math.floor(newY)) + (yC * 16));
			ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileAboveGround = newInstance;
			//ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileOnGround.pos(x, y);
			ChunkManager.loadedChunks[x][y].chunkMap[newX][newY].tileAboveGround.onPlace();
			inv.decreaseStackCount(InventoryManager.selectedInv, 0, 1);
			if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.count <= 0)
			{
				inv.removeItem(InventoryManager.selectedInv, 0);
			}
		}
		if(Handler.world.map[x][y].tile instanceof StoneTile)
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
		
	public static int x = 0;
	public static int y = 0;
	public static int xM = 0;
	public static int yM = 0;
	
	int xCT = 0;
	int yCT = 0;
	public void tick()
	{
		File file = new File("D:/world1");
		mouse.x = Handler.mouseX + -cam.getX() + 0;
		mouse.y = Handler.mouseY + -cam.getY() + 0;
		mouseTileX = (int) (Math.floor(mouse.x / Maps.tileScale));
		mouseTileY = (int) (Math.floor(mouse.y / Maps.tileScale));
		if(mouse.x < 0)
		{
			xC = (int) (mouse.x / Maps.tileScale / 16) - 1 ;
		}
		else
		{
			xC = (int) (mouse.x / Maps.tileScale / 16) ;
		}
		if(mouse.y < 0)
		{
			yC = (int) (mouse.y / Maps.tileScale / 16)- 1;
		}
		else
		{
			yC = (int) (mouse.y / Maps.tileScale / 16) ;
		}
		
		xCT = (int) (mouse.x - (xC * (Maps.tileScale * 16)));
		yCT = (int) (mouse.y - (yC * (Maps.tileScale * 16)));
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
		//leftClick = false;
		if(leftClick && InventoryManager.inventory[InventoryManager.selectedInv][0].container.material != null)
		{
			
			if(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material instanceof BasicItem)
			{
				useItem(InventoryManager.inventory[InventoryManager.selectedInv][0].container.material);
				itemInUse = true;
				
			}
		}
		if(leftClick && inv.getTile() instanceof BasicTile)
		{
			for(int rowM = 0; rowM < 3; rowM++)
			{
				for(int colM = 0; colM < 3; colM++)
				{
					if(xC == ChunkManager.loadedChunks[rowM][colM].x && yC == ChunkManager.loadedChunks[rowM][colM].y)
					{
						changeTile(rowM, colM, xCT, yCT);
					}
				}
			}
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
							//Handler.world.map[xM][yM].tile.onDestroy();
							//changeTile(xM, yM);	
							for(int rowM = 0; rowM < 3; rowM++)
							{
								for(int colM = 0; colM < 3; colM++)
								{
									if(xC == ChunkManager.loadedChunks[rowM][colM].x && yC == ChunkManager.loadedChunks[rowM][colM].y)
									{
										changeTile(rowM, colM, xCT, yCT);
									}
								}
							}
						}
					}
					else if(inv.getTile() instanceof OnGroundTile)
					{
						if(!(inv.getTile() instanceof Air))
						{
							//if(Handler.world.map[xM][yM].tileOnGround instanceof Air)
							{
								if(xM != Player.swimPos.x || yM != Player.swimPos.y)
								{
									
									//Handler.world.map[xM][yM].tileOnGround.onDestroy();
									//changeTile(xM, yM);	
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
		//if(Handler.world.map[xM][yM].tileOnGround instanceof Air)
		{
			g.setColor(new Color(0, 255, 0, 100));
		}
		//else
		{
			g.setColor(new Color(255, 0, 0, 100));
		}
		//if(Typing.showSelectionBox)
		{
			//g.fillRect(xM * Maps.tileScale + (int) cam.getX(), yM * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale);
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
			//LightEntity light = new LightEntity();
			//light.getObject().set;
			
			//Handler.util.addEntity(light, Handler.util.getMouse().x, Handler.util.getMouse().y);
		}
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			Handler.chunk.onRightClick((int) Math.floor(mouse.x), (int) Math.floor(mouse.y));
			
			InventoryManager.inventory[InventoryManager.selectedInv][0].container.material.onRightClick();
		
			for(int rowM = 0; rowM < 3; rowM++)
			{
				for(int colM = 0; colM < 3; colM++)
				{
					if(xC == ChunkManager.loadedChunks[rowM][colM].x && yC == ChunkManager.loadedChunks[rowM][colM].y)
					{
						xCT = (int) (mouse.x - (xC * (Maps.tileScale * 16)));
						yCT = (int) (mouse.y - (yC * (Maps.tileScale * 16)));
						//if(!(Handler.chunk.getTile(xCT, yCT).tileOnGround instanceof Air))
						{
							//Handler.chunk.onRightClick(xCT, yCT);
						}
						//else
						{
							Handler.chunk.onRightClick(mouse.x, mouse.y);
						}
						
					}
				}
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
