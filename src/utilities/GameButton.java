package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import engine.Handler;
import gfx.Sources;
import states.MenuState;
import states.State;

public class GameButton implements ActionListener, MouseListener
{

	JButton button = new JButton();
	Rectangle bounds;
	String text;
	int textSize = 20;
	Font font;
	protected boolean pressed = false;
	boolean LOCKED = false;
	public GameButton(int x, int y, int width, int height, String buttonText)
	{
		bounds = new Rectangle(x, y, width, height);
		text = buttonText;
		textSize = buttonText.length() * 2;
		setUpButton();
	}
	public void setUpButton()
	{
		button.setBounds(bounds);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(this);
		button.addMouseListener(this);
		button.addActionListener(new ActionListener() 
		  {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	
		    }
		  });
	}
	public void addActionListener(MenuState e)
	{
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		onClick();
	}
	public void onClick()
	{
		
	}
	public void onMouseEnter()
	{
		
	}
	public void onMouseExit()
	{
		
	}
	public void onMouseClick()
	{
		
	}
	public void onMousePress()
	{
		
	}
	public void onMouseRelease()
	{
		
	}
	public void lock()
	{
		LOCKED = true;
	}
	public void unlock()
	{
		LOCKED = false;
	}
	public boolean isPressed()
	{
		return pressed;
	}
	public void setBounds(int x, int y, int width, int height)
	{
		button.setBounds(x, y, width, height);
	}
	public void setBounds(Rectangle b)
	{
		button.setBounds(b);
	}
	public JButton getButton()
	{
		return button;
	}
	public void draw(Graphics2D g)
	{
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	Color color = Color.WHITE;
	public void setFont(Font font)
	{
		this.font = font;
	}
	public void setColor(Color c)
	{
		color = c;
	}
	public void render(Graphics2D g)
	{
		g.setColor(new Color(200, 200, 200, 255));
		if(button.getModel().isPressed())
		{
			g.drawImage(Sources.BUTTON_LOCKED, button.getBounds().x, button.getBounds().y, button.getBounds().width, button.getBounds().height, null );
		}
		else if(button.getModel().isRollover())
		{
			g.drawImage(Sources.BUTTON_HOVER, button.getBounds().x, button.getBounds().y, button.getBounds().width, button.getBounds().height, null );
		}
		
		else
		{
			g.drawImage(Sources.BUTTON, button.getBounds().x, button.getBounds().y, button.getBounds().width, button.getBounds().height, null );
		}
		g.setFont(Handler.text.setFont(textSize));
		FontMetrics font = g.getFontMetrics();
		g.setColor(color);
		g.drawString(text, bounds.x + (bounds.width / 2 ) - (font.stringWidth(text) / 2), 
				bounds.y + (bounds.height / 2) + (font.getHeight() / 3));
	}
	public String getText()
	{
		return text;
	}
	public void setText(String newText)
	{
		text = newText;
	}
	@Override
	public void mouseClicked(MouseEvent m)
	{
		onMouseClick();
	}
	@Override
	public void mouseEntered(MouseEvent m)
	{
		
		onMouseEnter();
	}
	@Override
	public void mouseExited(MouseEvent m)
	{
		onMouseExit();
	}
	@Override
	public void mousePressed(MouseEvent m)
	{
		onMousePress();
	}
	@Override
	public void mouseReleased(MouseEvent m)
	{
		onMouseRelease();
	}
}
