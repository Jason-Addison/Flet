package recipe;

import engine.Material;
import items.Container;

public class Recipe 
{
	public Container container;
	public String[] lines = new String[3];
	public Ingredient[][] ingredient = new Ingredient[3][3];
	public Recipe(Container container)
	{
		this.container = container;
		for(int i = 0; i < 3; i++)
		{
			for(int t = 0; t < 3; t++)
			{
				ingredient[i][t] = new Ingredient(' ', Material.AIR);
			}
		}
	}
	public void shape(String line1, String line2, String line3)
	{
		this.lines[0] = line1;
		this.lines[1] = line2;
		this.lines[2] = line3;
	}
	public void setIngredient(char character, Material material)
	{
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				if(lines[y].charAt(x) == character)
				{
					ingredient[x][y].material = material;
				}
			}
		}
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				//System.out.println(ingredient[x][y].material);
			}
		}
	}
}