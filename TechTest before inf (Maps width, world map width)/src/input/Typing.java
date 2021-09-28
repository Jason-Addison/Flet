package input;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chat.ChatLog;
import chat.ChatManager;
import engine.Handler;

public class Typing implements KeyListener
{
	public static String chat = "";
	public static boolean inChat, shift, showSelectionBox;
	@Override
	public void keyPressed(KeyEvent e)
	{
		
		if(inChat)
		{
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_A)
			{
				type("a");
			}
			if(keyCode == KeyEvent.VK_B)
			{
				type("b");
			}
			if(keyCode == KeyEvent.VK_C)
			{
				type("c");
			}
			if(keyCode == KeyEvent.VK_D)
			{
				type("d");
			}
			if(keyCode == KeyEvent.VK_E)
			{
				type("e");
			}
			if(keyCode == KeyEvent.VK_F)
			{
				type("f");
			}
			if(keyCode == KeyEvent.VK_G)
			{
				type("g");
			}
			if(keyCode == KeyEvent.VK_H)
			{
				type("h");
			}
			if(keyCode == KeyEvent.VK_I)
			{
				type("i");
			}
			if(keyCode == KeyEvent.VK_J)
			{
				type("j");
			}
			if(keyCode == KeyEvent.VK_K)
			{
				type("k");
			}
			if(keyCode == KeyEvent.VK_L)
			{
				type("l");
			}
			if(keyCode == KeyEvent.VK_M)
			{
				type("m");
			}
			if(keyCode == KeyEvent.VK_N)
			{
				type("n");
			}
			if(keyCode == KeyEvent.VK_O)
			{
				type("o");
			}
			if(keyCode == KeyEvent.VK_P)
			{
				type("p");
			}
			if(keyCode == KeyEvent.VK_Q)
			{
				type("q");
			}
			if(keyCode == KeyEvent.VK_R)
			{
				type("r");
			}
			if(keyCode == KeyEvent.VK_S)
			{
				type("s");
			}
			if(keyCode == KeyEvent.VK_T)
			{
				type("t");
			}
			if(keyCode == KeyEvent.VK_U)
			{
				type("u");
			}
			if(keyCode == KeyEvent.VK_V)
			{
				type("v");
			}
			if(keyCode == KeyEvent.VK_W)
			{
				type("w");
			}
			if(keyCode == KeyEvent.VK_X)
			{
				type("x");
			}
			if(keyCode == KeyEvent.VK_Y)
			{
				type("y");
			}
			if(keyCode == KeyEvent.VK_Z)
			{
				type("z");
			}
			
			/////////////Numbers
			
			if(keyCode == KeyEvent.VK_1)
			{
				type("1");
			}
			if(keyCode == KeyEvent.VK_2)
			{
				type("2");
			}
			if(keyCode == KeyEvent.VK_3)
			{
				type("3");
			}
			if(keyCode == KeyEvent.VK_4)
			{
				type("4");
			}
			if(keyCode == KeyEvent.VK_5)
			{
				type("5");
			}
			if(keyCode == KeyEvent.VK_6)
			{
				type("6");
			}
			if(keyCode == KeyEvent.VK_7)
			{
				type("7");
			}
			if(keyCode == KeyEvent.VK_8)
			{
				type("8");
			}
			if(keyCode == KeyEvent.VK_9)
			{
				type("9");
			}
			if(keyCode == KeyEvent.VK_0)
			{
				type("0");
			}
			if(keyCode == KeyEvent.VK_SPACE)
			{
				type(" ");
			}
			if(keyCode == KeyEvent.VK_SLASH)
			{
				type("/");
			}
			if(keyCode == KeyEvent.VK_BACK_SPACE)
			{
				if(chat.length() > 0)
				{
					chat = chat.substring(0, chat.length()-1);
				}
			}
			if(keyCode == KeyEvent.VK_SHIFT)
			{
				shift = true;
			}
			if(keyCode == KeyEvent.VK_ENTER)
			{
				if(!chat.equals(""));
				{
					char cmd = chat.charAt(0);
					
					if(chat.equals("/selecttoggle"))
					{
						if(showSelectionBox)
						{
							showSelectionBox = false;
						}
						else
						{
							showSelectionBox = true;
						}
					}
					if(cmd == '/')
					{
						//ChatManager.chatLog.add(0, new ChatLog(Color.RED, chat, 600, 0));
						
					}
					else
					{
						ChatManager.chatLog.add(0, new ChatLog(Color.WHITE, "Player : " + chat, 600, 0));
					}
					//Collections.reverse(ChatManager.chatLog);
					
					
					if(chat.contains("/tp"))
					{
						int x = 0;
						int y = 0;
						boolean error = false;
						if(chat.length() >= 6 && Character.isDigit(chat.charAt(4)))
						{
							x = chat.charAt(4);
						}
						else
						{
							error = true;
						}
						if(chat.length() >= 6 && Character.isDigit(chat.charAt(6)))
						{
							y = chat.charAt(6);
						}
						else
						{
							error = true;
						}
						if(error)
						{
							Handler.util.chatMsg(Color.RED, "Correct Usage : ", "/tp [x] [y]", 300);
						}
						if(!error)
						{
							Handler.util.chatMsg(Color.WHITE, "Player Teleported to : ", x + " " + y, 300);
							Handler.cam.setPlayer(x, y);
						}
					}
					inChat = false;
					chat = "";
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(inChat)
		{
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_SHIFT)
			{
				shift = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	public void type(String newCharacter)
	{
		if(chat.length() < 80)
		{
			if(shift)
			{
				chat = chat + newCharacter.toUpperCase();
			}
			else
			{
				chat = chat + newCharacter;
			}
		}
	}
	
	public String getChat()
	{
		return chat;
	}
}
