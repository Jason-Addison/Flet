package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import debug.Debug;

public class Audio
{

	public static File TEST;
	float MASTER_VOLUME = 0f;
	float volume;
	AudioInputStream audioIn;
	File audioFile;
	Clip clip;
	public Audio()
	{
		
	}
	public void setAudio(String path)
	{
		if(Audio.class.getResource(path).getFile() == null)
		{
			Debug.debugMessage(Debug.ERROR, "Audio file was not found or is corrupt!");
		}
		else
		{
			audioFile = new File(Audio.class.getResource(path).getFile());
		}
	}
	public float getVolume()
	{
		FloatControl gainControl = 
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float volume = gainControl.getValue();
		return volume;
	}
	public void setVolume(float volume)
	{
		FloatControl gainControl = 
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(volume);
	}
	public void stop()
	{
		clip.stop();
	}
	public void start()
	{
		clip.start();
	}
	public void loadAudio()
	{
		TEST = new File("D:/test.wav");
		
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(TEST);
			
			clip = AudioSystem.getClip();
			
			clip.open(audioIn);
			clip.start();
			audioIn.close();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public float getMasterVolume()
	{
		return MASTER_VOLUME;
	}
}
