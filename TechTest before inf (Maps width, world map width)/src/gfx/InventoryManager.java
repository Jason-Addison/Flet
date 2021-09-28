package gfx;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Game;
import engine.Handler;
import engine.Material;
import input.KeyManager;
import items.Container;
import items.Empty;
import items.Slot;
import misc.InventoryPresets;
import tile.Air;
import tile.groundtiles.Sign;

public class InventoryManager implements ActionListener
{

	public static int selectedInv = 0;
	int inventoryCount = 9;
	public static Slot[][] inventory = new Slot[10][7];
	boolean launch = true;
	public JPanel hotbar = new JPanel();
	public JButton[] hotbarButtons = new JButton[10];
	private Text text = new Text();
	public Rectangle[] buttonPos = new Rectangle[10];
	public static boolean inventoryOpen = false;
	private InventoryPresets presets = new InventoryPresets();
	static boolean invLaunch = true;
	public static JPanel mainInv = new JPanel();
	public static boolean inContainer = false;
	public void tick()
	{
		if(selectedInv < 0)
		{
			selectedInv = inventoryCount;
		}
		if(selectedInv > 9)
		{
			selectedInv = 0;
		}
		if(inventory[selectedInv][0].container != null)
		{
			if(inventory[selectedInv][0].container.count <= 0)
			{
				inventory[selectedInv][0].container.count = 0;
			}
		}
		if(!inventoryOpen)
		{
			//invLaunch = true;
			Game.frame.remove(mainInv);
		}
		else
		{
			Game.frame.add(mainInv);
		}
		if(inventoryOpen)
		{
			if(invLaunch)
			{
				System.out.println(inventory[0][0].container.material.texture);
				invLaunch = false;
				mainInv.setLayout(null);
				mainInv.setOpaque(false);
				Game.frame.add(mainInv);
			
				for(int row = 0; row < 10; row++)
				{
					for(int col = 2; col < 7; col++)
					{
						int x = row;
						int y = col; 
						
						
						inventory[row][col].button.setOpaque(false);
						inventory[row][col].button.setBounds((int) inventory[row][col].pos.x  * 120 + 368 - 6, (int) inventory[row][col].pos.y * 120 + 62, 70, 70);
						inventory[row][col].button.addActionListener(new ActionListener() 
								  {
								    public void actionPerformed(ActionEvent e) 
								    {
								    	Game.frame.requestFocus();
								    	//selectedInv = x;
								    	
								    	boolean tempLock = false;
								    	if(inventory[x][y].container.count > 0)
								    	{
								    		if(KeyManager.shift)
								    		{
								    			if(openHotbar())
								    			{
								    				int xPos = getNextHotbar().x;
								    				int yPos = getNextHotbar().y;
								    				shiftSwap(xPos, yPos, x, y);
								    			}
								    		}
									    	else if(inventory[0][1].container.count == 0)
									    	{
									    		takeItems(x, y);
									    		tempLock = true;
									    	}
									    	else
									    	{
									    		swapItems(x, y);
									    	}
								    	}
								    	//else if(inventory[x][y].item == inventory[0][1].item)
							    		//{
							    		//}
								    	else if(inventory[x][y].container.count == 0 && !tempLock)
								    	{	
									    	putItems(x, y);
								    	}
								      Game.frame.requestFocusInWindow();
								      Game.frame.requestFocus();
								    }
								  }
								);
						mainInv.add(inventory[row][col].button);
					}
				}
			}
		}
		if(launch)
		{
			hotbar.setLayout(null);
			hotbar.setBounds(0, 0, (int) Handler.width, (int) Handler.height);
			for(int row = 0; row < 10; row++)
			{
				for(int col = 0; col < 1; col++)
				{
					int x = row;
					int y = col; 
					double dif = (Handler.width / 2 - ((74 * 10) / 2));
					inventory[0][1].pos = new Rectangle2D.Double(0, 0, 65, 65);
					inventory[row][col].pos = new Rectangle2D.Double(row, col, 65, 65);
					inventory[row][col].button.setOpaque(false);
					inventory[row][col].button.setBounds( (int) dif + (int) (row * 74), (int) (Handler.height - 90), 70, 70);
					inventory[row][col].button.addActionListener(new ActionListener() 
							  {
							    public void actionPerformed(ActionEvent e) 
							    {
							    	
							    	Game.frame.requestFocus();
							    	//selectedInv = x;
							    	
							    	//if(inventory[x][y].item == inventory[0][1].item)
						    		{
							    		//Combine items
						    		}
							    	if(inventory[x][y].container.count == 0 )//&& inventory[0][1].container.count > 1)
							    	{	 
								    	putItems(x, y);
					
							    	}
							    	else if(inventory[x][y].container.count > 0)
							    	{
								    	if(inventory[0][1].container.count == 0)
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
							      Game.frame.requestFocusInWindow();
							      Game.frame.requestFocus();
							    }
							  }
							);
					hotbar.add(inventory[row][col].button);
				}
			}
			hotbar.setOpaque(false);
			Game.frame.add(hotbar);
			presets.makeInventory();
			launch = false;
		}
		if(selectedInv < 0)
		{
			selectedInv = inventoryCount;
		}
		if(selectedInv > 9)
		{
			selectedInv = 0;
		}
		//inventory[3][0].image = Sources.tree;
		//inventory[3][1].container = inventory[selectedInv][0].container;
    	
		inventory[3][1].container = inventory[selectedInv][0].container;
		inventory[0][1].pos.x = Handler.mouseX;
		inventory[0][1].pos.y = Handler.mouseY;
		 if(!Sign.typing)
		 {
			 Game.frame.requestFocusInWindow();
		      Game.frame.requestFocus();
		 }
		 else
		 {
			// Sign.signTextField.request ();
		 }
	}
	double dif = (Handler.width / 2 - ((74 * 10) / 2));
	int invScale = (int) (Handler.width / 17);
	public void render(Graphics g)
	{
		double dif = (Handler.width / 2 - ((74 * 10) / 2));
		double respos = (Handler.width / 2) - (460 / 2);
		
		for(int i = 0; i < 10; i++)
		{
			g.drawImage(Sources.hotbar, (int) dif + (int) (i * 74), (int) (Handler.height - 90), 70, 70, null);
		}
		g.drawImage(Sources.invSelect, 597 + (selectedInv * 74), (int) Handler.height - 83, 55, 55, null);
		if(inventoryOpen)
		{
			g.drawImage(Sources.inventory, 230, 100, (int) Handler.width - 460, (int) Handler.height - 200, null);
			for(int row = 0; row < 10; row++)
			{
				for(int col = 2; col < 7; col++)
				{
					g.drawImage(Sources.hotbar, 350 + (row * 120), (col * 120) + 50, 100, 100, null);
					if(!(inventory[row][col].container.material instanceof Empty))
					{
						g.drawImage(inventory[row][col].container.material.texture, (int) inventory[row][col].pos.x  * 120 + 368, (int) inventory[row][col].pos.y * 120 + 67, (int) inventory[row][col].pos.width, (int)inventory[row][col].pos.height, null);
					}
					else if(!(inventory[row][col].container.material instanceof Air))
					{
						g.drawImage(inventory[row][col].container.material.texture, (int) inventory[row][col].pos.x  * 120 + 368, (int) inventory[row][col].pos.y * 120 + 67, (int) inventory[row][col].pos.width, (int)inventory[row][col].pos.height, null);
					}
					g.setColor(Color.WHITE);
					g.setFont(Text.inventoryStackCount);
					FontMetrics fontMetrics = g.getFontMetrics();
					String stackCount = inventory[row][col].container.count + "";
					if(!(inventory[row][col].container.count <= 0))
					{
						g.drawString(inventory[row][col].container.count + "", (int) inventory[row][col].pos.x  * 120 + 441 - fontMetrics.stringWidth(stackCount), (int) inventory[row][col].pos.y * 120 + 140);
					}
				}
			}
		}
		for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 1; col++)
			{
				if(!(inventory[row][col].container.material instanceof Empty))
				{
					
					g.drawImage(inventory[row][col].container.material.texture, (int) dif + (row * 74) +  (int) (Handler.width / 150), (int) Handler.height - 78, (int) 45, (int) 45, null);
				}
				else if(!(inventory[row][col].container.material instanceof Air))
				{
					
					g.drawImage(inventory[row][col].container.material.texture, (int) dif + (row * 74) +  (int) (Handler.width / 150), (int) Handler.height - 78, (int) 45, (int) 45, null);
				}
				g.setColor(Color.WHITE);
				g.setFont(Text.inventoryStackCount);
				FontMetrics fontMetrics = g.getFontMetrics();
				String stackCount = inventory[row][col].container.count + "";
				if(!(inventory[row][col].container.count <= 0))
				{
				g.drawString(inventory[row][col].container.count + "", (int) inventory[row][col].pos.x * 74 + 650 - fontMetrics.stringWidth(stackCount), (int) inventory[row][col].pos.y + 1050);
				}
			}
		}
		g.setColor(Color.WHITE);
		g.setFont(Text.inventoryStackCount);
		FontMetrics fontMetrics = g.getFontMetrics();
		if(!inventoryOpen)
		{
			/*if(!(inventory[3][1].container.material instanceof Air))
			{
				g.drawImage(inventory[3][1].container.material.texture, (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y - 30, 100, 100, null);
			}
			else if(!(inventory[3][1].container.material instanceof Empty))
			{
				g.drawImage(inventory[3][1].container.material.texture, (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y - 30, 100, 100, null);
			}
			
			if(!(inventory[3][1].container.count <= 0))
			{
				g.drawString(inventory[3][1].container.count + "", (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y);
			}*/
			//g.drawImage(Sources.MOUSE_NOINTERACT, (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y, 30, 30, null);
			if(!(inventory[0][1].container.material instanceof Air))
			{
				g.drawImage(inventory[0][1].container.material.texture, (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y - 30, 100, 100, null);
			}
			else if(!(inventory[0][1].container.material instanceof Empty))
			{
				g.drawImage(inventory[0][1].container.material.texture, (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y - 30, 100, 100, null);
			}
			if(!(inventory[0][1].container.count <= 0))
			{
				g.drawString(inventory[0][1].container.count + "", (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y);
			}
		}
		if(inventoryOpen)
		{
			if(!(inventory[0][1].container.material instanceof Air))
			{
				g.drawImage(inventory[0][1].container.material.texture, (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y - 30, 100, 100, null);
			}
			else if(!(inventory[0][1].container.material instanceof Empty))
			{
				g.drawImage(inventory[0][1].container.material.texture, (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y - 30, 100, 100, null);
			}
			if(!(inventory[0][1].container.count <= 0))
			{
				g.drawString(inventory[0][1].container.count + "", (int) inventory[0][1].pos.x, (int) inventory[0][1].pos.y);
			}
		}
		String itemName = "";
		if(!(inventory[selectedInv][0].container.material instanceof Empty))
		{
			itemName = inventory[selectedInv][0].container.material.name;
		}
		else if(!(inventory[selectedInv][0].container.material instanceof Air))
		{
			itemName = inventory[selectedInv][0].container.material.name;
		}
		if(!itemName.equals("Empty"))
		{
			g.drawString(itemName, (int) Handler.width / 2 - (fontMetrics.stringWidth(itemName) / 2), 970);
		}
		g.setColor(Color.RED);
		for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 1; col++)
			{
				//g.fillRect((int) inventory[row][col].pos.x  * 74 + 590, 990, 70, 70);
			}
		}
	}
	
	public void setInvSelect(int wheel)
	{
		selectedInv += wheel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
	public void e (Container con)
	{
		
	}
	public int getStackCount(int row, int col)
	{
		return inventory[row][col].container.count;
	}
	public void decreaseStackCount(int row, int col, int amount)
	{
		inventory[row][col].container.count -= amount;
	}
	public Point getNextOpenSlot()
	{
		for(int col = 2; col < 7; col++)
		{
			for(int row = 0; row < 10; row++)
			{
				if(inventory[row][col].container.count <= 0)
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
		for(int col = 2; col < 7; col++)
		{
			for(int row = 0; row < 10; row++)
			{
				if(inventory[row][col].container.count <= 0)
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
				if(inventory[row][col].container.count <= 0)
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
				if(inventory[row][col].container.count <= 0)
				{
					Point pos = new Point(row, col);
					return pos;
				}
			}
		}
		return null;
	}
	public Material getTile()
	{
		return inventory[selectedInv][0].container.material;
	}
	public void removeItem(int x, int y)
	{
		inventory[x][y].container.material = new Air();
    	inventory[x][y].container.material = new Empty();
    	inventory[x][y].container.count = 0;
	}
	public void shiftSwap(int x, int y, int oldX, int oldY)
	{
		inventory[x][y].container = new Container(inventory[oldX][oldY].container.material, inventory[oldX][oldY].container.count);
		
		inventory[oldX][oldY].container.material = new Air();
    	inventory[oldX][oldY].container.material = new Empty();
    	inventory[oldX][oldY].container.count = 0;
	}
	public void putItems(int x, int y)
	{
		inventory[x][y].container = new Container(inventory[0][1].container.material, inventory[0][1].container.count);
		
    	inventory[0][1].container.material = new Air();
    	inventory[0][1].container.material = new Empty();
    	inventory[0][1].container.count = 0;
	}
	public void takeItems(int x, int y)
	{
		inventory[0][1].container = new Container(inventory[x][y].container.material, inventory[x][y].container.count);
		inventory[x][y].container.material = new Air();
    	inventory[x][y].container.material = new Empty();
    	inventory[x][y].container.count = 0;
	}
	public void swapItems(int x, int y)
	{
		inventory[1][1].container = inventory[x][y].container;
		
		inventory[x][y].container = inventory[0][1].container;

		inventory[0][1].container = inventory[1][1].container;
	}
}
