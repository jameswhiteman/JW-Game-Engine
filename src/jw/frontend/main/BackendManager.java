package jw.frontend.main;

import java.io.File;
import java.util.ArrayList;

import jw.engine.components.*;

public class BackendManager
{
    // Frontend Variables
    private static File game_file;
    
    // Resources
    private static ArrayList<Sprite> sprites;
    private static ArrayList<Animation> animations;
    private static ArrayList<Sound> sounds;
    
    
    // Components
    private static ArrayList<CollisionMask> collision_masks;
    private static ArrayList<RigidObject> rigid_objects; 
    private static ArrayList<AnimatedObject> animated_objects;
    private static ArrayList<Background> rigid_backgrounds;
    
    private static ArrayList<MovingBackground> rigid_moving_backgrounds;
    
    // SET METHODS
    public static void setGameFile(File file)
    {
        game_file = file;
    }
    
    // GET METHODS
    public static File getGameFile()
    {
        return game_file;
    }
}
