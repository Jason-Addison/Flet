package maps;

public class Maps 
{
	public static int mapWidth = 16 * 3;
	public static int mapHeight = 16 * 3;
	public static int tileScale = 80;
	public static int minimapScale = 6;
	public static int[][] tilesOverlay = new int[mapWidth][mapHeight];
	public int getMapWidth()
	{
		return mapWidth;
	}
	public int getMapHeight()
	{
		return mapHeight;
	}
}
