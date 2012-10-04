package jw.engine.init;

import javax.swing.JPanel;

//import com.sun.istack.internal.logging.Logger;

public class GameLoop extends Thread
{
    private final Game game;
    private final JPanel canvas;
    private Controller input;
    private final int MAX_DELAYS = 10;
    
    int delays = 0;
    long before, after, diff, sleepTime, over = 0;
    
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
            before = System.nanoTime();
            game.update();
            canvas.repaint();
            VirtualInput.setKeyStates(input.getKeyStates());
            after = System.nanoTime();
            diff = Math.abs(after - before);
            try
            {
                sleepTime = (game.getDelay() - diff - over) / 1000000;
                if (diff < game.getDelay() && diff > 0)
                    sleep(sleepTime);
                else if (diff > game.getDelay())
                    over = diff - game.getDelay();
                else if (++delays >= MAX_DELAYS)
                {
                    yield();
                    delays = 0;
                    over = 0;
                }
                else
                {
                    over = 0;
                }
                //logPerformance();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    @SuppressWarnings("unused")
    private void logPerformance()
    {
        log("Before:     " + before);
        log("After:      " + after);
        log("Difference: " + diff);
        log("Sleep time: " + sleepTime);
        log("Overtime:   " + over);
        log("Delays:     " + delays);
        log("");
    }
    
    private void log(String s)
    {
        System.out.println(s);
    }
}
