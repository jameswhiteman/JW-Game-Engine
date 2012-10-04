package jw.engine.init;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Game implements KeyListener, MouseListener, MouseMotionListener
{
    protected boolean over = false;
    protected long delay = 6 * 1000000;
    protected int width = 640;
    protected int height = 480;
    protected String title = "Cyber Servant";
    
    abstract public void init();
    abstract public void update();
    abstract public void draw(Graphics g);
    
    public boolean isOver()
    {
        return over;
    }
    
    public long getDelay()
    {
        return delay;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    @Override
    public void mouseDragged(MouseEvent arg0)
    {
    }

    @Override
    public void mouseMoved(MouseEvent arg0)
    {
    }

    @Override
    public void mouseClicked(MouseEvent arg0)
    {
    }

    @Override
    public void mouseEntered(MouseEvent arg0)
    {
    }

    @Override
    public void mouseExited(MouseEvent arg0)
    {
    }

    @Override
    public void mousePressed(MouseEvent arg0)
    {
    }

    @Override
    public void mouseReleased(MouseEvent arg0)
    {
    }

    @Override
    public void keyPressed(KeyEvent arg0)
    {
    }

    @Override
    public void keyReleased(KeyEvent arg0)
    {
    }

    @Override
    public void keyTyped(KeyEvent arg0)
    {
    }

}
