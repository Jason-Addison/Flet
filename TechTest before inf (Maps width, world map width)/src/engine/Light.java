package engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import maps.Maps;
import weather.WeatherManager;

public class Light 
{
	private WeatherManager weather = new WeatherManager();
	private Utilities util = new Utilities();
	public ArrayList<LightSource> light = new ArrayList<LightSource>();
	double dayNightColor = 50;
	private Camera cam = new Camera();
	public static BufferedImage worldLight = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
	public static boolean lightCheck = true;
	public void tick()
	{
		
		//if(lightCheck)
		{
			update();
		}
	}
	
	public void render(Graphics2D g)
	{
		
	}
	public void changeLight(int x, int y, int level)
	{
		
		World.shadeOverlay[x][y].shadeLevel = level;
		World.shadeOverlay[x][y].source = true;
		update();
	}
	public void removeLight(int targetX, int targetY)
	{
		/*World.shadeOverlay[targetX][targetY].shadeLevel = 15;
		World.shadeOverlay[targetX][targetY].source = false;
		
		int x = (int) -(cam.getX() / Maps.tileScale) - 10;
		int y = (int) -(cam.getY() / Maps.tileScale) - 6;
		for(int col = y; col < y + (Handler.height / Maps.tileScale) + 7; col++)
		{
			for(int row = x; row < x + (Handler.width / Maps.tileScale) + 11; row++)
			{
				if(row > 0 && col > 0)
				{
					double source = World.shadeOverlay[row][col].shadeLevel;
					boolean location = false;
					if(World.shadeOverlay[row - 1][col].shadeLevel > source)
					{
						location = true;
					}
					if(World.shadeOverlay[row + 1][col].shadeLevel > source)
					{
						location = true;
					}
					if(World.shadeOverlay[row][col - 1].shadeLevel > source)
					{
						location = true;
					}
					if(World.shadeOverlay[row][col + 1].shadeLevel > source)
					{
						location = true;
					}
					if(location && !World.shadeOverlay[row][col].source)
					{
						World.shadeOverlay[row][col].shadeLevel = 15;
					}
				}
			}
		}*/
	}
	public void update()
	{
		int x = 0;
		int y = 0;
		int oldX = x;
		int oldY = y;
		x = (int) -(cam.getX() / Maps.tileScale) - 10;
		y = (int) -(cam.getY() / Maps.tileScale) - 6;
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
				//World.shadeOverlay[10][10].shadeLevel = 0;
				if(row > 0 && col > 0)
				{
					boolean noLight = false;
					double source = World.shadeOverlay[row][col].shadeLevel;
					if(source < 14 )
					{
						if(World.shadeOverlay[row - 1][col].shadeLevel > source)
						{
							World.shadeOverlay[row - 1][col].shadeLevel = source + 2;
						}
						if(World.shadeOverlay[row + 1][col].shadeLevel > source)
						{
							World.shadeOverlay[row + 1][col].shadeLevel = source + 2;
						}
						if(World.shadeOverlay[row][col - 1].shadeLevel > source)
						{
							World.shadeOverlay[row][col - 1].shadeLevel = source + 2;
						}
						if(World.shadeOverlay[row][col + 1].shadeLevel > source)
						{
							World.shadeOverlay[row][col + 1].shadeLevel = source + 2;
						}
						
					}
					//else
					{
						if((World.shadeOverlay[row][col - 1].shadeLevel < source) && (World.shadeOverlay[row][col + 1].shadeLevel < source) 
								&& (World.shadeOverlay[row - 1][col].shadeLevel < source) && (World.shadeOverlay[row + 1][col].shadeLevel < source))
						{
							noLight = true;
						}
						if(noLight)
						{
							//World.shadeOverlay[row][col].shadeLevel = 15;
						}
					}
				}
			}
		}
	
	}
}
