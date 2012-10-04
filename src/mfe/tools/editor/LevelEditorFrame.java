package mfe.tools.editor;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class LevelEditorFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    
    // Frame Variables
    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private final String TITLE = "MFE Level Editor";
    private JPanel panelMain = new JPanel();
    
    // Menu Bar Variables
    private JMenuBar barMain = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenuItem itemFileNew = new JMenuItem("New");
    private JMenuItem itemFileLoad = new JMenuItem("Load");
    private JMenuItem itemFileSave = new JMenuItem("Save");
    private JMenuItem itemFileSaveAs = new JMenuItem("Save As...");
    private JMenuItem itemFileExit = new JMenuItem("Exit");
    
    // Combo Box Initialization
    UpdateObjects updater = new UpdateObjects();
    String[] listObjects = new String[updater.getList().size()];
    private JComboBox<String> comboObjects;
    
    public LevelEditorFrame() throws ClassNotFoundException, IOException
    {
        updater.update();
        for (int i = 0; i < updater.getList().size(); i++)
        {
            listObjects[i] = updater.getList().get(i).getName();
            System.out.println(updater.getList().get(i).getName());
        }
        comboObjects = new JComboBox<String>(listObjects);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        setBackground(Color.red);
        setJMenuBar(barMain);
        setItems();
        comboObjects.setEditable(false);
        comboObjects.addActionListener(new comboListener());
        barMain.add(menuFile);
        menuFile.add(itemFileNew);
        menuFile.add(itemFileLoad);
        menuFile.add(itemFileSave);
        menuFile.add(itemFileSaveAs);
        menuFile.add(itemFileExit);
        add(panelMain);
    }
    
    public void setItems()
    {
        panelMain.add(comboObjects);
    }
    
    // Action Listeners
    private class comboListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
        }
        
    }
}
