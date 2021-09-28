package gfx;


public class AnimatedWater 
{

	int tick = 0;
	int tickLim = 20;
	int currentFrame = 0;
	int frameLim = 3;
	public void tick()
	{
		
		tick++;
		if(tick > tickLim)
		{
			tick = 0;
			currentFrame++;
			if(currentFrame >= frameLim)
			{
				currentFrame = 0;
			}
			
		}
		if(currentFrame == 0)
		{
			//Sources.tiles[10].texture = Sources.water1;
		}
		if(currentFrame == 1)
		{
			//Sources.tiles[10].texture = Sources.water2;
		}
		if(currentFrame == 2)
		{
			//Sources.tiles[10].texture = Sources.water3;
		}
	}
	
}
