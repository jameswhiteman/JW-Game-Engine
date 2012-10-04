package jw.engine.init;

//import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener
{
    //private static final long serialVersionUID = 1L;
    
    public static final int LEFT = KeyEvent.VK_LEFT;
    public static final int RIGHT = KeyEvent.VK_RIGHT;
    public static final int UP = KeyEvent.VK_UP;
    public static final int DOWN = KeyEvent.VK_DOWN;
    public static final int CTR_LEFT = 0;
    public static final int CTR_RIGHT = 1;
    public static final int CTR_UP = 2;
    public static final int CTR_DOWN = 3;
    public static final int TOTAL_CONTROLS = 4;
    
    private int[] controls = new int[TOTAL_CONTROLS];
    
    private boolean[] keyDown = new boolean[controls.length];
    private boolean[] keyState = new boolean[controls.length];
    private boolean[] keyUp = new boolean[controls.length];
    
    public Controller()
    {
        controls[CTR_LEFT] = LEFT;
        controls[CTR_RIGHT] = RIGHT;
        controls[CTR_UP] = UP;
        controls[CTR_DOWN] = DOWN;
    }

    @Override
    public void keyPressed(KeyEvent k)
    {
        for (int i = 0; i < controls.length; i++)
        {
            if (k.getKeyCode() == controls[i])
            {
                keyUp[i] = false;
                keyDown[i] = true;
                keyState[i] = true;
            }
            else
                keyDown[i] = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent k)
    {
        for (int i = 0; i < controls.length; i++)
        {
            if (k.getKeyCode() == controls[i])
            {
                keyUp[i] = true;
                keyDown[i] = false;
                keyState[i] = false;
            }
            else
                keyUp[i] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent k)
    {
    }
    
    public boolean[] getKeyStates()
    {
        return keyState;
    }
    
    /*public KeyEvent()
    {
        controls[LEFT] = KeyEvent.VK_A;
        controls[RIGHT] = KeyEvent.VK_D;
        controls[UP] = KeyEvent.VK_W;
        controls[DOWN] = KeyEvent.VK_S;
    }*/
}
