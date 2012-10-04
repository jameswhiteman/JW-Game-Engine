package jw.frontend.main;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final String TITLE = "JW Frontend";
    
    public MainFrame()
    {
        setJMenuBar(FrameMenus.addAllMenus());
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
