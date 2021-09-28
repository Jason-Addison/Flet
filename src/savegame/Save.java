package savegame;

import java.awt.image.BufferedImage;

import engine.Handler;

public class Save 
{

	String name = "gamesave";
	String directory = "";
	BufferedImage preview;
	String date;
	public Save()
	{
		
	}
	public void setName(String newName)
	{
		name = newName;
	}
	public String getName()
	{
		return name;
	}
	public void setDirectory(String newDirectory)
	{
		directory = newDirectory;
	}
	public String getDirectory()
	{
		return directory;
	}
	public void setPreview(BufferedImage newPreview)
	{
		preview = newPreview;
	}
	public BufferedImage getPreview()
	{
		return preview;
	}
	public void setDate(String newDate)
	{
		date = newDate;
	}
	public String getDate()
	{
		return Handler.util.getTimeFancy();
	}
	public void load()
	{
		
	}
}
