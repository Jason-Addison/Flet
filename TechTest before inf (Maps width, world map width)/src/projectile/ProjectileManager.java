package projectile;

import java.awt.Graphics;

public class ProjectileManager 
{

	double x = 900;
	double y = 500;
static double angle = 1;
	public void tick()
	{//
		//double vy = (1 * Math.sin(angle)) + angle ;
		// Horizontal : Speed * Cosine * Angle
		//double vx = (1 * Math.cos(angle)) + angle;
		//x+= vx;
		//y+= vy;
		//angle+= 0.01;
	}
	public void render(Graphics g)
	{
		//g.fillOval((int) x, (int) y, 20, 20);
	}
	
}
