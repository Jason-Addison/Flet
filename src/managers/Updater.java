package managers;

public class Updater implements Runnable
{
	Thread runner;
	public static double time = 0.0;
	public static boolean running = true;
	  public Updater()
	  {
	    this.runner = new Thread(this);
	    this.runner.start();
	  }
	  
	@Override
	public void run()
	{
		
		while(running)
		{
			time += 1;
			try 
			{
				Thread.sleep(1);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
