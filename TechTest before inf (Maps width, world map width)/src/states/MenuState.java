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
	Rectangle gameBounds = new Rectangle();
	Rectangle editorBounds = new Rectangle();
	Rectangle optionsBounds = new Rectangle();
	Rectangle quitBounds = new Rectangle();
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
		g.fill(gameBounds);
		g.fill(editorBounds);
		g.fill(optionsBounds);
		g.fill(quitBounds);
		g.setFont(Text.title);
		g.setColor(Color.BLACK);
		FontMetrics fontMetrics = g.getFontMetrics();
		String title = "Ayy lmao";
		g.drawString(title,  (int) Handler.width / 2 - (fontMetrics.stringWidth(title) / 2) - 10, 200);
		g.setColor(Color.WHITE);
		g.drawString(title,  (int) Handler.width / 2 - (fontMetrics.stringWidth(title) / 2), 200);
		g.setFont(Text.MENU_OPTIONS);
		g.drawString("Singleplayer", 20, 400);
		if(opt1)
		{
			mouseHover(g, 400, fontMetrics.stringWidth("Singleplayer"));
		}
		g.drawString("Ebola", 20, 500);
		if(opt1)
		{
			mouseHover(g, 500, fontMetrics.stringWidth("Ebola   "));
		}
		g.drawString("Options", 20, 600);
		if(opt1)
		{
			mouseHover(g, 600, fontMetrics.stringWidth("Options"));
		}
		g.drawString("Quit", 20, 700);
		if(opt1)
		{
			mouseHover(g, 700, fontMetrics.stringWidth("Quit"));
		}
	}
	public void mouseHover(Graphics2D g, int y, int width)
	{
		g.fillRect(5, y - 75, width / 2 - 80, 10);
		g.fillRect(5, y - 75, 10, 80);
		g.fillRect(width / 2 - 85, y - 70, 10, 80);
	}
	boolean opt1 = true;
	boolean opt2 = false;
	boolean opt3 = false;
	boolean opt4 = false;
	public void addLayout()
	{
		gameBounds = new Rectangle(((int) (Handler.width / 2) - ((buttonWidth / 2))), 100, buttonWidth, 130);
		editorBounds = new Rectangle(((int) (Handler.width / 2) - ((buttonWidth / 2))), 550, buttonWidth, 130);
		optionsBounds = new Rectangle(((int) (Handler.width / 2) - ((buttonWidth / 2))), 700, buttonWidth, 130);
		quitBounds = new Rectangle(((int) (Handler.width / 2) - ((buttonWidth / 2))), 850, buttonWidth, 130);
		
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
                System.out.println("XDD good mmememmee");
            }
            @Override
            public void mouseExited(MouseEvent me) {
                System.out.println(":((");
            }
        });
		game.setContentAreaFilled(false);
		game.setBorderPainted(false);
		editor.setOpaque(false);
		editor.setContentAreaFilled(false);
		editor.setBorderPainted(false);
		options.setOpaque(false);
		options.setContentAreaFilled(false);
		options.setBorderPainted(false);
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		menuPanel.add(game);
		menuPanel.add(editor);
		menuPanel.add(options);
		menuPanel.add(quit);
		game.addActionListener(new ActionListener() 
		  {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	State.currentState = 2;
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
