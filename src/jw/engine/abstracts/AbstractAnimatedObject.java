package jw.engine.abstracts;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public abstract class AbstractAnimatedObject extends AbstractObject
{
    private int current_frame = 0;
    private double frame_buffer = 0;
    private double animation_speed;
    private ArrayList<BufferedImage> animation;
    private BufferedImage frame_image;
    
    public AbstractAnimatedObject()
    {
        super();
        current_frame = 0;
        frame_buffer = 0;
        animation_speed = 0;
        animation = null;
        frame_image = null;
    }
    
    public AbstractAnimatedObject(String name, double x, double y)
    {
        super(name, x, y);
        current_frame = 0;
        frame_buffer = 0;
        animation_speed = 0;
        animation = null;
        frame_image = null;
    }
    
    public AbstractAnimatedObject(ArrayList<BufferedImage> animation)
    {
        super();
        this.animation = animation;
    }
    
    public AbstractAnimatedObject(ArrayList<BufferedImage> animation, String name, double x, double y)
    {
        super(name, x, y);
        current_frame = 0;
        frame_buffer = 0;
        animation_speed = 0;
        this.animation = animation;
        if (animation.get(current_frame) != null)
            frame_image = animation.get(current_frame);
        setWidth(frame_image.getWidth());
        setHeight(frame_image.getHeight());
    }
    
    public AbstractAnimatedObject(ArrayList<BufferedImage> animation, String name, double x, double y,
            int width, int height, int depth)
    {
        super(name, x, y, width, height, depth);
        current_frame = 0;
        frame_buffer = 0;
        animation_speed = 0;
        this.animation = animation;
        if (animation.get(current_frame) != null)
            frame_image = animation.get(current_frame);
    }
    
    public void updateAnimation()
    {
        if (frame_buffer < animation.size() - 1)
            frame_buffer += animation_speed;
        else if (frame_buffer < 0)
            frame_buffer = animation.size() - 1;
        else
            frame_buffer = 0;
        current_frame = (int) frame_buffer;
        if (animation.get(current_frame) != null)
            frame_image = animation.get(current_frame);
        //System.out.println("Animation Speed: " + animation_speed + ", Current Frame: " + frame_buffer);
    }
    
    // SET METHODS
    public void setCurrentFrame(int p_current_frame)
    {
        if (p_current_frame <= animation.size() - 1 && p_current_frame >= 0)
            current_frame = p_current_frame;
    }

    public void setFrameBuffer(double p_frame_buffer)
    {
        if (p_frame_buffer >= 0)
            frame_buffer = p_frame_buffer;
    }

    public void setAnimationSpeed(double p_animation_speed)
    {
        animation_speed = p_animation_speed;
    }

    public void setAnimation(ArrayList<BufferedImage> p_animation)
    {
        animation = p_animation;
    }
    
    public void setFrameImage(BufferedImage p_frame_image)
    {
        frame_image = p_frame_image;
    }
    
    // GET METHODS
    public int getCurrentFrame()
    {
        return current_frame;
    }
    
    public double getFrameBuffer()
    {
        return frame_buffer;
    }
    
    public double getAnimationSpeed()
    {
        return animation_speed;
    }
    
    public ArrayList<BufferedImage> getAnimation()
    {
        return animation;
    }
    
    public BufferedImage getFrameImage()
    {
        return frame_image;
    }
    
    public int getAnimationSize()
    {
        return animation.size();
    }
}
