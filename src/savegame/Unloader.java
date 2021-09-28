package savegame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import engine.Handler;

public class Unloader 
{

	ArrayList<Save> saves = new ArrayList<Save>();
	public void discoverWorlds()
	{
		saves.clear();
		File saveDir = new File("D:/OpenWorld/saves");
		saveDir.mkdir();
		File[] newFiles = saveDir.listFiles();
		for(int i = 0; i < newFiles.length; i++)
		{
			if(newFiles[i].isDirectory())
			{
				Save newSave = new Save();
				newSave.setName(newFiles[i].getName());
				File worldInfo = new File(newFiles[i].getAbsolutePath().toString() + "/saveData.json");
				try 
				{
					Handler.saveMng.saveGame(worldInfo, newSave);
					if(worldInfo.createNewFile())
					{
						//World Data input could not be found, create new one 
						Handler.util.saveFile(worldInfo.getAbsolutePath().toString());
					}
					else
					{
						//World Data input could be found, use it
						String worldInfoJson = Handler.util.deserializeString(new File(worldInfo.getAbsolutePath().toString()));
						JsonElement worldInfoElement = new JsonParser().parse(worldInfoJson);
						JsonObject worldData = worldInfoElement.getAsJsonObject();
						//JsonObject WORLD_NAME = worldData.getAsJsonObject("World Name");
					}
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				saves.add(newSave);
			}
		}
	}
	public ArrayList<Save> getSaves()
	{
		return saves;
	}
}
