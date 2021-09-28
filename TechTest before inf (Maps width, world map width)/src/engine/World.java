package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entities.Player;
import input.KeyManager;
import maps.Maps;
import tile.Air;
import tile.BasicMap;
import tile.BasicTile;
import tile.ShadedTile;
import tile.groundtiles.nature.OakStump;

public class World 
{
	public int tileScale = 80;
	//private Handler handle = new Handler();
	private Camera cam = new Camera();
	public static int x = 0;
	public static int y = 0;
	public BasicMap[][] map = new BasicMap[16 * 3][16 * 3];    //Ground stuff, mainly will be edited by tilling.
	public static BasicMap[][] mapOverlay = new BasicMap[Maps.mapWidth][Maps.mapHeight]; //Stuff which renders above the player at all times, like when you're inside a house
	public static BasicMap[][] flatOverlay = new BasicMap[Maps.mapWidth][Maps.mapHeight]; //This will include things with render above the first layer, like stumps and fences.
	public static ShadedTile[][] shadeOverlay = new ShadedTile[Maps.mapWidth][Maps.mapHeight];
	
	public static BasicWorld overworld;
	public static BasicWorld currentWorld;
	
	public void tick()
	{
		if(KeyManager.up)
		{
			
		}
	}
	
	public void render(Graphics g)
	{
		x = (int) -(cam.getX() / Maps.tileScale);
		y = (int) -(cam.getY() / Maps.tileScale);
		if(x <= 0)
		{
			x = 0;
		}
		if(y <= 0)
		{
			y = 0;
		}
		
		for(int col = y; col < y + (Handler.height / Maps.tileScale) + 2; col++)
		{
			for(int row = x; row < x + (Handler.width / Maps.tileScale) + 1; row++)
			{
				g.drawImage(map[row][col].tile.getTexture(), row * Maps.tileScale + (int) cam.getX(), col * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale, null);
				
				g.drawImage(map[row][col].tileOnGround.getTexture(), row * Maps.tileScale + (int) cam.getX(), col * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale, null);
				//g.drawImage(Sources.tiles[flatOverlay[row][col].id].texture, row * Maps.tileScale + (int) cam.getX(), col * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale, null);
				//g.setColor(Color.RED);
				//g.fillRect((Player.playerTileX - 1) * Maps.tileScale + (int) cam.getX(),(Player.playerTileY - 1) * Maps.tileScale + (int) cam.getY(), 100, 100);
				g.setColor(new Color(0, 0, 10, (int) (shadeOverlay[row][col].shadeLevel * 15)));
				//dg.fillRect(row * Maps.tileScale + (int) cam.getX(), col * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale);
				for(int i = 0; i < map[row][col].entities.size(); i++)
				{
					g.drawImage(map[row][col].entities.get(i).texture, (int) map[row][col].entities.get(i).pos.x, (int) map[row][col].entities.get(i).pos.y,
							 (int) map[row][col].entities.get(i).pos.width, (int)  map[row][col].entities.get(i).pos.height, null);
				}
			}
		}
		//WorldManager wm = new WorldManager();
		//wm.saveWorld();
		Handler.footprint.render((Graphics2D) g);
	}
	
	public void loadWorld()
	{
		
	}
	/*public void renderSecond(Graphics g)
	{
		for(int col = y; col < y + (Handler.height / Maps.tileScale) + 1; col++)
		{
			for(int row = x; row < x + (Handler.width / Maps.tileScale) + 1; row++)
			{
				map[row][col].tileOnGround.render((Graphics2D) g);
			}
		}
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
		g.setColor(new Color(255, 50, 0, 50));
		for(int col = y; col < y + (Handler.height / Maps.tileScale) + 80; col++)
		{
			for(int row = x; row < x + (Handler.width / Maps.tileScale) + 11; row++)
			{
				if(mapOverlay[row][col] == null)
				{
					//mapOverlay[row][col].id = 1;
				}
				//g.drawImage(Sources.tiles[mapOverlay[row][col].id].texture, row * Maps.tileScale + (int) cam.getX(), col * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale, null);
				//if(mapOverlay[row][col].isSolid || mapOverlay[row][col].id == 60)
				{
				//	g.fillRect(mapOverlay[row][col].x * Maps.tileScale + (int) cam.getX(), mapOverlay[row][col].y * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale);
				}
				//g.setColor(new Color(255, 50, 0, 50));
				for(int x = Player.playerTileX; x < Player.playerTileX + 2; x++)
				{
					for(int y = Player.playerTileY - 3; y < Player.playerTileY; y++)
					{
						//g.fillRect(x * Maps.tileScale + (int) cam.getX(), y * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale);
					}
				}
				
			}
		
		}*/
	
	public int getTileScale()
	{
		return tileScale;
	}
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	public BasicTile getTile(int x, int y)
	{
		//System.out.println("World.java.getTile   : " + x + " " + y);
		
		if(x > 0 && y > 0)
		{
			return map[x][y].tile;
		}
		return null;
	}
	public boolean isSolid(int x, int y)
	{
		if(map[x][y].tile.isSolid())
		{
			return true;
		}
		if(map[x][y].tileOnGround.isSolid())
		{
			return true;
		}
		return false;
	}
	public BasicTile getTileOnGround(int x, int y)
	{
		return map[x][y].tileOnGround;
	}
	public void setTile(BasicTile tile, int x, int y)
	{
		map[x][y].tile = tile;
	}
	public void setTileOnGround(BasicTile tile, int x, int y)
	{
		map[x][y].tileOnGround = tile;
	}
	public BasicMap getMap(int x, int y)
	{
		return map[x][y];
	}
	public void setMap(int x, int y)
	{
		map[x][y] = new BasicMap(Material.GRASS, new Air(), null, x, y);
		if(Handler.util.randomNumber(18, 1) == 287867878)
		{
			OakStump stump = new OakStump();
			stump.pos(x, y);
			map[x][y] = new BasicMap(Material.GRASS, stump, null, x, y);
			stump.onPlace();
		
		}
	}
	public void ebola()
	{
		
	}
}
