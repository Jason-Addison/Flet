package tile;

import java.awt.Color;

public class ShadedTile
{

	public int x;
	public int y;
	public Color shade;
	public double shadeLevel;
	public double shadeMemory;
	public boolean source;
	public ShadedTile(boolean source, int x, int y, int shadeLevel, int shadeMemory, Color shade)
	{
		this.source = source;
		this.x = x;
		this.y = y;
		this.shade = shade;
		this.shadeLevel = shadeLevel;
		this.shadeLevel = shadeLevel;
	}
	
}
