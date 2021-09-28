package tile.groundtiles.nature;

import java.awt.geom.Point2D;

import engine.Handler;
import entities.nature.Pinetree;
import gfx.Sources;
import maps.Maps;
import tile.ongroundtiles.OnGroundTile;

public class OakStump extends OnGroundTile
{

	public OakStump()
	{
		super(100, Sources.OAK_TREE_STUMP, "Oak Tree Stump", 50);
	}
	
	public boolean isSolid()
	{
		return true;
	}
	int x, y;
	public void pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void onPlace()
	{
		//double x = (Handler.util.getMouse().x);
		//double y = (Handler.util.getMouse().y);
		int tileX = x;//(int) (x / Maps.tileScale);
		int tileY = y;//(int) (y / Maps.tileScale);
		System.out.println(tileX);
		Pinetree pinetree = new Pinetree();
		pinetree.setPos(new Point2D.Double(tileX * Maps.tileScale, tileY * Maps.tileScale));
		Handler.util.addEntity(pinetree, (double) (tileX * Maps.tileScale), (double) (tileY * Maps.tileScale));
	}
}
