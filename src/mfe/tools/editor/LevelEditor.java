package mfe.tools.editor;

import java.io.IOException;

import javax.swing.*;

public class LevelEditor
{
    public static void main(String [] args)
    {
        JFrame frame = null;
        try
        {
            frame = new LevelEditorFrame();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        frame.setVisible(true);
    }
}
