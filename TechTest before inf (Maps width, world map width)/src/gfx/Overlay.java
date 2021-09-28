package gfx;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import engine.Game;
import engine.Handler;
import entities.Player;
import entities.ThePlayer;
import input.KeyManager;
import input.Typing;
import items.Inventory;
import maps.Maps;
import weather.WeatherManager;

public class Overlay 
{

	private Text text = new Text();
	int health = 1000;
	double red = 0;
	double green = 255;
	private DayNight time = new DayNight();
	boolean gui = false;
	private Typing typing = new Typing();
	int tick = 0;
	boolean underscore;
	public void decreaseHealth(int amount)
	{
		if(red < 255)
		{
			red += amount * 0.25;
		}
		if(green > 0)
		{
			green -= amount * 0.25;	
		}
		if(health > 0)
		{
			health -= amount;
		}
		tick++;
		if(tick > 31)
		{
			if(underscore)
			{
				underscore = false;
			}
			else
			{
				underscore = true;
			}
			tick = 0;
		}
	}
	int tic = 0;
	public void tick()
	{
		decreaseHealth(1);
		tic++;
		if(tic > 30)
		{
			tic = 0;
			if(ThePlayer.PLAYER_HUNGER > 0)
			{
				ThePlayer.PLAYER_HUNGER--;
			}
		}
	}
	int angle = 0;
	//Inventory inv = new Inventory("Probably the best container ever xd", 10, 5);
	public void render(Graphics2D g)
	{
		//inv.set();
		//inv.focus();
		//inv.render(g);
		if(WeatherManager.raining)
		{
			g.setColor(new Color(0, 0, 120, 80));
			g.fillRect(0, 0, (int) Handler.width, (int) Handler.height);
		}
		//g.drawImage(Sources.healthbar, 10, 80, 60, 282, null);
		//g.drawImage(Sources.energybar, 80, 80, 60, 282, null);
		//g.setColor(new Color((int) red, (int) green, 0, 255));
	//	g.fillRect(22, 92 + (int) (red / 1.3) + 1, 36, health * 192 / 1000);
		
		if(KeyManager.minimap)
		{
			g.setColor(new Color(50, 50, 50, 255));
			g.fillRect((int)Handler.width - 310, (int) Handler.height - 310, 310, 310);
			for(int col = 0; col < Maps.mapHeight; col++)
			{
				for(int row = 0; row < Maps.mapWidth; row++)
				{
					//g.drawImage(Sources.tiles[World.map[row][col].id].texture, row * Maps.minimapScale + ((int) Handler.width - 300), col * Maps.minimapScale + (int) Handler.height - 300, Maps.minimapScale, Maps.minimapScale, null);
				}
			}
		}
		g.setFont(Text.time);
		if(gui)
		{
			g.setColor(new Color(50, 50, 50, 55));
			g.fillRect(0, 0, (int) Handler.width, 70);
			g.setFont(Text.time);
			g.setColor(Color.WHITE);
			if(time.getHours() < 13)
			{
				g.drawString("AM", (int) Handler.width - 110, 60);
				g.drawString(time.getHours() + "", (int) Handler.width - 320, 60);
			}
			else
			{
				g.drawString("PM", (int) Handler.width - 110, 60);
				g.drawString(time.getHours() - 12 + "",(int) Handler.width - 320, 60);
			}
			g.drawString(time.getMinutes() + "", (int) Handler.width - 200, 60);
			g.drawString(":", (int) Handler.width - 230, 55);
			g.drawString(time.getDays() + "", 10, 60);
			g.drawString(" of " + time.getMonthName(time.getMonths()), 85, 60);
		}
		if(KeyManager.debug)
		{
			g.setFont(Text.debug);
			g.setColor(new Color(0, 0, 0, 50));
			g.fillRect((int) Handler.width - 300, 0, 300, 800);
			FontMetrics fontMetrics = g.getFontMetrics();
			g.setColor(Color.WHITE);
			String title = "World Position";
			g.drawString(title, (int) Handler.width - 400 + (fontMetrics.stringWidth(title) / 2), 50);
			g.drawString("x : " + Player.playerPosMem.x, (int) Handler.width - 280, 100);
			g.drawString("y : " + Player.playerPosMem.y, (int) Handler.width - 280, 150);
			g.drawString("On Screen Pos", (int) Handler.width - 280, 200);
			g.drawString("x : " + Player.player.x, (int) Handler.width - 280, 250);
			g.drawString("y : " + Player.player.y, (int) Handler.width - 280, 300);
			g.drawString("FPS : " + Game.FPS, (int) Handler.width - 280, 350);
			g.drawString("Entities : " + Handler.entity.getOnScreenEntities().size(), (int) Handler.width - 280, 400);
		}
		if(Typing.inChat)
		{
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRect(0, (int) Handler.height - 50, (int) Handler.width, 50);
			g.setColor(Color.WHITE);
			g.setFont(Text.chat);
			if(underscore)
			{
				g.drawString("> " + typing.getChat() + "_", 10, (int) Handler.height - 10);
			}
			else
			{
				g.drawString("> " + typing.getChat(), 10, (int) Handler.height - 10);
			}
		}
		g.setColor(new Color(50, 50, 50, 255));
		g.fillRect(0, 0, (int) Handler.width / 2, 50);
		g.setColor(new Color(0, 150, 0, 255));
		g.fillRect(0, 0, 20, 50);
		g.setColor(new Color(0, 0, 0, 40));
		g.fillRect(0, 45, (int) Handler.width / 2, 5);
		g.setColor(Color.WHITE);
		g.setFont(Text.editorTitle);
		g.drawString("Health : ", 50, 40);
		if(ThePlayer.PLAYER_HEALTH < 25)
		{
			g.setColor(Color.RED);
		}
		else if(ThePlayer.PLAYER_HEALTH < 50)
		{
			g.setColor(Color.ORANGE);
		}
		else if(ThePlayer.PLAYER_HEALTH < 75)
		{
			g.setColor(Color.YELLOW);
		}
		else
		{
			g.setColor(Color.GREEN);
		}
		
		g.drawString(ThePlayer.PLAYER_HEALTH + "", 200, 40);
		g.setColor(Color.WHITE);
		g.drawString("Hunger : ", 300, 40);
		if(ThePlayer.PLAYER_HUNGER < 25)
		{
			g.setColor(Color.RED);
		}
		else if(ThePlayer.PLAYER_HUNGER < 50)
		{
			g.setColor(Color.ORANGE);
		}
		else if(ThePlayer.PLAYER_HUNGER < 75)
		{
			g.setColor(Color.YELLOW);
		}
		else
		{
			g.setColor(Color.GREEN);
		}
		g.drawString("" + ThePlayer.PLAYER_HUNGER, 470, 40);
	}
}
