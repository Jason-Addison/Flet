package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import debug.Debug;
import tile.Tiles;

public class Sources {

	public static Tiles[] tiles;

	// --------TILES--------------

	public static BufferedImage FILLER;
	public static BufferedImage GRASS;
	public static BufferedImage DIRT;
	public static BufferedImage WOODENPLANKS;
	public static BufferedImage SAND;
	public static BufferedImage HOLE;
	public static BufferedImage HOLE_SIMPLE;

	public static BufferedImage WOODEN_DOOR_TOP;
	public static BufferedImage WOODEN_DOOR_BOTTOM;
	public static BufferedImage WOODEN_DOOR_CLOSED;
	public static BufferedImage WOODEN_DOOR_OPEN;
	public static BufferedImage STONE_WALL_DOUBLE;
	public static BufferedImage DUST_STONE;
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

	// Entities

	public static BufferedImage MOB_PIG;

	// GUI

	public static BufferedImage BUTTON_HOVER;
	public static BufferedImage BUTTON_LOCKED;
	public static BufferedImage BUTTON;
	public static BufferedImage BASIC_BUTTON;
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
	// ITEMS////
	public static BufferedImage wood;
	public static BufferedImage torch;
	public static BufferedImage scythe;
	public static BufferedImage scytheR;
	public static BufferedImage ironaxe;
	public static BufferedImage TOOL_AXE_IRON;
	// Entities
	public static BufferedImage tallgrass;
	public static BufferedImage pinetree;
	public static BufferedImage WORLD_DEMO_TEMP_DELETE;
	//

	int ms = 16;

	//
	public void loadImages() {

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
		try {
			// Tiles;
			// InputStream e =
			// this.getClass().getResourceAsStream("//Tiles/Outside/Grass/grass.png");
			// GRASS = ImageIO.read(e);
			// GRASS =
			// ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Grass/grass.png")));
			FILLER = ImageIO.read(new FileInputStream("Textures/filler.png"));
			GRASS = ImageIO.read(new FileInputStream("Textures/Tiles/Outside/Grass/grass.png"));
			HOLE = ImageIO.read(new FileInputStream("Textures/Tiles/Outside/hole.png"));
			HOLE_SIMPLE = ImageIO.read(new FileInputStream("Textures/Tiles/Outside/holesimple.png"));
			DARK_GRASS = ImageIO.read(new FileInputStream("Textures/Tiles/Outside/Grass/darkgrass.png"));
			DIRT = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Dirt/dirt.png")));
			WOODENPLANKS = ImageIO.read(new FileInputStream("Textures/Tiles/Buildings/planks.png"));
			SAND = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Sand/sand.png")));
			ROCK = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/rock.png")));
			STONE_FLOORING = ImageIO
					.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/stoneflooring.png")));
			GLASS = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/glass.png")));
			WOODEN_BRIDGE = ImageIO
					.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/woodenbridge.png")));
			LOG = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/log.png")));
			STONE_WALL = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/stonewall.png")));
			SIGN = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/sign.png")));
			PEBBLES = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/pebbles.png")));
			SMALL_CHEST = ImageIO.read(new FileInputStream(("Textures/Tiles/Container/chest.png")));
			OAK_TREE_STUMP = ImageIO.read(new FileInputStream(("Textures/Tiles/Nature/treestump.png")));
			OAK_SAPLING = ImageIO.read(new FileInputStream(("Textures/Tiles/Nature/Saplings/oaksapling.png")));
			WOODEN_BARREL = ImageIO.read(new FileInputStream(("Textures/Tiles/Container/woodenbarrel.png")));
			STONE = ImageIO.read(new FileInputStream(("Textures/Things/Ressources/stone.png")));
			IRON_BUCKET = ImageIO.read(new FileInputStream(("Textures/Things/Tools/metalbucket.png")));
			BLACK = ImageIO.read(new FileInputStream(("Textures/Tiles/Buildings/black.png")));
			STICK = ImageIO.read(new FileInputStream(("Textures/Tiles/Outside/Obstacles/stick.png")));
			STONE_TILE = ImageIO.read(new FileInputStream("Textures/Tiles/Nature/stone.png"));
			WORKBENCH_LEFT = ImageIO.read(new FileInputStream("Textures/Tiles/Utilities/workbench_left.png"));
			WORKBENCH_RIGHT = ImageIO.read(new FileInputStream("Textures/Tiles/Utilities/workbench_right.png"));
			WOODEN_DOOR_TOP = ImageIO
					.read(new FileInputStream("Textures/Tiles/Furniture/WoodenDoorTopClosed.png"));
			WOODEN_DOOR_BOTTOM = ImageIO
					.read(new FileInputStream("Textures/Tiles/Furniture/WoodenDoorBottomClosed.png"));
			WOODEN_DOOR_CLOSED = ImageIO.read(new FileInputStream("Textures/Tiles/Furniture/Wooden_Door.png"));
			WOODEN_DOOR_OPEN = ImageIO.read(new FileInputStream("Textures/Tiles/Furniture/Wooden_Door_Open.png"));
			STONE_WALL_DOUBLE = ImageIO
					.read(new FileInputStream("Textures/Tiles/Furniture/Stone_Doublewall.png"));
			DUST_STONE = ImageIO.read(new FileInputStream("Textures/Tiles/Ores/stonefloor.png"));
			// WORLD_DEMO_TEMP_DELETE = ImageIO.read(new
			// File("D:/world1/2016_08_23_16-35-54.png"));
			// Animated

			WATER_FLOW = ImageIO.read(new FileInputStream(("Textures/Tiles/Liquid/Flow/FlowWater.png")));

			OCEAN[0] = ImageIO.read(new FileInputStream("Textures/Tiles/Liquid/water1.png"));
			OCEAN[1] = ImageIO.read(new FileInputStream("Textures/Tiles/Liquid/water2.png"));
			OCEAN[2] = ImageIO.read(new FileInputStream("Textures/Tiles/Liquid/water3.png"));
			OCEAN[3] = ImageIO.read(new FileInputStream("Textures/Tiles/Liquid/water2.png"));

			EFFECT_FOOTPRINT = ImageIO.read(new FileInputStream(("Textures/Effects/footprint.png")));

			CONTAINER_AREA = ImageIO.read(new FileInputStream(("Textures/Tiles/Container/container.png")));

			// TOOLS

			TOOL_AXE_IRON = ImageIO.read(new FileInputStream("Textures/Things/Tools/ironaxe.png"));

			// Mobs
			BufferedImage chickenSheet = ImageIO.read(new FileInputStream("Textures/Mobs/chicken.png"));
			MOB_PIG = ImageIO.read(new FileInputStream(("Textures/Mobs/pig.png")));
			int base = 16;
			MOB_CHICKEN[0][0] = chickenSheet.getSubimage(base * 0, base * 0, base, base);
			MOB_CHICKEN[0][1] = chickenSheet.getSubimage(base * 1, base * 0, base, base);
			MOUSE_NOINTERACT = ImageIO.read(new FileInputStream("Textures/GUI/mouse.png"));
			GUI_ERROR = ImageIO.read(new FileInputStream("Textures/GUI/error.png"));
			GUI_MAGNIFY = ImageIO.read(new FileInputStream("Textures/GUI/Editor/magnify.png"));
			GUI_NEWMAP = ImageIO.read(new FileInputStream("Textures/GUI/Editor/newfile.png"));
			GUI_FULLSCREEN = ImageIO.read(new FileInputStream("Textures/GUI/fullscreen.png"));
			GUI_BOX = ImageIO.read(new FileInputStream("Textures/GUI/button.png"));
			BASIC_BUTTON = ImageIO.read(new FileInputStream("Textures/GUI/Basic_Button.png"));
			BUTTON = ImageIO.read(new FileInputStream("Textures/GUI/GUI_Button.png"));
			BUTTON_LOCKED = ImageIO.read(new FileInputStream("Textures/GUI/GUI_Button_Locked.png"));
			BUTTON_HOVER = ImageIO.read(new FileInputStream("Textures/GUI/GUI_Button_Hover.png"));
			// grass =
			// ImageIO.read(new FileInputStream(("Textures/Tiles/grass.png")));
			// healthbar =
			// ImageIO.read(new FileInputStream("Textures/Tiles/grass.png"));
			stonebrick = ImageIO.read(new FileInputStream("Textures/Tiles/Buildings/brick.png"));
			// Name - Texture - ID - isSolid - entityTile

			/*
			 * tiles[0] = new Tiles("Null", null, 0, false, false, false, 0);
			 * tiles[1] = new Tiles("Grass", grass, 1, false, false, true, 1);
			 * tiles[2] = new Tiles("Sand",
			 * ImageIO.read(new FileInputStream("Textures/Tiles/sand.png")
			 * ), 2, false, false, false, 1); tiles[3] = new Tiles("Stone Brick"
			 * , ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Buildings/brick.png")), 3, true, false, false, 1);
			 * tiles[4] = new Tiles("Shaded Stone Brick",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Buildings/shadedbrick.png")), 4, true, false, false, 1);
			 * tiles[5] = new Tiles("Wooden Planks",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Buildings/planks.png")), 5, false, false, false, 1);
			 * tiles[6] = new Tiles("Stone",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Nature/stone.png")), 6, true, false, false, 1); tiles[7]
			 * = new Tiles("Shaded Planks",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Buildings/planksshaded.png")), 7, false, false, false,
			 * 1); tiles[8] = new Tiles("Shaded Grass",
			 * ImageIO.read(Sources.class.getResourceAsStream((
			 * "/Tiles/shadedgrass.png"))), 8, false, false, false, 1);
			 * tiles[15] = new Tiles("Dirt",
			 * ImageIO.read(Sources.class.getResourceAsStream((
			 * "/Tiles/Outside/Dirt/dirt.png"))), 15, false, false, false, 1);
			 * tiles[9] = new Tiles("Stone",
			 * ImageIO.read(Sources.class.getResourceAsStream((
			 * "/Tiles/Ores/stonefloor.png"))), 8, false, false, false, 1);
			 * tiles[10] = new Tiles("Water",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Liquid/water1.png")), 10, false, false, false, 1);
			 * tiles[11] = new Tiles("Water - Grass - Down",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Liquid/Grass/watergrassDown.png")), 11, false, false,
			 * false, 1); tiles[12] = new Tiles("Water - Grass - Left",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Liquid/Grass/watergrassLeft.png")), 12, false, false,
			 * false, 1); tiles[20] = new Tiles("Black",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Buildings/black.png")), 20, false, false, false, 1);
			 * tiles[21] = new Tiles("Drawer",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Furniture/drawer.png")), 21, true, false, false, 1);
			 * tiles[22] = new Tiles("Bed Top",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Furniture/bedtop.png")), 22, true, false, false, 1);
			 * tiles[25] = new Tiles("Fire Pit",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Structures/firepit.png")), 25, true, false, false, 2);
			 * tiles[23] = new Tiles("Bed Bottom",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Furniture/bedbottom.png")), 23, true, false, false, 1);
			 * tiles[40] = new Tiles("Zatarium Ore",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Ores/zatariumore.png")), 40, true, false, false, 1);
			 * tiles[50] = new Tiles("Dead Grass",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Nature/deadgrass.png")), 50, false, false, false, 1);
			 * tiles[51] = new Tiles("Grass Variation 1",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Outside/Grass/grassVar1.png")), 51, false, false, true,
			 * 1); tiles[52] = new Tiles("Grass Variation 2",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Outside/Grass/grassVar2.png")), 52, false, false, true,
			 * 1); tiles[55] = new Tiles("Tree Stump",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Nature/treestump.png")), 55, true, false, false, 2);
			 * tiles[120] = new Tiles("Chest",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Furniture/chest.png")), 120, true, false, false, 1);
			 * tiles[110] = new Tiles("Fence H",
			 * ImageIO.read(Sources.class.getResourceAsStream(
			 * "/Tiles/Outside/fenceH.png")), 110, true, false, false, 3);
			 * tiles[60] = new Tiles("Tall Grass Tile", null, 60, false, true,
			 * false, 3);
			 */
			spritesheet = ImageIO.read(new FileInputStream("Textures/Player/playerSpriteSheet.png"));
			playerDown[0] = spritesheet.getSubimage(0, 0, 16, 32);
			playerDown[1] = spritesheet.getSubimage(0, 0, 16, 32);
			playerDown[2] = spritesheet.getSubimage(16, 0, 16, 32);
			playerDown[3] = spritesheet.getSubimage(32, 0, 16, 32);
			playerDown[4] = spritesheet.getSubimage(16, 0, 16, 32);

			// tallgrass =
			// ImageIO.read(new FileInputStream("Textures/Tiles/Nature/tallgrass.png"));
			pinetree = ImageIO.read(new FileInputStream("Textures/Tiles/Nature/pinetree.png"));

			playerRight[0] = ImageIO.read(new FileInputStream("Textures/Player/playerRightStill.png"));
			playerRight[1] = ImageIO.read(new FileInputStream("Textures/Player/playerRight1.png"));
			playerRight[2] = ImageIO.read(new FileInputStream("Textures/Player/playerRight2.png"));
			playerRight[3] = ImageIO.read(new FileInputStream("Textures/Player/playerRight3.png"));
			playerRight[4] = ImageIO.read(new FileInputStream("Textures/Player/playerRight4.png"));

			playerRightAttack[0] = ImageIO
					.read(new FileInputStream("Textures/Player/Attack/playerRightAttack1.png"));
			playerRightAttack[1] = ImageIO
					.read(new FileInputStream("Textures/Player/Attack/playerRightAttack2.png"));
			playerRightAttack[2] = ImageIO
					.read(new FileInputStream("Textures/Player/Attack/playerRightAttack3.png"));

			playerLeft[0] = ImageIO.read(new FileInputStream("Textures/Player/playerLeftStill.png"));
			playerLeft[1] = ImageIO.read(new FileInputStream("Textures/Player/playerLeft1.png"));
			playerLeft[2] = ImageIO.read(new FileInputStream("Textures/Player/playerLeft2.png"));
			playerLeft[3] = ImageIO.read(new FileInputStream("Textures/Player/playerLeft3.png"));
			playerLeft[4] = ImageIO.read(new FileInputStream("Textures/Player/playerLeft4.png"));

			playerRightHead[0] = ImageIO.read(new FileInputStream("Textures/Player/playerRightHead.png"));
			playerRightHead[1] = ImageIO.read(new FileInputStream("Textures/Player/rightHeadBlink1.png"));
			playerRightHead[2] = ImageIO.read(new FileInputStream("Textures/Player/rightHeadBlink2.png"));
			playerLeftHead[0] = ImageIO.read(new FileInputStream("Textures/Player/playerLeftHead.png"));
			playerLeftHead[1] = ImageIO.read(new FileInputStream("Textures/Player/leftHeadBlink1.png"));
			playerLeftHead[2] = ImageIO.read(new FileInputStream("Textures/Player/leftHeadBlink2.png"));

			weather[0] = ImageIO.read(new FileInputStream("Textures/GUI/sunweather.png"));
			weather[1] = ImageIO.read(new FileInputStream("Textures/GUI/rainweather.png"));
			weather[2] = ImageIO.read(new FileInputStream("Textures/GUI/stormweather.png"));

			// playerRight[3] =
			// ImageIO.read(new FileInputStream("Textures/Player/playerRightStill.png"));
			tree = ImageIO.read(new FileInputStream("Textures/tree.png"));
			tallgrass = ImageIO.read(new FileInputStream("Textures/Tiles/Nature/tallgrass.png"));
			shadow = ImageIO.read(new FileInputStream("Textures/Effects/treeshadow.png"));
			healthbar = ImageIO.read(new FileInputStream("Textures/GUI/healthbar.png"));
			energybar = ImageIO.read(new FileInputStream("Textures/GUI/energybar.png"));
			hotbar = ImageIO.read(new FileInputStream("Textures/GUI/hotbar.png"));
			inventory = ImageIO.read(new FileInputStream("Textures/GUI/inventory.png"));
			invSelect = ImageIO.read(new FileInputStream("Textures/GUI/hotbarselect.png"));

			rain = ImageIO.read(new FileInputStream("Textures/Effects/rain.png"));
			splash[0] = ImageIO.read(new FileInputStream("Textures/Effects/rainsplash1.png"));
			splash[1] = ImageIO.read(new FileInputStream("Textures/Effects/rainsplash2.png"));
			splash[2] = ImageIO.read(new FileInputStream("Textures/Effects/rainsplash3.png"));

			///////// ITEMS //////////
			pickaxe = ImageIO.read(new FileInputStream("Textures/Things/pickaxe.png"));
			torch = ImageIO.read(new FileInputStream("Textures/Things/torch.png"));
			wood = ImageIO.read(new FileInputStream("Textures/Things/wood.png"));
			scythe = ImageIO.read(new FileInputStream("Textures/Things/scythe.png"));
			scytheR = ImageIO.read(new FileInputStream("Textures/Things/scytheR.png"));
			ironaxe = ImageIO.read(new FileInputStream("Textures/Things/Tools/ironaxe.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to load some images or the FileInputStream might be corrupt! Oh noes :o");
		} catch (IllegalArgumentException e) {

			System.out.println("Failed to load some images or they may be corrupt!");
			System.out.println("--------------------");
			e.printStackTrace();
			System.out.println("--------------------");
		}
	}

	public void loadImage(String path) {

	}
}
