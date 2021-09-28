package recipe;

import engine.Material;

public class Ingredient
{

	public char character;
	public Material material;
	public Ingredient(char character, Material material)
	{
		this.character = character;
		this.material = material;
	}
	
	public Material getMaterial()
	{
		return material;
	}
}
