package items;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import engine.Handler;
import engine.Material;
import gfx.InventoryManager;
import gfx.Sources;
import gfx.Text;
import input.KeyManager;
import tile.Air;
import tile.groundtiles.Grass;
import tile.groundtiles.Sand;

public class Inventory 
{
	JButton[][] buttons = new JButton[10][3];
	Container[][] container = new Container[0][0];
	public JPanel panel = new JPanel();
	int containerCount = 0;
	public boolean isOpen = false;
	int width;
	int height;
	String name;
	public Inventory(String newName, int newWidth, int newHeight)
	{
		name = newName;
		width = newWidth;
		height = newHeight;
		container = new Container[width][height];
		 buttons = new JButton[width][height];
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				container[x][y] = new Container(Material.AIR, 0);
			}
		}
		
		addLayout();
	}
	public void set()
	{
		container[2][0].material = Material.GRASS;
	}
	public void focus()
	{
		panel.requestFocus();
	}
	int x = (int) (Handler.width / 2 - (width * 100 / 2));
	//int y = (width * 100);
	int fxWidth = (width * 100);
	//int fxHeight = 0;
	public void render(Graphics2D g)
	{
		if(isOpen)
		{
			x = (int) (Handler.width / 2 - (width * 100 / 2));
			fxWidth = (width * 100);
			containerCount = 0;
			g.setColor(new Color(109, 109, 109, 255));
			g.fillRect(x, 250, fxWidth, 50);
			g.setColor(Color.WHITE);
			g.setFont(Text.containerFont);
			g.drawString(name, x + 5, 290);
			FontMetrics fontMetrics = g.getFontMetrics();
			for(int row = 0; row < width; row++)
			{
				for(int col = 0; col < height; col++)
				{
					g.drawImage(Sources.CONTAINER_AREA, x + (row * 100), (col * 100) + 300, 100, 100, null);
					
					String count = container[row][col].count + "";
					if(!(container[row][col].material instanceof Air) && container[row][col].count > 0)
					{					
						g.drawImage(container[row][col].material.texture, x + (row * 100) + 10, (col * 100) + 310, 80, 80, null);
						g.drawString(count, (row * 100) + x + 100- (fontMetrics.stringWidth(count)), (col * 100) + 395);
						containerCount++;
					}
				}
			}
			String info = containerCount + "/" + width * height;
			g.drawString(info, x + fxWidth - (fontMetrics.stringWidth(info) / 2) - 35, 290);
			
			for(int row = 0; row < width; row++)
			{
				for(int col = 0; col < height; col++)
				{
					g.setColor(Color.RED);
					//buttons[row][col] = new JButton();
					//buttons[row][col].setOpaque(false);
					Rectangle bounds = new Rectangle(x + (row * 100), (col * 100) + 300, 100, 100);
					//g.fill(bounds);
				}
			}
		}
	}
	public void onPlace()
	{
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < height; col++)
			{
				container[row][col] = new Container(new Air(), 0);
				container[row][col].count = 0;
				container[row][col].material = new Empty();
				container[row][col].material = new Air();
			}
		}
		container[0][0].material = new Sand();
		container[0][0].count = 999;
	}
	public void addLayout()
	{
		panel.setBounds(0, 0, (int) Handler.width, (int) Handler.height);
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setFocusable(false);
		x = (int) (Handler.width / 2 - (width * 100 / 2));
		fxWidth = (width * 100);
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < height; col++)
			{
				buttons[row][col] = new JButton();
				buttons[row][col].setOpaque(false);
				Rectangle bounds = new Rectangle(x + (row * 100), (col * 100) + 300, 100, 100);
				buttons[row][col].setBounds(bounds);
				buttons[row][col].setBorder(null);
				buttons[row][col].setBorderPainted(false);
		        buttons[row][col].setContentAreaFilled(false);
				int x = row;
				int y = col;
				
				buttons[row][col].addActionListener(new ActionListener() 
				  {
				    public void actionPerformed(ActionEvent e) 
				    {
				    	Game.frame.requestFocus();
				    	if(container[x][y].count == 0 )
				    	{	 
					    	putItems(x, y);
				    	}
				    	else if(container[x][y].count > 0)
				    	{
					    	if(InventoryManager.inventory[0][1].container.count == 0)
					    	{
					    		if(KeyManager.shift)
					    		{
					    			if(openSlot())
					    			{
					    				int xPos = getNextOpenSlot().x;
					    				int yPos = getNextOpenSlot().y;
					    				shiftSwap(xPos, yPos, x, y);
					    			}
					    		}
					    		else
					    		{
					    			takeItems(x, y);
					    		}
					    	}
					    	else
					    	{
					    		swapItems(x, y);
					    	}
				    	}
				    }
				  });
				panel.add(buttons[row][col]);
			}
		}
		Game.frame.add(panel);
	}

	public void removeLayout()
	{
		Game.frame.remove(panel);
	}

	public void putItems(int x, int y)
	{
		container[x][y] = new Container(InventoryManager.inventory[0][1].container.material, InventoryManager.inventory[0][1].container.count);
    	InventoryManager.inventory[0][1].container.material = new Air();
    	InventoryManager.inventory[0][1].container.material = new Empty();
    	InventoryManager.inventory[0][1].container.count = 0;
	}
	public Point getNextOpenSlot()
	{
		for(int col = 0; col < height; col++)
		{
			for(int row = 0; row < width; row++)
			{
				if(container[row][col].count <= 0)
				{
					Point pos = new Point(row, col);
					return pos;
				}
			}
		}
		return null;
	}
	public boolean openSlot()
	{
		for(int col = 0; col < height; col++)
		{
			for(int row = 0; row < width; row++)
			{
				if(container[row][col].count <= 0)
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean openHotbar()
	{
		for(int col = 0; col < 1; col++)
		{
			for(int row = 0; row < 10; row++)
			{
				if(InventoryManager.inventory[row][col].container.count <= 0)
				{
					return true;
				}
			}
		}
		return false;
	}
	public Point getNextHotbar()
	{
		for(int col = 0; col < 1; col++)
		{
			for(int row = 0; row < 10; row++)
			{
				if(InventoryManager.inventory[row][col].container.count <= 0)
				{
					Point pos = new Point(row, col);
					return pos;
				}
			}
		}
		return null;
	}
	public void shiftSwap(int x, int y, int oldX, int oldY)
	{
		container[x][y] = new Container(InventoryManager.inventory[oldX][oldY].container.material, InventoryManager.inventory[oldX][oldY].container.count);
		
		InventoryManager.inventory[oldX][oldY].container.material = new Air();
		InventoryManager.inventory[oldX][oldY].container.material = new Empty();
		InventoryManager.inventory[oldX][oldY].container.count = 0;
	}
	public void takeItems(int x, int y)
	{
		InventoryManager.inventory[0][1].container = new Container(container[x][y].material, container[x][y].count);
		container[x][y].material = new Air();
		container[x][y].material = new Empty();
		container[x][y].count = 0;
	}
	public void swapItems(int x, int y)
	{
		InventoryManager.inventory[1][1].container = InventoryManager.inventory[x][y].container;
		
		InventoryManager.inventory[x][y].container = InventoryManager.inventory[0][1].container;

		InventoryManager.inventory[0][1].container = InventoryManager.inventory[1][1].container;
	}
	
}
