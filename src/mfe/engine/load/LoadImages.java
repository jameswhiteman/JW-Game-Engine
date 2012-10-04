package mfe.engine.load;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class LoadImages
{
    private static ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();

    public static void addImage(String resourceName)
    {
        try
        {
            sprites.add(0, ImageIO.read(LoadImages.class.getResource("/Resources/Sprites/" + resourceName + ".png")));
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
}
