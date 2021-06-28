package tumble.gui;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 * This class represents short sound clips.
 * Credit to SpriteAndSound demo from demos folder. Used modified getBytes() 
 * code from java2s.com/Tutorial/Java/0180__File/GetbytesfromInputStream.htm.
 * @author Amanda Xu, Julia Gu
 * @version May 24, 2020
 */
public class Sound implements Runnable {
	
	private SourceDataLine line = null;
	private byte[] audioBytes;
	
	/**
	 * Creates a Sound object that consists of a short audio clip.
	 * @param fileName name of wav sound file line to read
	 */
	public Sound(String fileName) {
		
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream(fileName)));
		}
		catch (Exception ex) {
			System.out.println("Audio file cannot be found");
			System.exit(1);
		}
		
		AudioFormat audioFormat = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		try {
			line = (SourceDataLine)AudioSystem.getLine(info);
			line.open(audioFormat);
		}
		catch (LineUnavailableException ex) {
			System.out.println("Audio line unavailable");
			System.exit(1);
		}
		
		line.start();
		
		try {
			int len;
			int size = 1024;
			byte[] data = new byte[size];
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			while ((len = audioInputStream.read(data, 0, size)) != -1)
				out.write(data, 0, len);
			audioBytes = out.toByteArray();
		}
		catch (IOException ex) {
			System.out.println("Audio file cannot be read");
			System.exit(1);
		}
		
	}
	
	/**
	 * Writes the line of sound.
	 */
	public void run() {
		line.write(audioBytes, 0, audioBytes.length);
	}
	
	/**
	 * Plays the short audio clip.
	 */
	public void play() {
		line.flush();
		new Thread(this).start();
	}
}