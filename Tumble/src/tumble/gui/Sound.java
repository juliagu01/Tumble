package tumble.gui;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class represents short sound clips.
 * Credit to SpriteAndSound demo from demos folder.
 * @author Amanda Xu
 * @version 5/21/20
 */
public class Sound implements Runnable
{
  private SourceDataLine line = null;
  private byte[] audioBytes;
//  private int numBytes;

//  /**
//   * Creates a Sound object that consists of a short audio clip.
//   * @param fileName name of wav sound file line to read
//   */
//  public Sound(String fileName)
//  {
//    File soundFile = new File(fileName);
//    AudioInputStream audioInputStream = null;
//    try
//    {
//      audioInputStream = AudioSystem.getAudioInputStream(soundFile);
//    }
//    catch (Exception ex)
//    {
//      System.out.println(fileName + " cannot be found");
//      System.exit(1);
//    }
//
//    AudioFormat audioFormat = audioInputStream.getFormat();
//    DataLine.Info info = new DataLine.Info(SourceDataLine.class,
//                         audioFormat);
//    try
//    {
//      line = (SourceDataLine)AudioSystem.getLine(info);
//      line.open(audioFormat);
//    }
//    catch (LineUnavailableException ex)
//    {
//      System.out.println("Audio line unavailable");
//      System.exit(1);
//    }
//
//    line.start();
//
//    audioBytes = new byte[(int)soundFile.length()];
//
//    try
//    {
//      audioInputStream.read(audioBytes, 0, audioBytes.length);
//    }
//    catch (IOException ex)
//    {
//      System.out.println(fileName + " cannot be read");
//      System.exit(1);
//    }
//  }

//  /**
//   * Creates a Sound object that consists of a short audio clip.
//   * @param stream name of wav sound file line to read
//   */
//  public Sound(InputStream stream)
//  {
//    AudioInputStream audioInputStream = null;
//    try
//    {
//      audioInputStream = AudioSystem.getAudioInputStream(stream);
//    }
//    catch (Exception ex)
//    {
//      System.out.println("Audio file cannot be found");
//      System.exit(1);
//    }
//
//    AudioFormat audioFormat = audioInputStream.getFormat();
//    DataLine.Info info = new DataLine.Info(SourceDataLine.class,
//                         audioFormat);
//    try
//    {
//      line = (SourceDataLine)AudioSystem.getLine(info);
//      line.open(audioFormat);
//    }
//    catch (LineUnavailableException ex)
//    {
//      System.out.println("Audio line unavailable");
//      System.exit(1);
//    }
//
//    line.start();
//
//    try
//    {
//      int len;
//      int size = 1024;
//      byte[] data = new byte[size];
//      ByteArrayOutputStream out = new ByteArrayOutputStream();
//      while ((len = audioInputStream.read(data, 0, size)) != -1)
//        out.write(data, 0, len);
//      audioBytes = out.toByteArray();
//    }
//    catch (IOException ex)
//    {
//      System.out.println("Audio file cannot be read");
//      System.exit(1);
//    }
//  }

  /**
   * Creates a Sound object that consists of a short audio clip.
   * @param stream name of wav sound file line to read
   */
  public Sound(String fileName)
  {
    AudioInputStream audioInputStream = null;
    try
    {
      audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream(fileName)));
    }
    catch (Exception ex)
    {
      System.out.println("Audio file cannot be found");
      System.exit(1);
    }

    AudioFormat audioFormat = audioInputStream.getFormat();
    DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                         audioFormat);
    try
    {
      line = (SourceDataLine)AudioSystem.getLine(info);
      line.open(audioFormat);
    }
    catch (LineUnavailableException ex)
    {
      System.out.println("Audio line unavailable");
      System.exit(1);
    }

    line.start();

    try
    {
      int len;
      int size = 1024;
      byte[] data = new byte[size];
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      while ((len = audioInputStream.read(data, 0, size)) != -1)
        out.write(data, 0, len);
      audioBytes = out.toByteArray();
    }
    catch (IOException ex)
    {
      System.out.println("Audio file cannot be read");
      System.exit(1);
    }
  }

  /**
   * Writes the line of sound.
   */
  public void run() 
  {
	line.write(audioBytes, 0, audioBytes.length);
  }

  /**
   * Plays the short audio clip.
   */
  public void play()
  {
	line.flush();
	new Thread(this).start();
  }
}