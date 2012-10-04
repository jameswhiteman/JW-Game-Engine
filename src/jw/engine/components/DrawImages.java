package jw.engine.components;

import java.awt.Graphics;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawImages
{
    static int animation_frame_count = 0;

    public static void draw_objects(RigidObject obj, Graphics g)
    {
        BufferedImage img = obj.getSprite();
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getHorizontalScale(), obj.getVerticalScale(), obj.getX(),
                obj.getY(), obj.getWidth(), obj.getHeight(), g);
        
        if (img != null)
            g2.drawImage(img,afftrans, null);        
    }
    
    public static void draw_animated_objects(AnimatedObject obj, Graphics g) throws IOException
    {
        BufferedImage img = obj.getFrameImage();
        obj.updateAnimation();
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getHorizontalScale(), obj.getVerticalScale(), obj.getX(),
                obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (img != null)
            g2.drawImage(img,  afftrans, null);
    }
    
    public static void draw_backgrounds(Background obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getHorizontalScale(), obj.getVerticalScale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
    
    public static void draw_fixed_backgrounds(FixedBackground obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getHorizontalScale(), obj.getVerticalScale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
    
    public static void draw_moving_backgrounds(MovingBackground obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getHorizontalScale(), obj.getVerticalScale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
    
    public static void draw_parallax_backgrounds(ParallaxBackground obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getHorizontalScale(), obj.getVerticalScale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
}
