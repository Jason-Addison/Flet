package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import engine.Camera;
import engine.Handler;
import engine.World;
import entities.creatures.Chicken;
import entities.creatures.Pig;
import entities.nature.Pinetree;
import gfx.Sources;
import managers.Attack;
import maps.Maps;
import tile.groundtiles.Dirt;

public class EntityManager
{
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	private Camera cam = new Camera();
	boolean needPlayer = true;
	private EntityCollision collision = new EntityCollision();
	ArrayList<Entity> onScreen = new ArrayList<Entity>();
	private Comparator<Entity> compare = new Comparator<Entity>()
	{
	@Override
		public int compare(Entity a, Entity b)
		{
			if(a.pos.y + a.pos.height + a.yRenderOffset() < b.pos.y + b.pos.height + b.yRenderOffset())
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	};
	boolean d = true;
	public void loadTile(int x, int y)
	{
		Handler.world.map[x][y].LOADED = true;
	}
	public void unloadTile(int x, int y)
	{
		Handler.world.map[x][y].LOADED = false;
	}
	public void tick()
	{
		int tileX;
		int tileY;
		if(d)
		{
			double x = Handler.util.randomNumber(5000, 4000);
			double y = Handler.util.randomNumber(5000, 4000);
			d=false;
			Handler.util.addEntity(new Chicken(), x, y);
		}
		//System.out.println(onScreen.size());
		for(int i = 0; i < onScreen.size(); i++)
		{
			
			if(onScreen.get(i).tileCollision())
			{
				Handler.entityCol.collisionCheck(i);
				
			}
			onScreen.get(i).roam();
			tileX = (int) (onScreen.get(i).pos.x / Maps.tileScale);
			tileY = (int) (onScreen.get(i).pos.y / Maps.tileScale);
			int xT = (int) (onScreen.get(i).pos.x / Maps.tileScale) + 10;
			int yT = (int) (onScreen.get(i).pos.y / Maps.tileScale) + 10;
			
			if(xT < World.x || xT > World.x + (Handler.width / Maps.tileScale) + 33 || yT < World.y || yT > World.y + (Handler.width / Maps.tileScale) + 33 && !onScreen.get(i).permLoad())
			{
				if(xT > 0 && yT > 0 && xT < Maps.mapWidth && yT < Maps.mapHeight)
				{
					Handler.world.map[xT][yT].entities.add(onScreen.get(i));
					onScreen.remove(i);
				}
			}
		}
		
		entities.sort(compare);
		onScreen.sort(compare);
		for(int col = World.y - 10; col < World.y + (Handler.height / Maps.tileScale) + 30; col++)
		{
			for(int row = World.x - 10; row < World.x + (Handler.width / Maps.tileScale) + 33; row++)
			{
				int xP;
				int yP;
				if(row > 0 && row < Maps.mapWidth && col > 0 && col < Maps.mapHeight)
				{
					for(int i = 0; i < Handler.world.map[row][col].entities.size(); i++)
					{
						onScreen.add(Handler.world.map[row][col].entities.get(i));
						Handler.world.map[row][col].entities.remove(i);
					}
				}
				for(int i = 0; i < onScreen.size(); i++)
				{
					
				}
				/*if(!Handler.world.map[row][col].LOADED)
				{
					for(int i = 0; i < Handler.world.map[row][col].entities.size(); i++)
					{
						if(!Handler.world.map[row][col].entities.get(i).permLoad())
						{
							for(int ind = 0; ind < Handler.world.map[row][col].entities.size(); ind++)
							{
								double x = Handler.world.map[row][col].entities.get(ind).pos.x;
								double y = Handler.world.map[row][col].entities.get(ind).pos.y;
								//if(!load)
								{
									if(x > Player.playerPosMem.x - Player.player.x - 300 || x < Player.playerPosMem.x - Player.player.x + Handler.width + 300 || 
											y > Player.playerPosMem.y - Player.player.y - 300 || y < Player.playerPosMem.y - Player.player.y + Handler.height + 300)
									{
										onScreen.add(Handler.world.map[row][col].entities.get(ind));
										Handler.world.map[row][col].LOADED = true;
									}
								}
							}
						}
					}
					
				}
				/*else if(Handler.world.map[row][col].LOADED)
				{
					for(int i = 0; i < onScreen.size(); i++)
					{
						double x = onScreen.get(i).pos.x;
						double y = onScreen.get(i).pos.y;
						
						
						if(!onScreen.get(i).permLoad())
						{
							boolean load = false;
							if(x < Player.playerPosMem.x - Player.player.x - 300 || x > Player.playerPosMem.x - Player.player.x + Handler.width + 300 || 
									y < Player.playerPosMem.y - Player.player.y - 300 || y > Player.playerPosMem.y - Player.player.y + Handler.height + 300)
							{
								xP = (int) (x / Maps.tileScale);
								yP = (int) (y / Maps.tileScale);
								
								
								Handler.world.map[xP][yP].entities.add(onScreen.get(i));
								Handler.world.map[xP][yP].LOADED = false;
								Handler.world.map[xP][yP].tile = new Dirt();
								onScreen.remove(i);
								load = true;
							} 
						}
					}
					
				}*/
				
			}
		}
		
		if(needPlayer)
		{
			needPlayer = false;
			//entities.add(new Player(Sources.playerRight[0], new Rectangle2D.Double((handle.screenWidth() / 2), (int) handle.screenHeight() / 2, Player.playerWidth, Player.playerHeight), new Rectangle2D.Double((handle.screenWidth() / 2),
				//(int) handle.screenHeight() / 2, Player.playerWidth, Player.playerHeight), 1, true));
		}
		if(entities.size() < 2)
		{
			//entities.add(new Chicken(new Rectangle2D.Double(500, 500, 80, 80), new Rectangle2D.Double(500, 500, 80, 80), 1, false, false, false, false, 0, 0));
		}
		for(int i = 0; i < entities.size(); i++)
		{
			if(entities.get(i).hasHealth())
			{
				if(entities.get(i).health <= 0)
				{
					
				}
			}
			if(entities.size() < 2)
			{
				//entities.add(new Pig(new Rectangle2D.Double(100, 100, 50, 50), new Rectangle2D.Double(100, 100, 50, 50), 10));
				
			}
			if(entities.get(i) instanceof Pig)
			{
				Pig pig = null;

				Entity q = (entities.get(i)); 

				pig = ((Pig)q);
				pig.roam();
				collision.collisionCheck(i);
			}
			if(entities.get(i) instanceof Chicken)
			{
				Chicken chicken = null;

				Entity q = (entities.get(i)); 

				chicken = ((Chicken)q);
				chicken.roam();
				chicken.animate();
				collision.collisionCheck(i);
			}
			if(entities.get(i) instanceof TallGrass)
			{
				TallGrass tallgrass = null;

				Entity q = (entities.get(i)); 

				tallgrass = ((TallGrass)q);
				//System.out.println(Player.boundsTileBL.x + " " + Player.boundsTileBL.y + " | " + b.x + " " + b.y);
				if(Player.inMotion)
				{
					if(Player.boundsTileBL.x == tallgrass.x || Player.boundsTileBR.x == tallgrass.x)
					{
						if(Player.boundsTileBL.y - 1 == tallgrass.y || Player.boundsTileBR.y - 1 == tallgrass.y)
						{
							tallgrass.collided = true;
							tallgrass.maxFrame = 0;
							tallgrass.tick = 0;
							tallgrass.frame = 0;
						}
					}
				}
				if(tallgrass.maxFrame > 4)
				{
					tallgrass.collided = false;
					tallgrass.right = false;
					tallgrass.left = false;
				}
				if(tallgrass.collided)
				{
					if(tallgrass.frame < 3)
					{
						tallgrass.tick++;
						if(tallgrass.tick > 5)
						{
							tallgrass.tick = 0;
							if(tallgrass.right)
							{
								tallgrass.right = false;
								tallgrass.left = true;
							}
							else
							{
								tallgrass.right = true;
								tallgrass.left = false;
							}
							tallgrass.frame++;
						}
					}
					
					
					if(tallgrass.right)
					{
						tallgrass.pos.x+= 1.5;
					}
					if(tallgrass.left)
					{
						tallgrass.pos.x-= 1.5;
					}
				}
				if(tallgrass.frame >= 3)
				{
					tallgrass.collided = false;
					tallgrass.frame = 0;
					tallgrass.tick = 0;
					tallgrass.right = false;
					tallgrass.left = false;
					tallgrass.maxFrame++;
					tallgrass.pos.x = tallgrass.origin.x;
					tallgrass.pos.y = tallgrass.origin.y;
				}
			}
		}
	}
	private Attack attack = new Attack(); 
	public void render(Graphics2D g)
	{
		for(int i = 0; i < entities.size(); i++)
		{
			//g.fillRect((int) entities.get(i).bounds.x + (int) cam.getX(), (int) entities.get(i).bounds.y + (int) cam.getY(),(int)  entities.get(i).bounds.width,(int)  entities.get(i).bounds.height);
			if(entities.get(i).hasShadow())
			{
				//g.drawImage(Sources.shadow, (int) entities.get(i).pos.x + (int) cam.getX(), (int) entities.get(i).pos.y + (int) cam.getY() + 267, 140, 140, null);
			}
			
			else
			{
				if(entities.get(i) instanceof Pinetree)
				{
					Pinetree pine = null;

					Entity ent = (entities.get(i)); 

					pine = ((Pinetree)ent);
					if(!pine.lock)
					{
						if(Player.player.x < pine.pos.x + cam.getX() + pine.pos.width / 2 && !pine.fallenRight)
						{
							//fall = 1;
							//pine.fallenLeft = true;
							//pine.fallTree(true);
							pine.left = true;
						}
						else
						{
							pine.left = false;
						}
						pine.lock = true;
					}
					if(pine.health <= 0)
					{
						pine.fallTree();
					}
					AffineTransform backup = g.getTransform();
					AffineTransform trans = new AffineTransform();
					trans.rotate((pine.angleMem), (int) entities.get(i).pos.x + (int) cam.getX() + 90, (int) entities.get(i).pos.y + (int) cam.getY() + 310); 
					g.transform( trans );
					
					g.drawImage(entities.get(i).texture, (int) entities.get(i).pos.x + (int) cam.getX(), (int) entities.get(i).pos.y + (int) cam.getY(), (int) entities.get(i).pos.width, (int) entities.get(i).pos.height, null);
					g.setTransform( backup );
					
				}
				else
				{
					g.drawImage(entities.get(i).texture, (int) entities.get(i).pos.x + (int) cam.getX(), (int) entities.get(i).pos.y + (int) cam.getY(), (int) entities.get(i).pos.width, (int) entities.get(i).pos.height, null);
					g.setColor(Color.RED);
				}
				//g.fillRect((int) entities.get(i).collision.x + (int) cam.getX(), (int) entities.get(i).collision.y + (int) cam.getY(), 550, 50);
			}//g.fillRect((int) entities.get(i).collision.x + (int) cam.getX(), (int) entities.get(i).collision.y + (int) cam.getY(), 500, 1);
		}
		//g.drawImage(Sources.tiles[25].texture, 500, 500, 500, 500, null);
		for(int i = 0; i < onScreen.size(); i++)
		{
			if(onScreen.get(i).isPlayer())
			{
				onScreen.get(i).render(g);
			}
			if(onScreen.get(i).renderOverride())
			{
				onScreen.get(i).render(g);
			}
			g.drawImage(onScreen.get(i).texture, (int) onScreen.get(i).pos.x + (int) cam.getX() + onScreen.get(i).xOffset(), (int) onScreen.get(i).pos.y + (int) cam.getY()  + onScreen.get(i).yOffset(), (int) onScreen.get(i).pos.width, (int) onScreen.get(i).pos.height, null);
			g.setColor(Color.RED);
			//g.fillRect((int) onScreen.get(i).pos.x + (int) cam.getX(), (int) onScreen.get(i).pos.y + (int) cam.getY(), 70, 30);
			Handler.entityCol.render(g);
		}
	}
	
	public int randomX()
	{
		Random x = new Random();
		int rx = x.nextInt(Maps.mapWidth);
		return rx;
	}
	
	public int randomY()
	{
		Random y = new Random();
		int ry = y.nextInt(Maps.mapHeight);
		return ry;
	}
	public ArrayList<Entity> getOnScreenEntities()
	{
		return onScreen;
	}
}
