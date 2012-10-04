package jw.engine.init;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GameCanvas extends JPanel implements Runnable
{
    private static final long serialVersionUID = 1L;
    
    private final Game game;
    private Dimension panelSize = new Dimension(640, 480);
    public volatile boolean running;
    
    public GameCanvas(Game game)
    {
        this.game = game;
        addKeyListener(this.game);
        addMouseListener(this.game);
        addMouseMotionListener(this.game);
        setPreferredSize(panelSize);
        setBackground(Color.WHITE);
        setFocusable(true);
        requestFocus();
        requestFocus();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        game.draw(g);
    }

    @Override
    public void run()
    {
        
    }
}
