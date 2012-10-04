package jw.engine.components;

import jw.engine.abstracts.AbstractObject;

public class CollisionMask
{
    private int width;
    private int height;
    
    public CollisionMask()
    {
        width = 16;
        height = 16;
    }
    
    public CollisionMask(int p_width, int p_height)
    {
        width = p_width;
        height = p_height;
    }
    
    public CollisionMask(AbstractObject o)
    {
        width = o.getWidth();
        height = o.getHeight();
    }
    
    public void setWidth(int p_width)
    {
        width = p_width;
    }
    
    public void setHeight(int p_height)
    {
        height = p_height;
    }
    
    public void setSize(int p_width, int p_height)
    {
        width = p_width;
        height = p_height;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
}
