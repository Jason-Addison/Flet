package chunk;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import engine.Handler;
import entities.Entity;
import entities.EntityManager;
import entities.Player;
import input.MouseManager;
import maps.Maps;
import tile.Air;
import tile.BasicMap;
import tile.BasicTile;
import tile.groundtiles.GroundTile;
import tile.ongroundtiles.OnGroundTile;

public class ChunkManager 
{

	int chunkX;
	int chunkY;
	String[][] playerChunks = new String[3][3];
	public static Chunk[][] loadedChunks = new Chunk[3][3];
	public void initChunks()
	{
		if(Player.playerPosMem.x < 0)
		{
			chunkX = (int) (Player.playerPosMem.x / Maps.tileScale / 16) - 1;
		}
		else
		{
			chunkX = (int) (Player.playerPosMem.x / Maps.tileScale / 16) + 0;
		}
		if(Player.playerPosMem.y < 0)
		{
			chunkY = (int) (Player.playerPosMem.y / Maps.tileScale / 16) - 1;
		}
		else
		{
			chunkY = (int) (Player.playerPosMem.y / Maps.tileScale / 16) + 0;
		}
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				loadedChunks[row][col] = Handler.chunkloader.readChunk(chunkX + row - 1, chunkY + col - 1);
			}
		}
	}
	boolean up, down, left, right;
	int oldX =2;
	int oldY = 2;
	int centerX;
	int centerY;
	public void tick()
	{
		ChunkInfo info = new ChunkInfo(MouseManager.mouse.x, MouseManager.mouse.y);
		
		if(Player.playerPosMem.x < 0)
		{
			chunkX = (int) (Player.playerPosMem.x / Maps.tileScale / 16) - 1;
		}
		else
		{
			chunkX = (int) (Player.playerPosMem.x / Maps.tileScale / 16) + 0;
		}
		if(Player.playerPosMem.y < 0)
		{
			chunkY = (int) (Player.playerPosMem.y / Maps.tileScale / 16) - 1;
		}
		else
		{
			chunkY = (int) (Player.playerPosMem.y / Maps.tileScale / 16) + 0;
		}
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				for(int rowT = 0; rowT < 16; rowT++)
				{
					for(int colT = 0; colT < 16; colT++)
					{
						loadedChunks[row][col].chunkMap[rowT][colT].tile.update();
						loadedChunks[row][col].chunkMap[rowT][colT].tileOnGround.update();
					}
				}
			}
		}
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.chunkX == loadedChunks[row][col].x && info.chunkY == loadedChunks[row][col].y)
				{
				}
			}
		}
		centerX = loadedChunks[1][0].x;
		centerY = loadedChunks[0][1].y;
		validateChunkOffscreen();
		resetShifters();
	}
	public void shiftCurrentChunks(int xOffset, int yOffset, int x, int y)
	{
		if(xOffset == -1)
		{
			Handler.chunkloader.saveChunk(loadedChunks[2][0], loadedChunks[2][0].getX(), loadedChunks[2][0].getY()); 
			Handler.chunkloader.saveChunk(loadedChunks[2][1], loadedChunks[2][1].getX(), loadedChunks[2][1].getY());
			Handler.chunkloader.saveChunk(loadedChunks[2][2], loadedChunks[2][2].getX(), loadedChunks[2][2].getY());
			loadedChunks[0][0] = loadedChunks[1][0]; loadedChunks[1][0] = loadedChunks[2][0]; loadedChunks[2][0] = Handler.chunkloader.readChunk(x, y);
			loadedChunks[0][1] = loadedChunks[1][1]; loadedChunks[1][1] = loadedChunks[2][1]; loadedChunks[2][1] = Handler.chunkloader.readChunk(x, y + 1);
			loadedChunks[0][2] = loadedChunks[1][2]; loadedChunks[1][2] = loadedChunks[2][2]; loadedChunks[2][2] = Handler.chunkloader.readChunk(x, y + 2);
		}
		if(xOffset == 1)
		{
			Handler.chunkloader.saveChunk(loadedChunks[0][0], loadedChunks[0][0].getX(), loadedChunks[0][0].getY()); 
			Handler.chunkloader.saveChunk(loadedChunks[0][1], loadedChunks[0][1].getX(), loadedChunks[0][1].getY());
			Handler.chunkloader.saveChunk(loadedChunks[0][2], loadedChunks[0][2].getX(), loadedChunks[0][2].getY());
			loadedChunks[2][0] = loadedChunks[1][0]; loadedChunks[1][0] = loadedChunks[0][0]; loadedChunks[0][0] = Handler.chunkloader.readChunk(x, y);
			loadedChunks[2][1] = loadedChunks[1][1]; loadedChunks[1][1] = loadedChunks[0][1]; loadedChunks[0][1] = Handler.chunkloader.readChunk(x, y + 1);
			loadedChunks[2][2] = loadedChunks[1][2]; loadedChunks[1][2] = loadedChunks[0][2]; loadedChunks[0][2] = Handler.chunkloader.readChunk(x, y + 2);
		}
		if(yOffset == -1)
		{
			Handler.chunkloader.saveChunk(loadedChunks[0][2], loadedChunks[0][2].getX(), loadedChunks[0][2].getY()); 
			Handler.chunkloader.saveChunk(loadedChunks[1][2], loadedChunks[1][2].getX(), loadedChunks[1][2].getY());
			Handler.chunkloader.saveChunk(loadedChunks[2][2], loadedChunks[2][2].getX(), loadedChunks[2][2].getY());
			loadedChunks[0][0] = loadedChunks[0][1]; loadedChunks[0][1] = loadedChunks[0][2]; loadedChunks[0][2] = Handler.chunkloader.readChunk(x + 0, y);
			loadedChunks[1][0] = loadedChunks[1][1]; loadedChunks[1][1] = loadedChunks[1][2]; loadedChunks[1][2] = Handler.chunkloader.readChunk(x + 1, y);
			loadedChunks[2][0] = loadedChunks[2][1]; loadedChunks[2][1] = loadedChunks[2][2]; loadedChunks[2][2] = Handler.chunkloader.readChunk(x + 2, y);
		}
		if(yOffset == 1)
		{
			Handler.chunkloader.saveChunk(loadedChunks[0][0], loadedChunks[0][0].getX(), loadedChunks[0][0].getY()); 
			Handler.chunkloader.saveChunk(loadedChunks[1][0], loadedChunks[1][0].getX(), loadedChunks[1][0].getY());
			Handler.chunkloader.saveChunk(loadedChunks[2][0], loadedChunks[2][0].getX(), loadedChunks[2][0].getY());
			loadedChunks[0][2] = loadedChunks[0][1]; loadedChunks[0][1] = loadedChunks[0][0]; loadedChunks[0][0] = Handler.chunkloader.readChunk(x + 0, y);
			loadedChunks[1][2] = loadedChunks[1][1]; loadedChunks[1][1] = loadedChunks[1][0]; loadedChunks[1][0] = Handler.chunkloader.readChunk(x + 1, y);
			loadedChunks[2][2] = loadedChunks[2][1]; loadedChunks[2][1] = loadedChunks[2][0]; loadedChunks[2][0] = Handler.chunkloader.readChunk(x + 2, y);
		}
	}
	public void resetShifters()
	{
		up = false; 
		down = false; 
		left = false; 
		right = false;
	}
	public void validateChunkOffscreen()
	{
		
		if(chunkX > centerX)
		{
			left = true;
		}
		if(chunkX < centerX)
		{
			right = true;
		}
		if(chunkX > centerX)
		{
			left = true;
		}
		if(chunkY > centerY)
		{
			up = true;
		}
		if(chunkY < centerY)
		{
			down = true;
		}
		if(left)
		{
			shiftCurrentChunks(-1, 0, centerX + 2, centerY - 1);
		}
		if(right)
		{
			shiftCurrentChunks(1, 0, centerX - 2, centerY - 1);
		}
		if(up)
		{
			shiftCurrentChunks(0, -1, centerX - 1, centerY + 2);
		}
		if(down)
		{
			shiftCurrentChunks(0, 1, centerX - 1, centerY - 2);
		}
	}
	public void render(Graphics2D g)
	{
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				loadedChunks[row][col].render(g);
			}
		}
		
	}
	public void secondRender(Graphics2D g)
	{
		for(int i = 0; i < EntityManager.onScreen.size(); i++)
		{
			EntityManager.onScreen.get(i).render(g);
		}
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				loadedChunks[row][col].secondRender(g);
				loadedChunks[row][col].renderFinal(g);
			}
		}
	}
	public int getPlayerX()
	{
		return chunkX;
	}
	public int getPlayerY()
	{
		return chunkY;
	}
	public void updateChunk()
	{
		
	}
	public boolean scanChunks(ChunkInfo info)
	{
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					return true;
				}
			}
		}
		return false;
	}
	public void addEntity(int tileX, int tileY, Entity entity)
	{
		ChunkInfo info = new ChunkInfo(tileX, tileY);
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					System.out.println(entity.pos.y);
					loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].entities.add(entity);
				}
			}
		}
	}
	public void removeEntity(int tileX, int tileY, int index)
	{
		ChunkInfo info = new ChunkInfo(tileX, tileY);
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].entities.remove(index);
				}
			}
		}
	}
	public void setTexture(int tileX, int tileY, BufferedImage texture)
	{
		ChunkInfo info = new ChunkInfo(tileX, tileY);
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tile.texture = texture;
				}
			}
		}
	}
	public void functionOnGround(int tileX, int tileY)
	{
		ChunkInfo info = new ChunkInfo(tileX, tileY);
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tileOnGround.function();
				}
			}
		}
	}
	public void onRightClick(int tileX, int tileY)
	{
		ChunkInfo info = new ChunkInfo(tileX, tileY);
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tileOnGround.onRightClick();
				}
			}
		}
	}
	public BasicMap getTile(int tileX, int tileY)
	{
		ChunkInfo info = new ChunkInfo(tileX, tileY);
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					return loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()];
				}
			}
		}
		return new BasicMap(new Air(), new Air(), new ArrayList<Entity>(), tileX, tileY);
	}
	public void setTile(BasicTile tile, int tileX, int tileY)
	{
		ChunkInfo info = new ChunkInfo(tileX, tileY);
		for(int row = 0; row < 3; row++) 
		{
			for(int col = 0; col < 3; col++)
			{
				if(info.getChunkX() == loadedChunks[row][col].x && info.getChunkY() == loadedChunks[row][col].y)
				{
					tile.x = tileX;
					tile.y = tileY;
					if(tile instanceof GroundTile)
					{
						loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tile = tile;
						//loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tile.pos(info.getTileX(), info.getTileY());;
						loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tile.onPlace();
					}
					else if(tile instanceof OnGroundTile)
					{
						loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tileOnGround = tile;
						loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tileOnGround.onPlace();
					}	
					else
					{
						loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tileAboveGround = tile;
						loadedChunks[row][col].chunkMap[info.getTileX()][info.getTileY()].tileAboveGround.onPlace();
					}
				}
			}
		}
	}
	public void onRightClick(double x, double y)
	{
		
		double xPos = x;
		double yPos = y;
		int xC;
		int yC;
		if(xPos < 0)
		{
			xC = (int) (((xPos + 0) / Maps.tileScale / 16) - 1);
		}
		else
		{
			xC = (int) ((xPos + 0) / Maps.tileScale / 16) ;
		}
		if(yPos < 0)
		{
			yC = (int) (((yPos + 0) / Maps.tileScale / 16) - 1);
		}
		else
		{
			yC = (int) ((yPos + 0) / Maps.tileScale / 16) ;
		}
		
		int xCT = (int) (xPos - (xC * (Maps.tileScale * 16)));
		int yCT = (int) (yPos - (yC * (Maps.tileScale * 16)));
		if(xCT < 0)
		{
			xCT = (xC * 16) + xCT;
		}
		if(yCT < 0)
		{
			yCT = (xC * 16) + yCT;
		}
		if(xC == -2)
		{
			//xC++;
		}
		if(xCT >= Maps.tileScale * 16)
		{
			xCT = 0;
		}
		if(yCT >= Maps.tileScale * 16)
		{
			yCT = 0;
		}
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				if(xC == loadedChunks[row][col].x && yC == loadedChunks[row][col].y)
				{
					loadedChunks[row][col].chunkMap[(xCT / Maps.tileScale)][(yCT / Maps.tileScale)].tile.onRightClick();
					loadedChunks[row][col].chunkMap[(xCT / Maps.tileScale)][(yCT / Maps.tileScale)].tileOnGround.onRightClick();
				}
			}
		}
	}
	public BasicMap getTileSimple(int x, int y)
	{
		int xPos = x / Maps.tileScale;
		int yPos = y / Maps.tileScale;
		int xC;
		int yC;
		if(xPos < 0)
		{
			xC = (int) (xPos / Maps.tileScale / 16) - 1 ;
		}
		else
		{
			xC = (int) (xPos / Maps.tileScale / 16) ;
		}
		if(yPos < 0)
		{
			yC = (int) (yPos / Maps.tileScale / 16)- 1;
		}
		else
		{
			yC = (int) (yPos / Maps.tileScale / 16) ;
		}
		
		int xCT = (int) (xPos - (xC * (Maps.tileScale * 16)));
		int yCT = (int) (yPos - (yC * (Maps.tileScale * 16)));
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				if(xC == loadedChunks[row][col].x && yC == loadedChunks[row][col].y)
				{
					return loadedChunks[row][col].chunkMap[xCT][yCT];
				}
			}
		}
		return null;
	}
	@Deprecated public void setTile(int x, int y, BasicTile tile)
	{
		int xPos = (x * Maps.tileScale);
		int yPos = (y * Maps.tileScale);
		int xC;
		int yC;
		if(xPos < 0)
		{
			xC = (int) (xPos / Maps.tileScale / 16) - 1 ;
		}
		else
		{
			xC = (int) (xPos / Maps.tileScale / 16) ;
		}
		if(yPos < 0)
		{
			yC = (int) (yPos / Maps.tileScale / 16)- 1;
		}
		else
		{
			yC = (int) (yPos / Maps.tileScale / 16) ;
		}
		
		int xCT = (int) (xPos - (xC * (Maps.tileScale * 16)));
		int yCT = (int) (yPos - (yC * (Maps.tileScale * 16)));
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				if(xC == loadedChunks[row][col].x && yC == loadedChunks[row][col].y)
				{
					//return loadedChunks[row][col].chunkMap[xCT][yCT];
				}
			}
		}
	}
	public Chunk createChunk(int x, int y)
	{
		Chunk chunk = new Chunk(x, y);
		return chunk;
	}
	@Deprecated public void saveChunkOLD(Chunk chunk, int d, int e)
	{
		try (Writer writer = new FileWriter("D:/world1/chunk_" + d + "_" + e + ".json"))
		{
			Gson gson = new GsonBuilder().create();
	        //gson.toJson("Hello", writer);
	        //Test map = new Test();
	        JsonObject tileOb = new JsonObject();
	        //for(int i = 0; i < 5; i++)
	        for(int row = 0; row < 16; row++)
	        {
	        	for(int col = 0; col < 16; col++)
	        	{
	        		BasicTile tile = chunk.chunkMap[row][col].tile;
	        		BasicTile tileOnGround = chunk.chunkMap[row][col].tileOnGround;
	        		//gson.toJson(newObj, writer);
	        		String tType = tile.getClass().getCanonicalName();
	        		tile.name = tType;
	        		String togType = tileOnGround.getClass().getCanonicalName();
	        		tileOnGround.name = togType;
	    	        //String newTile = gson.toJson(ob);
	    	        
	    	        tileOb.add("tile " + row + " " + col, gson.toJsonTree(tile));
	    	        tileOb.add("tileOnGround " + row + " " + col, gson.toJsonTree(tileOnGround));
	        	}
	        }
	        
	       // JsonObject newObj = new JsonParser().parse(gson.toJson(tileOb)).getAsJsonObject();
	        JsonObject chunkob = new JsonObject();
	        chunkob.add("chunk " + d + " " + e, gson.toJsonTree(tileOb));
	        JsonObject newChunk = new JsonParser().parse(gson.toJson(chunkob)).getAsJsonObject();
	        gson.toJson(newChunk, writer);
		}
		
	        //BufferedImage texture = grass.map[0][0].tile.texture;
	        //byte[] tex = Handler.util.imageToByteArray(texture);
	        //text = gson.toJson(tex);
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        //gson.toJson(tile, writer);
	        //gson.toJson(tex, writer);
	   // }
		//catch (IOException e) 
		//{
		//	e.printStackTrace();
		//}
		
		//readWorld();
	}
	public int getChunkX()
	{
		return chunkX;
	}
	public int getChunkY()
	{
		return chunkY;
	}
}
