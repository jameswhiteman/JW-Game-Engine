package mfe.engine.init;

import javax.swing.JPanel;

//import com.sun.istack.internal.logging.Logger;

public class GameLoop extends Thread
{
    private final Game game;
    private final JPanel canvas;
    private Controller input;
    public static boolean[] keys;
    
    public GameLoop(Game game, JPanel canvas2)
    {
        this.game = game;
        this.canvas = canvas2;
        input = new Controller();
        canvas.addKeyListener(input);
    }
    
    @Override
    public void run()
    {
        game.init();
        
        while (!game.isOver())
        {
            game.update();
            canvas.repaint();
            VirtualInput.setKeyStates(input.getKeyStates());
            try
            {
                Thread.sleep(game.getDelay());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
