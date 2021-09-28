package chunk;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import engine.Game;
import engine.Handler;
import engine.Test;
import entities.Entity;
import entities.EntityManager;
import entities.Player;
import entities.creatures.Chicken;
import gfx.Text;
import maps.Maps;
import tile.Air;
import tile.BasicMap;
import tile.BasicTile;
import tile.animated.DeepWater;
import tile.groundtiles.Grass;
import tile.groundtiles.Sand;
import tile.groundtiles.StoneTile;
import tile.ongroundtiles.Stick;

public class Chunk
{

	public BasicMap[][] chunkMap;
	public int x;
	public int y;
	
	Random r = new Random(50);
	Test test = new Test();
	public Chunk(double x, double y)
	{
		float[][] xd = new float[16][16];
		for(int i = 0; i < 16; i++)
		{
			for(int e = 0; e < 16; e++)
			{
				xd[i][e] = r.nextFloat();
			}
		}
		
		test.x = (int) x;
		test.y = (int) y;
		float[][] mapp = test.GenerateWhiteNoise(16, 16);
		float[][] fancymap = test.GenerateSmoothNoise(mapp, 2);
		float[][] newNoise = test.GeneratePerlinNoise(fancymap, 4);
		chunkMap = new BasicMap[16][16];
		BasicTile tile = null;
		if(Handler.util.randomNumber(3, 0) == 1)
		{
			tile = new Sand();
		}
		else
		{
			tile = new Grass();
		}
		//System.out.println(x + "               " + y);
		for(int row = 0; row < 16; row++)
		{ 
			for(int col = 0; col < 16; col++)
			{
				//System.out.println(newNoise[row][col]);
				if(row % 2 == 0 && col % 2 == 1)
				{
				//	chunkMap[row][col] = new BasicMap(new Grass(), new Air(), new ArrayList<Entity>(), row, col);
				}
				else
				{
					//chunkMap[row][col] = new BasicMap(new Sand(), new Air(), new ArrayList<Entity>(), row, col);
				}
				if(newNoise[row][col] < 0.05)
				{
					chunkMap[row][col] = new BasicMap(new DeepWater(), new Air(), new ArrayList<Entity>(), row, col);
				}
				else if(newNoise[row][col] < 0.5)
				{
					chunkMap[row][col] = new BasicMap(new Sand(), new Air(), new ArrayList<Entity>(), row, col);
				}
				else if(newNoise[row][col] < 0.95)
				{
					chunkMap[row][col] = new BasicMap(new Grass(), new Air(), new ArrayList<Entity>(), row, col);
				}
				else
				{
					chunkMap[row][col] = new BasicMap(new StoneTile(), new Air(), new ArrayList<Entity>(), row, col);
				}
				chunkMap[row][col].worldX = (int) ((x * 16) + chunkMap[row][col].x);
				chunkMap[row][col].worldY = (int) ((y * 16) + chunkMap[row][col].y);
				chunkMap[row][col].tile.x = chunkMap[row][col].worldX;
				chunkMap[row][col].tile.y = chunkMap[row][col].worldY;
				chunkMap[row][col].tileOnGround.x = chunkMap[row][col].worldX;
				chunkMap[row][col].tileOnGround.y = chunkMap[row][col].worldY;
			}
		}
		populate();
	}
	transient int camX;
	transient int camY;
	public void manageEntities()
	{
		for(int row = 0; row < 16; row++)
		{
			for(int col = 0; col < 16; col++)
			{
				for(int i = 0; i < chunkMap[row][col].entities.size(); i++)
				{
					EntityManager.onScreen.add(chunkMap[row][col].entities.get(i));
					chunkMap[row][col].entities.remove(i);
				}
			}
		}
	}
	public void populate()
	{
		for(int row = 0; row < 16; row++)
		{
			for(int col = 0; col < 16; col++)
			{
				if(Handler.util.randomNumber(100, 0) < 2)
				{
					if(chunkMap[row][col].tile instanceof Grass)
					{
						chunkMap[row][col].tileOnGround = new Stick();
					}
				}
			}
		}
	}
	public void render(Graphics2D g)
	{
		
		g.setColor(Color.BLACK);
		g.setFont(Text.MENU_OPTIONS);
		g.drawString(x + "   " + y, (int) Handler.cam.getX() + (((int) x) * (Maps.tileScale * 16)),
				(int) Handler.cam.getY() + (((int) y) * (Maps.tileScale * 16)));
		for(int row = 0; row < 16; row++)
		{
			for(int col = 0; col < 16; col++)
			{
				g.drawImage(chunkMap[row][col].tile.getTexture(), row * Maps.tileScale + (int) Handler.cam.getX() + (((int) x) * (Maps.tileScale * 16)), col * Maps.tileScale + (int) Handler.cam.getY() + (((int) y) * (Maps.tileScale * 16)) + chunkMap[row][col].tile.getYOffset(), Maps.tileScale, Maps.tileScale + chunkMap[row][col].tile.getYScaleOffset(), null);
				if(chunkMap[row][col].tileOnGround.renderFirst())
				{
					g.drawImage(chunkMap[row][col].tileOnGround.getTexture(), row * Maps.tileScale + (int) Handler.cam.getX() + (((int) x) * (Maps.tileScale * 16)), col * Maps.tileScale + (int) Handler.cam.getY() + (((int) y) * (Maps.tileScale * 16)) + chunkMap[row][col].tile.getYOffset(), Maps.tileScale, Maps.tileScale + chunkMap[row][col].tile.getYScaleOffset(), null);
				}
				if(chunkMap[row][col].worldY < Player.swimPos.y + Game.frame.getHeight() / 2)
				{		
					if(!chunkMap[row][col].tileOnGround.renderFirst())
					{
						g.drawImage(chunkMap[row][col].tileOnGround.getTexture(), row * Maps.tileScale + (int) Handler.cam.getX() + (((int) x) * (Maps.tileScale * 16)), col * Maps.tileScale + (int) Handler.cam.getY() + (((int) y) * (Maps.tileScale * 16)) + chunkMap[row][col].tileOnGround.getYOffset(), Maps.tileScale, Maps.tileScale + chunkMap[row][col].tileOnGround.getYScaleOffset(), null);
					}
					g.drawImage(chunkMap[row][col].tileAboveGround.getTexture(), row * Maps.tileScale + (int) Handler.cam.getX() + (((int) x) * (Maps.tileScale * 16)), col * Maps.tileScale + (int) Handler.cam.getY() + (((int) y) * (Maps.tileScale * 16)) + chunkMap[row][col].tileAboveGround.getYOffset(), Maps.tileScale, Maps.tileScale + chunkMap[row][col].tileAboveGround.getYScaleOffset(), null);
				}
				else
				{
					playerZ = true;
				}
			}
		}
		
	}
	boolean playerZ;
	public void secondRender(Graphics2D g)
	{
		for(int row = 0; row < 16; row++)
		{
			for(int col = 0; col < 16; col++)
			{
				if(chunkMap[row][col].worldY >= Player.swimPos.y)
				{
					if(!chunkMap[row][col].tileOnGround.renderFirst())
					{
						//g.drawImage(chunkMap[row][col].tileOnGround.getTexture(), row * Maps.tileScale + (int) Handler.cam.getX() + (((int) x) * (Maps.tileScale * 16)), col * Maps.tileScale + (int) Handler.cam.getY() + (((int) y) * (Maps.tileScale * 16)) + chunkMap[row][col].tileOnGround.getYOffset(), Maps.tileScale, Maps.tileScale+ chunkMap[row][col].tileOnGround.getYScaleOffset(), null);
					}
					g.drawImage(chunkMap[row][col].tileAboveGround.getTexture(), row * Maps.tileScale + (int) Handler.cam.getX() + (((int) x) * (Maps.tileScale * 16)), col * Maps.tileScale + (int) Handler.cam.getY() + (((int) y) * (Maps.tileScale * 16)) + chunkMap[row][col].tileAboveGround.getYOffset(), Maps.tileScale, Maps.tileScale + chunkMap[row][col].tileAboveGround.getYScaleOffset(), null);
					
				}
			}
		}
	}
	public void renderFinal(Graphics2D g)
	{
		for(int row = 0; row < 16; row++)
		{
			for(int col = 0; col < 16; col++)
			{
				chunkMap[row][col].tile.render(g);
				chunkMap[row][col].tileOnGround.render(g);
				for(int i = 0; i < chunkMap[row][col].entities.size(); i++)
				{
					
					//Entity e = chunkMap[row][col].entities.get(i);
					//g.drawImage(e.texture, (int) e.pos.x + (int) Handler.cam.getX(), (int) e.pos.y + (int) Handler.cam.getY(), (int) e.pos.width, (int) e.pos.height, null);
				}
			}
		}
	}
	public void renderPlayer(Graphics2D g)
	{
		
	}
	public void unload()
	{
		
	}
	public void setX(int newX)
	{
		x = newX;
	}
	public void setY(int newY)
	{
		y = newY;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void clearEntities()
	{
		for(int row = 0; row < 16; row++)
		{
			for(int col = 0; col < 16; col++)
			{
				chunkMap[row][col].entities.clear();
			}
		}
	}
}
