package jw.engine.logic;

import java.awt.Rectangle;

import jw.engine.abstracts.AbstractObject;



public class Collision
{
    // If any two objects collide
    public static boolean Col(AbstractObject o1, AbstractObject o2)
    {
        Rectangle r1 = new Rectangle(o1.getMaskWidth(), o1.getMaskHeight());
        Rectangle r2 = new Rectangle(o2.getMaskWidth(), o2.getMaskHeight());
        
        if (r1.intersects(r2))
            return true;
        else
            return false;
    }
    
    // If at least one object is solid
    public static boolean SolidCol(AbstractObject o1, AbstractObject other)
    {
        Rectangle r1 = new Rectangle(o1.getMaskWidth(), o1.getMaskHeight());
        Rectangle r2 = new Rectangle(other.getMaskWidth(), other.getMaskHeight());
        r1.x = (int) o1.getX();
        r1.y = (int) o1.getY();
        r2.x = (int) other.getX();
        r2.y = (int) other.getY();
        if (r1.intersects(r2) && (o1.getSolid() || other.getSolid()))
            return true;
        else
            return false;
    }
    
    // If both objects are solid
    public static boolean SolidsCol(AbstractObject o1, AbstractObject o2)
    {
        Rectangle r1 = new Rectangle(o1.getMaskWidth(), o1.getMaskHeight());
        Rectangle r2 = new Rectangle(o2.getMaskWidth(), o2.getMaskHeight());
        
        if (r1.intersects(r2) && o1.getSolid() && o2.getSolid())
            return true;
        else
            return false;
    }
}
