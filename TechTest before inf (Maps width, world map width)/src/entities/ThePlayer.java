package entities;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import engine.Handler;
import entities.creatures.BasicCreature;
import gfx.Sources;
import input.MouseManager;

public class ThePlayer extends BasicCreature
{
	public int health;
	public BufferedImage texture;
	public Rectangle2D.Double collision;
	
	public static int PLAYER_HEALTH = 100;
	public static int PLAYER_HUNGER = 100;
	public ThePlayer()
	{
		super(null, new Rectangle2D.Double(0, 0, 40, 40), new Rectangle2D.Double(0, 0, 40, 40), 100);
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
}
