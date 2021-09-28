package managers;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import engine.Handler;
import entities.Player;
import gfx.Footprint;
import gfx.Sources;
import tile.Air;
import tile.groundtiles.Sand;

public class FootprintManager
{

	public ArrayList<Footprint> footprints = new ArrayList<Footprint>();
	int tick = 0;
	public void tick()
	{
		for(int col = Player.swimPos.y; col < Player.swimPos.y + 1; col++)
		{
			for(int row = Player.swimPos.x; row < Player.swimPos.x + 1; row++)
			{
				if(Handler.world.getTile(row, col) instanceof Sand && Handler.world.getTileOnGround(row, col) instanceof Air)
				{
					tick++;
					if(tick > 7 && Player.inMotion)
					{
						tick = 0;
						int xOffset = Handler.util.randomNumber(20, 0);
						int yOffset = Handler.util.randomNumber(20, 0);
						footprints.add(new Footprint(new Rectangle2D.Double(Player.playerPosMem.x - (xOffset - (xOffset / 2)) + 25, Player.playerPosMem.y - (yOffset - (yOffset / 2)) + 76, 20, 20), 0, 350, 1));
					}
				}
			}
			
		}
		for(int i = 0; i < footprints.size(); i++)
		{
			footprints.get(i).tick++;
			if(footprints.get(i).tick > footprints.get(i).tickMax)
			{
				footprints.remove(i);
			}
		}
	}
	
	public void render(Graphics2D g)
	{
		for(int i = 0; i < footprints.size(); i++)
		{
			if(footprints.get(i).opacity - 0.003 > 0)
			{
				footprints.get(i).opacity -= 0.003;
			}
			Composite old = g.getComposite();
			//System.out.println(opacity);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, footprints.get(i).opacity));
			g.drawImage(Sources.EFFECT_FOOTPRINT, (int) (footprints.get(i).pos.x + (int) Handler.cam.getX()), (int) (footprints.get(i).pos.y + (int) Handler.cam.getY()), 
					(int) footprints.get(i).pos.width, (int) footprints.get(i).pos.height, null);
			g.setComposite(old);
		}
	
	}
	
}
