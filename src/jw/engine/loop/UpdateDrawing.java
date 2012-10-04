package jw.engine.loop;

import java.awt.Graphics;
import java.io.IOException;

import jw.engine.components.DrawImages;
import jw.engine.load.Components;


public class UpdateDrawing
{
    public static void update(Graphics g)
    {
        for (int i = 0; i < Components.getObjects().size(); i++)
        {
            Components.getObjects().get(i).updatePosition();
        }
        
        for (int i = 0; i < Components.getObjects().size(); i++)
        {
            DrawImages.draw_objects(Components.getObjects().get(i), g);
        }
        
        for (int i = 0; i < Components.getAnimatedObjects().size(); i++)
        {
            try
            {
                DrawImages.draw_animated_objects(Components.getAnimatedObjects().get(i), g);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
        for (int i = 0; i < Components.getBackgrounds().size(); i++)
        {
            DrawImages.draw_backgrounds(Components.getBackgrounds().get(i), g);
        }
        
        for (int i = 0; i < Components.getFixedBackgrounds().size(); i++)
        {
            DrawImages.draw_fixed_backgrounds(Components.getFixedBackgrounds().get(i), g);
        }
        
        for (int i = 0; i < Components.getMovingBackgrounds().size(); i++)
        {
            DrawImages.draw_moving_backgrounds(Components.getMovingBackgrounds().get(i), g);
        }
        
        for (int i = 0; i < Components.getParallaxBackgrounds().size(); i++)
        {
            DrawImages.draw_parallax_backgrounds(Components.getParallaxBackgrounds().get(i), g);
        }
    }
}
