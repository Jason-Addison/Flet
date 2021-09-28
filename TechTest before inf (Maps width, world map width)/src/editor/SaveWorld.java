package editor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import managers.Test;
import tile.BasicMap;
import tile.BasicTile;
import tile.groundtiles.Grass;

public class SaveWorld
{

	public void saveWorld(BasicMap[][] map)
	{
		JSONObject world = new JSONObject();
		
		world.put("Map Info", map);
		try (FileWriter file = new FileWriter("D:/text.txt")) 
		{
			file.write(world.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + world);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void test()
	{
		
		Gson gson = new Gson();
		Grass obj = new Grass();
		int a = 3;

		// 1. Java object to JSON, and save into a file
		try {
			gson.toJson(a, new FileWriter("D:\\file.json"));
			gson.toJson(obj, new FileWriter("D:\\file.json"));
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. Java object to JSON, and assign to a String
		String jsonInString = gson.toJson(obj);
		System.out.println(jsonInString);
		/*JSONObject world = new JSONObject();
		int e = 3;
		Grass grass = new Grass();
		JSONObject js = new JSONObject();
		js.put("dddddddddddddddgrass", grass);
		world.put("d", js);
		world.put("int", e);
		world.put("cool", "swag");
		world.put("tile", grass);
		
		try (FileWriter file = new FileWriter("D:/text.txt")) 
		{
			file.write(world.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + world);
		} 
		catch (IOException d) 
		{
			d.printStackTrace();
		}
		readWorld();*/
	}
	public Object readWorld()
	{
		 JSONParser parser = new JSONParser();
	        try 
	        {
	        	File world = new File("D:/text.txt");
	            Object obj = parser.parse(new FileReader(world));
	            
	            JSONObject jsonObject = (JSONObject) obj;
	            long name = (long) jsonObject.get("int");
	            System.out.println(name);
	            System.out.println(jsonObject.get("cool"));
	            System.out.println(jsonObject);
	           // BasicMap[][] worl = (BasicMap[][]) jsonObject.get("Map Info");
	           // BasicMap[][] map = (BasicMap[][]) jsonObject.get("info");
	            Object map = null;
	            return map;
	 
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        return null;
	}
}
