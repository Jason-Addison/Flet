package states;

import java.awt.Graphics2D;

import editor.Editing;
import editor.EditorCamera;
import editor.EditorUI;
import engine.World;

public class EditorState
{

	private EditorUI ui = new EditorUI();
	private EditorCamera editorcam = new EditorCamera();
	private Editing editing = new Editing();
	public void tick()
	{
		ui.tick();
		editorcam.tick();
		editing.tick();
	}
	
	public void render(Graphics2D g)
	{
		ui.render(g);
	}
	
}
