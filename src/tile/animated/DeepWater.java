package tile.animated;



import engine.Camera;
import engine.Handler;
import gfx.Sources;
import maps.Maps;
import tile.groundtiles.Sand;

public class DeepWater extends AnimatedTile
{
	private Camera cam = new Camera();
	public static int animation = 2;
	public DeepWater()
	{
		super(10, Sources.OCEAN[0], "Water", 0, 30, 0, 3);
	}
	public void update()
	{
		animate();
	}
	public void onPlace()
	{
		if(Handler.chunk.getTile(x - 1, y).tile instanceof Sand)
		{
			Handler.chunk.setTile(new DeepWater(), x - 1, y);
		}
		if(Handler.chunk.getTile(x + 1, y).tile instanceof Sand)
		{
			Handler.chunk.setTile(new DeepWater(), x + 1, y);
		}
		if(Handler.chunk.getTile(x, y - 1).tile instanceof Sand)
		{
			Handler.chunk.setTile(new DeepWater(), x, y - 1);
		}
		if(Handler.chunk.getTile(x, y + 1).tile instanceof Sand)
		{
			Handler.chunk.setTile(new DeepWater(), x, y + 1);
		}
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
		texture = Sources.OCEAN[frame];
	}
	
}
