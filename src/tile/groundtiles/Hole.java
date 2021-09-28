package tile.groundtiles;

import engine.Handler;
import gfx.Sources;

public class Hole extends GroundTile
{
	public Hole()
	{
		super(0, Sources.HOLE, "Hole (Logic)");
	}
	public void onPlace()
	{
		System.out.println(x + " " + y);
		if(Handler.chunk.getTile(x, y - 1).tile instanceof Hole)
		{
			texture = Sources.HOLE_SIMPLE;
		}
		if(Handler.chunk.getTile(x, y + 1).tile instanceof Hole)
		{
			System.out.println("XLOL");
			//Handler.chunk.setTexture(x, y + 1, Sources.HOLE_SIMPLE);
		}
	}
}
 