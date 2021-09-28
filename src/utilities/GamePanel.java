package utilities;

import java.awt.Component;

import javax.swing.JPanel;

import engine.Game;

public class GamePanel 
{

	public JPanel panel = new JPanel();
	public GamePanel()
	{
		panel.setLayout(null);
		panel.setOpaque(false);
	}
	public void addToFrame()
	{
		Game.frame.add(panel);
		panel.requestFocus();
	}
	public void removeFromFrame()
	{
		Game.frame.remove(panel);
		panel.requestFocus();
	}
	public void addComponent(Component c)
	{
		panel.add(c);
	}
	public void removeComponent(Component c)
	{
		panel.remove(c);
	}
}
