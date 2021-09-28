package recipe;

import items.Container;

public class BasicRecipe 
{

	public Container container;
	public Ingredient[][] ingredient;
	public BasicRecipe(Ingredient[][] ingredient, Container output)
	{
		ingredient = new Ingredient[3][3];
	}
	
}
