package chunk;

import maps.Maps;

public class ChunkInfo
{

	public ChunkInfo(int chunkX, int chunkY, int tileX, int tileY)
	{
		
	}
	int chunkX;
	int chunkY;
	int tileX;
	int tileY;
	public ChunkInfo(double x, double y)
	{
		///This is for converting doubles to chunk info
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
		chunkX = xC;
		chunkY = yC;
		tileX = xCT / Maps.tileScale;
		tileY = yCT / Maps.tileScale;
	}
	public ChunkInfo(int tileX, int tileY)
	{
		///This is for converting tiles to chunk info
		int xPos = tileX;
		int yPos = tileY;
		int xC;
		int yC;
		if(xPos < 0)
		{
			xC = (int) (((xPos + 1) / 16) - 1);
		}
		else
		{
			xC = (int) ((xPos + 0) / 16) ;
		}
		if(yPos < 0)
		{
			yC = (int) (((yPos + 1) / 16) - 1);
		}
		else
		{
			yC = (int) ((yPos + 0) / 16) ;
		}
		
		int xCT = (int) (xPos - (xC * (16)));
		int yCT = (int) (yPos - (yC * (16)));
		//System.out.println(xC + " " + yC + " " + xCT + " " + yCT);
		chunkX = xC;
		chunkY = yC;
		this.tileX = xCT;
		this.tileY = yCT;
	}
	public int getChunkX()
	{
		return chunkX;
	}
	public int getChunkY()
	{
		return chunkY;
	}
	public int getTileX()
	{
		return tileX;
	}
	public int getTileY()
	{
		return tileY;
	}
}
