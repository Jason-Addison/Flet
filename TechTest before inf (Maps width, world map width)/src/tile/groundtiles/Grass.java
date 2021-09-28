package tile.groundtiles;

import java.awt.image.BufferedImage;

import gfx.Sources;

public class Grass extends GroundTile
{

	int  z, r;
	public Grass()
	{
		super(1, Sources.GRASS, "Grass");
	}
	public void onDestroy()
	{
		System.out.println("XD");
	}
	public BufferedImage getTexture()
	{
		return Sources.GRASS;
	}
}
