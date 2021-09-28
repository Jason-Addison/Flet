package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import chunk.Chunk;
import entities.Player;
import maps.Maps;
import tile.BasicTile;

public class WorldManager
{
	String tile;
	String text;
	
	String json = "";//Handler.util.deserializeString(new File("D:/file.json"));
	JsonElement jelement = new JsonParser().parse(json);
	JsonObject  jobject = null;//jelement.getAsJsonObject();
	public String parse(String input) 
	{
		JsonObject  jobject = jelement.getAsJsonObject();
	    jobject = jobject.getAsJsonObject("chunk");
	    JsonObject jarray = jobject.getAsJsonObject("members");
	    jobject = jarray.getAsJsonObject();
		String result = jarray.get(input).toString();
		    
		return result;
	}
	int preX = 0;
	int preY = 0;
	public String parse(String input, int x, int y) 
	{
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String jsonn = Handler.util.deserializeString(new File(s + "/saves/world1/chunk_" + x + "_" + y +".json"));
		JsonElement jelementt = new JsonParser().parse(jsonn);
		JsonObject  jobjectj = jelementt.getAsJsonObject();
	    
	    if(jobjectj.has("chunk " + x + " " + y))
	    {
	    	jobjectj = jobjectj.getAsJsonObject("chunk " + x + " " + y);
	    	JsonObject jarray = jobjectj.getAsJsonObject("members");
	 	    jobjectj = jarray.getAsJsonObject();
	 	    //System.out.println(jarray.has("tile 0 0") + " " + x + " " + y);
	 		String result = jarray.get(input).toString();
	 		return result;
	    }
		
		return x + " " + y;
	}
	public void readChunk()
	{
		//.getClass().saveWorld();
		Gson gson = new GsonBuilder().create();
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
       // System.out.println(Handler.world.map[Player.playerTileX][Player.playerTileY].tile + " dat tile");
		for(int row = 0; row < Maps.mapWidth; row++)
		{
			for(int col = 0; col < Maps.mapHeight; col++)
			{
				//Handler.world.map[row][col].tile = tile.map[0][0].tile;
			}
		}
		//readChunk(0, 0);
	}
	
	
	public void chunkToMap(Chunk chunk, int x, int y)
	{
		// -10 -9
		int nX = x - Handler.chunk.getPlayerX() + 1;
		int nY = y - Handler.chunk.getPlayerY() + 1;
		///System.out.println(nX + "  " + nY);
		//for(int row = )
	}
}
