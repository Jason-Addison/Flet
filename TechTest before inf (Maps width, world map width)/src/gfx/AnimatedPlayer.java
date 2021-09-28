package gfx;

import engine.Camera;
import engine.Utilities;
import input.KeyManager;

public class AnimatedPlayer 
{

	static int currentFrame = 0;
	int tick = 0;
	int tickMax = 100;
	int frameMax = 3;
	boolean up = true;
	boolean down = false;
	int ani = 0;
	boolean on = true;
	//Head
	int blinkTick = 0;
	int blinkTickMax = 5;
	boolean blink = true;
	boolean blinkUp = false;
	static int blinkFrame = 0;
	private Utilities util = new Utilities();
	public void tick()
	{
		tickMax = (int) (Camera.playerSpeed);
		if(KeyManager.shift)
		{
			tickMax = (int) (Camera.playerSpeed * 3);
		}
		tick++;
		if(tick > tickMax)
		{
			tick = 0;
			if(up)
			{
				ani++;
				if(ani > 2)
				{
					up = false;
					ani--;
				}
			}
			if(!up)
			{
				ani--;
				if(ani < -2)
				{
					up = true;
					ani++;
				}
				if(ani == -3)
				{
					ani = -1;
				}
			}

			if(ani == -2)
			{
				currentFrame = 4;
			}
			else if(ani == -1)
			{
				currentFrame = 3;
			}
			else if(ani == 0)
			{
				currentFrame = 0;
			}
			else if(ani == 1)
			{
				currentFrame = 1;
			}
				
			else if(ani == 2)
			{
				currentFrame = 2;
			}
		}
		if(!blink)
		{
			if(util.randomNumber(200, 0) == 1)
			{
				blink = true;
				blinkUp = true;
			}
		}
		if(blink)
		{
			blinkTick++;
			if(blinkTick >= blinkTickMax)
			{
				if(blinkUp)
				{
					blinkTick = 0;
					blinkFrame++;
					if(blinkFrame > 2)
					{
						blinkUp = false;
					}
				}
				if(!blinkUp)
				{
					blinkTick = 0;
					blinkFrame--;
					if(blinkFrame < 0)
					{
						blinkFrame = 0;
						blinkUp = true;
						blink = false;
					}
				}
			}
		}
	}
	
	public int getCurrentFrame()
	{
		return currentFrame;
	}
	
	public void setCurrentFrame(int frame, int animation)
	{
		currentFrame = frame;
		ani = animation;
	}
	
	public int getBlinkFrame()
	{
		return blinkFrame;
	}
}
