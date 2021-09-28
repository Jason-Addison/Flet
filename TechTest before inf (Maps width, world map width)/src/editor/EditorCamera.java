package editor;

import java.awt.geom.Point2D;

import input.EditorKeys;

public class EditorCamera
{

	public static Point2D.Double cameraPos = new Point2D.Double(0, 0);
	public static double speed = 50;
	public void tick()
	{
		if(EditorKeys.up)
		{
			moveUp(speed);
		}
		if(EditorKeys.down)
		{
			moveDown(speed);
		}
		if(EditorKeys.left)
		{
			moveLeft(speed);
		}
		if(EditorKeys.right)
		{
			moveRight(speed);
		}
	}
	
	public void moveUp(double speed)
	{
		cameraPos.y -= speed;
	}
	public void moveDown(double speed)
	{
		cameraPos.y += speed;
	}
	public void moveLeft(double speed)
	{
		cameraPos.x -= speed;
	}
	public void moveRight(double speed)
	{
		cameraPos.x += speed;
	}
	public double getCamX()
	{
		return cameraPos.x;
	}
	public double getCamY()
	{
		return cameraPos.y;
	}
	
}
