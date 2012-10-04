/**
 * Sets of functions dealing with resource manipulation. These are the resource
 * functions that games using this engine will utilize directly.
 * @author James Whiteman
 */

package jw.engine.functions;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import jw.engine.load.Components;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class resource
{
    public static void playSound(String name)
    {
        if (!Components.getSounds().isEmpty())
        {
            for (int i = 0; i < Components.getSounds().size(); i++)
            {
                if (Components.getSounds().get(i).getName().equals(name))
                {
                    File temp = Components.getSounds().get(i).getFile();
                    AudioInputStream stream;
                    Clip clip = null;
                    try
                    {
                        stream = AudioSystem.getAudioInputStream(temp);
                        try
                        {
                            clip = AudioSystem.getClip();
                        }
                        catch (LineUnavailableException e)
                        {
                            e.printStackTrace();
                        }
                        try
                        {
                            clip.open(stream);
                        }
                        catch (LineUnavailableException e)
                        {
                            e.printStackTrace();
                        }
                        clip.start();
                    }
                    catch (UnsupportedAudioFileException e)
                    {
                        e.printStackTrace();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    public static void stopSound(String name)
    {
        for (int i = 0; i < Components.getSounds().size(); i++)
        {
            if (Components.getSounds().get(i).getName().equals(name))
            {
                try
                {
                    InputStream in = new FileInputStream(Components.getSounds().get(i).getFile());
                    AudioStream as = new AudioStream(in);
                    AudioPlayer.player.stop(as);
                }
                catch (Exception e)
                {
                    e.getStackTrace();
                }
            }
        }
    }
}
