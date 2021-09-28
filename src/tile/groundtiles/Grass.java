package tile.groundtiles;

import java.awt.image.BufferedImage;

import gfx.Sources;

public class Grass extends GroundTile
{

	public Grass()
	{
		super(1, Sources.GRASS, "Grass");
	}

	public BufferedImage getTexture()
	{
		return Sources.GRASS;
	}
	
}
