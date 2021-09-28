package engine;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import chat.ChatLog;
import chat.ChatManager;
import entities.Entity;
import entities.Player;
import gfx.Sources;
import items.EntityItem;
import maps.Maps;

public class Utilities 
{
	public Point2D.Double getMouse()
	{
		Point2D.Double mouse = new Point2D.Double(Handler.mouseX + Player.playerPosMem.x - Player.player.x, Handler.mouseY + Player.playerPosMem.y - Player.player.y);
		return mouse;
	}

	public int randomNumber(int max, int min)
	{
		if(max > min)
		{
			Random ran = new Random();
			int random = ran.nextInt(max - min) + min;
			return random;
		}
		else
		{
			chatMsg(Color.BLACK, "Warning ! : ", new String("The minimum random number was greater than the maximum! Max : " + max + " Min : " + min + " (Returned minimum : " + min + ")"), 500);
		}
		return min;
	}
	
	public void chatMsg(Color color, String type, String message, int priority)
	{
		ChatManager.chatLog.add(0, new ChatLog(color, type + message, priority, 0));
		
	}
	//public void (String message)
	public boolean compareObjects(Object a, Object b)
	{
		if(a.getClass().equals(b.getClass()))
		{
			return true;
		}
		else
		{
		return true;
		}
	}
	
	public void setMouse()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Cursor c = toolkit.createCustomCursor(Sources.MOUSE_NOINTERACT, new Point(Game.frame.getX(), 
				Game.frame.getY()), "img");
		Game.frame.setCursor (c);
		
	}
	public void addEntity(Entity entity, Double x, Double y)
	{
		
		int xPos = (int) (x / Maps.tileScale);
		int yPos = (int) (y / Maps.tileScale);
		entity.setPos(x, y);
		if(xPos < 0)
		{
			xPos = -xPos;
		}
		if(yPos < 0)
		{
			yPos = -yPos;
		}
		Handler.world.map[xPos][yPos].entities.add(entity);
		
		System.out.println("Entity added : " + entity.getClass().getSimpleName() + " at x : " + x + " y : " + y + "  |  Size : " + Handler.world.map[xPos][yPos].entities.size());
	}
	public Point2D.Double pointToPoint(Point2D.Double start, Point2D.Double end)
	{
		double xDiffrence = end.x - start.x;
		double yDiffrence = end.y - start.y;
		double hypotenuse = Math.sqrt((Math.pow(xDiffrence, 2)) + (Math.pow(yDiffrence, 2)));
		
		double xOffset = xDiffrence / hypotenuse;
		double yOffset = yDiffrence / hypotenuse;
		Point2D.Double offset = new Point2D.Double(xOffset, yOffset);
		return offset;
	}
	public void dropItems(EntityItem item, int x, int y)
	{
		item.pos.x = (item.pos.width / 2 ) + x * Maps.tileScale;
		item.pos.y = (item.pos.height / 2 ) + y * Maps.tileScale;
		int tileX = (int) (item.pos.x / Maps.tileScale);
		int tileY = (int) (item.pos.y / Maps.tileScale);
		Handler.world.map[tileX][tileY].entities.add(item);
		item.x = randomNumber(100, 0) - 50;
		item.y = randomNumber(100, 0) - 50;
		item.max(item.x, item.y);
	}
	public byte[] imageToByteArray(BufferedImage originalImage)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write( originalImage, "jpg", baos );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] imageInByte = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageInByte;
	}
	public BufferedImage byteArrayToImage(byte[] imageInByte)
	{
		InputStream in = new ByteArrayInputStream(imageInByte);
		BufferedImage bImageFromConvert = null;
		try {
			bImageFromConvert = ImageIO.read(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bImageFromConvert;
	}
	public String deserializeString(File file)
	{
			      int len;
			      char[] chr = new char[4096];
			      final StringBuffer buffer = new StringBuffer();
			      try
			      {
				      final FileReader reader = new FileReader(file);
				      try {
				          while ((len = reader.read(chr)) > 0) {
				              buffer.append(chr, 0, len);
				          }
				      } finally {
				          reader.close();
				      }
			      }
			      catch(FileNotFoundException e)
			      {
			    	  e.printStackTrace();
			      }
			      catch(IOException e)
			      {
			    	  e.printStackTrace();
			      }
			      return buffer.toString();
			  }
	public void writeStringToFile(File file, String data) 
	{

		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = data.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
