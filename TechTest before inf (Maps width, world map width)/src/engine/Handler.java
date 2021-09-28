package engine;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;

import entities.EntityCollision;
import entities.EntityManager;
import entities.Player;
import gfx.InventoryManager;
import gfx.Lighting;
import gfx.OptionsMenu;
import input.KeyManager;
import managers.FootprintManager;
import managers.ItemManager;
import maps.Maps;

public class Handler 
{

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int) screenSize.getWidth();
	public static int height = (int) screenSize.getHeight();
//	private World world = new World();
	//private GameState gs = new GameState();
	public static Camera cam = new Camera();
	public static Utilities util = new Utilities();
	public static FootprintManager footprint = new FootprintManager();
	private Maps maps = new Maps();
	public static double mouseX;
	public static double mouseY;
	private KeyManager key = new KeyManager();
	public static World world = new World();
	public static ItemManager item = new ItemManager();
	//public static OnScreenEntity entity = new OnScreenEntity();
	public static InventoryManager inv = new InventoryManager();
	public static OptionsMenu options = new OptionsMenu();
	public static EntityManager entity = new EntityManager();
	public static Player player = new Player();
	public static EntityCollision entityCol = new EntityCollision();
	public static Lighting lighting = new Lighting();
	public static void update()
	{
		mouseY = MouseInfo.getPointerInfo().getLocation().getY() - Game.frame.getLocationOnScreen().y;
	    mouseX = MouseInfo.getPointerInfo().getLocation().getX() - Game.frame.getLocationOnScreen().x;
	}
	
	public void updateInfo()
	{
		//screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//width = screenSize.getWidth();
		//height = screenSize.getHeight();
		width = Game.frame.getWidth();
		height = Game.frame.getHeight();
		Game.frame.revalidate();
		Game.frame.repaint();
	}
	public double screenWidth()
	{
		return width;
	}
	
	public double screenHeight()
	{
		return height;
	}
	
	public World getWorld()
	{
		return world;
	}
	//public GameState getGS()
	{
		//return gs;
	}
	public Maps getMaps()
	{
		return maps;
	}
	public double getMouseX()
	{
		return mouseX;
	}
	public double getMouseY()
	{
		return mouseY;
	}
	public KeyManager key()
	{
		return key;
	}
}
