package debug;

import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import engine.Game;
import engine.Handler;

public class Debug
{

	public static final String MESSAGE = "Console";
	public static final String UNKNOWN = "???";
	public static final String WARNING = "WARNING";
	public static final String ERROR = "ERROR";
	public static final String CRITICAL_ERROR = "CRITICAL ERROR";
	
	public static void debugMessage(String type, String message)
	{
		System.out.println("[" + type + "] " + message);
		if(type.equals(CRITICAL_ERROR))
		{
			System.out.println("[" + CRITICAL_ERROR + "] " + "Attempting to save game...");
			shutDown();
		}
	}
	public static void shutDown()
	{
		try
		{
			for(int row = 0; row < 3; row++)
			{
				for(int col = 0; col < 3; col++)
				{
					Handler.chunkloader.saveChunk(Handler.chunk.loadedChunks[row][col], Handler.chunk.loadedChunks[row][col].x,
							Handler.chunk.loadedChunks[row][col].y);
				}
			}
			System.out.println("[" + CRITICAL_ERROR + "] " + "Game was saved, closing...");
		}
		catch(NullPointerException e)
		{
			System.out.println("[" + CRITICAL_ERROR + "] " + "Game was unable to save, closing...");
		}
		
		Game.frame.dispatchEvent(new WindowEvent(Game.frame, WindowEvent.WINDOW_CLOSING));
	}
}
