package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import tile.Tiles;

public class Sources
{

	
	public static Tiles[] tiles;
	
	// --------TILES--------------
	
	public static BufferedImage GRASS;
	public static BufferedImage DIRT;
	public static BufferedImage WOODENPLANKS;
	public static BufferedImage SAND;
	
	public static BufferedImage ROCK;
	public static BufferedImage STONE_FLOORING;
	public static BufferedImage GLASS;
	public static BufferedImage WOODEN_BRIDGE;
	public static BufferedImage LOG;
	public static BufferedImage SIGN;
	public static BufferedImage PEBBLES;
	public static BufferedImage SMALL_CHEST;
	public static BufferedImage OAK_TREE_STUMP;
	public static BufferedImage OAK_SAPLING;
	public static BufferedImage WOODEN_BARREL;
	public static BufferedImage STONE;
	public static BufferedImage IRON_BUCKET;
	public static BufferedImage EFFECT_FOOTPRINT;
	public static BufferedImage WATER_FLOW;
	public static BufferedImage STONE_WALL;
	public static BufferedImage BLACK;
	public static BufferedImage STICK;
	public static BufferedImage DARK_GRASS;
	public static BufferedImage STONE_TILE;
	public static BufferedImage WORKBENCH_LEFT;
	public static BufferedImage WORKBENCH_RIGHT;
	
	public static BufferedImage CONTAINER_AREA;
	public static BufferedImage[] OCEAN = new BufferedImage[3];
	public static BufferedImage[] playerUp;
	public static BufferedImage[] playerDown;
	public static BufferedImage[] playerLeft;
	public static BufferedImage[] playerRight;
	public static BufferedImage playerSheet;
	
	//Entities
	
	public static BufferedImage MOB_PIG;
	
	//GUI
	
	public static BufferedImage MOUSE_NOINTERACT;
	public static BufferedImage GUI_ERROR;
	public static BufferedImage GUI_MAGNIFY;
	public static BufferedImage GUI_NEWMAP;
	public static BufferedImage GUI_FULLSCREEN;
	public static BufferedImage GUI_BOX;
	public static BufferedImage[] playerRightAttack;
	public static BufferedImage tree;
	public static BufferedImage shadow;
	public static BufferedImage healthbar;
	public static BufferedImage energybar;
	public static BufferedImage hotbar;
	public static BufferedImage water1;
	public static BufferedImage water2;
	public static BufferedImage water3;
	public static BufferedImage[] playerRightHead;
	public static BufferedImage[] playerLeftHead;
	
	public static BufferedImage inventory;
	public static BufferedImage invSelect;
	public static BufferedImage rain;
	public static BufferedImage[] splash;
	public static BufferedImage[] weather;
	public static BufferedImage[][] MOB_CHICKEN;
	
	public static BufferedImage pickaxe;
	public static BufferedImage spritesheet;
	public static BufferedImage player;
	
	public static BufferedImage grass;
	public static BufferedImage stonebrick;
	//ITEMS////
	public static BufferedImage wood;
	public static BufferedImage torch;
	public static BufferedImage scythe;
	public static BufferedImage scytheR;
	public static BufferedImage ironaxe;
	public static BufferedImage TOOL_AXE_IRON;
	//Entities
	public static BufferedImage tallgrass;
	public static BufferedImage pinetree;

	//
	
	int ms = 16;
	//
	public void loadImages()
	{
		tiles = new Tiles[200];
		playerUp = new BufferedImage[5];
		playerDown = new BufferedImage[5];
		playerLeft = new BufferedImage[5];
		playerRight = new BufferedImage[5];
		playerRight = new BufferedImage[5];
		playerRightHead = new BufferedImage[3];
		playerLeftHead = new BufferedImage[3];
		playerRightAttack = new BufferedImage[3];
		weather = new BufferedImage[3];
		MOB_CHICKEN = new BufferedImage[2][4];
		splash = new BufferedImage[3];
		OCEAN = new BufferedImage[4];
		try 
		{
			//Tiles;
			//InputStream e = this.getClass().getResourceAsStream("//Tiles/Outside/Grass/grass.png");
			//GRASS =  ImageIO.read(e);
			//GRASS = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Grass/grass.png")));
			GRASS = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Outside/Grass/grass.png"));
			DARK_GRASS = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Outside/Grass/darkgrass.png"));
			DIRT = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Dirt/dirt.png")));
			WOODENPLANKS = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Buildings/planks.png"));
			SAND = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Sand/sand.png")));
			ROCK = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/rock.png")));
			STONE_FLOORING = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/stoneflooring.png")));
			GLASS = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/glass.png")));
			WOODEN_BRIDGE = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/woodenbridge.png")));
			LOG = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/log.png")));
			STONE_WALL = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/stonewall.png"))); 
			SIGN = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/sign.png")));
			PEBBLES = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/pebbles.png")));
			SMALL_CHEST = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Container/chest.png")));
			OAK_TREE_STUMP = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Nature/treestump.png")));
			OAK_SAPLING = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Nature/Saplings/oaksapling.png")));
			WOODEN_BARREL = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Container/woodenbarrel.png")));
			STONE = ImageIO.read(Sources.class.getResourceAsStream(("/Things/Ressources/stone.png")));
			IRON_BUCKET = ImageIO.read(Sources.class.getResourceAsStream(("/Things/Tools/metalbucket.png")));
			BLACK = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Buildings/black.png")));
			STICK = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Obstacles/stick.png")));
			STONE_TILE = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Nature/stone.png"));
			WORKBENCH_LEFT = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Utilities/workbench_left.png"));
			WORKBENCH_RIGHT = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Utilities/workbench_right.png"));
			//Animated
			
			WATER_FLOW = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Liquid/Flow/FlowWater.png")));
			
			OCEAN[0] = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Liquid/water1.png"));
			OCEAN[1] = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Liquid/water2.png"));
			OCEAN[2] = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Liquid/water3.png"));
			OCEAN[3] = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Liquid/water2.png"));
			
			EFFECT_FOOTPRINT = ImageIO.read(Sources.class.getResourceAsStream(("/Effects/footprint.png")));
			
			CONTAINER_AREA = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Container/container.png")));
			
			//TOOLS
			
			TOOL_AXE_IRON = ImageIO.read(Sources.class.getResourceAsStream("/Things/Tools/ironaxe.png"));
			
			//Mobs
			BufferedImage chickenSheet = ImageIO.read(Sources.class.getResourceAsStream("/Mobs/chicken.png"));
			MOB_PIG = ImageIO.read(Sources.class.getResourceAsStream(("/Mobs/pig.png")));
			int base = 16;
			MOB_CHICKEN[0][0] = chickenSheet.getSubimage(base * 0, base * 0, base, base);
			MOB_CHICKEN[0][1] = chickenSheet.getSubimage(base * 1, base * 0, base, base);
			MOUSE_NOINTERACT = ImageIO.read(Sources.class.getResourceAsStream("/GUI/mouse.png"));
			GUI_ERROR = ImageIO.read(Sources.class.getResourceAsStream("/GUI/error.png"));
			GUI_MAGNIFY = ImageIO.read(Sources.class.getResourceAsStream("/GUI/Editor/magnify.png"));
			GUI_NEWMAP = ImageIO.read(Sources.class.getResourceAsStream("/GUI/Editor/newfile.png"));
			GUI_FULLSCREEN = ImageIO.read(Sources.class.getResourceAsStream("/GUI/fullscreen.png"));
			GUI_BOX = ImageIO.read(Sources.class.getResourceAsStream("/GUI/button.png"));
			
		//	grass = ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/grass.png")));
			//healthbar = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/grass.png"));
			stonebrick = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Buildings/brick.png"));
			// Name - Texture - ID - isSolid - entityTile
			
		/*	tiles[0] = new Tiles("Null", null, 0, false, false, false, 0);
			tiles[1] = new Tiles("Grass", grass, 1, false, false, true, 1);
			tiles[2] = new Tiles("Sand", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/sand.png")), 2, false, false, false, 1);
			tiles[3] = new Tiles("Stone Brick", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Buildings/brick.png")), 3, true, false, false, 1);
			tiles[4] = new Tiles("Shaded Stone Brick", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Buildings/shadedbrick.png")), 4, true, false, false, 1);
			tiles[5] = new Tiles("Wooden Planks", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Buildings/planks.png")), 5, false, false, false, 1);
			tiles[6] = new Tiles("Stone", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Nature/stone.png")), 6, true, false, false, 1);
			tiles[7] = new Tiles("Shaded Planks", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Buildings/planksshaded.png")), 7, false, false, false, 1);
			tiles[8] = new Tiles("Shaded Grass", ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/shadedgrass.png"))), 8, false, false, false, 1);
			tiles[15] = new Tiles("Dirt", ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Outside/Dirt/dirt.png"))), 15, false, false, false, 1);
			tiles[9] = new Tiles("Stone", ImageIO.read(Sources.class.getResourceAsStream(("/Tiles/Ores/stonefloor.png"))), 8, false, false, false, 1);
			tiles[10] = new Tiles("Water", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Liquid/water1.png")), 10, false, false, false, 1);
			tiles[11] = new Tiles("Water - Grass - Down", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Liquid/Grass/watergrassDown.png")), 11, false, false, false, 1);
			tiles[12] = new Tiles("Water - Grass - Left", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Liquid/Grass/watergrassLeft.png")), 12, false, false, false, 1);
			tiles[20] = new Tiles("Black", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Buildings/black.png")), 20, false, false, false, 1);
			tiles[21] = new Tiles("Drawer", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Furniture/drawer.png")), 21, true, false, false, 1);
			tiles[22] = new Tiles("Bed Top", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Furniture/bedtop.png")), 22, true, false, false, 1);
			tiles[25] = new Tiles("Fire Pit", ImageIO.read(Sources.class.getResourceAsStream("/Structures/firepit.png")), 25, true, false, false, 2);
			tiles[23] = new Tiles("Bed Bottom", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Furniture/bedbottom.png")), 23, true, false, false, 1);
			tiles[40] = new Tiles("Zatarium Ore", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Ores/zatariumore.png")), 40, true, false, false, 1);
			tiles[50] = new Tiles("Dead Grass", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Nature/deadgrass.png")), 50, false, false, false, 1);
			tiles[51] = new Tiles("Grass Variation 1", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Outside/Grass/grassVar1.png")), 51, false, false, true, 1);
			tiles[52] = new Tiles("Grass Variation 2", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Outside/Grass/grassVar2.png")), 52, false, false, true, 1);
			tiles[55] = new Tiles("Tree Stump", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Nature/treestump.png")), 55, true, false, false, 2);
			tiles[120] = new Tiles("Chest", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Furniture/chest.png")), 120, true, false, false, 1);
			tiles[110] = new Tiles("Fence H", ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Outside/fenceH.png")), 110, true, false, false, 3);
			tiles[60] = new Tiles("Tall Grass Tile", null, 60, false, true, false, 3);*/
			spritesheet = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerSpriteSheet.png"));
			playerDown[0] = spritesheet.getSubimage(0, 0, 16, 32);
			playerDown[1] = spritesheet.getSubimage(0, 0, 16, 32);
			playerDown[2] = spritesheet.getSubimage(16, 0, 16, 32);
			playerDown[3] = spritesheet.getSubimage(32, 0, 16, 32);
			playerDown[4] = spritesheet.getSubimage(16, 0, 16, 32);
			
			//tallgrass = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Nature/tallgrass.png"));
			pinetree = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Nature/pinetree.png"));
			
			playerRight[0] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerRightStill.png"));
			playerRight[1] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerRight1.png"));
			playerRight[2] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerRight2.png"));
			playerRight[3] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerRight3.png"));
			playerRight[4] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerRight4.png"));
			
			playerRightAttack[0] = ImageIO.read(Sources.class.getResourceAsStream("/Player/Attack/playerRightAttack1.png"));
			playerRightAttack[1] = ImageIO.read(Sources.class.getResourceAsStream("/Player/Attack/playerRightAttack2.png"));
			playerRightAttack[2] = ImageIO.read(Sources.class.getResourceAsStream("/Player/Attack/playerRightAttack3.png"));
			
			playerLeft[0] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerLeftStill.png"));
			playerLeft[1] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerLeft1.png"));
			playerLeft[2] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerLeft2.png"));
			playerLeft[3] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerLeft3.png"));
			playerLeft[4] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerLeft4.png"));
			
			playerRightHead[0] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerRightHead.png"));
			playerRightHead[1] = ImageIO.read(Sources.class.getResourceAsStream("/Player/rightHeadBlink1.png"));
			playerRightHead[2] = ImageIO.read(Sources.class.getResourceAsStream("/Player/rightHeadBlink2.png"));
			playerLeftHead[0] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerLeftHead.png"));
			playerLeftHead[1] = ImageIO.read(Sources.class.getResourceAsStream("/Player/leftHeadBlink1.png"));
			playerLeftHead[2] = ImageIO.read(Sources.class.getResourceAsStream("/Player/leftHeadBlink2.png"));
			
			weather[0] = ImageIO.read(Sources.class.getResourceAsStream("/GUI/sunweather.png"));
			weather[1] = ImageIO.read(Sources.class.getResourceAsStream("/GUI/rainweather.png"));
			weather[2] = ImageIO.read(Sources.class.getResourceAsStream("/GUI/stormweather.png"));
			
			
			//playerRight[3] = ImageIO.read(Sources.class.getResourceAsStream("/Player/playerRightStill.png"));
			tree = ImageIO.read(Sources.class.getResourceAsStream("/tree.png"));
			tallgrass = ImageIO.read(Sources.class.getResourceAsStream("/Tiles/Nature/tallgrass.png"));
			shadow = ImageIO.read(Sources.class.getResourceAsStream("/Effects/treeshadow.png"));
			healthbar = ImageIO.read(Sources.class.getResourceAsStream("/GUI/healthbar.png"));
			energybar = ImageIO.read(Sources.class.getResourceAsStream("/GUI/energybar.png"));
			hotbar = ImageIO.read(Sources.class.getResourceAsStream("/GUI/hotbar.png"));
			inventory = ImageIO.read(Sources.class.getResourceAsStream("/GUI/inventory.png"));
			invSelect = ImageIO.read(Sources.class.getResourceAsStream("/GUI/hotbarselect.png"));
			
			rain = ImageIO.read(Sources.class.getResourceAsStream("/Effects/rain.png"));
			splash[0] = ImageIO.read(Sources.class.getResourceAsStream("/Effects/rainsplash1.png"));
			splash[1] = ImageIO.read(Sources.class.getResourceAsStream("/Effects/rainsplash2.png"));
			splash[2] = ImageIO.read(Sources.class.getResourceAsStream("/Effects/rainsplash3.png"));
			
			///////// ITEMS //////////
			pickaxe = ImageIO.read(Sources.class.getResourceAsStream("/Things/pickaxe.png"));
			torch = ImageIO.read(Sources.class.getResourceAsStream("/Things/torch.png"));
			wood = ImageIO.read(Sources.class.getResourceAsStream("/Things/wood.png"));
			scythe = ImageIO.read(Sources.class.getResourceAsStream("/Things/scythe.png"));
			scytheR = ImageIO.read(Sources.class.getResourceAsStream("/Things/scytheR.png"));
			ironaxe = ImageIO.read(Sources.class.getResourceAsStream("/Things/Tools/ironaxe.png"));
		} 
		catch 
		(IOException e)
		{
			e.printStackTrace();
			System.out.println("Failed to load some images or the FileInputStream might be corrupt! Oh noes :o");
		}
		catch (IllegalArgumentException e)
		{
			
			System.out.println("Failed to load some images or they may be corrupt!");
			System.out.println("--------------------");
			e.printStackTrace();
			System.out.println("--------------------");
		}
	}
	public void loadImage(String path)
	{
		
	}
}

