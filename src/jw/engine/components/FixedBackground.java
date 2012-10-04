package jw.engine.components;

import java.awt.image.BufferedImage;

import jw.engine.abstracts.AbstractImageObject;
import jw.engine.interfaces.Transformable;



public class FixedBackground extends AbstractImageObject implements Transformable
{
    public FixedBackground(String name, BufferedImage lastSprite, int x, int y,
            int width, int height, int i, int rot, double xsc, double ysc)
    {
        setName(name);
        setSprite(lastSprite);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setDepth(i);
        setRotation(rot);
        setScale(xsc, ysc);
    }
}
