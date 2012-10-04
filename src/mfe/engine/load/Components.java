package mfe.engine.load;


import java.util.ArrayList;

import mfe.engine.components.Background;
import mfe.engine.components.FixedBackground;
import mfe.engine.components.MovingBackground;
import mfe.engine.components.Object;
import mfe.engine.components.ParallaxBackground;
import mfe.engine.load.LoadImages;

public class Components
{
    // An object is an image that moves.
    private static ArrayList<Object> objects = new ArrayList<Object>();
    /* DEPTH CAN BE SPECIFIED FOR ALL BACKGROUNDS SO THAT THEY MAY BECOME
     * A FORGROUND AT ANY POINT.*/
    // A background (standard) moves in relation to the camera.
    private static ArrayList<Background> backgrounds = new ArrayList<Background>();
    // A fixed background stays in one position in the window at all times.
    private static ArrayList<FixedBackground> fixed_backgrounds = new ArrayList<FixedBackground>();
    // A moving background moves constantly, e.g. clouds, ocean, etc.
    private static ArrayList<MovingBackground> moving_backgrounds = new ArrayList<MovingBackground>();
    // A parallax background moves in a speed separate from a normal background.
    private static ArrayList<ParallaxBackground> parallax_backgrounds = new ArrayList<ParallaxBackground>();
    
    public static void addBackground(String resource, String name, int x, int y, int rot, double xsc, double ysc)
    {
        LoadImages.addImage(resource);
        Background temp = new Background(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        backgrounds.add(temp);
    }
    
    public static void addFixedBackground(String resource, String name, int x, int y, int rot, double xsc, double ysc)
    {
        LoadImages.addImage(resource);
        FixedBackground temp = new FixedBackground(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        fixed_backgrounds.add(temp);
    }
    
    public static void addMovingBackground(String resource, String name, int x, int y, int rot, double xsc, double ysc)
    {
        LoadImages.addImage(resource);
        MovingBackground temp = new MovingBackground(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        moving_backgrounds.add(temp);
    }
    
    public static void addParallaxBackground(String resource, String name, int x, int y, int rot, double xsc, double ysc)
    {
        LoadImages.addImage(resource);
        ParallaxBackground temp = new ParallaxBackground(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        parallax_backgrounds.add(temp);
    }
    
    public static void addObject(String resource, String name, int x, int y, int rot, double xsc, double ysc)
    {
        LoadImages.addImage(resource);
        Object temp = new Object(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        objects.add(temp);
    }
    
    public static void addObject(String resource, String name, int x, int y, int rot, double xsc, double ysc, String objtype)
    {
        LoadImages.addImage(resource);
        Object temp = new Object(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc, objtype);
        objects.add(temp);
    }
    
    public static void addObject(String resource, String name, int x, int y, int j, int k,
            int rot, double xsc, double ysc, String objtype)
    {
        LoadImages.addImage(resource);
        Object temp = new Object(name, LoadImages.getLastSprite(), x, y,
                j, k, 0, rot, xsc, ysc, objtype);
        objects.add(temp);
    }
    
    // GET METHODS
    public static ArrayList<Object> getObjects()
    {
        return objects;
    }
    
    public static ArrayList<Background> getBackgrounds()
    {
        return backgrounds;
    }
    
    public static ArrayList<FixedBackground> getFixedBackgrounds()
    {
        return fixed_backgrounds;
    }
    
    public static ArrayList<MovingBackground> getMovingBackgrounds()
    {
        return moving_backgrounds;
    }
    
    public static ArrayList<ParallaxBackground> getParallaxBackgrounds()
    {
        return parallax_backgrounds;
    }
    
    // Main Methods
    public static Object obj(String name)
    {
        for (int i = 0; i < objects.size(); i++)
        {
            if (objects.get(i).getName().equals(name))
            {
                return objects.get(i);
            }
        }
        return null;
    }
    
    public static Background bg(String name)
    {
        for (int i = 0; i < backgrounds.size(); i++)
        {
            if (backgrounds.get(i).getName().equals(name))
            {
                return backgrounds.get(i);
            }
        }
        return null;
    }
    
    public static FixedBackground fbg(String name)
    {
        for (int i = 0; i < fixed_backgrounds.size(); i++)
        {
            if (fixed_backgrounds.get(i).getName().equals(name))
            {
                return fixed_backgrounds.get(i);
            }
        }
        return null;
    }
    
    public static MovingBackground mbg(String name)
    {
        for (int i = 0; i < moving_backgrounds.size(); i++)
        {
            if (moving_backgrounds.get(i).getName().equals(name))
            {
                return moving_backgrounds.get(i);
            }
        }
        return null;
    }
    
    public static ParallaxBackground pbg(String name)
    {
        for (int i = 0; i < parallax_backgrounds.size(); i++)
        {
            if (parallax_backgrounds.get(i).getName().equals(name))
            {
                return parallax_backgrounds.get(i);
            }
        }
        return null;
    }
}