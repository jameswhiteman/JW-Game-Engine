package jw.engine.interfaces;

public interface Transformable
{
    int rotation = 0;
    double xscale = 1.0;
    double yscale = 1.0;
    
    // SET METHODS
    public void setRotation(int rot);
    public void setHorizontalScale(double scale);
    public void setVerticalScale(double scale);
    public void setScale(double x, double y);
    
    // GET METHODS
    public int getRotation();
    public double getHorizontalScale();
    public double getVerticalScale();
}
