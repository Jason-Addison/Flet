package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import entities.Player;
import maps.Maps;
import tile.BasicTile;
import tile.groundtiles.Dirt;

public class WorldManager
{
	String tile;
	String text;
	//public transient BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
	public void saveChunk()
	{
		System.out.println("saving...");
		try (Writer writer = new FileWriter("D:/file.json"))
		{
			Gson gson = new GsonBuilder().create();//setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
	        //gson.toJson("Hello", writer);
	        Test map = new Test();
	        map.init();
	        
	        map.map = Handler.world.map;
	        System.out.println(map);
	        JsonObject tileOb = new JsonObject();
	        //for(int i = 0; i < 5; i++)
	        for(int row = 0; row <Maps.mapWidth; row++)
	        {
	        	for(int col = 0; col <Maps.mapWidth; col++)
	        	{
	        		BasicTile tile = Handler.world.map[row][col].tile;
	        		BasicTile tileOnGround = Handler.world.map[row][col].tileOnGround;
	        		//gson.toJson(newObj, writer);
	        		String tType = tile.getClass().getCanonicalName();
	        		tile.name = tType;
	        		String togType = tileOnGround.getClass().getCanonicalName();
	        		tileOnGround.name = togType;
	    	        //String newTile = gson.toJson(ob);
	    	        
	    	        tileOb.add("tile " + row + " " + col, gson.toJsonTree(tile));
	    	        tileOb.add("tileOnGround " + row + " " + col, gson.toJsonTree(tileOnGround));
	        	}
	        }
	        
	       // JsonObject newObj = new JsonParser().parse(gson.toJson(tileOb)).getAsJsonObject();
	        JsonObject chunk = new JsonObject();
	        chunk.add("chunk", gson.toJsonTree(tileOb));
	        JsonObject newChunk = new JsonParser().parse(gson.toJson(chunk)).getAsJsonObject();
	        gson.toJson(newChunk, writer);
		}
		
	        //BufferedImage texture = grass.map[0][0].tile.texture;
	        //byte[] tex = Handler.util.imageToByteArray(texture);
	        //text = gson.toJson(tex);
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        //gson.toJson(tile, writer);
	        //gson.toJson(tex, writer);
	   // }
		//catch (IOException e) 
		//{
		//	e.printStackTrace();
		//}
		
		//readWorld();
	}
	String json = Handler.util.deserializeString(new File("D:/file.json"));
	JsonElement jelement = new JsonParser().parse(json);
	JsonObject  jobject = jelement.getAsJsonObject();
	public String parse(String input) 
	{
		JsonObject  jobject = jelement.getAsJsonObject();
	    jobject = jobject.getAsJsonObject("chunk");
	    JsonObject jarray = jobject.getAsJsonObject("members");
	    jobject = jarray.getAsJsonObject();
		String result = jarray.get(input).toString();
		    
		return result;
	}
	public void readChunk()
	{
		saveChunk();
		//.getClass().saveWorld();
		Gson gson = new GsonBuilder().create();
		JsonReader reader = null;
		try
		{
			reader = new JsonReader(new FileReader("D:/file.json"));
		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//reader.setLenient(true);
		String json = Handler.util.deserializeString(new File("D:/file.json"));
		for(int row = 0; row < Maps.mapWidth; row++)
        {
        	for(int col = 0; col < Maps.mapHeight; col++)
        	{
        		String parsedTile = parse("tile " + row + " " + col);
        		String parsedTileOnGround = parse("tileOnGround " + row + " " + col);
        		//parsed = parsed.replaceAll("^\"|\"$", "");
        		//System.out.println(parsed);
        		//System.out.println(gson.fromJson(parsed, String.class));
        		BasicTile tile = gson.fromJson(parsedTile, BasicTile.class);
        		BasicTile tileOnGround = gson.fromJson(parsedTileOnGround, BasicTile.class);
        		
        		String type = tile.name;
    	        Object ob = null;
    	        String typeOnGround = tileOnGround.name;
    	        Object obOnGround = null;
    	        try {
    				ob = Class.forName(type).getConstructor().newInstance();
    				obOnGround = Class.forName(typeOnGround).getConstructor().newInstance();
    			} catch (InstantiationException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IllegalAccessException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IllegalArgumentException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (InvocationTargetException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (NoSuchMethodException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (SecurityException e) { 
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (ClassNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	        
    	        //System.out.println(tile.name + " " + tile);
    	        Handler.world.map[row][col].tile = (BasicTile) ob;
    	        Handler.world.map[row][col].tileOnGround = (BasicTile) obOnGround;
        	}
        }
        System.out.println(Handler.world.map[Player.playerTileX][Player.playerTileY].tile + " dat tile");
		for(int row = 0; row < Maps.mapWidth; row++)
		{
			for(int col = 0; col < Maps.mapHeight; col++)
			{
				//Handler.world.map[row][col].tile = tile.map[0][0].tile;
			}
		}
	}
}
