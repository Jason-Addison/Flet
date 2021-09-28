package states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import chat.ChatManager;
import engine.Camera;
import engine.Handler;
import engine.Light;
import gfx.AnimatedPlayer;
import gfx.AnimatedWater;
import gfx.DayNight;
import gfx.InventoryManager;
import gfx.Overlay;
import input.KeyManager;
import input.MouseManager;
import managers.FlatCollision;
import managers.GrassManager;
import tile.animated.DeepWater;
import weather.WeatherManager;

public class GameState 
{
	//private Handler handle = new Handler();
	private MouseManager mouse = new MouseManager();
	private Camera cam = new Camera();
	private Overlay over = new Overlay();
	private AnimatedWater water = new AnimatedWater();
	private AnimatedPlayer animate = new AnimatedPlayer();
	private InventoryManager inv = new InventoryManager();
	private WeatherManager weather = new WeatherManager();
	private DayNight daynight= new DayNight();
	private Light light = new Light();
	private GrassManager tallgrass = new GrassManager();
	//private LakeManager lake = new LakeManager();
	private FlatCollision flatCol = new FlatCollision();
	private DeepWater deepWater = new DeepWater();
	private ChatManager chat = new ChatManager();
	
	public void tick()
	{
		mouse.tick();
		//handle.getWorld().tick();
		//System.out.println(world.map[1][1].tile);
		Handler.player.tick();
		//col.tick();
		flatCol.tick();
		daynight.tick();
		inv.tick();
		cam.tick();
		Handler.entity.tick();
		deepWater.animate();
		Handler.footprint.tick();
		Handler.item.tick();
		Handler.entity.tick();
		Handler.lighting.tick();
		//update.tick();
		
		over.tick();
		water.tick();
		animate.tick();
		light.tick();
		weather.tick();
		tallgrass.tick();
		chat.tick();
		//projectile.tick();
	}
	
	public void render(Graphics2D g)
	{
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	              RenderingHints.VALUE_ANTIALIAS_ON);
		Handler.world.render(g);
		
		//player.render(g);
		Handler.item.render(g);
		Handler.entity.render(g);
		//Handler.world.renderSecond(g);
		mouse.render(g);
		//world.renderSecond(g);
		weather.render(g);
		daynight.render(g);
		light.render(g);
		Handler.lighting.render(g);
		//g.setColor(new Color(0, 0, 0, 50));
		//g.fillRect(0, 0, (int) Handler.width, (int) Handler.height);
		inv.render(g);
		over.render(g);
		chat.render(g);
		
		if(KeyManager.esc)
		{
			Handler.options.render(g);
		}
		//inv.render(g);
		//projectile.render(g);
		//handle.getWorld().render(g);
	}
	
}
