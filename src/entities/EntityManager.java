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
import managers.Attack;
import maps.Maps;

public class EntityManager
{
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	private Camera cam = new Camera();
	boolean needPlayer = true;
	private EntityCollision collision = new EntityCollision();
	public static ArrayList<Entity> onScreen = new ArrayList<Entity>();
	private Comparator<Entity> compare = new Comparator<Entity>()
	{
	@Override
		public int compare(Entity a, Entity b)
		{
		//System.out.println(a.pos.y + a.pos.height + a.yRenderOffset()  + "  " + (b.pos.y + b.pos.height + b.yRenderOffset()));
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
		
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				for(int x = 0; x < 16; x++)
				{
					for(int y = 0; y < 16; y++)
					{
						for(int i = 0; i < Handler.chunk.loadedChunks[row][col].chunkMap[x][y].entities.size(); i++)
						{
							onScreen.add(Handler.chunk.loadedChunks[row][col].chunkMap[x][y].entities.get(i));
						}
					}
				}
				Handler.chunk.loadedChunks[row][col].clearEntities();
			}
		}
		int tileX;
		int tileY;
		if(d)
		{
			double x = Handler.util.randomNumber(5000, 4000);
			double y = Handler.util.randomNumber(5000, 4000);
			d=false;
			//Handler.util.addEntity(new Chicken(), x, y);
		}
		//System.out.println(onScreen.size());
		for(int i = 0; i < onScreen.size(); i++)
		{
			if(!(onScreen.get(i) instanceof ThePlayer))
			{
				//System.out.println(onScreen.get(i).pos.x);
			}
			if(onScreen.get(i).tileCollision())
			{
				//Handler.entityCol.collisionCheck(i);
				
			}
			//onScreen.get(i).roam();
			tileX = (int) (onScreen.get(i).pos.x / Maps.tileScale);
			tileY = (int) (onScreen.get(i).pos.y / Maps.tileScale);
			int xT = (int) (onScreen.get(i).pos.x / Maps.tileScale) + 10;
			int yT = (int) (onScreen.get(i).pos.y / Maps.tileScale) + 10;
			
			if(xT < World.x || xT > World.x + (Handler.width / Maps.tileScale) + 33 || yT < World.y || yT > World.y + (Handler.width / Maps.tileScale) + 33 && !onScreen.get(i).permLoad())
			{
				if(xT > 0 && yT > 0 && xT < Maps.mapWidth && yT < Maps.mapHeight)
				{
					//Handler.world.map[xT][yT].entities.add(onScreen.get(i));
					//onScreen.remove(i);
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
						//onScreen.add(Handler.world.map[row][col].entities.get(i));
						//Handler.world.map[row][col].entities.remove(i);
					}
				}
				
			}
		}
		
		
	}
	private Attack attack = new Attack(); 
	public void render(Graphics2D g)
	{
		for(int i = 0; i < onScreen.size(); i++)
		{
			if(!(onScreen.get(i) instanceof ThePlayer))
			{
				onScreen.get(i).render(g);
			}
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
