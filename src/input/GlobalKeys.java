package input;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import engine.Handler;

public class GlobalKeys implements KeyListener
{

	@Override
	public void keyPressed(KeyEvent e)
	{
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	public void addGlobalControls()
	{
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() 
		  {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) 
		      {
		    	  int keyCode = e.getKeyCode();
		    	  if(keyCode == KeyEvent.VK_F1)
		    	  {
		    		  Handler.util.screenCapture("D:/", Handler.util.getTime());
		    	  }
		    	  return false;
		      }
		      
		});
	}
}
