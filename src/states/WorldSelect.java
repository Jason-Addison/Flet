package states;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;

import javax.swing.JTextField;

import engine.Handler;
import gfx.Sources;
import gfx.Text;
import utilities.GameButton;
import utilities.GamePanel;

public class WorldSelect
{

	GamePanel panel = new GamePanel();
	GameButton createWorld;
	int mid = Handler.width / 2;
	int ed = 0;
	public void tick()
	{
		Handler.selectionMng.tick();
	}
	JTextField nameBox = new JTextField();
	Rectangle nameBoxBounds = new Rectangle(725, 125, 450, 75);
	public void init()
	{
		nameBox.setBounds(nameBoxBounds);
		nameBox.setEditable(true);
		nameBox.setOpaque(false);
		createWorld = new GameButton(725, 25, 450, 75, "Create World")
		{
			public void onClick()
			{
				ed++;
				if(nameString.equals(""))
				{
					nameString = "New World";
				}
				File file = new File(Handler.getGamePath() + "/saves/"+nameString);
				nameBox.setText("");
				file.mkdir();
			}
		};
	
		panel.addComponent(createWorld.getButton());
		panel.addComponent(nameBox);
		panel.panel.addMouseWheelListener(Handler.selectionMng);
		panel.panel.addKeyListener(Handler.globalKeys);
		panel.addToFrame();
	}
	double s = 1;
	String nameString;
	public void render(Graphics2D g)
	{
		
		Handler.selectionMng.render(g);
		createWorld.render(g);
		g.setFont(Text.setFont(30));
		
		g.drawImage(Sources.BUTTON_LOCKED, nameBoxBounds.x, nameBoxBounds.y, nameBoxBounds.width, nameBoxBounds.height, null);
		nameString = nameBox.getText();
		if(nameString.length() > 13)
		{
			nameString = nameString.substring(13);
		}
		g.drawString(nameString, nameBoxBounds.x, nameBoxBounds.y + 60);
	}	
}
