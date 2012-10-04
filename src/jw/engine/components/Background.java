package jw.engine.components;

import java.awt.image.BufferedImage;

import jw.engine.abstracts.AbstractImageObject;


public class Background extends AbstractImageObject
{
    // Constructors.
    public Background()
    {
        super();
    }
    
    public Background(int x, int y)
    {
        super(null, "unnamed", x, y);
    }
    
    public Background(String name, BufferedImage sprite, int x, int y)
    {
        super(sprite, name, x, y, sprite.getWidth(), sprite.getHeight(), 0);
    }
    
    public Background(String name, BufferedImage sprite, int x, int y, int width, int height, int depth)
    {
        super(sprite, name, x, y, width, height, depth);
    }
    
    public Background(String name, BufferedImage sprite, int x, int y, int width, int height, int depth, int rot, double xsc, double ysc)
    {
        super(sprite, name, x, y, width, height, depth);
        super.setRotation(rot);
        super.setScale(xsc, ysc);
    }
    
    // Update method
    public void update()
    {
    }
    
    // SET METHODS
    
    public void setPosition(int p_x, int p_y)
    {
        super.setX(p_x);
        super.setY(p_y);
    }
    
    public void setSize(int p_width, int p_height)
    {
        super.setWidth(p_width);
        super.setHeight(p_height);
    }
}
