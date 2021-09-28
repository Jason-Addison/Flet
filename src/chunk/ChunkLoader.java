package chunk;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import engine.Handler;
import entities.Entity;
import tile.Air;
import tile.BasicMap;
import tile.BasicTile;
import tile.groundtiles.Grass;

public class ChunkLoader// implements Runnable
{
	Thread runner;
	public static double time = 0.0;
	public static boolean running = true;
	public ChunkLoader()
	{
		//this.runner = new Thread(this);
	   // this.runner.start();
	}
	  
	//@Override
	////public void run()
	//{
		//while(running)
		//{
	//	}
	//}
	public void saveChunk(Chunk chunk, int x, int y)
	{
		
		try (Writer writer = new FileWriter(Handler.getWorldPath() + "/chunk_" + x + "_" + y + ".json"))
		{
			Gson gson = new GsonBuilder().create();
	        //gson.toJson("Hello", writer);
	        //Test map = new Test();
	        JsonObject tileOb = new JsonObject();
	        JsonObject chunkob = new JsonObject();
	        JsonObject chunkInfo = new JsonObject();
	        for(int row = 0; row < 16; row++)
	        {
	        	for(int col = 0; col < 16; col++)
	        	{
	        		BasicTile tile = chunk.chunkMap[row][col].tile;
	        		BasicTile tileOnGround = chunk.chunkMap[row][col].tileOnGround;
	        		BasicTile tileAboveGround = chunk.chunkMap[row][col].tileAboveGround;
	        		ArrayList<Entity> entities = chunk.chunkMap[row][col].entities;
	        		//gson.toJson(newObj, writer);
	        		String tType = tile.getClass().getCanonicalName();
	        		tile.name = tType;
	        		String togType = tileOnGround.getClass().getCanonicalName();
	        		tileOnGround.name = togType;
	        		String tagType = tileAboveGround.getClass().getCanonicalName();
	        		tileAboveGround.name = tagType;
	        		
	    	        //String newTile = gson.toJson(ob);
	        		JsonObject tileSpace = new JsonObject();
	    	        BasicMap map = new BasicMap(new Grass(), new Air(), new ArrayList<Entity>(), row, col);
	    	        //tileSpace.add("entities", gson.toJsonTree(entities));
	    	        //tileSpace.add("tile", gson.toJsonTree(tile));
	    	        tileSpace.add("t", gson.toJsonTree(Handler.materials.getIdFromMaterial(chunk.chunkMap[row][col].tile)));
	    	        tileSpace.add("targs", gson.toJsonTree(chunk.chunkMap[row][col].tile.getArgs()));
	    	        if(chunk.chunkMap[row][col].tile.getSpecialArgs() != null)
	    	        {
	    	        	tileSpace.add("tsargs", gson.toJsonTree(chunk.chunkMap[row][col].tile.getSpecialArgs()));
	    	        }
	    	        tileSpace.add("tog", gson.toJsonTree(Handler.materials.getIdFromMaterial(chunk.chunkMap[row][col].tileOnGround)));
	    	        tileSpace.add("togargs", gson.toJsonTree(chunk.chunkMap[row][col].tileOnGround.getArgs()));
	    	        if(chunk.chunkMap[row][col].tileOnGround.getSpecialArgs() != null)
	    	        {
	    	        	tileSpace.add("togsargs", gson.toJsonTree(chunk.chunkMap[row][col].tileOnGround.getSpecialArgs()));
	    	        }
	    	        tileSpace.add("tag", gson.toJsonTree(Handler.materials.getIdFromMaterial(chunk.chunkMap[row][col].tileAboveGround)));
	    	        tileSpace.add("tagargs", gson.toJsonTree(chunk.chunkMap[row][col].tileAboveGround.getArgs()));
	    	        if(chunk.chunkMap[row][col].tileAboveGround.getSpecialArgs() != null)
	    	        {
	    	        	tileSpace.add("tagsargs", gson.toJsonTree(chunk.chunkMap[row][col].tileAboveGround.getSpecialArgs()));
	    	        }
	    	        chunkob.add("ts " + row + " " + col, tileSpace);
	    	       // tileOb.add("entities " + row + " " + col, gson.toJsonTree(entities));
	        	}
	        }
	        chunkInfo.add("chunk " + x + " " + y, gson.toJsonTree(chunkob));
	        JsonObject newChunk = new JsonParser().parse(gson.toJson(chunkInfo)).getAsJsonObject();
	        gson.toJson(newChunk, writer);
		}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	public Chunk readChunk(int x, int y)
	{
		Gson gson = new GsonBuilder().create();
		
	    String json = "";
		try 
		{
		      File file = new File(Handler.getWorldPath() + "/chunk_" + x + "_" + y + ".json");

		      if (file.createNewFile())
		      {
		    	  Handler.chunkloader.saveChunk(new Chunk(x, y), x, y);
		      }
		      else
		      {
		        json = Handler.util.deserializeString(new File(Handler.getWorldPath() + "/chunk_" + x + "_" + y + ".json"));
		      }

	    	} catch (IOException e)
		{
		      e.printStackTrace();
		}
		Chunk chunk = new Chunk(x, y);
		//String parsedTile = parse("tile " + x + " " + y, x, y);
		String parsedTile = "";
		
		String jsonn = Handler.util.deserializeString(new File(Handler.getWorldPath() + "/chunk_" + x + "_" + y +".json"));
		JsonElement jelementt = new JsonParser().parse(jsonn);
		//JsonObject  jobjectj;// = jelementt.getAsJsonObject();
	    
		if(!parsedTile.equals(x + " " + y))
		{
			for(int row = 0; row < 16; row++)
			{
				for(int col = 0; col < 16; col++)
				{
					String nparsedTile = "";
					String entityString = "";
					JsonObject jobjectj = jelementt.getAsJsonObject();
				    if(jobjectj.has("chunk " + x + " " + y))
				    {
				    	jobjectj = jobjectj.getAsJsonObject("chunk " + x + " " + y);
				    	JsonObject jarray = jobjectj.getAsJsonObject("members");
				    	JsonObject tileSpace = jarray.getAsJsonObject("ts " + row + " " + col);
				 	    jobjectj = tileSpace.getAsJsonObject();
				 		nparsedTile = tileSpace.get("t").toString();
				 		String tileARGSString = tileSpace.get("targs").toString();
				 		//ayy = jarray.get("map " + row + " " + col).toString();
					 	String tileOnGrounds = tileSpace.get("tog").toString();
					 	String tileOnGroundsARGS = tileSpace.get("togargs").toString();
					 	
					 	String tileAboveGround = tileSpace.get("tag").toString();
					 	String tileAboveGroundsARGS = tileSpace.get("tagargs").toString();
	        			//BasicTile tile = gson.fromJson(nparsedTile, BasicTile.class);
	        			int tileID = gson.fromJson(nparsedTile, int.class);
	        			int tileOnGroundID = gson.fromJson(tileOnGrounds, int.class);
	        			int tileAboveGroundID = gson.fromJson(tileAboveGround, int.class);
	        			int[] tileARGS = gson.fromJson(tileARGSString, int[].class);
	        			int[] tileOnGroundARGS = gson.fromJson(tileOnGroundsARGS, int[].class);
	        			int[] tileAboveGroundARGS = gson.fromJson(tileAboveGroundsARGS, int[].class);
	        			Object tileObj = null;// = gson.fromJson(json, Object.class);
	        			Object tileOnGroundObj = null;// = gson.fromJson(json, Object.class);
	        			Object tileAboveGroundObj = null;
	        			if(Handler.materials.getMaterialFromId(tileID).getSpecialArgs() != null)
	        			{
	        				String tileObjString = tileSpace.get("tsargs").toString();
	        				tileObj = gson.fromJson(tileObjString, Object.class);
	        			}
	        			if(Handler.materials.getMaterialFromId(tileOnGroundID).getSpecialArgs() != null)
	        			{
	        				String tileOnGroundObjString = tileSpace.get("togsargs").toString();
	        				tileOnGroundObj = gson.fromJson(tileOnGroundObjString, Object.class);
	        			}
	        			if(Handler.materials.getMaterialFromId(tileAboveGroundID).getSpecialArgs() != null)
	        			{
	        				String tileAboveGroundObjString = tileSpace.get("tagsargs").toString();
	        				tileAboveGroundObj = gson.fromJson(tileAboveGroundObjString, Object.class);
	        			}
	        	        chunk.chunkMap[row][col].tile = (BasicTile) Handler.materials.getMaterialFromId(tileID);//(BasicTile) ob;
	        	        chunk.chunkMap[row][col].tile.args(tileARGS);
	        	       
	          	        chunk.chunkMap[row][col].tileOnGround = (BasicTile) Handler.materials.getMaterialFromId(tileOnGroundID);
	          	        chunk.chunkMap[row][col].tileOnGround.args(tileOnGroundARGS);

	          	        chunk.chunkMap[row][col].tileAboveGround = (BasicTile) Handler.materials.getMaterialFromId(tileAboveGroundID);
	          	        chunk.chunkMap[row][col].tileAboveGround.args(tileAboveGroundARGS);
	          	        
	          	        if(tileObj != null)
	          	        {
	          	        	chunk.chunkMap[row][col].tile.specialArgs(gson.fromJson(tileObj.toString(), Object.class));
	          	        }
	          	        if(tileOnGroundObj != null)
	          	        {
	          	        	chunk.chunkMap[row][col].tileOnGround.specialArgs(gson.fromJson(tileOnGroundObj.toString(), Object.class));
	          	        }
	          	        if(tileAboveGroundObj != null)
	          	        {
	          	        	chunk.chunkMap[row][col].tileOnGround.specialArgs(gson.fromJson(tileAboveGroundObj.toString(), Object.class));
	          	        }
				    }
				}
			}
        }
		else
		{
			
		}
		chunk.x = x;
		chunk.y = y;
		Handler.chunkloader.saveChunk(chunk, x, y);
		return chunk;
	}
}