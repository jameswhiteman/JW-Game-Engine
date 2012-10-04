package cs.main;

import java.awt.Graphics;

import java.io.IOException;

import jw.engine.functions.engine;
import jw.engine.functions.resource;
import jw.engine.init.Game;
import jw.engine.init.GameApplication;
import jw.engine.load.Components;


public class CyberServant extends Game
{
    public CyberServant()
    {
    }
    
    @Override
    public void init()
    {
        Components.addSound("alex", "mus.wav");
        Components.addAnimatedObject("counter.gif", "player", 50, 60, 0, 1, 1, Components.IMG_CUSTOM);
        Components.addObject("big_truck_01", "wall", 50, 400, 0, 1, 1, Components.IMG_PNG);
        Components.addMovingBackground("administration_building", "building", 250, 300, 0, 1, 1, Components.IMG_PNG);
        Components.addParallaxBackground("cobra_2", "cobra", 320, 240, 45, 4, 4, Components.IMG_PNG);
        Components.aobj("player").setFriction(0.25);
        Components.aobj("player").setMoveIncrements(0.35, 0.35, 0, 0);
        Components.aobj("player").setMoveSpeeds(-2, 2, 0, 0);
        //Components.obj("player").setGravity(0.07, 10.0, 270);
        //Components.obj("wall").setSolid(true);
        Components.aobj("player").setAnimationSpeed(0.15);
        resource.playSound("alex");
        /*
        try
        {
            WriteObjects.write();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }*/
    }

    @Override
    public void update()
    {/*
        frame++;
        if (frame > 2)
        {
            frame = 0;
        }*/
        Updater.update();
    }

    @Override
    public void draw(Graphics g)
    {
        try
        {
            engine.Update(g);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String [] args)
    {
        GameApplication.start(new CyberServant());
    }
}
