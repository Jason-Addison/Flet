package entities;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import engine.Handler;
import entities.creatures.BasicCreature;

public class ThePlayer extends BasicCreature
{
	public int health;
	public BufferedImage texture;
	public Rectangle2D.Double collision;
	
	public static int PLAYER_HEALTH = 100;
	public static int PLAYER_HUNGER = 100;
	public static boolean CONTAINER_OPEN = false;
	public static boolean COLLISION = true;
	public ThePlayer()
	{
		super(null, 100);
	}
	public boolean isPlayer()
	{
		return true;		
	}
	public boolean permLoad()
	{
		return true;
	}
	public void render(Graphics2D g)
	{
		Handler.player.render(g);
	}
	public void save()
	{
		/*try 
		{
			Writer writer = new FileWriter(Handler.getWorldPath() + "/xddddd.json");
			
			Gson gson = new GsonBuilder().create();
			JsonObject playerInfo = new JsonObject();
			playerInfo.add("playerX", gson.toJsonTree("DASDDWQDQWD"));
			
			JsonObject newChunk = new JsonParser().parse(gson.toJson(playerInfo)).getAsJsonObject();
			gson.toJson("SADSDDWDF", writer);
			writer.write("DD");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}*/
	}
	public void init()
	{
		
	}
}
