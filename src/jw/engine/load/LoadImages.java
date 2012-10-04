package jw.engine.load;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class LoadImages
{
    private static ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
    private static ArrayList<ArrayList<BufferedImage>> animations = new ArrayList<ArrayList<BufferedImage>>();
    private static ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
    private static BufferedImage buffImg;
    
    public static void addAnimation(String resourceName)
    {
        try
        {
            Iterator<ImageReader> readers = ImageIO.getImageReadersBySuffix("gif");
            ImageReader reader = (ImageReader) readers.next();
            InputStream input = new BufferedInputStream(new
                    FileInputStream(System.getProperty("user.dir") + "/Resources/Sprites/" + resourceName));
            ImageInputStream stream = ImageIO.createImageInputStream(input);
            reader.setInput(stream, false, false);
            for (int i = 0; i < reader.getNumImages(true); i++)
            {
                buffImg = reader.read(i);
                frames.add(buffImg);
            }
            animations.add(frames);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void addImage(String resourceName)
    {
        try
        {
            sprites.add(0, ImageIO.read(LoadImages.class.getResource("/Resources/Sprites/" + resourceName)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static BufferedImage getSprite(int i)
    {
        return sprites.get(i);
    }
    
    public static BufferedImage getLastSprite()
    {
        if (sprites.size() >= 1)
            return sprites.get(0);
        else
            return null;
    }
    
    public static ArrayList<BufferedImage> getAnimation(int i)
    {
        return animations.get(i);
    }
    
    public static ArrayList<BufferedImage> getLastAnimation()
    {
        if (animations.size() >= 1)
            return animations.get(0);
        else
            return null;
    }
}
