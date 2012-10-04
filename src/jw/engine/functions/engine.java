package jw.engine.functions;

import java.awt.Graphics;
import java.io.IOException;

import jw.engine.loop.UpdateDrawing;


public class engine
{
    public static void Update(Graphics g) throws IOException
    {
        UpdateDrawing.update(g);
    }
}
