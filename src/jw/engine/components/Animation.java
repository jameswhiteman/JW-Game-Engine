package jw.engine.components;

import java.awt.image.BufferedImage;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class Animation
{
    private String name;
    private File file;
    private ArrayList<BufferedImage> value;
    private BufferedImage frame;
    
    public Animation(String name, File file)
    {
        this.name = name;
        this.file = file;
        Iterator<ImageReader> readers = ImageIO.getImageReadersBySuffix("gif");
        ImageReader reader = (ImageReader) readers.next();
        InputStream input;
        ImageInputStream stream;
        try
        {
            input = new BufferedInputStream(new FileInputStream(file));
            stream = ImageIO.createImageInputStream(input);
            reader.setInput(stream, false, false);
            for (int i = 0; i < reader.getNumImages(true); i++)
            {
                frame = reader.read(i);
                value.add(frame);
            }
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
        Iterator<ImageReader> readers = ImageIO.getImageReadersBySuffix("gif");
        ImageReader reader = (ImageReader) readers.next();
        InputStream input;
        ImageInputStream stream;
        try
        {
            input = new BufferedInputStream(new FileInputStream(file));
            stream = ImageIO.createImageInputStream(input);
            reader.setInput(stream, false, false);
            for (int i = 0; i < reader.getNumImages(true); i++)
            {
                frame = reader.read(i);
                value.add(frame);
            }
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
    
    public ArrayList<BufferedImage> getImage()
    {
        return value;
    }
}
