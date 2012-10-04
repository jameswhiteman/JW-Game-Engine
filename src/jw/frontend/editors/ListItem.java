package jw.frontend.editors;

import java.awt.image.BufferedImage;

public class ListItem
{
    private String name;
    private BufferedImage sprite;
    private int depth;
    
    public ListItem()
    {
        name = "<unnamed>";
        sprite = null;
        depth = 0;
    }
    
    public ListItem(String str, BufferedImage img, int dep)
    {
        name = str;
        sprite = img;
        depth = dep;
    }
    
    public String getName()
    {
        return name;
    }
    
    public BufferedImage getSprite()
    {
        return sprite;
    }
    
    public int getDepth()
    {
        return depth;
    }
}
