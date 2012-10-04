package jw.engine.init;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameApplication
{
    public static void start(Game game)
    {
        JFrame frame = new JFrame(game.getTitle());
        frame.setSize(game.getWidth(), game.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel canvas = new GameCanvas(game);
        frame.add(canvas);
        frame.setVisible(true);
        GameLoop loop = new GameLoop(game, canvas);
        loop.start();
    }
}
