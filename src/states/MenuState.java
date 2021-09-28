package states;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import engine.Handler;
import engine.Utilities;
import gfx.Sources;
import gfx.Text;
import maps.Maps;
import tile.Air;
import tile.BasicMap;
import tile.animated.DeepWater;
import tile.groundtiles.Sand;
import tile.ongroundtiles.Stick;

public class MenuState
{

	private Utilities util = new Utilities();
	boolean launch = true;
	JPanel menuPanel = new JPanel();
	static Rectangle gameBounds = new Rectangle();
	static Rectangle editorBounds = new Rectangle();
	static Rectangle optionsBounds = new Rectangle();
	static Rectangle quitBounds = new Rectangle();
	int buttonWidth = 800;
	static int tile = 1;
	public BasicMap[][] menuBackground = new BasicMap[30][20];
	private DeepWater deepWater = new DeepWater();
	public void tick()
	{
		
		deepWater.animate();
		if(launch)
		{
			launch = false;
			for(int row = 0; row < 30; row++)
			{
				for(int col = 0; col < 15; col++)
				{
					menuBackground[row][col] = new BasicMap(new Air(), new Air(), null, row, col);
					menuBackground[row][col].tile = new Sand();
				}
			}
			menuBackground[10][4].tileOnGround = new Stick();
			menuBackground[4][11].tileOnGround = new Stick();
			menuBackground[14][13].tileOnGround = new Stick();
			menuBackground[10][4].tileOnGround.onPlace();
		}
	}
	private DeepWater water = new DeepWater();
	public void render(Graphics2D g)
	{
		for(int row = 0; row < 30; row++)
		{
			for(int col = 0; col < 15; col++)
			{
			//	menuBackground[row][col] = new Tile(new Grass(), new Grass(), row, col);
				g.drawImage(menuBackground[row][col].tile.getTexture(), row * Maps.tileScale, col * Maps.tileScale, Maps.tileScale, Maps.tileScale, null);
				g.drawImage(menuBackground[row][col].tileOnGround.getTexture(), row * Maps.tileScale, col * Maps.tileScale, Maps.tileScale, Maps.tileScale, null);
			}
		}
		//g.fill(gameBounds);
		//g.fill(editorBounds);
		//g.fill(optionsBounds);
		//g.fill(quitBounds);
		g.setFont(Text.title);
		g.setColor(Color.BLACK);
		FontMetrics fontMetrics = g.getFontMetrics();
		String title = "Flet";
		g.drawString(title,  20, 170);
		g.setColor(Color.WHITE);
		g.drawString(title,  20, 170);
		g.setFont(Text.MENU_OPTIONS);
		
		g.setColor(new Color(0, 0, 0, 100));
		if(opt1)
		{
			g.fillRect(20, 330, 410, 90);
		}
		
		if(opt2)
		{
			g.fillRect(20, 430, 410, 90);
		}
		
		if(opt3)
		{
			g.fillRect(20, 530, 410, 90);
		}
		
		if(opt4)
		{
			g.fillRect(20, 630, 410, 90);
		}
		g.setColor(Color.WHITE);
		g.drawString("Singleplayer", 20, 400);
		g.drawString("Editor", 20, 500);
		g.drawString("Options", 20, 600);
		g.drawString("Quit", 20, 700);
	}
	public void mouseHover(Graphics2D g, int y, int width)
	{
		g.fillRect(5, y - 75, width / 2 - 80, 10);
		g.fillRect(5, y - 75, 10, 80);
		g.fillRect(width / 2 - 85, y - 70, 10, 80);
	}
	boolean opt1 = false;
	boolean opt2 = false;
	boolean opt3 = false;
	boolean opt4 = false;
	public void addLayout()
	{
		gameBounds = new Rectangle(20, 330, 410, 90);
		editorBounds = new Rectangle(20, 430, 410, 90);
		optionsBounds = new Rectangle(20, 530, 410, 90);
		quitBounds = new Rectangle(20, 630, 410, 90);
		
		JButton game = new JButton();
		game.setBounds(gameBounds);
		JButton editor = new JButton();
		editor.setBounds(editorBounds);
		JButton options = new JButton();
		options.setBounds(optionsBounds);
		JButton quit = new JButton();
		quit.setBounds(quitBounds);
		menuPanel.setLayout(null);
		menuPanel.setOpaque(false);
		game.setOpaque(false);
		game.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
               opt1 = true;
            }
            @Override
            public void mouseExited(MouseEvent me) {
            	opt1 = false;
            }
        });
		game.setContentAreaFilled(false);
		game.setBorderPainted(false);
		editor.setOpaque(false);
		editor.setContentAreaFilled(false);
		editor.setBorderPainted(false);
		editor.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
               opt2 = true;
            }
            @Override
            public void mouseExited(MouseEvent me) {
            	opt2 = false;
            }
        });
		options.setOpaque(false);
		options.setContentAreaFilled(false);
		options.setBorderPainted(false);
		options.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
               opt3 = true;
            }
            @Override
            public void mouseExited(MouseEvent me) {
            	opt3 = false;
            }
        });
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		quit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
               opt4 = true; 
            }
            @Override
            public void mouseExited(MouseEvent me) {
            	opt4 = false;
            }
        });
		
		menuPanel.add(game);
		menuPanel.add(editor);
		menuPanel.add(options);
		menuPanel.add(quit);
		game.addActionListener(new ActionListener() 
		  {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	State.currentState =2;//4
		    	Handler.worldselect.init();
		    	removeLayout();
		    }
		  });
		editor.addActionListener(new ActionListener() 
		  {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	State.currentState = 3;
		    	removeLayout();
		    }
		  });
		for(int row = 0; row < 30; row++)
		{
			for(int col = 0; col < 15; col++)
			{
				menuBackground[row][col] = new BasicMap(new Air(), new Air(), null, row, col);
			}
		}
		Game.frame.add(menuPanel);
	}
	public void removeLayout()
	{
		Game.frame.remove(menuPanel);
		launch = true;
	}
	public void getRandomTile()
	{
		int randomTile = util.randomNumber(200, 1);
		int random = util.randomNumber(3, 0);
		if(random == 2)
		{
			tile = 1;
		}
		else
		{
			if(Sources.tiles[randomTile] == null)
			{
				getRandomTile();
			}
			else
			{
				tile = randomTile;
			}
		}
	}
}
