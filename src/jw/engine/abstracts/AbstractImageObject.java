package jw.engine.abstracts;

import java.awt.image.BufferedImage;

public abstract class AbstractImageObject extends AbstractObject
{
    private BufferedImage sprite;
    
    // CONSTRUCTORS
    public AbstractImageObject()
    {
        super();
        sprite = null;
    }
    
    public AbstractImageObject(String name, double x, double y)
    {
        super(name, x, y);
        sprite = null;
    }
    
    public AbstractImageObject(BufferedImage sprite)
    {
        super();
        this.sprite = sprite;
        setWidth(sprite.getWidth());
        setHeight(sprite.getHeight());
    }
    
    public AbstractImageObject(BufferedImage sprite, String name)
    {
        super(name);
        this.sprite = sprite;
        setWidth(sprite.getWidth());
        setHeight(sprite.getHeight());
    }
    
    public AbstractImageObject(BufferedImage sprite, String name, double x, double y)
    {
        super(name, x, y, sprite.getWidth(), sprite.getHeight());
        this.sprite = sprite;
    }
    
    public AbstractImageObject(String name, double x, double y, int width, int height, int depth)
    {
        super(name, x, y, width, height, depth);
        sprite = null;
    }
    
    public AbstractImageObject(BufferedImage sprite, String name, double x, double y, int width,
            int height, int depth)
    {
        super(name, x, y, width, height, depth);
        this.sprite = sprite;
    }
    
    // SET METHODS
    public void setSprite(BufferedImage img)
    {
        sprite = img;
    }
    
    // GET METHODS
    public BufferedImage getSprite()
    {
        return sprite;
    }
}
