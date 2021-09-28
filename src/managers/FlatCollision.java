package managers;

import java.awt.Point;
import java.awt.geom.Rectangle2D;

import chunk.Bounds;
import engine.Camera;
import engine.Handler;
import entities.Player;
import input.KeyManager;
import maps.Maps;

public class FlatCollision 
{
public static Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 50, 30);
	
	public static Bounds boundsTileTR = new Bounds();
	public static Bounds boundsTileBR = new Bounds();
	public static Bounds boundsTileTL = new Bounds();
	public static Bounds boundsTileBL = new Bounds();
	public static boolean upLock, downLock, leftLock, rightLock;
	public void tick()
	{
		
		bounds = Player.bounds;
		
		for(int i = 0; i < Handler.entity.getOnScreenEntities().size(); i++)
		{
			if(Handler.entity.getOnScreenEntities().get(i).isPlayer())
			{
			//	EntityManager.entities.get(i).collision.x = bounds.x;
			//	EntityManager.entities.get(i).collision.y = bounds.y;
			//	EntityManager.entities.get(i).collision.width = bounds.width;
			//	EntityManager.entities.get(i).collision.height = bounds.height;
				//Handler.entity.getOnScreenEntities().get(i).pos.x = bounds.x;
				//Handler.entity.getOnScreenEntities().get(i).pos.y = bounds.y;
				//Handler.entity.getOnScreenEntities().get(i).pos.width = bounds.width;
				//Handler.entity.getOnScreenEntities().get(i).pos.height = bounds.height;
				
			}
				
		}
		
		//System.out.println(playerPosMem.x + " " + playerPosMem.y);
		Player.playerTileY  = (int) (bounds.y / Maps.tileScale) + 1;
		Player.playerTileX  = (int) (bounds.x / Maps.tileScale) + 1;
		Player.swimPos.x = (int) ((bounds.x + 30) / Maps.tileScale);
		Player.swimPos.y = (int) ((bounds.y + 10) / Maps.tileScale);
		
		boundsTileTR.x = (int) ((bounds.x + bounds.width) / Maps.tileScale) + 1;
		boundsTileTR.y = (int) ((bounds.y) / Maps.tileScale);
		if(bounds.x + bounds.width < 0)
		{
			boundsTileTR.x--;
		}
		if(bounds.y < 0)
		{
			boundsTileTR.y--;
		}
		boundsTileBR.x = (int) ((bounds.x + bounds.width) / Maps.tileScale) + 1;
		boundsTileBR.y = (int) ((bounds.y + bounds.height) / Maps.tileScale) + 1;
		if(bounds.x + bounds.width < 0)
		{
			boundsTileBR.x--;
		}
		if(bounds.y + bounds.height < 0)
		{
			boundsTileBR.y--;
		}
		boundsTileTL.x = (int) (Math.floor((bounds.x) / Maps.tileScale));
		boundsTileTL.y = (int) (Math.floor((bounds.y) / Maps.tileScale));
		if(bounds.x < 0)
		{
			//boundsTileTL.x--;
		}
		if(bounds.y < 0)
		{
			//boundsTileTL.y--;
		}
		//boundsTileBL.x = bottomLeft.getTilleX();
		//boundsTileBL.y = bottomLeft.getTilleY();
		//System.out.println(boundsTileBL.x);
		boundsTileBL.x = (int) ((bounds.x) / Maps.tileScale) - 1;
		boundsTileBL.y = (int) ((bounds.y + bounds.height) / Maps.tileScale) + 1;
		if(bounds.x < 0)
		{
			boundsTileBL.x--;
		}
		if(bounds.y + bounds.height < 0)
		{
			boundsTileBL.y--;
		}
		//System.out.println(Handler.chunk.getTile(boundsTileTL.x - 1, boundsTileTL.y).worldX * Maps.tileScale + Maps.tileScale + (Handler.chunk.getChunkX() * Maps.tileScale * 16));
		//isSwimming = false;
		//System.out.println(bounds.x + bounds.width  + Camera.playerSpeed + " " + (Handler.chunk.getTille(boundsTileTR.x * Maps.tileScale, boundsTileTR.y * Maps.tileScale).x * Maps.tileScale + Maps.tileScale));
		boolean foundColL = false;
		
		{
			if(Handler.chunk.getTile(boundsTileTL.x - 1, boundsTileTL.y).tileOnGround.isSolid())
			{
				if(bounds.x - Camera.playerSpeed < Handler.chunk.getTile(boundsTileTL.x - 1, boundsTileTL.y).worldX * Maps.tileScale + Maps.tileScale)
				{
					leftLock = true;
					foundColL = true;
				}
				else if(!foundColL)
				{
					leftLock = false;
				}
			}
			else if(!foundColL)
			{
				leftLock = false;
			}
			if(Handler.chunk.getTile(boundsTileBL.x, boundsTileBL.y - 1).tileOnGround.isSolid())
			{
				if(bounds.x - Camera.playerSpeed < Handler.chunk.getTile(boundsTileBL.x, boundsTileBL.y - 1).worldX * Maps.tileScale + Maps.tileScale)
				{
					leftLock = true;
					foundColL = true;
				}
				else if(!foundColL)
				{
					leftLock = false;
				}
			}
			else if(!foundColL)
			{
				leftLock = false;
			}
		}
		
		boolean foundColU = false;
		{
			if(Handler.chunk.getTile(boundsTileTL.x, boundsTileTL.y - 1).tileOnGround.isSolid())
			{
				if(bounds.y - Camera.playerSpeed < Handler.chunk.getTile(boundsTileTL.x, boundsTileTL.y - 1).worldY * Maps.tileScale + Maps.tileScale)
				{
					foundColU = true;
					upLock = true;
				}
				else if(!foundColU)
				{
					upLock = false;
				}
			}
			else if(!foundColU)
			{
				upLock = false;
			}
			if(Handler.chunk.getTile(boundsTileTR.x - 1, boundsTileTL.y - 1).tileOnGround.isSolid())
			{
				if(bounds.y - Camera.playerSpeed < Handler.chunk.getTile(boundsTileTR.x - 1, boundsTileTL.y - 1).worldY * Maps.tileScale + Maps.tileScale)
				{
					foundColU = true;
					upLock = true;
				}
				else if(!foundColU)
				{
					upLock = false;
				}
			}
			else if(!foundColU)
			{
				upLock = false;
			}
		}
		boolean foundColD = false;
		{
			if(Handler.chunk.getTile(boundsTileBR.x - 1, boundsTileBR.y).tileOnGround.isSolid())
			{
				if(bounds.y + bounds.height + Camera.playerSpeed > Handler.chunk.getTile(boundsTileBR.x - 1, boundsTileBR.y).worldY * Maps.tileScale)
				{
					foundColD = true;
					downLock = true;
				}
				else if (!foundColD)
				{
					downLock = false;
				}
			}
			else if(!foundColD)
			{
				downLock = false;
			}

			if(Handler.chunk.getTile(boundsTileBL.x + 1, boundsTileBL.y).tileOnGround.isSolid())
			{
				if(bounds.y + bounds.height + Camera.playerSpeed > Handler.chunk.getTile(boundsTileBL.x + 1, boundsTileBL.y).worldY * Maps.tileScale)
				{
					foundColD = true;
					downLock = true;
				}
				else if (!foundColD)
				{
					downLock = false;
				}
			}
			else if(!foundColD)
			{
				downLock = false;
			}
		}
		boolean foundColR = false;
		{
			if(Handler.chunk.getTile(boundsTileTR.x, boundsTileTR.y).tileOnGround.isSolid())
			{
				if(bounds.x + bounds.width + Camera.playerSpeed > Handler.chunk.getTile(boundsTileTR.x, boundsTileTR.y).worldX * Maps.tileScale)
				{
					rightLock = true;
					foundColR = true;
					
				}
				else if(!foundColR)
				{
					rightLock = false;
				}
			}
			else if(!foundColR)
			{
				rightLock = false;
			}
			if(Handler.chunk.getTile(boundsTileBR.x, boundsTileBR.y - 1).tileOnGround.isSolid())
			{
				
				if(bounds.x + bounds.width + Camera.playerSpeed > Handler.chunk.getTile(boundsTileBR.x, boundsTileBR.y - 1).worldX * Maps.tileScale)
				{
					rightLock = true;
					foundColR = true;
				}
				else if(!foundColR)
				{
					rightLock = false;
				}
			}
			else if(!foundColR)
			{
				rightLock = false;
			}
		}
	}
	
}
