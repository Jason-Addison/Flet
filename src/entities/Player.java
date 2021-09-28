package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import chunk.Bounds;
import engine.Camera;
import engine.Handler;
import gfx.AnimatedPlayer;
import gfx.Sources;
import input.KeyManager;
import input.MouseManager;
import managers.Attack;
import maps.Maps;
import tile.Air;
import tile.animated.DeepWater;

public class Player
{
	static double playerWidth = 15 * (Maps.tileScale / 16.66666666666667);
	static double playerHeight = 20 * (Maps.tileScale / 16.66666666666667);
	static double headHeight = 12 * (Maps.tileScale / 16.66666666666667);
	static double headWidth = 15 * (Maps.tileScale / 16.66666666666667);
	private static Handler handle = new Handler();
	Point startingPos = new Point();
	//private Handler.world Handler.world = new Handler.world();
	public static Rectangle2D.Double player = new Rectangle2D.Double((handle.screenWidth() / 2), (int) handle.screenHeight() / 2, playerWidth, playerHeight);
	public static Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, 50, 30);
	private Attack attack = new Attack();
	private Camera cam = new Camera();
	public static Rectangle2D.Double playerPosMem = new Rectangle2D.Double(0, 0, 100, 100);
	ArrayList<Entity> e = new ArrayList<Entity>();
	private AnimatedPlayer animate = new AnimatedPlayer();
	public static int playerTileX = 0;
	public static int playerTileY = 0;
	public static Bounds boundsTileTR = new Bounds();
	public static Bounds boundsTileBR = new Bounds();
	public static Bounds boundsTileTL = new Bounds();
	public static Bounds boundsTileBL = new Bounds();

	public static Point swimPos = new Point(0, 0);
	public static boolean isSwimming = false;
	boolean isplayer;
	public static int dir = 3;
	
	public static boolean inMotion;
	
	public static boolean upLock, downLock, leftLock, rightLock;
	
	public static Point playerTile = new Point();
	public void tick()
	{
		
		if(KeyManager.up || KeyManager.down || KeyManager.left || KeyManager.right)
		{
			inMotion = true;
		}
		else
		{
			inMotion = false;
		}
		playerPosMem.x = player.x + -cam.getX();
		playerPosMem.y = player.y + -cam.getY();
		
		bounds.x = playerPosMem.x + 10;
		bounds.y = playerPosMem.y + 70;
		
		playerTile.x = (int) ((bounds.x) / Maps.tileScale); 
		playerTile.y = (int) ((bounds.y) / Maps.tileScale);
		if(bounds.x < 0)
		{
			playerTile.x --;
		}
		if(bounds.y < 0)
		{
			playerTile.y --;
		}
		
		for(int i = 0; i < Handler.entity.getOnScreenEntities().size(); i++)
		{
			if(Handler.entity.getOnScreenEntities().get(i).isPlayer())
			{
			//	EntityManager.entities.get(i).collision.x = bounds.x;
			//	EntityManager.entities.get(i).collision.y = bounds.y;
			//	EntityManager.entities.get(i).collision.width = bounds.width;
			//	EntityManager.entities.get(i).collision.height = bounds.height;
				Handler.entity.getOnScreenEntities().get(i).pos.x = bounds.x;
				Handler.entity.getOnScreenEntities().get(i).pos.y = bounds.y;
				Handler.entity.getOnScreenEntities().get(i).pos.width = bounds.width;
				Handler.entity.getOnScreenEntities().get(i).pos.height = bounds.height;
				
			}
				
		}
		
		//System.out.println(playerPosMem.x + " " + playerPosMem.y);
		playerTileY  = (int) (bounds.y / Maps.tileScale) + 1;
		playerTileX  = (int) (bounds.x / Maps.tileScale) + 1;
		swimPos.x = (int) ((bounds.x + 30) / Maps.tileScale);
		swimPos.y = (int) ((bounds.y + 10) / Maps.tileScale);
		
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
		Handler.flatCol.tick();
		//System.out.println(Handler.chunk.getTile(boundsTileTL.x - 1, boundsTileTL.y).worldX * Maps.tileScale + Maps.tileScale + (Handler.chunk.getChunkX() * Maps.tileScale * 16));
		isSwimming = false;
		//System.out.println(bounds.x + bounds.width  + Camera.playerSpeed + " " + (Handler.chunk.getTille(boundsTileTR.x * Maps.tileScale, boundsTileTR.y * Maps.tileScale).x * Maps.tileScale + Maps.tileScale));
		boolean foundColL = false;
		
		{
			if(Handler.chunk.getTile(boundsTileTL.x - 1, boundsTileTL.y).tile.isSolid())
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
			if(Handler.chunk.getTile(boundsTileBL.x, boundsTileBL.y - 1).tile.isSolid())
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
			if(Handler.chunk.getTile(boundsTileTL.x, boundsTileTL.y - 1).tile.isSolid())
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
			if(Handler.chunk.getTile(boundsTileTR.x - 1, boundsTileTL.y - 1).tile.isSolid())
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
			if(Handler.chunk.getTile(boundsTileBR.x - 1, boundsTileBR.y).tile.isSolid())
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

			if(Handler.chunk.getTile(boundsTileBL.x + 1, boundsTileBL.y).tile.isSolid())
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
			if(Handler.chunk.getTile(boundsTileTR.x, boundsTileTR.y).tile.isSolid())
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
			if(Handler.chunk.getTile(boundsTileBR.x, boundsTileBR.y - 1).tile.isSolid())
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
		isSwimming = false;
		if(bounds.x < 0)
		{
			swimPos.x --;
		}
		if(bounds.y < 0)
		{
			swimPos.y --;
		}
		if(Handler.chunk.getTile(swimPos.x, swimPos.y).tile instanceof DeepWater && Handler.chunk.getTile(swimPos.x, swimPos.y).tileOnGround instanceof Air)
		{
			isSwimming = true;
		}
		for(int col = swimPos.y; col < swimPos.y + 1; col++)
		{
			for(int row = swimPos.x; row < swimPos.x + 1; row++)
			{
				//if(Handler.chunk.getTille(row * Maps.tileScale, col * Maps.tileScale).tile instanceof DeepWater && Handler.chunk.getTille(row * Maps.tileScale, col * Maps.tileScale).tileOnGround instanceof Air)
				{
				//	isSwimming = true;
				}
			}
			
		}
		if(isSwimming)
		{
			Camera.playerSpeed = 0.7;
		}
		else
		{
			Camera.playerSpeed = 1;
		}
	}
	public void render(Graphics2D g)
	{
		//g.drawImage(Sources.tiles[Maps.tiles[playerTileX][playerTileY]], 600, 100, 100, 100, null);
		//if(!isSwimming)
		{
			g.drawImage(Sources.shadow, (int) player.x, (int) player.y + 67, (int) (70 * 1.1), (int) (40 * 1.1), null);
		}
		//if(!MouseManager.itemInUse)
		{
			if(KeyManager.right)
			{
				if(KeyManager.right && ! KeyManager.left)
				{
					if(!isSwimming)
					{
						g.drawImage(Sources.playerRight[animate.getCurrentFrame()], (int) player.x, (int) player.y, (int) player.width, (int) player.height, null);
						g.drawImage(Sources.playerRightHead[animate.getBlinkFrame()], (int) player.x - 6, (int) player.y - 57, (int) headWidth, (int) headHeight, null);
						dir = 3;
					}
					else
					{
						g.drawImage(Sources.playerRightHead[animate.getBlinkFrame()], (int) player.x - 6, (int) player.y + 45, (int) headWidth, (int) headHeight, null);
						dir = 3;
					}
				}
			}
			if(KeyManager.left)
			{
				if(KeyManager.left && !KeyManager.right && !isSwimming)
				{
					g.drawImage(Sources.playerLeft[animate.getCurrentFrame()], (int) player.x, (int) player.y, (int) player.width, (int) player.height, null);
					g.drawImage(Sources.playerLeftHead[animate.getBlinkFrame()], (int) player.x - 0, (int) player.y - 57, (int) headWidth, (int) headHeight, null);
					dir = 4;
				}
				else if(isSwimming)
				{
					{
						g.drawImage(Sources.playerLeftHead[animate.getBlinkFrame()], (int) player.x - 0, (int) player.y + 45, (int) headWidth, (int) headHeight, null);
						dir = 4;
					}
				}
			}
			
			if(KeyManager.down && !KeyManager.right && !KeyManager.left)
			{
				g.drawImage(Sources.playerDown[animate.getCurrentFrame()], (int) player.x, (int) player.y - 55, (int) player.width, (int) player.height + 50, null);
				dir = 2;
			}
			if(KeyManager.down && KeyManager.right && KeyManager.left)
			{
			g.drawImage(Sources.playerDown[animate.getCurrentFrame()], (int) player.x, (int) player.y - 55, (int) player.width, (int) player.height + 50, null);
			dir = 2;
			}
			if(KeyManager.up && ! KeyManager.left && !KeyManager.right)
			{
				g.drawImage(Sources.playerDown[0], (int) player.x, (int) player.y - 55, (int) player.width, (int) player.height + 50, null);
				dir = 1;
			}
		}
		
		//STATIC
		
		if(!KeyManager.up && !KeyManager.down && !KeyManager.left && !KeyManager.right || MouseManager.itemInUse)
		{
			if(dir == 1)
			{
				g.drawImage(Sources.playerDown[0], (int) player.x, (int) player.y - 55, (int) player.width, (int) player.height + 50, null);
			}
			if(dir == 2 && !isSwimming)
			{
				animate.setCurrentFrame(0, 0);
				g.drawImage(Sources.playerDown[0], (int) player.x, (int) player.y - 55, (int) player.width, (int) player.height + 50, null);
			}
			if(dir == 3 && !isSwimming && MouseManager.itemInUse)
			{
				animate.setCurrentFrame(0, 0);
				g.drawImage(Sources.playerRightAttack[attack.getAttackFrame()], (int) player.x, (int) player.y, (int) player.width, (int) player.height, null);
				g.drawImage(Sources.playerRightHead[animate.getBlinkFrame()], (int) player.x - 6, (int) player.y - 57, (int) headWidth, (int) headHeight, null);
			}
			else if(dir == 3 && !isSwimming)
			{
				animate.setCurrentFrame(0, 0);
				g.drawImage(Sources.playerRight[0], (int) player.x, (int) player.y, (int) player.width, (int) player.height, null);
				g.drawImage(Sources.playerRightHead[animate.getBlinkFrame()], (int) player.x - 6, (int) player.y - 57, (int) headWidth, (int) headHeight, null);
			}
			else if (dir == 3)
			{
				g.drawImage(Sources.playerRightHead[animate.getBlinkFrame()], (int) player.x - 6, (int) player.y + 45, (int) headWidth, (int) headHeight, null);
			}
			if(dir == 4 && !isSwimming)
			{
				animate.setCurrentFrame(0, 0);
				g.drawImage(Sources.playerLeft[0], (int) player.x, (int) player.y, (int) player.width, (int) player.height, null);
				g.drawImage(Sources.playerLeftHead[animate.getBlinkFrame()], (int) player.x - 0, (int) player.y - 57, (int) headWidth, (int) headHeight, null);
			}
			else if(dir == 4)
			{
				g.drawImage(Sources.playerLeftHead[animate.getBlinkFrame()], (int) player.x - 0, (int) player.y + 45, (int) headWidth, (int) headHeight, null);
			}
		}
		if(KeyManager.left && KeyManager.right && !isSwimming)
		{
			if(dir == 3)
			{
				animate.setCurrentFrame(0, 0);
				g.drawImage(Sources.playerRight[0], (int) player.x, (int) player.y, (int) player.width, (int) player.height, null);
				g.drawImage(Sources.playerRightHead[animate.getBlinkFrame()], (int) player.x - 6, (int) player.y - 57, (int) headWidth, (int) headHeight, null);
			}
			if(dir == 4)
			{
				animate.setCurrentFrame(0, 0);
				g.drawImage(Sources.playerLeft[0], (int) player.x, (int) player.y, (int) player.width, (int) player.height, null);
				g.drawImage(Sources.playerLeftHead[animate.getBlinkFrame()], (int) player.x - 0, (int) player.y - 57, (int) headWidth, (int) headHeight, null);
			}
		}
		//for(int col = boundsTileTL.y; col < boundsTileTL.y; col++)
		{
			//for(int row = boundsTileTL.x; row < boundsTileTL.x + 1; row++)
			{
				g.setColor(new Color(255, 0, 0, 150));
				//g.fillRect(boundsTileTR.x * Maps.tileScale + (int) cam.getX(), boundsTileTR.y * Maps.tileScale + (int) cam.getY(), 80, 80);
				//g.fillRect(boundsTileBR.x * Maps.tileScale + (int) cam.getX(), boundsTileBR.y * Maps.tileScale + (int) cam.getY(), 80, 80);
				//g.fillRect(boundsTileTL.x * Maps.tileScale + (int) cam.getX(), boundsTileTL.y * Maps.tileScale + (int) cam.getY(), 80, 80);
				//g.fillRect(boundsTileBL.x * Maps.tileScale + (int) cam.getX(), boundsTileBL.y * Maps.tileScale + (int) cam.getY(), 80, 80);
				//for(int col = boundsTileBR.y - 1; col < boundsTileBR.y; col++)
				{
					//for(int row = boundsTileBR.x; row < boundsTileBR.x + 1; row++)
					{
						//g.fillRect(row * Maps.tileScale + (int) cam.getX(), col * Maps.tileScale + (int) cam.getY(), Maps.tileScale, Maps.tileScale);
					}
				}
			}
		}
		g.setColor(Color.RED);
		//g.fillRect((int) bounds.x + (int) Handler.cam.getX(), (int) bounds.y + (int) Handler.cam.getY(), (int) bounds.width, (int) bounds.height);
		//g.fillRect(((int) ((bounds.x + bounds.width) / Maps.tileScale) + 1) * Maps.tileScale + (int) cam.getX(), (int) (bounds.y + bounds.height) + (int) cam.getY(), 50, 50);
		//g.fillRect((int)EntityManager.entities.get(0).collision.x, 100, 500, 500);
		//System.out.println("ASDDS");
		//g.fillRect((int) bounds.x + (int) cam.getX(), (int) bounds.y + (int) cam.getY(), (int) bounds.width, (int) bounds.height);
	}
	
	public boolean isSwimming()
	{
		return isSwimming;
	}	
	public double getBoundsX()
	{
		return bounds.x;
	}
	public int getDirection()
	{
		return dir;
	}
}
