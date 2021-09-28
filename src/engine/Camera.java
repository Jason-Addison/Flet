package engine;

import java.awt.Color;

import entities.Player;
import input.KeyManager;
import managers.Collision;
import managers.FlatCollision;
import maps.Maps;

public class Camera 
{

	static double cameraX = 0;
	static double cameraY = 0;
	public static double playerSpeed = 5;
	static double playervel = 0;
	public static final double playerBaseSpeed = 4;
	//private Handler handle = new Handler();
	int x = 0;
	public void tick()
	{
		if(!KeyManager.itemUse)
		{
			if(KeyManager.right && KeyManager.down && !Player.isSwimming)
			{
				Camera.playerSpeed = playerBaseSpeed / 1.1;
			}
			else if(!Player.isSwimming && !KeyManager.shift)
			{
				Camera.playerSpeed = playerBaseSpeed;
			}
			else
			{
				Camera.playerSpeed = playerBaseSpeed / 2;
			}
			if(KeyManager.up && Player.playerPosMem.y <= Handler.height / 2 && !Player.upLock && !Collision.upLock && ! FlatCollision.upLock)
			{
				//moveUpScreen();
			}
			
			if(KeyManager.up && !Player.upLock && !Collision.upLock && ! FlatCollision.upLock)
			{
				moveUp();
			}
			
			if(KeyManager.down &&  !Player.downLock && !Collision.downLock && ! FlatCollision.downLock)
			{
				//moveDownScreen();
			}
			if(KeyManager.down && !Player.downLock && !Collision.downLock && ! FlatCollision.downLock)
			{
				moveDown();
			}
			
			if(KeyManager.left && Player.playerPosMem.x < Handler.width / 2 + playerSpeed && !Player.leftLock && !Collision.leftLock && ! FlatCollision.leftLock)
			{
				//moveLeftScreen();
			}
			if(KeyManager.left && ! Player.leftLock && !Collision.leftLock && ! FlatCollision.leftLock)
			{
				moveLeft();
			}
						 
			if(KeyManager.right && Player.playerPosMem.x < Handler.width / 2 && !Player.rightLock && !Collision.rightLock && ! FlatCollision.rightLock)
			{
				//moveRightScreen();
			}
			if(KeyManager.right && ! Player.rightLock && !Collision.rightLock && ! FlatCollision.rightLock)// && cameraX >= -(Maps.mapWidth * Maps.tileScale - Handler.width - 5))
			{
				//if(cameraX > -(Maps.mapHeight *Maps.tileScale - Handler.width - 100))
				{
					moveRight();
				}
			}
				
			x++;
		}
	}
	public void moveUp()
	{
		cameraY += playerSpeed;
	}
	public void moveDown()
	{
		cameraY -= playerSpeed;
	}
	public void moveLeft()
	{
		cameraX += playerSpeed;
	}
	public void moveRight()
	{
	
		cameraX -= playerSpeed;
	}
	
	public double getX()
	{
		return cameraX;
	}
	public double getY()
	{
		return cameraY;
	}
	public void moveUpScreen()
	{
		Player.player.y -= playerSpeed;
	}
	public void moveDownScreen()
	{
		Player.player.y += playerSpeed;
	}
	public void moveLeftScreen()
	{
		Player.player.x -= playerSpeed;
	}
	public void moveRightScreen()
	{
		Player.player.x += playerSpeed;
	}
	public void setPlayer(int x, int y)
	{
		//if(x > 0 && x < Maps.mapWidth * Maps.tileScale)
		{
			cameraX = -x;
			cameraY = -y;
		}
		//else
		{
			Handler.util.chatMsg(Color.RED, "Teleported : ", y + " : " + x, 300);
		}
	}
}
