package managers;

import java.awt.Point;
import java.awt.geom.Rectangle2D;

import engine.Camera;
import engine.World;
import entities.Player;
import maps.Maps;

public class Collision 
{
	public Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 70, 30);
	private World world = new World();
	public static Point boundsTileTR = new Point(0, 0);
	public static Point boundsTileBR = new Point(0, 0);
	public static Point boundsTileTL = new Point(0, 0);
	public static Point boundsTileBL = new Point(0, 0);
	public static boolean upLock, downLock, leftLock, rightLock;
	public void tick()
	{
		
		bounds.x = Player.bounds.x;
		bounds.y = Player.bounds.y;
		boundsTileTR.x = (int) ((bounds.x + bounds.width) / Maps.tileScale) + 1;
		boundsTileTR.y = (int) ((bounds.y) / Maps.tileScale);
		if(boundsTileTR.x < 1)
		{
			boundsTileTR.x = 1;
		}
		if(boundsTileTR.y < 1)
		{
			boundsTileTR.y = 1;
		}
		
		boundsTileBR.x = (int) ((bounds.x + bounds.width) / Maps.tileScale) + 1;
		boundsTileBR.y = (int) ((bounds.y + bounds.height) / Maps.tileScale) + 1;
		
		boundsTileTL.x = (int) ((bounds.x) / Maps.tileScale);
		boundsTileTL.y = (int) ((bounds.y) / Maps.tileScale);
		if(boundsTileTL.x < 1)
		{
			boundsTileTL.x = 1;
		}
		if(boundsTileTL.y < 1)
		{
			boundsTileTL.y = 1;
		}
		boundsTileBL.x = (int) ((bounds.x) / Maps.tileScale);
		boundsTileBL.y = (int) ((bounds.y + bounds.height) / Maps.tileScale);
		if(boundsTileBL.x < 1)
		{
			boundsTileBL.x = 1;
		}
		if(boundsTileBL.y < 1)
		{
			boundsTileBL.y = 1;
		}
		/////////THIS IS FOR COLLIDIING WITH LEFT UP TILES
		
		boolean foundColL = false;
		//if(KeyManager.left)
		{
			for(int col = boundsTileTL.y; col < boundsTileTL.y + 1; col++)
			{
				for(int row = boundsTileTL.x - 1; row < boundsTileTL.x; row++)
				{
					if(world.getTile(row, col).isSolid())
					{
						if(bounds.x - Camera.playerSpeed < World.mapOverlay[row][col].x * Maps.tileScale + Maps.tileScale)
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
			}
			for(int col = boundsTileBL.y; col < boundsTileBL.y + 1; col++)
			{
				for(int row = boundsTileBL.x - 1; row < boundsTileBL.x; row++)
				{
					if(world.getTile(row, col).isSolid())
					{
						if(bounds.x - Camera.playerSpeed < World.mapOverlay[row][col].x * Maps.tileScale + Maps.tileScale)
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
			}
		}
		
		boolean foundColU = false;
		//if(KeyManager.up)
		{
			for(int col = boundsTileTL.y - 1; col < boundsTileTL.y; col++)
			{
				for(int row = boundsTileTL.x; row < boundsTileTL.x + 1; row++)
				{
					if(world.getTile(row, col).isSolid())
					{
						if(bounds.y - Camera.playerSpeed < World.mapOverlay[row][col].y * Maps.tileScale + Maps.tileScale)
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
			}
			for(int col = boundsTileTR.y - 1; col < boundsTileTR.y; col++)
			{
				for(int row = boundsTileTR.x - 1; row < boundsTileTR.x; row++)
				{
					if(world.getTile(row, col).isSolid())
					{
						if(bounds.y - Camera.playerSpeed < World.mapOverlay[row][col].y * Maps.tileScale + Maps.tileScale)
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
			}
		}
		boolean foundColD = false;
		//if(KeyManager.down)
		{
			for(int col = boundsTileBR.y; col < boundsTileBR.y + 1; col++)
			{
				for(int row = boundsTileBR.x - 1; row < boundsTileBR.x; row++)
				{
					if(world.getTile(row, col).isSolid())
					{
						if(bounds.y + bounds.height + Camera.playerSpeed > World.mapOverlay[row][col].y * Maps.tileScale)
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
			}

			for(int col = boundsTileBL.y + 1; col < boundsTileBL.y +2; col++)
			{
				for(int row = boundsTileBL.x; row < boundsTileBL.x + 1; row++)
				{
					if(world.getTile(row, col).isSolid())
					{
						if(bounds.y + bounds.height + Camera.playerSpeed > World.mapOverlay[row][col].y * Maps.tileScale)
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
			}
		}
		boolean foundColR = false;
	//	if(KeyManager.right)
		{
			for(int col = boundsTileTR.y; col < boundsTileTR.y + 1; col++)
			{
				for(int row = boundsTileTR.x; row < boundsTileTR.x + 1; row++)
				{
					if(world.getTile(row, col).isSolid())
					{
						
						if(bounds.x + bounds.width + Camera.playerSpeed > World.mapOverlay[row][col].x * Maps.tileScale)
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
			for(int col = boundsTileBR.y - 1; col < boundsTileBR.y; col++)
			{
				for(int row = boundsTileBR.x; row < boundsTileBR.x + 1; row++)
				{
					if(world.map[row][col].tile.isSolid())
					{
						if(bounds.x + bounds.width + Camera.playerSpeed > World.mapOverlay[row][col].x * Maps.tileScale)
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
	}
	
}
