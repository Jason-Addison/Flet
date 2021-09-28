package gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Transparency;
import java.awt.geom.Point2D;
import java.awt.image.VolatileImage;
import java.util.function.Consumer;

import engine.Handler;

public class LightVolatile 
{
    public VolatileImage image;
    private final Component component;
    private final int width;
    private final int height;
    private final boolean transparent;
    private Consumer<? super Graphics2D> painter;
    int radius;
    LightVolatile(Component component, 
        int width, int height, boolean transparent,
        Consumer<? super Graphics2D> painter, int radius)
    {
    	this.radius = radius;
        this.component = component;
        this.width = width;
        this.height = height;
        this.transparent = transparent;
        this.painter = painter;
    }

    private void createImage()
    {
        GraphicsConfiguration graphicsConfiguration = 
            component.getGraphicsConfiguration();
        int transparency = transparent ? 
            Transparency.TRANSLUCENT : Transparency.OPAQUE;
        image = graphicsConfiguration.createCompatibleVolatileImage(
            width, height, transparency);
    }

    private void validateImage()
    {
        if (image == null)
        {
            createImage();
        }
        else
        {
            GraphicsConfiguration graphicsConfiguration = 
                component.getGraphicsConfiguration();
            int validationResult = 
                image.validate(graphicsConfiguration);
            if (validationResult == VolatileImage.IMAGE_INCOMPATIBLE)
            {
                image.flush();
                createImage();
            }
        }
    }

    private void updateImage()
    {
        do
        {
            validateImage();
            Graphics2D gl = image.createGraphics();
    		gl.setColor(Color.BLACK);
    		gl.fillRect(0, 0, image.getWidth(), image.getHeight());
    		gl.setColor(new Color(0,0,0,0));
            Point2D.Double pt = new Point2D.Double(image.getWidth() / 2, image.getHeight() / 2);
    		//int radius = 500;
    		gl.setComposite(AlphaComposite.DstOut);
            Point2D center = new Point2D.Double(pt.x, pt.y);
            float[] dist = {0.0f, 1f};
            Color[] colors = {new Color(255,0,0,255), new Color(0,255,0,0) };
            RadialGradientPaint p =
                new RadialGradientPaint(
                    center, radius, dist, colors, CycleMethod.NO_CYCLE);
            gl.setPaint(p);
           // g.drawImage(image, (int) pt.x, (int) pt.y, radius * 2, radius * 2, null);
            gl.fillOval((int) (pt.x-(int)radius), (int) (pt.y-(int)radius), (int)radius * 2, (int)radius * 2);
            System.out.println(radius + " " + image.getWidth());
            painter.accept(gl);
            gl.dispose();
        } while (image.contentsLost());
    }
    
    float lol = 0f;
    public void draw(int x, int y)
    {
        do
        {
            validateImage();
            updateImage();
           // Composite oldComp = g.getComposite();
            lol += 0.001;
            if(lol > 1)
            {
            	lol = 1;
            }
            //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            //System.out.println("XDDdsadad");
            
           // g.setComposite(oldComp);
           // g.drawImage(image, x, y, null);
        } while (image.contentsLost());
    }
    public void drawImage(Graphics2D g, Point pt, int radius)
    {
    	g.drawImage(image, pt.x-(int)radius,pt.y-(int)radius, null);
    }
}