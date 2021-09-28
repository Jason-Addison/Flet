package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import engine.Handler;
import maps.Maps;

public class EntityCollision 
{
public Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 70, 30);
	
	public static Point boundsTileTR = new Point(0, 0);
	public static Point boundsTileBR = new Point(0, 0);
	public static Point boundsTileTL = new Point(0, 0);
	public static Point boundsTileBL = new Point(0, 0);
	public static boolean upLock, downLock, leftLock, rightLock;
	public void render(Graphics2D g)
	{
		//g.fillRect((int) bounds.x + (int) Handler.cam.getX(), (int) bounds.y + (int) Handler.cam.getY(), (int) bounds.width, (int) bounds.height);
	}
	public void collisionCheck(int index)
	{
		bounds = Handler.entity.getOnScreenEntities().get(index).collision();
		Entity entity = Handler.entity.getOnScreenEntities().get(index);
		boundsTileTR.x = (int) ((bounds.x + bounds.width) / Maps.tileScale) + 1;
		boundsTileTR.y = (int) ((bounds.y) / Maps.tileScale);
		
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
		boolean foundColL = false;
		
		boolean foundRight = false;
		boolean foundLeft = false;
		boolean foundUp = false;
		boolean foundDown = false;
		
		rightLock = false;
		leftLock = false;
		upLock = false;
		downLock = false;
		{
			for(int col = boundsTileTL.y; col < boundsTileTL.y + 1; col++)
			{
				for(int row = boundsTileTL.x - 1; row < boundsTileTL.x; row++)
				{
					//System.out.println(Handler.world.isSolid(row, col));
					if(Handler.world.isSolid(row, col))
					{
						if(bounds.x + entity.getSpeedX() < Handler.world.getMap(row, col).x * Maps.tileScale + Maps.tileScale)
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
					if(Handler.world.isSolid(row, col))
					{
						if(bounds.x + entity.getSpeedX() < Handler.world.getMap(row, col).x * Maps.tileScale + Maps.tileScale)
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
					if(Handler.world.isSolid(row, col))
					{
						if(bounds.y + entity.getSpeedY() < Handler.world.getMap(row, col).y * Maps.tileScale + Maps.tileScale)
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
					if(Handler.world.isSolid(row, col))
					{
						if(bounds.y + entity.getSpeedY() < Handler.world.getMap(row, col).y * Maps.tileScale + Maps.tileScale)
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
					if(Handler.world.isSolid(row, col))
					{
						if(bounds.y + bounds.height + entity.getSpeedY() > Handler.world.getMap(row, col).y * Maps.tileScale)
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
					if(Handler.world.isSolid(row, col))
					{
						if(bounds.y + bounds.height + entity.getSpeedY() > Handler.world.getMap(row, col).y * Maps.tileScale)
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
					if(Handler.world.isSolid(row, col))
					{
						if(bounds.x + bounds.width + entity.getSpeedX() > Handler.world.getMap(row, col).x * Maps.tileScale)
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
					if(Handler.world.isSolid(row, col))
					{
						
						if(bounds.x + bounds.width + entity.getSpeedX() > Handler.world.getMap(row, col).x * Maps.tileScale)
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
		/*for(int row = boundsTileTR.x; row < boundsTileTR.x + 1; row++)
		{
			for(int col = boundsTileTR.y; col < boundsTileTR.y + 1; col++)
			{
				if(Handler.Handler.world.map[row][col].tile.isSolid())
				{
					if(row == boundsTileTR.x + 1 && col == boundsTileTR.y)
					{
						if(!foundRight)
						{
							if(bounds.x + bounds.width + entity.getSpeedX() > row * Maps.tileScale)
							{
								rightLock = true;
								foundRight = true;
							}
							else
							{
								rightLock = false;
							}
						}
						if(!foundUp)
						{
							if(bounds.y - entity.getSpeedY() < col * Maps.tileScale + Maps.tileScale)
							{
								upLock = true;
								foundUp = true;
							}
							else
							{
								upLock = false;
							}
						}
					}
				}
			}
		}
		for(int row = boundsTileBL.x; row < boundsTileBL.x + 1; row++)
		{
			for(int col = boundsTileBL.y; col < boundsTileBL.y + 1; col++)
			{
				if(Handler.Handler.world.map[row][col].tile.isSolid())
				{
					if(row == boundsTileBL.x && col == boundsTileBL.y)
					{
						if(!foundLeft)
						{
							if(bounds.x - entity.getSpeedX() < row * Maps.tileScale + Maps.tileScale)
							{
								leftLock = true;
								foundLeft = true;
							}
							else
							{
								leftLock = false;
							}
						}
						if(!foundDown)
						{
							if(bounds.y + bounds.height + entity.getSpeedY() > col * Maps.tileScale)
							{
								downLock = true;
								foundDown = true;
							}
							else
							{
								downLock = false;
							}
						}
					}
				}
			}
		}
		
		for(int row = boundsTileTL.x; row < boundsTileTL.x + 1; row++)
		{
			for(int col = boundsTileTL.y; col < boundsTileTL.y + 1; col++)
			{
				if(Handler.Handler.world.map[row][col].tile.isSolid())
				{
					if(row == boundsTileTL.x && col == boundsTileTL.y)
					{
						if(!foundLeft)
						{
							if(bounds.x - entity.getSpeedX() < row * Maps.tileScale + Maps.tileScale)
							{
								leftLock = true;
								foundLeft = true;
							}
							else
							{
								leftLock = false;
							}
						}
						if(!foundUp)
						{
							if(bounds.y - entity.getSpeedY() < col * Maps.tileScale + Maps.tileScale)
							{
								upLock = true;
								foundUp = true;
							}
							else
							{
								upLock = false;
							}
						}
					}
				}
			}
		}
		for(int row = boundsTileBR.x; row < boundsTileBR.x + 1; row++)
		{
			for(int col = boundsTileBR.y; col < boundsTileBR.y + 1; col++)
			{
				if(Handler.Handler.world.map[row][col].tile.isSolid())
				{
					if(row == boundsTileBR.x && col == boundsTileBR.y)
					{
						if(!foundRight)
						{
							if(bounds.x + bounds.width + entity.getSpeedX() > row * Maps.tileScale)
							{
								rightLock = true;
								foundRight = true;
							}
							else
							{
								rightLock = false;
							}
						}
						if(!foundDown)
						{
							if(bounds.y + bounds.height + entity.getSpeedY() > col * Maps.tileScale)
							{
								downLock = true;
								foundDown = true;
							}
							else
							{
								downLock = false;
							}
						}
					}
				}
			}
		}*/
		
	}
	
}
