package tile.ongroundtiles;

import javax.swing.JButton;

import gfx.Sources;

public class WoodenBarrel extends ContainerTile
{

	JButton[][] buttons = new JButton[10][3];
	int containerCount = 0;
	
	public WoodenBarrel()
	{
		super(0, Sources.WOODEN_BARREL, "Wooden Barrel", 300, 10, 3);
	}
	
	public boolean isSolid()
	{
		return true;
	}
	
	
}
