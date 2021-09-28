package engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import editor.SaveWorld;
import entities.Player;
import entities.ThePlayer;
import gfx.InventoryManager;
import gfx.Sources;
import gfx.Text;
import input.EditorKeys;
import input.KeyManager;
import input.MouseManager;
import input.Typing;
import items.Container;
import items.Empty;
import items.Slot;
import managers.Generator;
import managers.Updater;
import maps.Maps;
import recipe.Recipe;
import states.MenuState;
import states.State;
import tile.Air;
import tile.ShadedTile;
import tile.groundtiles.Grass;

public class Game extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int tileScale = 100;
	int scale = 50;
	int qq = 0;
	static String name = "2d game";
	public static JFrame frame = new JFrame(name);
	private Sources src = new Sources();
	private Handler handle = new Handler();
	private MouseManager mouse = new MouseManager();
	//private GameState gs = new GameState();
	private KeyManager key = new KeyManager();
	private Text text = new Text();
	private State state = new State();
	private MenuState menu = new MenuState();
	//private Utilities util = new Utilities();
	private Typing typing = new Typing();
	private EditorKeys editorKeys = new EditorKeys();
	public static Point frameLocation = new Point(2000, 0);
	public static double FPS = 0;
	private Generator generator = new Generator();
	public void launch()
	{
		src.loadImages();
		text.loadFonts();
		menu.addLayout();
		Handler.util.setMouse();
		Material.GRASS = new Grass();
		//System.out.println(Material.GRASS.texture);
		//presets.makeInventory();
		//EntityManager.entities.add(new ThePlayer());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(frameLocation.x, frameLocation.y, (int) handle.screenWidth() / 2, (int) handle.screenHeight() / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setFocusable(true);
		frame.addMouseListener(mouse);
		frame.addKeyListener(key);
		frame.addKeyListener(typing);
		frame.addKeyListener(editorKeys);
		frame.addMouseWheelListener(mouse);
		frame.setIconImage(Sources.playerRightHead[0]);
		frame.addComponentListener(new ComponentAdapter() 
		{  
		        public void componentResized(ComponentEvent evt) 
		        {
		            Component c = (Component)evt.getSource();
		            Handler handle = new Handler();
		            handle.updateInfo();
		        }
		});
		
		frame.setVisible(true);
		
		//World/*.overworld = new BasicWorld(50, 50, );
		/*List<String> lines = Arrays.asList("The first line", "The second line");
		Path file = Paths.get("the-file-name.txt");
		*/
		
		//frame.setLayout(null);
		System.out.println("-----The Very Best Console-----");
		
		for(int row = 0; row < Maps.mapWidth; row++)
		{
			for(int col = 0; col < Maps.mapHeight; col++)
			{
				Handler.world.setMap(row, col);
			}
		}
		Recipe rec = new Recipe(new Container(Material.AIR, 1));
		rec.shape("DDD", "DDD", "DAD");
		rec.setIngredient('A', Material.GRASS);
		//generator.generateWorld();
		SaveWorld w = new SaveWorld();
		//w.test();
		//w.saveWorld(Handler.world.map);
		//Handler.world.map = w.readWorld();
		//w.readWorld();
		WorldManager wm = new WorldManager();
		wm.readChunk();
		System.out.println("Starting to generatate world...");
		Updater update = new Updater();
		
		for(int row = 0; row < Maps.mapWidth; row++)
		{
			for(int col = 0; col < Maps.mapHeight; col++)
			{
				World.shadeOverlay[row][col] = new ShadedTile(false, row, col, 15, 4, new Color(0, 0, 0, 0));
				//if(ran < 99)
				{
					//world.map[row][col] = new BasicMap(new Grass(), new Air(), null, row, col);
					//world.setMap(row, col);
					
					//world.setTile(new Grass(), row, col);
				}
				
				//else
				{
					
					//World.map[row][col].tile = new WaterSpread();
					//gen.generateWorld();
				}
				//else
				{
					//World.map[row][col] = new Tile(52, row, col, false, isSolid);
				}
			}
		}
		//Handler.lighting.lights.add(new BasicLight(400, 400, 500, 5));
		//Handler.lighting.lights.add(new BasicLight(800, 500, 500, 5));
		System.out.println("World Generation Finished at : " + (Updater.time / 10) + " Seconds");
		for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 7; col++)
			{
				InventoryManager.inventory[row][col] = new Slot(null, row, null, new JButton());
				InventoryManager.inventory[row][col].container = new Container(new Air(), 0);
				InventoryManager.inventory[row][col].container.material = new Empty();
				InventoryManager.inventory[row][col].container.material = new Air();
				InventoryManager.inventory[row][col].pos = new Rectangle2D.Double(row, col, 65, 65);
			}
		}
		
		Handler.lighting.makeLite();
		
		mouse.launch();
		frame.add(this);
		Handler.entity.getOnScreenEntities().add(new ThePlayer());
		Handler.entity.getOnScreenEntities().get(0).pos = new Rectangle2D.Double(Player.playerPosMem.x, Player.playerPosMem.y, 100, 100);
		
		gameLoop();
	}
	
	public void load(Graphics g)
	{
		
	}
	Rectangle2D.Double ayy = new Rectangle2D.Double(0, 0, 100, 100);
	public void update()
	{
		state.tick();
		handle.update();	
	}
	BufferedImage SCREEN = new BufferedImage(Handler.width, Handler.height, BufferedImage.TYPE_INT_ARGB);
	public void render()
	{
		frame.revalidate();
		frame.repaint();
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D gs = (Graphics2D) SCREEN.getGraphics();
		state.render((Graphics2D) g);
		g.drawImage(SCREEN, 0, 0, null);
		//dg.dispose();
	}
	
	public int r()
	{
		Random r = new Random();
		int e = r.nextInt(240 - 0) - 0;
		return e;
	}


boolean gameRunning = true;
double lastFpsTime = 0;
double fps = 0;

	public void gameLoop()
	{
	   long lastLoopTime = System.nanoTime();
	   final int TARGET_FPS = 60;
	   final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
	
	   while (gameRunning)
	   {
	      long now = System.nanoTime();
	      long updateLength = now - lastLoopTime;
	      lastLoopTime = now;
	     // double delta = updateLength / ((double)OPTIMAL_TIME);
	
	      lastFpsTime += updateLength;
	      fps++;
	      update();
	      render();
	      
	      //if(!KeyManager.esc)
	      {
	    	
	      }
	      
	      if (lastFpsTime >= 1000000000)
	      {
	    	//  System.out.println(fps);
	    	 FPS = fps;
	         lastFpsTime = 0;
	         fps = 0;
	         
	      }
	      
	  
	      double sleep = (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000;
	      if(sleep < 0)
	      {
	    	  sleep = 0;
	      }
	      try 
	      {
			Thread.sleep((long) sleep);
		  } 
	      catch (InterruptedException e) 
	      {
			e.printStackTrace();
		}
	   }
	}
}

