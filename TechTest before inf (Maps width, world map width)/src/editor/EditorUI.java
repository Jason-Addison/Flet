package editor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import engine.BasicWorld;
import engine.Game;
import engine.Handler;
import gfx.Sources;
import gfx.Text;
import tile.Air;
import tile.BasicMap;
import tile.groundtiles.Grass;

public class EditorUI
{

	public static int editorScale = 30;
	private EditorCamera ec = new EditorCamera();
	public static BasicWorld loadedWorld = new BasicWorld(null, 0, 0);
	//private Editing editing = new Editing();
	int x = 0;
	int y = 0;
	Rectangle background = new Rectangle(0, 0, (int) Handler.width, (int) Handler.height);
	Area a = new Area(new Rectangle(0, 0, (int) Handler.width, (int) Handler.height));
	private Editing editing = new Editing();
	boolean kappa = true;
	Rectangle newMapRec = new Rectangle(30, 60, 60, 60);
	public void tick()
	{
		Game.frame.requestFocusInWindow();
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(180, 180, 180, 255));
		g.fillRect(30, 150, 1300, 850);
		editor(g);
		a.subtract(new Area(new Rectangle(30, 150, 1300, 850)));
		g.setColor(Color.WHITE);
		g.fill(a);
		g.drawImage(Sources.GUI_MAGNIFY, 1000, 55, 70, 70, null);
		g.setFont(Text.editorTitle);
		g.setColor(Color.BLACK);
		g.drawString(editorScale + "%", 1010, 140);
		g.setColor(new Color(100, 100, 100, 255));
		g.fillRect(0, 0, (int) Handler.width, 50);
		g.setColor(new Color(90, 90, 90, 255));
		g.fillRect(0, 40, (int) Handler.width, 10);
		g.setFont(Text.editorTitle);
		g.setColor(Color.WHITE);
		g.drawString("Terrain Editor", 10, 35);
		if(Editing.cannotPlace)
		{
			error(g, "Out of Bounds!");
		}
		g.setColor(Color.BLACK);
		g.setFont(Text.time);
		g.drawImage(Sources.GUI_NEWMAP, newMapRec.x, newMapRec.y, newMapRec.width, newMapRec.height, null);
		g.drawString("X : " + editing.getMouse().x, 40, 1060);
		g.drawString("Y : " + editing.getMouse().y, 250, 1060);
		g.drawString("Tile : ", 460, 1060);
		int x = editing.getMouse().x;
		int y = editing.getMouse().y;
		if(x > 0 && y > 0 && x < loadedWorld.width && y < loadedWorld.height)
		{
			g.drawImage(loadedWorld.map[x][y].tile.getTexture(), 600, 1010, 60, 60, null);
		}
		g.setColor(new Color(255, 0, 0, 100));
		g.fillRect(x * editorScale - (int) ec.getCamX(), y * editorScale - (int) ec.getCamY(), editorScale, editorScale);
	}
	public void editor(Graphics2D g)
	{
		if(kappa)
		{
			addLayout();
		}
		x = (int) (ec.getCamX() / editorScale) - 0;
		y = (int) (ec.getCamY() / editorScale) - 0;
		if(x <= 0)
		{
			x = 0;
		}
		if(y <= 0)
		{
			y = 0;
		}
		
		for(int col = y; col < (loadedWorld.height); col++)
		{
			for(int row = x; row < (loadedWorld.width); row++)
			{
				{
					g.drawImage(loadedWorld.map[row][col].tile.getTexture(), row * editorScale -(int) ec.getCamX(), col * editorScale - (int) ec.getCamY(), editorScale, editorScale, null);
					g.drawImage(loadedWorld.map[row][col].tileOnGround.getTexture(), row * editorScale - (int) ec.getCamX(), col * editorScale - (int) ec.getCamY(), editorScale, editorScale, null);
				}
			}
		
		}
		//World.map[mouseX][mouseY].tile = new Sand();
	}
	
	public void zoom(int amount)
	{
		editorScale -= amount;
		EditorCamera.cameraPos.x += 1;
	}
	public void error(Graphics2D g, String problem)
	{
		g.drawImage(Sources.GUI_ERROR, 1220, 160, 100, 100, null);
	}
	public void addLayout()
	{
		JPanel editorPanel = new JPanel();
		editorPanel.setOpaque(false);
		editorPanel.setLayout(null);
		JButton newMap = new JButton();
		newMap.setOpaque(false);
		newMap.setBounds(newMapRec);
		editorPanel.add(newMap);
		newMap.addActionListener(new ActionListener() 
		  {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	newMap();
		    }
		  });
		Game.frame.add(editorPanel);
	}
	JFrame newMap = new JFrame("New Map");
	public void newMap()
	{
		JTextField mapName = new JTextField("my_map");
		mapName.setVisible(true);
		mapName.setBounds(220, 10, 260, 50);
		
		JTextField mapWidth = new JTextField("100");
		mapWidth.setVisible(true);
		mapWidth.setBounds(220, 70, 260, 50);
		
		JTextField mapHeight = new JTextField("100");
		mapHeight.setVisible(true);
		mapHeight.setBounds(220, 130, 260, 50);
		
		newMap.setFont(Text.inventoryStackCount);
		newMap.setIconImage(Sources.GUI_NEWMAP);
		
		mapName.setFont(Text.editorTitle);
		mapWidth.setFont(Text.editorTitle);
		mapHeight.setFont(Text.editorTitle);
		
		JTextArea mapNameText = new JTextArea("Map Name :");
		mapNameText.setFont(Text.editorTitle);
		mapNameText.setEditable(false);
		mapNameText.setVisible(true);
		mapNameText.setBounds(10, 10, 200, 50);
		JTextArea mapWidthText = new JTextArea("Map Width :");
		mapWidthText.setFont(Text.editorTitle);
		mapWidthText.setEditable(false);
		mapWidthText.setVisible(true);
		mapWidthText.setBounds(10, 70, 200, 50);
		
		JTextArea mapHeightText = new JTextArea("Map Height :");
		mapHeightText.setFont(Text.editorTitle);
		mapHeightText.setEditable(false);
		mapHeightText.setVisible(true);
		mapHeightText.setBounds(10, 130, 200, 50);
		
		JButton createMap = new JButton("Create");
		createMap.setVisible(true);
		createMap.setBounds(150, 200, 180, 50);
		createMap.setFont(Text.editorTitle);
		
		createMap.addActionListener(new ActionListener() 
		  {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	int width = Integer.parseInt(mapWidth.getText());
		    	int height = Integer.parseInt(mapHeight.getText());
		    	createMap(mapName.getText(), width, height);
		    }
		  });
		
		newMap.add(mapNameText);
		newMap.setLayout(null);
		newMap.add(mapName);
		newMap.add(mapWidthText);
		newMap.add(mapHeightText);
		newMap.add(mapWidth);
		newMap.add(mapHeight);
		newMap.add(createMap);
		newMap.setBounds(Game.frameLocation.x, 500, 500, 300);
		newMap.setVisible(true);
		kappa = false;
	}
	public void createMap(String name, int width, int height)
	{
		BasicWorld newWorld = new BasicWorld("new Map", width, height);
		//newMap.map = new BasicMap[2][2]();
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < height; col++)
			{
				newWorld.map[row][col] = new BasicMap(new Grass(), new Air(), null, row, col);
				//newMap.map[row][col].tile = new Air();
				newWorld.map[row][col].x = row;
				newWorld.map[row][col].y = col;
			}
		}
		loadedWorld = new BasicWorld(" ", width, height);
		loadedWorld.width = width;
		loadedWorld.height = height;
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < height; col++)
			{
				loadedWorld.map[row][col] = new BasicMap(new Air(), new Air(), null, row, col);
				loadedWorld.map[row][col].tile = newWorld.map[row][col].tile;
				loadedWorld.map[row][col].tileOnGround = newWorld.map[row][col].tileOnGround;
				loadedWorld.map[row][col].x = newWorld.map[row][col].x;
				loadedWorld.map[row][col].y = newWorld.map[row][col].y;
			}
		}
		newMap.dispatchEvent(new WindowEvent(Game.frame, WindowEvent.WINDOW_CLOSING));
	}
}
