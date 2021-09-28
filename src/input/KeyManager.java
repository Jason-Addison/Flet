package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import debug.Debug;
import engine.Game;
import engine.Handler;
import engine.World;
import engine.WorldManager;
import gfx.InventoryManager;
import gfx.Sources;
import maps.Maps;
import weather.WeatherManager;

public class KeyManager implements KeyListener
{

	public static boolean up, down, left, right, inventory, debug, firstLayer = true, secondLayer, flatLayer, shift, minimap, itemUse, esc;
	public static int layer = 0;
	private WeatherManager weather = new WeatherManager();
	

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		if(!Typing.inChat)
		{
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
			if(keyCode == KeyEvent.VK_E)
			{
				if(InventoryManager.inventoryOpen)
				{
					InventoryManager.inventoryOpen = false;
					InventoryManager.inContainer = false;
				}
				else
				{
					InventoryManager.inventoryOpen = true;
					InventoryManager.inContainer = true;
					Game.frame.requestFocus();
				}
			}
			if(keyCode == KeyEvent.VK_0)
			{
				for(int row = 0; row < 3; row++)
				{
					for(int col = 0; col < 3; col++)
					{
						Handler.chunkloader.saveChunk(Handler.chunk.loadedChunks[row][col], Handler.chunk.loadedChunks[row][col].x,
								Handler.chunk.loadedChunks[row][col].y);
					}
				}
				Game.frame.dispatchEvent(new WindowEvent(Game.frame, WindowEvent.WINDOW_CLOSING));
			}
			if(keyCode == KeyEvent.VK_1)
			{
				if(weather.getStorm())
				{
					weather.setWeather(false);
				}
				else
				{
					weather.setWeather(true);
				}
			}
			
			if(keyCode == KeyEvent.VK_C)
			{
				if(Typing.inChat)
				{
					Typing.inChat = false;
					Typing.chat = "";
				}
				else
				{
					Typing.inChat = true;
					up = false;
					down = false;
					left = false;
					right = false;
				}
			}
			if(keyCode == KeyEvent.VK_2)
			{
				Handler.cam.setPlayer(-500, 500);
			}
			if(keyCode == KeyEvent.VK_Q)
			{
				if(layer > 2)
				{
					layer = 0;
				}
				if(layer == 0)
				{
					firstLayer = true;
					secondLayer = false;
					flatLayer = false;
					
				}
				if(layer == 1)
				{
					firstLayer = false;
					secondLayer = false;
					flatLayer = true;
				}
				if(layer == 2)
				{
					firstLayer = false;
					secondLayer = true;
					flatLayer = false;
				}
			}
			if(keyCode == KeyEvent.VK_F)
			{
				if(debug)
				{
					debug = false;
				}
				else
				{
					debug = true;
				}
			}
			if(keyCode == KeyEvent.VK_SHIFT)
			{
				shift = true;
			}
			if(keyCode == KeyEvent.VK_M)
			{
				if(minimap)
				{
					minimap = false;
				}
				else
				{
					minimap = true;
				}
			}
			if(keyCode == KeyEvent.VK_T)
			{
				Handler.cam.setPlayer(-30000, 0);
				Sources src = new Sources();
				src.loadImages();
			}
		}
		if(keyCode == KeyEvent.VK_SLASH)
		{
			if(Typing.inChat)
			{
				Typing.inChat = false;
				Typing.chat = "";
			}
			else
			{
				Typing.inChat = true;
				up = false;
				down = false;
				left = false;
				right = false;
			}
		}
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			if(esc)
			{
				Handler.optionsMenu.removeLayout();
				esc = false;
			}
			else
			{
				Handler.optionsMenu.addLayout();
				esc = true;
			}
			for(int col = World.y; col < World.y + (Handler.height / Maps.tileScale) + 7; col++)
			{
				for(int row = World.x; row < World.x + (Handler.width / Maps.tileScale) + 11; row++)
				{
					Handler.world.map[row][col].tileOnGround.onEscape();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		//if(!Typing.inChat)
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
			if(keyCode == KeyEvent.VK_SHIFT)
			{
				shift = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	
}
