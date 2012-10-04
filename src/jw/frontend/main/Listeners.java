package jw.frontend.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Listeners
{
    public static class open_game_listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser choose = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JWG file", "jwg");
            choose.addChoosableFileFilter(filter);
            int decision = choose.showOpenDialog(null);
            if (decision == JFileChooser.APPROVE_OPTION)
            {
                String s = choose.getSelectedFile().getAbsolutePath();
                if (s.substring(s.length() - 4, s.length() - 1).equals("jwg"))
                    BackendManager.setGameFile(choose.getSelectedFile());
                else
                    JOptionPane.showMessageDialog(null, "Hello!");
            }
        }
    }
}
