package savegame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import engine.Handler;

public class SaveManager
{

	public void saveGame(File saveDir, Save save)
	{
		Gson gson = new GsonBuilder().create();
		try (Writer writer = new FileWriter(saveDir))
		{
			JsonObject saveData = new JsonObject();
			saveData.add("World Name", gson.toJsonTree(save.getName()));
			saveData.add("Last Edited", gson.toJsonTree(save.getDate()));
			gson.toJson(saveData, writer);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
