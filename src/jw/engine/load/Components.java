package jw.engine.load;


import java.awt.image.BufferedImage;

import java.util.ArrayList;

import jw.engine.abstracts.AbstractObject;
import jw.engine.components.AnimatedObject;
import jw.engine.components.Background;
import jw.engine.components.FixedBackground;
import jw.engine.components.RigidObject;
import jw.engine.components.MovingBackground;
import jw.engine.components.ParallaxBackground;
import jw.engine.components.Sound;
import jw.engine.load.LoadAudio;
import jw.engine.load.LoadImages;


public class Components
{
    // Constants
    public static final int IMG_PNG = 0;
    public static final int IMG_GIF = 1;
    public static final int IMG_JPEG = 2;
    public static final int IMG_CUSTOM = 3;
    
    // An object is an image that moves.
    private static ArrayList<RigidObject> objects = new ArrayList<RigidObject>();
    private static ArrayList<AnimatedObject> ani_objects = new ArrayList<AnimatedObject>();
    private static ArrayList<AbstractObject> all_objects = new ArrayList<AbstractObject>();
    
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
    
    // A sound is a sound file with a name.
    private static ArrayList<Sound> sounds = new ArrayList<Sound>();
    
    public static void addBackground(String resource, String name, int x, int y, int rot, double xsc, double ysc,
            int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addImage(resource + format);
        Background temp = new Background(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        backgrounds.add(temp);
    }
    
    public static void addFixedBackground(String resource, String name, int x, int y, int rot, double xsc, double ysc,
            int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addImage(resource + format);
        FixedBackground temp = new FixedBackground(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        fixed_backgrounds.add(temp);
    }
    
    public static void addMovingBackground(String resource, String name, int x, int y, int rot, double xsc, double ysc,
            int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addImage(resource + format);
        MovingBackground temp = new MovingBackground(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        moving_backgrounds.add(temp);
    }
    
    public static void addParallaxBackground(String resource, String name, int x, int y, int rot, double xsc,
            double ysc, int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addImage(resource + format);
        ParallaxBackground temp = new ParallaxBackground(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        parallax_backgrounds.add(temp);
    }
    
    public static void addObject(String resource, String name, int x, int y, int rot, double xsc, double ysc,
            int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addImage(resource + format);
        RigidObject temp = new RigidObject(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc);
        objects.add(temp);
        all_objects.add(temp);
    }
    
    public static void addAnimatedObject(String resource, String name, int x, int y, int rot,
            double xsc, double ysc, int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addAnimation(resource + format);
        ArrayList<BufferedImage> ani = LoadImages.getLastAnimation();
        AnimatedObject temp = new AnimatedObject(name, ani, x, y,
                ani.get(0).getWidth(),
                ani.get(0).getHeight(), 0, rot, xsc, ysc, format);
        ani_objects.add(temp);
        all_objects.add(temp);
    }
    
    public static void addObject(String resource, String name, int x, int y, int rot, double xsc, double ysc,
            String objtype, int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addImage(resource + format);
        RigidObject temp = new RigidObject(name, LoadImages.getLastSprite(), x, y,
                LoadImages.getLastSprite().getWidth(),
                LoadImages.getLastSprite().getHeight(), 0, rot, xsc, ysc, objtype);
        objects.add(temp);
        all_objects.add(temp);
    }
    
    public static void addObject(String resource, String name, int x, int y, int width, int height,
            int rot, double xsc, double ysc, String objtype, int img_format)
    {
        String format = "";
        switch (img_format)
        {
        case IMG_PNG:
        {
            format = ".png";
            break;
        }
        case IMG_GIF:
        {
            format = ".gif";
            break;
        }
        case IMG_JPEG:
        {
            format = ".jpeg";
            break;
        }
        default:
            break;
        }
        LoadImages.addImage(resource + format);
        RigidObject temp = new RigidObject(name, LoadImages.getLastSprite(), x, y,
                width, height, 0, rot, xsc, ysc, objtype);
        objects.add(temp);
        all_objects.add(temp);
    }
    
    public static void addSound(String name, String file)
    {
        LoadAudio.addSound(name, file);
        sounds.add(LoadAudio.getLastSound());
    }
    
    // GET METHODS
    public static ArrayList<RigidObject> getObjects()
    {
        return objects;
    }
    
    public static ArrayList<AnimatedObject> getAnimatedObjects()
    {
        return ani_objects;
    }
    
    public static ArrayList<AbstractObject> getAllObjects()
    {
        return all_objects;
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
    
    public static ArrayList<Sound> getSounds()
    {
        return sounds;
    }

    // Main Methods
    public static RigidObject iobj(String name)
    {
        if (!objects.isEmpty())
        {
            for (int i = 0; i < objects.size(); i++)
            {
                if (objects.get(i).getName().equals(name))
                {
                    return objects.get(i);
                }
            }
        }
        return null;
    }

    public static AnimatedObject aobj(String name)
    {
        if (!ani_objects.isEmpty())
        {
            for (int i = 0; i < ani_objects.size(); i++)
            {
                if (ani_objects.get(i).getName().equals(name))
                {
                    return ani_objects.get(i);
                }
            }
        }
        return null;
    }
    
    public static AbstractObject obj(String name)
    {
        if (!all_objects.isEmpty())
        {
            for (int i = 0; i < all_objects.size(); i++)
            {
                if (all_objects.get(i).getName().equals(name))
                {
                    return all_objects.get(i);
                }
            }
        }
        return null;
    }
    
    public static Background bg(String name)
    {
        if (!backgrounds.isEmpty())
        {
            for (int i = 0; i < backgrounds.size(); i++)
            {
                if (backgrounds.get(i).getName().equals(name))
                {
                    return backgrounds.get(i);
                }
            }
        }
        return null;
    }
    
    public static FixedBackground fbg(String name)
    {
        if (!fixed_backgrounds.isEmpty())
        {
            for (int i = 0; i < fixed_backgrounds.size(); i++)
            {
                if (fixed_backgrounds.get(i).getName().equals(name))
                {
                    return fixed_backgrounds.get(i);
                }
            }
        }
        return null;
    }

    public static MovingBackground mbg(String name)
    {
        if (!moving_backgrounds.isEmpty())
        {
            for (int i = 0; i < moving_backgrounds.size(); i++)
            {
                if (moving_backgrounds.get(i).getName().equals(name))
                {
                    return moving_backgrounds.get(i);
                }
            }
        }
        return null;
    }

    public static ParallaxBackground pbg(String name)
    {
        if (!parallax_backgrounds.isEmpty())
        {
            for (int i = 0; i < parallax_backgrounds.size(); i++)
            {
                if (parallax_backgrounds.get(i).getName().equals(name))
                {
                    return parallax_backgrounds.get(i);
                }
            }
        }
        return null;
    }
    
    public static Sound snd(String name)
    {
        if (!sounds.isEmpty())
        {
            for (int i = 0; i < sounds.size(); i++)
            {
                if (sounds.get(i).getName().equals(name))
                {
                    return sounds.get(i);
                }
            }
        }
        return null;
    }

    public static void delete(java.lang.Object o)
    {
        o = null;
    }
    
    public static void createObject(RigidObject o, double xcoord, double ycoord)
    {
        //addObject("", o.getName(), xcoord, ycoord, o.getWidth(), o.getHeight(), 
          //      o.getRotation(), o.getXscale(), o.getYscale(), o.getType());
    }
    
}