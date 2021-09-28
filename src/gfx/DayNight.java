package gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DayNight 
{

	
	public int dayNightTick = 0;
	public static int minutes = 0;
	public static int hours = 0;
	public static int days = 1;
	public int hoursAM = 1;
	public int hoursPM = 0;
	public static double time = 0;
	int speed = 5;
	public static int months = 0;
	public int years = 0;
	public static String[] monthNames = new String[12];
	boolean launch = true;
	public void tick()
	{
		if(launch)
		{
			launch = false;
			monthNames[0] = "January";
			monthNames[1] = "Febuary";
			monthNames[2] = "March";
			monthNames[3] = "April";
			monthNames[4] = "May";
			monthNames[5] = "June";
			monthNames[6] = "July";
			monthNames[7] = "August";
			monthNames[8] = "September";
			monthNames[9] = "October";
			monthNames[10] = "November";
			monthNames[11] = "December";
			
		}
		dayNightTick++;
		if(dayNightTick > 250 / speed)
		{
			minutes++;
			dayNightTick = 0;
		}
		if(minutes >= 60)
		{
			minutes = 00;
			hours++;
		}
		
		if(hours > 24)
		{
			hours = 1;
			days++;
		}
		if(days > 30)
		{
			days = 1;
			months++;
		}
		if(months > 11)
		{
			months = 0;
			years++;
		}
	}
	
	public void render(Graphics2D g)
	{
		g.setFont(new Font("Arial", 70, 70));
		g.setColor(Color.RED);
		//g.drawString("" + minutes + " : " + hours + " : " + days, 1600, 60);
		
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	public int getHours()
	{
		return hours;
	}
	public int getDays()
	{
		return days;
	}
	public int getMonths()
	{
		return months;
	}
	public String getMonthName(int month)
	{
		return monthNames[month];
	}
}
