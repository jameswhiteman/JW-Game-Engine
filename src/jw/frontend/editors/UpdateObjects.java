package jw.frontend.editors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class UpdateObjects
{
    private ArrayList<ListItem> objects;
    private JFileChooser filechooser = new JFileChooser();
    
    public UpdateObjects()
    {
        objects = new ArrayList<ListItem>();
    }
    
    public void update() throws IOException, ClassNotFoundException
    {
        try
        {
            File f = filechooser.getSelectedFile();
            FileInputStream file = new FileInputStream(f);
            ObjectInputStream stream = new ObjectInputStream(file);
            int num = stream.read();
            System.out.println(num);
            for (int i = 0; i < num; i++)
            {
                String str = stream.readUTF();
                System.out.println(str);
                BufferedImage img = (BufferedImage) stream.readObject();
                int dep = stream.read();
                ListItem obj = new ListItem(str, img, dep);
                objects.add(obj);
            }
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
    }
    
    public ArrayList<ListItem> getList()
    {
        return objects;
    }
}
