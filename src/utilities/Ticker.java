package utilities;

public class Ticker 
{

	int ticks;
	int tickLimit;
	boolean tickIsActive;
	public Ticker(int ticks)
	{
		this.tickLimit = ticks;
	}
	public void tick()
	{
		tickIsActive = false;
		ticks++;
		if(ticks >= tickLimit)
		{
			tickIsActive = true;
			ticks = 0;
		}
	}
	public boolean isActive()
	{
		return tickIsActive;
	}
	public int getTick()
	{
		return ticks;
	}
	public int getTickLimit()
	{
		return tickLimit;
	}
}
