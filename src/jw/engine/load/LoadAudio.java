package jw.engine.load;

import java.io.File;
import java.util.ArrayList;

import jw.engine.components.Sound;

public class LoadAudio
{
    private static ArrayList<Sound> sounds = new ArrayList<Sound>();
    private static ArrayList<Sound> songs = new ArrayList<Sound>();
    
    public static void addSound(String name, String file)
    {
        File f2 = new File(System.getProperty("user.dir") + "/Resources/Music/" + file);
        Sound snd = new Sound(name, f2);
        sounds.add(snd);
    }
    
    public static void addMusic(String name, File file)
    {
        songs.add(0, new Sound(name, file));
    }
    
    // GET METHODS
    
    public static Sound getLastSound()
    {
        return sounds.get(0);
    }
    
    public static ArrayList<Sound> getSounds()
    {
        return sounds;
    }
    
    public static Sound getLastSong()
    {
        return songs.get(0);
    }
    
    public static ArrayList<Sound> getSongs()
    {
        return songs;
    }
}
