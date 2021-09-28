package tile.groundtiles.nature;

import java.awt.geom.Point2D;

import engine.Handler;
import entities.nature.Pinetree;
import gfx.Sources;
import input.MouseManager;
import maps.Maps;
import tile.groundtiles.Sand;
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
	public void onPlace()
	{
		int tileX = (int) Math.floor(MouseManager.mouse.x / Maps.tileScale);
		int tileY = (int) Math.floor(MouseManager.mouse.y / Maps.tileScale);
		Pinetree pinetree = new Pinetree();
		pinetree.setTile(tileX, tileY);
		Handler.chunk.addEntity(tileX, tileY, pinetree);
	}
}
