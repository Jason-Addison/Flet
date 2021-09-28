package weather;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import engine.Camera;
import engine.Handler;
import engine.Utilities;
import entities.Player;
import gfx.Rain;
import gfx.Sources;
import gfx.Splash;

public class WeatherManager
{

	public ArrayList<Rain> rain = new ArrayList<Rain>();
	public ArrayList<Splash> splash = new ArrayList<Splash>();
	private Utilities util = new Utilities();
	private Camera cam = new Camera();
	boolean lightning = false;
	int lightningTick = 0;
	int lightningMax = 0;
	public static boolean raining = false;
	public static int overcast = 0;
	public void tick()
	{
		if(raining)
		{
			if(util.randomNumber(2, 0) == 1)
			{
				double x = util.randomNumber(4000, 0) + Player.playerPosMem.x - 800;
				rain.add(new Rain(new Rectangle2D.Double(x, Player.playerPosMem.y - 800, 70, 100), (int) x - 1000, 0, util.randomNumber(100, 000)));
				x = util.randomNumber(4000, 0) + Player.playerPosMem.x - 800;
				rain.add(new Rain(new Rectangle2D.Double(x, Player.playerPosMem.y - 800, 70, 100), (int) x - 1000, 0, util.randomNumber(100, 000)));
			}
			for(int i = 0; i < rain.size(); i++)
			{
				rain.get(i).pos.x -= 10;
				rain.get(i).pos.y += 14;
				rain.get(i).tick++;
				if(rain.get(i).tick >= rain.get(i).tickMax)// || rain.get(i).pos.y > 1000)
				{
					splash.add(new Splash(new Rectangle2D.Double(rain.get(i).pos.x, rain.get(i).pos.y + 100, 50, 50), 0, 10, 0, 2));
					rain.remove(i);
				}
			}
			for(int i = 0; i < splash.size(); i++)
			{
				splash.get(i).tick++;
				if(splash.get(i).tick >= splash.get(i).tickMax)
				{
					splash.get(i).tick = 0;
					splash.get(i).frame++;
					if(splash.get(i).frame >= splash.get(i).frameMax)
					{
						splash.remove(i);
					}
				}
			}
		}
	}
	int lightningColorR = 255;
	int lightningColorG = 255;
	int lightningColorB = 255;
	int lightningColorA = 50;
	static Area darkness = new Area(new Rectangle(0, 0,  (int) Handler.width, (int) Handler.height));
	
	int torchDiameter = 1300;
	boolean launch = true;
	static double darknessX;
	static double darknessY;
	double darknessWidth = torchDiameter;
	double darknessHeight = torchDiameter;
	int torchFade = 20;
	static Area[] gradient = new Area[10];
	public static int test = 1;
	public void render(Graphics2D g)
	{
		g.setColor(new Color(0, 0, 0, overcast));
		g.fillRect(0, 0, (int) Handler.width, (int) Handler.height);
		
		if(launch)
		{
			darknessX = Player.player.x - torchDiameter / 2;
			darknessY = Player.player.y - torchDiameter / 2;
			//System.out.println(darknessX + " " + darknessY + " " + darknessWidth + " " + darknessHeight);
			//darkness.subtract(new Area(new Ellipse2D.Double(darknessX, darknessY, darknessWidth, darknessHeight)));
			
			launch = false;
			for(int i = 0; i < 10; i++)
			{
			}
		}
		if(!launch && !lightning)
		{
			
		}
		if(raining)
		{
			g.setColor(new Color(0, 0, 130, 120));
			for(int i = 0; i < rain.size(); i++)
			{
				g.drawImage(Sources.rain, (int) rain.get(i).pos.x + (int) cam.getX(), (int) rain.get(i).pos.y + (int) cam.getY(), (int) rain.get(i).pos.width, (int) rain.get(i).pos.height, null);
			}
			if(util.randomNumber(500, 0) == 1)
			{
				lightning = true;
				lightningMax = util.randomNumber(200, 50);
			}
			if(lightning)
			{
				lightningTick++;
				if(lightningTick < lightningMax)
				{
					if(lightningColorR >= 5)
					{
						lightningColorR -= 5;
					}
					if(lightningColorG >= 5)
					{
						lightningColorG -= 5;
					}
					if(lightningColorB > 180)
					{
						lightningColorB -= 1;
					}
					if(lightningColorA < 120)
					{
						lightningColorA += 1;
					}
					g.setColor(new Color(255, 255, 255, 50));
				}
				else
				{
					lightningColorR = 255;
					lightningColorG = 255;
					lightningColorB = 255;
					lightningColorA = 50;
					lightningTick = 0;
					lightning = false;
				}
			}
			//g.setColor(new Color(0, 0, lightningColor));
			else
			{
				//((Graphics2D) g).fill(darkness);
			}
			for(int i = 0; i < splash.size(); i++)
			{
				g.drawImage(Sources.splash[splash.get(i).frame], (int) splash.get(i).pos.x + (int) cam.getX(), (int) splash.get(i).pos.y + (int) cam.getY(), (int) splash.get(i).pos.width, (int) splash.get(i).pos.height, null);
			}
			if(!lightning)
			{
				
			}
		}
		
	}
	
	public void setWeather(boolean storm)
	{
		raining = storm;
	}
	public boolean getStorm()
	{
		return raining;
	}
}
