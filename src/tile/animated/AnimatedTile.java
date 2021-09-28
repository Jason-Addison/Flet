package tile.animated;

import java.awt.image.BufferedImage;

import tile.groundtiles.GroundTile;

public class AnimatedTile extends GroundTile
{
	public int tick;
	public int tickMax;
	public int frame;
	public int frameMax;
	public AnimatedTile(int id, BufferedImage texture, String name, int tick, int tickMax, int frame, int frameMax)
	{
		super(id, texture, name);
		this.tick = tick;
		this.tickMax = tickMax;
		this.frame = frame;
		this.frameMax = frameMax;
	}
	public void animate()
	{
		
	}
	
	public int getCurrentFrame()
	{
		return frame;
	}
	public void onPlace()
	{
		
	}
}
