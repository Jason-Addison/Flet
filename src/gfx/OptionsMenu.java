package gfx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import engine.Handler;
import states.State;

public class OptionsMenu 
{

	public static boolean FULLSCREEN = true;
	JPanel panel = new JPanel();
	public void tick()
	{
		System.out.println(FULLSCREEN);
	}
	public void addLayout()
	{
		panel.setLayout(null);
		panel.setOpaque(false);
		JButton fullscreen = new JButton();
		fullscreen.setBounds(200, 100, 100, 100);
		fullscreen.setOpaque(false);
		fullscreen.addActionListener(new ActionListener() 
		  {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	if(FULLSCREEN)
		    	{
		    		FULLSCREEN = false;
		    	}
		    	else
		    	{
		    		FULLSCREEN = true;
		    	}
		    }
		  });
		panel.add(fullscreen);
		Game.frame.add(panel);
	}
	
	public void removeLayout()
	{
		Game.frame.remove(panel);
	}
	public void render(Graphics2D g)
	{
		tick();
		g.setColor(new Color(255, 255, 255, 130));
		g.fillRect(0, 0, (int) Handler.width, (int) Handler.height);
		for(int i = 0; i < 5; i++)
		{
			for(int ind = 0; ind < 2; ind++)
			{
				if(ind == 1)
				{
					if(FULLSCREEN)
					{
						g.setColor(Color.GREEN);
					}
					else
					{
						g.setColor(Color.RED);
					}
					g.fillRect(50 + (ind * 150), 100 + (i * 150), 100, 100);
				}
				g.drawImage(Sources.GUI_BOX, 50 + (ind * 150), 100 + (i * 150), 100, 100, null);
				
			}
		}
		g.drawImage(Sources.GUI_FULLSCREEN, 55, 95, 90, 90, null);
	}
	
}
