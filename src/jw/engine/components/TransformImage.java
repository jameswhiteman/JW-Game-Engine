package jw.engine.components;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

public class TransformImage
{
    public static AffineTransform transform(int deg, double xscale, double yscale,
            double d, double e, int width, int height, Graphics g)
    {
        AffineTransform transform = new AffineTransform();
        transform.translate(d - (width / 2), e - (height / 2));
        transform.scale(xscale, yscale);
        transform.rotate(Math.toRadians(deg));
        return transform;
    }
}
