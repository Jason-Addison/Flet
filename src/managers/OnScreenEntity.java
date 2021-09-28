package managers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;

import engine.Handler;
import engine.World;
import entities.Entity;
import entities.Player;
import maps.Maps;

public class OnScreenEntity
{

	ArrayList<Entity> onScreen = new ArrayList<Entity>();
	
	private Comparator<Entity> compare = new Comparator<Entity>()
	{
	@Override
		public int compare(Entity a, Entity b)
		{
			if(a.pos.y + a.pos.height < b.pos.y + b.pos.height)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	};
	//	onScreen.sort(compare);
	public void tick()
	{
		if(onScreen.size() < 2)
		{
			//onScreen.add(new Entity(Sources.DIRT, new Rectangle2D.Double(Player.playerPosMem.x, Player.playerPosMem.y, 50, 50), new Rectangle2D.Double(Player.playerPosMem.x, Player.playerPosMem.y, 50, 50), 0));
			//Handler.world.map[Player.swimPos.x][Player.swimPos.y].entities.add(new Entity(Sources.DIRT, new Rectangle2D.Double(Player.playerPosMem.x,
				//	Player.playerPosMem.y, 50, 50), new Rectangle2D.Double(Player.playerPosMem.x, Player.playerPosMem.y, 50, 50), 0));
		}
	
		for(int i = 0; i < onScreen.size(); i++)
		{
			int x = World.x;
			int y = World.y;
			for(int col = y; col < y + (Handler.height / Maps.tileScale) + 7; col++)
			{
				for(int row = x; row < x + (Handler.width / Maps.tileScale) + 11; row++)
				{
					for(int ind = 0; ind < Handler.world.map[row][col].entities.size(); ind++)
					{
						if(Handler.world.map[row][col].entities.get(ind) != onScreen.get(i))
						{
							//onScreen.add(Handler.world.map[row][col].entities.get(ind));
							//System.out.println(onScreen.size());
						}
					}
				}
			}
			if(onScreen.get(i).pos.x < Player.playerPosMem.x - 1000)
			{
				onScreen.remove(i);
			}
			else if(onScreen.get(i).pos.y < Player.playerPosMem.y - 1000)
			{
				onScreen.remove(i);
			}
			else if(onScreen.get(i).pos.x > Player.playerPosMem.x + 1000)
			{
				onScreen.remove(i);
			}
			else if(onScreen.get(i).pos.y > Player.playerPosMem.y + 1000)
			{
				onScreen.remove(i);
			}
		}
		int x = World.x;
		int y = World.y;
		
	}
	
	public void render(Graphics2D g)
	{
		for(int i = 0; i < onScreen.size(); i++)
		{
			g.drawImage(onScreen.get(i).texture, (int) (onScreen.get(i).pos.x + Handler.cam.getX()), (int) (onScreen.get(i).pos.y + Handler.cam.getY()), (int) onScreen.get(i).pos.width, (int) onScreen.get(i).pos.height, null);
		}
	}
	
}
