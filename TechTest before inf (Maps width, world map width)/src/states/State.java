package states;

import java.awt.Graphics2D;

public class State 
{

	public static int currentState = 1; 
	
	////////STATE INFO//////////
	// 	  0 = EMPTY
	//	  1 = MENU
	//    2 = GAME
	// 	  3 = EDITOR
	////////////////////////////
	
	private GameState game = new GameState();
	private MenuState menu = new MenuState();
	private EditorState editor = new EditorState();
	
	public void tick()
	{
		if(currentState == 1)
		{
			menu.tick();
		}
		if(currentState == 2)
		{
			game.tick();
		}
		if(currentState == 3)
		{
			editor.tick();
		}
	}
	public void render(Graphics2D g)
	{
		if(currentState == 1)
		{
			inMenu(g);
		}
		if(currentState == 2)
		{
			inGame(g);
		}
		if(currentState == 3)
		{
			inEditor(g);
		}
	}
	public void inGame(Graphics2D g)
	{
		game.render(g);
	}
	public void inMenu(Graphics2D g)
	{
		menu.render(g);
	}
	public void inEditor(Graphics2D g)
	{
		editor.render(g);
	}
}
