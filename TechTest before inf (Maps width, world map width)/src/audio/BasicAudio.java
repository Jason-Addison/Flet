package audio;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class BasicAudio 
{
	File audio;
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    Clip clip;
    
	public BasicAudio(File audio)
	{
		try 
		{
		    stream = AudioSystem.getAudioInputStream(audio);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    //whatevers
		}
	}
}
