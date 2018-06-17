package Guessus;

import java.io.File;

import javax.sound.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;;

/**
 * This class creates a thred for playing audio
 * <p>
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */

public class Sound implements Runnable{
 
	/**
	 * audio path
	 */
	private String song="src/Guessus/Sound/gamemusic.wav";
	Clip clip;
	/**
	 * initial volume level
	 */
	int volume=-5;
	
	
	
	/**
	 * method that starts the music player
	 * @param string for audio path
	 */
	private void Play(String name)
	{
		try {
			File soundtrack=new File(name);
			AudioInputStream ais=AudioSystem.getAudioInputStream(soundtrack);
			AudioFormat format=ais.getFormat();
			DataLine.Info info=new DataLine.Info(Clip.class, format);
			clip=(Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl sound_control=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			sound_control.setValue(volume);
			clip.start();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * method that stops the music player
	 */
	void stop()
	{
		try {
		
			clip.stop();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * method that raises the volume
	 */
	void up()
	{
		FloatControl sound_control=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume+=2;
		sound_control.setValue(volume);
	}
	/**
	 * method that lowers the volume
	 */
	void down()
	{
		FloatControl sound_control=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume-=2;
		sound_control.setValue(volume);
	}
	
	
	/**
	 * method that resums the audio
	 */
	void resume()
	{
		try {
		
			clip.start();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * run method for thread that starts the music
	 */
	public void run() 
	{
		Play(song);
	}
	
	
	
}
