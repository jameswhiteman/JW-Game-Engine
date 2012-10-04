package mfe.engine.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;


public class DrawImages
{
    public static void draw_objects(Object obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getXscale(), obj.getYscale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
    
    public static void draw_backgrounds(Background obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getXscale(), obj.getYscale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
    
    public static void draw_fixed_backgrounds(FixedBackground obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getXscale(), obj.getYscale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
    
    public static void draw_moving_backgrounds(MovingBackground obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getXscale(), obj.getYscale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
    
    public static void draw_parallax_backgrounds(ParallaxBackground obj, Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform afftrans = TransformImage.transform(obj.getRotation(),
                obj.getXscale(), obj.getYscale(), obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
        if (obj.getSprite() != null)
            g2.drawImage(obj.getSprite(),afftrans, null);
    }
}
