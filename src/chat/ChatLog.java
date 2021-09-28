package chat;

import java.awt.Color;

public class ChatLog
{

	public String text;
	public int tick;
	public int tickMax;
	public Color color;
	public ChatLog(Color color, String text, int tick, int tickMax)
	{
		this.color = color;
		this.text = text;
		this.tick = tick;
		this.tickMax = tickMax;
	}
	
}
