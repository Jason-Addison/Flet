package savegame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import engine.Handler;

public class OptionSaver 
{

	public void saveOptions()
	{
		try (Writer writer = new FileWriter(Handler.getGamePath() + "/options.json"))
		{
			Gson gson = new GsonBuilder().create();
			JsonObject options = new JsonObject();
			options.add("directory", gson.toJsonTree(Handler.getGamePath()));
			options.add("Master Volume", gson.toJsonTree(Handler.audio.getMasterVolume()));
			gson.toJson(options, writer);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
