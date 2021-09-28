package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EditorKeys implements KeyListener
{

	public static boolean up, down, left, right;
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_W)
		{
			up = true;
		}
		if(keyCode == KeyEvent.VK_S)
		{
			down = true;
		}
		if(keyCode == KeyEvent.VK_A)
		{
			left = true;
		}
		if(keyCode == KeyEvent.VK_D)
		{
			right = true;
		}
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			//State.currentState = 1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W)
		{
			up = false;
		}
		if(keyCode == KeyEvent.VK_S)
		{
			down = false;
		}
		if(keyCode == KeyEvent.VK_A)
		{
			left = false;
		}
		if(keyCode == KeyEvent.VK_D)
		{
			right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

}
