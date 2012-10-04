package mfe.engine.components;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

public class TransformImage
{
    public static AffineTransform transform(int deg, double xscale, double yscale,
            int x, int y, int width, int height, Graphics g)
    {
        AffineTransform transform = new AffineTransform();
        transform.translate(x - (width / 2), y - (height / 2));
        transform.scale(xscale, yscale);
        transform.rotate(Math.toRadians(deg));
        return transform;
    }
}
