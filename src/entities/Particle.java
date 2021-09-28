package entities;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Particle extends Entity 
{

	public int spread;
	public Color color;
	public Color colorFade;
	public BufferedImage texture;
	public Rectangle2D.Double pos;
	public Rectangle2D.Double bounds;
	public int life;
	public int lifeSpan;
	public int x;
	public int y;
	public Particle(int x, int y, int life, int lifeSpan, int spread, Color color, Color colorFade, BufferedImage texture, Rectangle2D.Double pos, Rectangle2D.Double bounds)
	{
		super(texture, 100);
		this.spread = spread;
		this.color = color;
		this.colorFade = colorFade;
		this.life = life;
		this.lifeSpan = lifeSpan;
		this.x = x;
		this.y = y;
	}
	public void emit(int index)
	{
		life++;
		
		int x = util.randomNumber(200, 0);
		double xOffset = (x - 100.0) / 1000.0 * spread;
		double yOffset = util.randomNumber(100, 0) / 1000.0 * spread;
		System.out.println(xOffset);
		EntityManager.entities.get(index).pos.x += xOffset;
		EntityManager.entities.get(index).pos.y -= yOffset;
		//if(color.getAlpha() < 0)
		{
			//EntityManager.entities.remove(index);
		}
	}
}
