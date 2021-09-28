package gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.image.VolatileImage;
import java.util.function.Consumer;

import engine.Handler;
import entities.Entity;
import entities.LightEntity;
import input.MouseManager;
import tile.BasicTile;
import tile.ongroundtiles.OnGroundTile;

public class VolatileImageHandle 
{
    private VolatileImage image;
    private final Component component;
    private final int width;
    private final int height;
    private final boolean transparent;
    private Consumer<? super Graphics2D> painter;

    VolatileImageHandle(Component component, 
        int width, int height, boolean transparent,
        Consumer<? super Graphics2D> painter)
    {
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

    private void updateImage(BasicLight light)
    {
        do
        {
            validateImage();
            Graphics2D g = image.createGraphics();
            g.setColor(new Color(0, 0, 0, 255));
            //g.setColor(Color.RED);
            //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            g.fillRect(0, 0, Handler.width, Handler.height);
            for(int i = 0; i < Handler.entity.getOnScreenEntities().size(); i ++)
            {
            	if(Handler.entity.getOnScreenEntities().get(i) instanceof LightEntity)
            	{
            		LightEntity lightE = null;

    				Entity basic = Handler.entity.getOnScreenEntities().get(i); 
    				
    				lightE = (LightEntity)basic;
            		//Point pt = new Point(Lighting.lights.get(i).x, Lighting.lights.get(i).y);
                	Point pt = new Point((int) lightE.pos.x + (int) Handler.cam.getX(), (int) lightE.pos.y + (int) Handler.cam.getY());
                	//g.setColor(Color.RED);
                	Handler.lighting.drawLight(g, pt, lightE.light.radius, lightE.light.mainImage);
                	//image.getGraphics().drawImage(Sources.DIRT, 0+i, 0+i, null);
            	}
            }
            painter.accept(g);
           
            g.dispose();
        } while (image.contentsLost());
    }
    
    float lol = 0f;
    public void draw(Graphics2D g, int x, int y, BasicLight light)
    {
        do
        {
            validateImage();
            updateImage(light);
            Composite oldComp = g.getComposite();
            lol += 0.001;
            if(lol > 1)
            {
            	lol = 1;
            }
            //g.setPaint(Color.RED);
           // g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.95f)); // the amount of color we want from the light map to be composited into the scene 
            g.drawImage(image,0,0, null);
           
            //g.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_ATOP, 1f));
            //g.drawImage(image,0,0, null);
            g.setComposite(oldComp);
           // g.drawImage(image, x, y, null);
        } while (image.contentsLost());
    }
}