package gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Text 
{

	public static Font inventoryStackCount;
	public static Font time;
	public static Font title;
	public static Font menu;
	public static Font debug;
	public static Font chat;
	public static Font editorTitle;
	public static Font containerFont;
	public static Font MENU_OPTIONS;
	public void loadFonts()
	{
		try 
		{
			
			String normalFont = "/font.ttf";
			inventoryStackCount = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 15);
			time = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 35);
			title = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 100);
			menu = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 50);
			debug = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 20);
			chat = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 10);
			editorTitle = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 20);
			containerFont = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 20);
			MENU_OPTIONS = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream(normalFont)).deriveFont(Font.PLAIN, 40);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (FontFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	InputStream NORMAL_FONT_INPUT = Text.class.getResourceAsStream("/font.ttf");
	static File file = new File(Text.class.getResource("/font.ttf").getFile());
	Font NORMAL_FONT;
	Object e;
	public static Font setFont(int fontSize)
	{
		Font font = null;
		try 
		{
			font = Font.createFont(Font.TRUETYPE_FONT, file);
			font = font.deriveFont(Font.PLAIN, fontSize);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (FontFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return font;
	}
}
