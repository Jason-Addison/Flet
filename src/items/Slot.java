package items;

import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

public class Slot
{

	public int slot;
	public Rectangle2D.Double pos;
	public JButton button;
	public Container container;
	public Slot(Container container, int slot, Rectangle2D.Double pos, JButton button)
	{
		this.slot = slot;
		this.pos = pos;
		this.button = button;
	}
	
}
