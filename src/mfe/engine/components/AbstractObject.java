package mfe.engine.components;

import java.awt.image.BufferedImage;

abstract public class AbstractObject
{
    private String name;
    private BufferedImage sprite;
    private int x;
    private int y;
    private int width;
    private int height;
    private int depth;
    
    public AbstractObject()
    {
        name = "unnamed";
        sprite = null;
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        depth = 0;
    }
    
    public AbstractObject(String name, BufferedImage sprite, int x, int y, int width, int height, int depth)
    {
        this.name = name;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    
    public void setName(String p_name)
    {
        name = p_name;
    }
    
    public void setSprite(BufferedImage p_sprite)
    {
        sprite = p_sprite;
    }
    
    public void setX(int p_x)
    {
        x = p_x;
    }
    
    public void setY(int p_y)
    {
        y = p_y;
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
    
    // GET METHODS
    
    public String getName()
    {
        return name;
    }
    
    public BufferedImage getSprite()
    {
        return sprite;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
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
}
