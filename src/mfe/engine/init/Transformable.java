package mfe.engine.init;

public interface Transformable
{
    int rotation = 0;
    double xscale = 1.0;
    double yscale = 1.0;
    
    // SET METHODS
    public void setRotation(int rot);
    public void setXscale(double scale);
    public void setYscale(double scale);
    public void setScale(double x, double y);
    
    // GET METHODS
    public int getRotation();
    public double getXscale();
    public double getYscale();
}
