package mfe.engine.init;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private Dimension panelSize = new Dimension(640, 480);
    public volatile boolean running;
    
    public GamePanel()
    {
        paintComponent(null);
        setPreferredSize(panelSize);
        setBackground(Color.WHITE);
        setFocusable(true);
        requestFocus();
    }
}
