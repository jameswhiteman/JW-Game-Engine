package jw.engine.abstracts;

import jw.engine.components.CollisionMask;
import jw.engine.interfaces.Transformable;

abstract public class AbstractObject implements Transformable
{
    // Properties of the object.
    private String name;
    private double x;
    private double y;
    private int width;
    private int height;
    private int depth;
    
    // Collision Mask properties.
    private CollisionMask mask;
    private boolean solid = false;
    
    // Image transform variables
    private int rotation = 0;
    private double hscale = 1.0;
    private double vscale = 1.0;
    
    public AbstractObject()
    {
        name = "unnamed";
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        depth = 0;
    }
    
    public AbstractObject(String name)
    {
        this.name = name;
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        depth = 0;
    }
    
    public AbstractObject(String name, double x, double y)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        width = 0;
        height = 0;
        depth = 0;
    }
    
    public AbstractObject(String name, double x, double y, int width, int height)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        depth = 0;
    }
    
    public AbstractObject(String name, double x, double y, int width, int height, int depth)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    
    // MAIN METHODS
    
    // SET METHODS
    
    public void setName(String p_name)
    {
        name = p_name;
    }
    
    public void setX(double d)
    {
        x = d;
    }
    
    public void setY(double d)
    {
        y = d;
    }
    
    public void setWidth(int p_width)
    {
        width = p_width;
    }
    
    public void setHeight(int p_height)
    {
        height = p_height;
    }
    
    public void setDepth(int p_depth)
    {
        depth = p_depth;
    }
    
    public void setMask(CollisionMask mask)
    {
        this.mask = mask;
    }
    
    public void setSolid(boolean solidity)
    {
        solid = solidity;
    }

    @Override
    public void setRotation(int rot)
    {
        rotation = rot;
    }

    @Override
    public void setHorizontalScale(double scale)
    {
        hscale = scale;
    }

    @Override
    public void setVerticalScale(double scale)
    {
        vscale = scale;
    }

    @Override
    public void setScale(double s1, double s2)
    {
        hscale = s1;
        vscale = s2;
    }
    
    // GET METHODS
    
    public String getName()
    {
        return name;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getDepth()
    {
        return depth;
    }
    
    public CollisionMask getMask()
    {
        return mask;
    }
    
    public boolean getSolid()
    {
        return solid;
    }
    
    public double getMaskLeft()
    {
        return (x - (mask.getWidth() / 2));
    }
    
    public double getMaskRight()
    {
        return (x + (mask.getWidth() / 2));
    }
    
    public double getMaskTop()
    {
        return (y - (mask.getHeight() / 2));
    }
    
    public double getMaskBottom()
    {
        return (y + (mask.getHeight() / 2));
    }
    
    public int getMaskWidth()
    {
        return mask.getWidth();
    }
    
    public int getMaskHeight()
    {
        return mask.getHeight();
    }

    @Override
    public int getRotation()
    {
        return rotation;
    }

    @Override
    public double getHorizontalScale()
    {
        return hscale;
    }
    
    @Override
    public double getVerticalScale()
    {
        return vscale;
    }
}
