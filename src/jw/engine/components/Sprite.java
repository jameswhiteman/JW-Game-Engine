package jw.engine.components;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite
{
    private String name;
    private File file;
    private BufferedImage value;
    
    public Sprite(String name, File file)
    {
        this.name = name;
        this.file = file;
        try
        {
            value = ImageIO.read(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    // SET METHODS
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setFile(File file)
    {
        this.file = file;
        refresh();
    }
    
    public void refresh()
    {
        try
        {
            value = ImageIO.read(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
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
    
    public BufferedImage getImage()
    {
        return value;
    }
}
