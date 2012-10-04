package jw.engine.components;

import java.io.File;

public class Sound
{
    private String name;
    private File file;
    
    public Sound(String name, File file)
    {
        this.name = name;
        this.file = file;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setFile(File file)
    {
        this.file = file;
    }
    
    // GET METHODS
    
    public String getName()
    {
        return name;
    }
    
    public File getFile()
    {
        return file;
    }
}
