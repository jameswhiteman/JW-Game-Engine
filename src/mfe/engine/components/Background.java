package mfe.engine.components;

import java.awt.image.BufferedImage;

import mfe.engine.init.Transformable;


public class Background extends AbstractObject implements Transformable
{
    int rotation = 0;
    double xscale = 1.0;
    double yscale = 1.0;
    
    public Background()
    {
        super();
    }
    
    public Background(int x, int y)
    {
        super("unnamed", null, x, y, 0, 0, 0);
    }
    
    public Background(String name, BufferedImage sprite, int x, int y)
    {
        super(name, sprite, x, y, sprite.getWidth(), sprite.getHeight(), 0);
    }
    
    public Background(String name, BufferedImage sprite, int x, int y, int width, int height, int depth)
    {
        super(name, sprite, x, y, width, height, depth);
    }
    
    public Background(String name, BufferedImage sprite, int x, int y, int width, int height, int depth, int rot, double xsc, double ysc)
    {
        super(name, sprite, x, y, width, height, depth);
        setRotation(rot);
        setScale(xsc, ysc);
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

    // AbstractTransformable methods
    @Override
    public void setRotation(int rot)
    {
        rotation = rot;
    }

    @Override
    public void setXscale(double scale)
    {
        xscale = scale;
    }

    @Override
    public void setYscale(double scale)
    {
        yscale = scale;
    }

    @Override
    public void setScale(double x, double y)
    {
        xscale = x;
        yscale = y;
    }

    @Override
    public int getRotation()
    {
        return rotation;
    }

    @Override
    public double getXscale()
    {
        return xscale;
    }

    @Override
    public double getYscale()
    {
        return yscale;
    }
}
