package mfe.engine.components;

import java.awt.image.BufferedImage;

import mfe.engine.init.Transformable;


public class ParallaxBackground extends AbstractObject implements Transformable
{
    private int rotation = 0;
    private double xscale = 1;
    private double yscale = 1;

    public ParallaxBackground(String name, BufferedImage lastSprite, int x,
            int y, int width, int height, int i, int rot, double xsc, double ysc)
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
