package tile.animated;

import engine.Camera;
import engine.Handler;
import gfx.Sources;
import maps.Maps;

public class WaterSpread extends AnimatedTile
{
	private Camera cam = new Camera();
	public static int animation = 2;
	public WaterSpread()
	{
		super(10, Sources.OCEAN[0], "Water (Spread)", 0, 30, 0, 3);
	}
	
	public void animate()
	{
		tick++;
		if(tick > tickMax)
		{
			tick = 0;
			frame++;
			animation++;
			if(frame > frameMax)
			{
				frame = 0;
				animation = 0;
			}
		}
		int x = (int) -(cam.getX() / Maps.tileScale) - 10;
		int y = (int) -(cam.getY() / Maps.tileScale) - 6;
		if(x <= 0)
		{
			x = 0;
		}
		if(y <= 0)
		{
			y = 0;
		}
		for(int col = y; col < y + (Handler.height / Maps.tileScale) + 7; col++)
		{
			for(int row = x; row < x + (Handler.width / Maps.tileScale) + 11; row++)
			{
				//if(World.map[row][col].tile instanceof DeepWater)
				{
				//	World.map[row][col].tile.texture = Sources.OCEAN[frame];
				}
			}
		}
	}
	
}
