package items;

import engine.Material;
import tile.groundtiles.Grass;

public class Container 
{
	public Material material = new Grass();
	public int count;
	
	public Container(Material material, int count)
	{
		this.material = material;
		this.count = count;
	}
	
}
