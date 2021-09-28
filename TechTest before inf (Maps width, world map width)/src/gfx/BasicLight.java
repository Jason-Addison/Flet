package gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import engine.Game;
import engine.Handler;
import input.MouseManager;

public class BasicLight 
{

	//public BufferedImage lightImage;
	public int x;
	public int y;
	public int radius;
	public LightVolatile mainImage; 
	public BasicLight(int x, int y, int radius, float luminosity) 
	{
		this.radius = radius;
	    this.x = x;
	    this.y = y;
	    mainImage = 
		        new LightVolatile(Game.frame, radius * 2, radius * 2, true, this::drawImages, radius);
	    //lightImage = new BufferedImage(radius * 2, radius * 2, BufferedImage.TYPE_INT_ARGB);
	   // renderLight((Graphics2D) Game.frame.getGraphics(), new BasicLight(radius, radius, radius, luminosity));
        renderLight();
	}
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	boolean switchV = true;
	public void render(Graphics2D g)
	{
		//if(switchV)
		{
			
			//renderLight(g, this);
			//switchV = false;
		}
		//Handler.lighting.renderLight(g, this);
	}
	

	    private final BufferedImage tileImage = Sources.DIRT;
	    private boolean drawDirect = false;
	    

	    public void setDrawDirect(boolean drawDirect)
	    {
	        this.drawDirect = drawDirect;
	    }

	    public void renderLight()
	    {
	        mainImage.draw(0, 0);
	    }

	    private void drawImages(Graphics2D g)
	    {
	    	/*	g.setColor(Color.BLACK);
	    		g.fillRect(0, 0, Handler.width, Handler.height);
	    		g.setColor(new Color(0,0,0,0));
	    		g.fillRect(0, 0, Handler.width,Handler.height);
	            Point2D.Double pt = new Point2D.Double(MouseManager.x, MouseManager.y);
	    		//int radius = 500;
	    		g.setComposite(AlphaComposite.DstOut);
	            Point2D center = new Point2D.Double(pt.x, pt.y);
	            float[] dist = {0.0f, 1.0f};
	            Color[] colors = {new Color(255,0,0,255), new Color(0,255,0,0) };
	            RadialGradientPaint p =
	                new RadialGradientPaint(
	                    center, 100, dist, colors, CycleMethod.NO_CYCLE);
	            
	            g.setPaint(p);
	           // g.drawImage(image, (int) pt.x, (int) pt.y, radius * 2, radius * 2, null);
	            
	            g.fillOval((int) (pt.x-(int)100), (int) (pt.y-(int)100) ,(int)100*2,(int)100*2);
	            
	            g.dispose();*/
	    }
}
