package tile.groundtiles;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Handler;
import gfx.Sources;
import input.Typing;
import tile.ongroundtiles.OnGroundTile;

public class Sign extends OnGroundTile 
{
	
	public static boolean typing = false;
	//public static JTextField signTextField = new JTextField("DDDDDDDDDDDDDD");
	String message;
	boolean typed = false;
	boolean displayingText = false;
	public Sign()
	{
		super(666, Sources.SIGN, "Sign", 5);
	}
	
	public boolean isSolid()
	{
		return true;
	}
	public void onRightClick()
	{
		typing = true;
		displayingText = true;
		if(!typed)
		{
			message = Typing.chat;
			typed = true;
		}
		Handler.util.chatMsg(Color.BLACK, "Sign : ", message, 300);
	}
	public void render(Graphics2D g)
	{
		//if(displayingText && 0 != 0)
		//{
		//	g.setColor(new Color(0, 0, 0, 100));
		//	g.fillRect(300, 300, (int) Handler.width - 600, (int) Handler.height - 600);
		//}
	}
}