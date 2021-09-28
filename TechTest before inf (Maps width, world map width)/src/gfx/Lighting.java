package gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.util.ArrayList;

import engine.Game;
import engine.Handler;
public class Lighting
{

	public void tick()
	{
		
	}
	//int lights = 2;
	int lightCount = 2;
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = env.getDefaultScreenDevice();
    GraphicsConfiguration config = device.getDefaultConfiguration();
	public static ArrayList<BasicLight> lights = new ArrayList<BasicLight>();
	public BufferedImage light = new BufferedImage(Handler.width, Handler.height, BufferedImage.TYPE_INT_ARGB); //GraphicsConfiguration.createCompatibleImage(Handler.width, Handler.height, 1);
   // Graphics2D g = (Graphics2D)light.getGraphics();
    float lol = 1f;
	public void render(Graphics2D g)
	{
		
		Paint old = g.getPaint();
		Composite oldComp = g.getComposite();
		
        //g.dispose();
		lol-= 0.0001f;
		if(lol < 0)
		{
			lol = 0;
		}
		for(int i = 0; i < 200; i++)
		{
			//BufferedImage e = new BufferedImage(Handler.width, Handler.height, BufferedImage.TYPE_INT_ARGB);
		}
		for(int i = 0; i < 200; i++)
		{
			//g.drawImage(lite, 50 + i, 50, 2000, 2000, null);
		}
		//g.setPaint(old);
		//g.drawImage(lite, 0, 0, 1000, 1000, null);
		//makeLightMap(g);
		//  g.setComposite(oldComp);
		//makeLightMap(light);
		//drawLights();
		//g.drawImage(light, 0, 0, null);
		//BufferedImageLag();
		//g.drawImage(bufferedimage, 0, 0, null);
		
		//g.drawImage(mainImage, 0, 0,null);
		
		for(int i = 0; i < 500; i++)
		{
			//g.drawImage(Sources.DIRT, 0 + i, 0 + i, 100, 100, null);
		}
		renderLight(g, null);
	}
	private final VolatileImageHandle mainImage = 
	        new VolatileImageHandle(Game.frame, Handler.width, Handler.height, true, this::drawImages);

	    private final BufferedImage tileImage = Sources.DIRT;
	    private boolean drawDirect = false;
	    

	    public void setDrawDirect(boolean drawDirect)
	    {
	        this.drawDirect = drawDirect;
	    }

	    public void renderLight(Graphics2D g, BasicLight light)
	    {
	        mainImage.draw(g, 0, 0, light);
	    }

	    private void drawImages(Graphics2D g)
	    {
	        for (int i = 0; i < 500; i++)
	        {
	            g.drawImage(tileImage, 0 + i, 0 + i, null);
	        }
	    }

	 public void drawLight(Graphics2D g, Point pt, int radius, LightVolatile lightImage)
	    {
	        
	        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN));
	       // Point2D center = new Point2D.Float(pt.x, pt.y);
	       // float[] dist = {0.0f, 1.0f};
	       // Color[] colors = {new Color(255,255,255,255), new Color(0,0,0,0) };
	        //RadialGradientPaint p =
	         //   new RadialGradientPaint(
	        //        center, radius, dist, colors, CycleMethod.NO_CYCLE);
	        g.setPaint(Color.RED);
	        g.setColor(Color.RED);
	        lightImage.drawImage(g, pt, radius);
	       // g.drawImage(lightImage, pt.x - radius, pt.y -  radius, null);
	       // g.fillOval(pt.x-(int)radius,pt.y-(int)radius,(int)radius*2,(int)radius*2);
	    }
	public void makeLightMapp() 
	{
		   Graphics2D gl = light.createGraphics();
		   gl.setColor(new Color(0, 0, 0, 255));
		   gl.fillRect(0, 0, Handler.width, Handler.height);
		   Composite oldComp = gl.getComposite();
		   gl.setComposite(AlphaComposite.DstOut);

		   for(int i = 0; i < lights.size(); i++)
			{
			 //  lights.get(i).render(gl);
			}
		 

		   gl.setComposite(oldComp);
		   gl.dispose();
		}
	public void updateLightMap()
	{
		
	}
	BufferedImage lite = new BufferedImage(Handler.width, Handler.height, BufferedImage.TYPE_INT_ARGB);
	public void makeLite()
	{
		
		Graphics2D gl = lite.createGraphics();
		gl.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
		gl.setColor(Color.BLACK);
		gl.fillRect(0, 0, lite.getWidth(), lite.getHeight());
		//lite.setRGB(0, 0, 255000000);
		
		int pix = lite.getRGB(0, 0);
		
		int r = (pix >> 16) & 0xFF;
		int g = (pix >> 8) & 0xFF;
		int b = pix & 0xFF;
		
		System.out.println(r + "DDD");
		gl.setColor(new Color(0,0,0,0));
		gl.fillRect(0, 0, Handler.width,Handler.height);
        Point2D.Double pt = new Point2D.Double(lite.getWidth() / 2, lite.getHeight() / 2);
		int radius = 500;
		gl.setComposite(AlphaComposite.DstOut);
        Point2D center = new Point2D.Double(pt.x, pt.y);
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {new Color(255,0,255,255), new Color(0,255,0,0) };
        RadialGradientPaint p =
            new RadialGradientPaint(
                center, radius, dist, colors, CycleMethod.NO_CYCLE);
        gl.setPaint(p);
       // g.drawImage(lite, (int) pt.x, (int) pt.y, radius * 2, radius * 2, null);
        gl.fillOval((int) (pt.x-(int)radius), (int) (pt.y-(int)radius) ,(int)radius*2,(int)radius*2);
        
        gl.dispose();
	}
}
