package mfe.tools.editor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import mfe.engine.load.Components;

public class WriteObjects
{
    public static void write() throws IOException
    {
        FileOutputStream file = new FileOutputStream("ListObjects.lvl");
        ObjectOutputStream stream = new ObjectOutputStream(file);
        stream.write(Components.getObjects().size());
        for (int i = 0; i < Components.getObjects().size(); i++)
        {
            stream.writeChars(Components.getObjects().get(i).getName());
            stream.writeObject(Components.getObjects().get(i).getSprite());
            stream.write(Components.getObjects().get(i).getDepth());
            /*
            stream.writeDouble(Components.getObjects().get(i).getMaxlspeed());
            stream.writeDouble(Components.getObjects().get(i).getMaxrspeed());
            stream.writeDouble(Components.getObjects().get(i).getMaxuspeed());
            stream.writeDouble(Components.getObjects().get(i).getMaxdspeed());
            
            stream.writeDouble(Components.getObjects().get(i).getMovelspeed());
            stream.writeDouble(Components.getObjects().get(i).getMoverspeed());
            stream.writeDouble(Components.getObjects().get(i).getMoveuspeed());
            stream.writeDouble(Components.getObjects().get(i).getMovedspeed());
            
            stream.writeDouble(Components.getObjects().get(i).getMovelincr());
            stream.writeDouble(Components.getObjects().get(i).getMoverincr());
            stream.writeDouble(Components.getObjects().get(i).getMoveuincr());
            stream.writeDouble(Components.getObjects().get(i).getMovedincr());
            
            stream.writeDouble(Components.getObjects().get(i).getHspeed());
            stream.writeDouble(Components.getObjects().get(i).getVspeed());
            
            stream.writeDouble(Components.getObjects().get(i).getFriction());
            stream.writeDouble(Components.getObjects().get(i).getGravity());
            stream.write(Components.getObjects().get(i).getGravityDirection());
            
            stream.writeBoolean(Components.getObjects().get(i).getSolid());
            stream.writeBoolean(Components.getObjects().get(i).getVisible());
            stream.writeChars(Components.getObjects().get(i).getType());
            
            stream.write(Components.getObjects().get(i).getRotation());
            stream.writeDouble(Components.getObjects().get(i).getXscale());
            stream.writeDouble(Components.getObjects().get(i).getYscale());*/
        }
        stream.close();
        file.close();
    }
}
