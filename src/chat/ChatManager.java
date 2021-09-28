package chat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import gfx.Text;

public class ChatManager 
{

	public static ArrayList<ChatLog> chatLog = new ArrayList<ChatLog>();
	public void tick()
	{
		for(int i = 0; i < chatLog.size(); i++)
		{
			chatLog.get(i).tick--;
			if(chatLog.get(i).tick <= 0)
			{
				chatLog.remove(i);
				//Collections.reverse(chatLog);
			}
			
		}
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		g.setFont(Text.chat);
		for(int i = 0; i < chatLog.size(); i++)
		{
			if(chatLog.get(i).text.charAt(0) == '/')
			{
				g.setColor(chatLog.get(i).color);
				g.drawString("Command : " + chatLog.get(i).text, 10, -(i * 30) + 1000);
			}
			else
			{
				g.setColor(chatLog.get(i).color);
				g.drawString(chatLog.get(i).text, 10, -(i * 30) + 1000);
			}
		}
	}
	
}
