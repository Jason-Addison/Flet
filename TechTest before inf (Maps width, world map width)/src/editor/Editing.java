package editor;

import java.awt.Graphics2D;
import java.awt.Point;

import engine.Handler;
import input.MouseManager;
import tile.BasicTile;
import tile.groundtiles.Sand;

public class Editing 
{

	private EditorCamera ec = new EditorCamera();
	public static boolean cannotPlace = false;
	static int mouseX = 0;
	static int mouseY = 0;
	public void tick()
	{
		cannotPlace = false;
		mouseX = (int) ((Handler.mouseX + ec.getCamX())/ EditorUI.editorScale);
		mouseY = (int) ((Handler.mouseY + ec.getCamY())/ EditorUI.editorScale);
		
		if(MouseManager.leftClick)
		{
			mouseX = (int) ((Handler.mouseX + ec.getCamX())/ EditorUI.editorScale);
			mouseY = (int) ((Handler.mouseY + ec.getCamY())/ EditorUI.editorScale);
			if(mouseX > 0 && mouseY > 0 && mouseX < EditorUI.loadedWorld.width && mouseY < EditorUI.loadedWorld.height)
			{
				changeTile(mouseX, mouseY, new Sand());
				cannotPlace = false;
			}
			else
			{
				cannotPlace = true;
			}
		}
	}
	
	public void changeTile(int x, int y, BasicTile tile)
	{
		EditorUI.loadedWorld.map[x][y].tile = tile;
	}
	public void render(Graphics2D g)
	{
		
	}
	public Point getMouse()
	{
		return new Point(mouseX, mouseY);
	}
}
