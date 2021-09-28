package engine;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.io.File;

import audio.Audio;
import chunk.ChunkLoader;
import chunk.ChunkManager;
import entities.EntityCollision;
import entities.EntityManager;
import entities.Player;
import gfx.InventoryManager;
import gfx.Lighting;
import gfx.OptionsMenu;
import gfx.Text;
import input.GlobalKeys;
import input.KeyManager;
import managers.FlatCollision;
import managers.FootprintManager;
import managers.ItemManager;
import managers.WorldSelectionManager;
import maps.Maps;
import savegame.OptionSaver;
import savegame.Options;
import savegame.SaveManager;
import savegame.Unloader;
import states.MenuState;
import states.WorldSelect;
import tile.Tiles;

public class Handler 
{

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int) screenSize.getWidth();
	public static int height = (int) screenSize.getHeight();
	public static File CURRENT_WORLD = new File("");
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
	public static OptionsMenu optionsMenu = new OptionsMenu();
	public static EntityManager entity = new EntityManager();
	public static Player player = new Player();
	public static EntityCollision entityCol = new EntityCollision();
	public static Lighting lighting = new Lighting();
	public static ChunkManager chunk = new ChunkManager();
	//public static WorldManager worldmg = new WorldManager();
	public static ChunkLoader chunkloader = new ChunkLoader();
	public static MenuState menustate = new MenuState();
	public static FlatCollision flatCol = new FlatCollision();
	public static Tiles materials = new Tiles();
	public static WorldSelect worldselect = new WorldSelect();
	public static Text text = new Text();
	public static WorldSelectionManager selectionMng = new WorldSelectionManager();
	public static OptionSaver optionSaver = new OptionSaver();
	public static Unloader unloader = new Unloader();
	public static Options options = new Options();
	public static Audio audio = new Audio();
	public static SaveManager saveMng = new SaveManager();
	public static GlobalKeys globalKeys = new GlobalKeys();
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
	public static String getWorldPath()
	{
		return CURRENT_WORLD.getAbsolutePath().toString();
	}
	public static String getGamePath()
	{
		return Options.GAME_DIRECTORY;
	}
}
