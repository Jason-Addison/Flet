package managers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import engine.Handler;
import gfx.Sources;
import gfx.Text;
import savegame.Save;

public class WorldSelectionManager implements MouseWheelListener
{

	ArrayList<Save> saves = new ArrayList<Save>();
	double scrollVelocity;
	double scroll = 100;
	int scrollBar = 0;
	public void tick()
	{
		saves = Handler.unloader.getSaves();
		if(scrollVelocity > 0)
		{
			scrollVelocity -= 1;
		}
		else if(scrollVelocity < 0)
		{
			scrollVelocity += 1;
		}
		scroll += scrollVelocity;
		if(scroll > 100)
		{
			scroll = 100;
			scrollVelocity = 0;
		}
		if(scroll < -(saves.size() * 200) + Handler.height)
		{
			scroll = -(saves.size() * 200) + Handler.height;
			scrollVelocity = 0;//-(scrollVelocity / 2);
		}
	}
	public void render(Graphics2D g)
	{
		renderBackground(g);
		g.setFont(Text.setFont(20));
		g.setColor(Color.WHITE);
		for(int i = 0; i < saves.size(); i++)
		{
			int indexScroll = -(i * 200);
			if(indexScroll < scroll && indexScroll > scroll - Handler.height - 200)
			{
				Save save = saves.get(i);
				g.setFont(Text.setFont(30));
				g.drawString(save.getName(), 80, i * 200 + (int) scroll);
			}
		}
		scrollBar = (int) -(scroll / (saves.size() / 7));
		g.fillRect(60, scrollBar, 10, 80);
	}
	
	public void renderBackground(Graphics2D g)
	{
		int scale = 150;
		for(int row = 0; row < 15; row++)
		{
			for(int col = 0; col < 15; col++)
			{
				g.drawImage(Sources.DUST_STONE, row * scale, col * scale, scale, scale, null);
			}
		}
		//int i = 16;
		g.setColor(new Color(0, 0, 0, 100));
		g.fillRect(50, 0, Handler.width / 3, Handler.height);
		//g.fillRect(725, 525, 1000, 650);
		double imgscale = 0.6;
		g.drawImage(Sources.WORLD_DEMO_TEMP_DELETE, 725, 400, (int) (Sources.WORLD_DEMO_TEMP_DELETE.getWidth() * imgscale), (int) (Sources.WORLD_DEMO_TEMP_DELETE.getHeight() * imgscale), null);
	}
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		scrollVelocity -= e.getWheelRotation() * 5;
	}
	
}
