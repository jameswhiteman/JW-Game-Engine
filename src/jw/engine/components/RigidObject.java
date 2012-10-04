package jw.engine.components;

import java.awt.image.BufferedImage;

import java.io.Serializable;
import java.util.ArrayList;

import jw.engine.abstracts.AbstractImageObject;
import jw.engine.abstracts.AbstractObject;
import jw.engine.init.Controller;
import jw.engine.init.VirtualInput;
import jw.engine.interfaces.Playable;
import jw.engine.interfaces.Transformable;
import jw.engine.load.Components;
import jw.engine.logic.Collision;


public class RigidObject extends AbstractImageObject implements Transformable, Playable, Serializable
{
    private static final long serialVersionUID = 1L;
    
    // Maximum speeds achievable by the object, left, right, up, and down.
    private double maxlspeed;
    private double maxrspeed;
    private double maxuspeed;
    private double maxdspeed;
    
    // Maximum speeds the object can move, left, right, up, and down.
    private double movelspeed;
    private double moverspeed;
    private double moveuspeed;
    private double movedspeed;
    
    // The movement increment per frame when moving, left, right, up, and down.
    private double move_lincr;
    private double move_rincr;
    private double move_uincr;
    private double move_dincr;
    
    // The current horizontal and vertical speed.
    private double hspeed;
    private double vspeed;
    
    // The friction, gravity, maximum gravity, and gravity direction.
    private double friction;
    private double gravity;
    private double max_gravity;
    private int gravity_direction;
    
    // Object properties. Whether or not it is solid, visible, the type of object it is, and its collision mask.
    private boolean solid;
    private boolean visible;
    private String type;
    private CollisionMask mask;
    
    // Collision detection variables.
    private ArrayList<AbstractObject> colliders = new ArrayList<AbstractObject>();
    private boolean freeLeft = true;
    private boolean freeRight = true;
    private boolean freeTop = true;
    private boolean freeBottom = true;
    
    public RigidObject(String name, BufferedImage sprite, double x, double y)
    {
        super(sprite, name, x, y);
        maxlspeed = -25;
        maxrspeed = 25;
        maxuspeed = -25;
        maxrspeed = 25;
        
        movelspeed = -5;
        moverspeed = 5;
        moveuspeed = -5;
        movedspeed = 5;
        
        move_lincr = 1;
        move_rincr = 1;
        move_uincr = 1;
        move_dincr = 1;
        
        hspeed = 0;
        vspeed = 0;
        
        friction = 0.0;
        gravity = 0.0;
        max_gravity = 0.0;
        gravity_direction = 0;
        
        solid = false;
        visible = true;
        type = "Standard Object";
        mask = new CollisionMask(this);
    }
    
    public RigidObject()
    {
        maxlspeed = -25;
        maxrspeed = 25;
        maxuspeed = -25;
        maxrspeed = 25;
        
        movelspeed = -5;
        moverspeed = 5;
        moveuspeed = -5;
        movedspeed = 5;
        
        move_lincr = 1;
        move_rincr = 1;
        move_uincr = 1;
        move_dincr = 1;
        
        hspeed = 0;
        vspeed = 0;
        
        friction = 0.0;
        gravity = 0.0;
        max_gravity = 0.0;
        gravity_direction = 0;
        
        solid = false;
        visible = true;
        type = "Standard Object";
        mask = new CollisionMask(this);
    }
    
    public RigidObject(String name, BufferedImage lastSprite, double x, double y, int width,
            int height, int depth, int rot, double xsc, double ysc)
    {
        setName(name);
        setSprite(lastSprite);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setDepth(depth);
        setRotation(rot);
        setScale(xsc, ysc);
        type = "Standard Object";
        initialize();
    }
    
    public RigidObject(String name, BufferedImage lastSprite, double x, double y, int i,
            int j, int k, int rot, double xsc, double ysc, String objtype)
    {
        setName(name);
        setSprite(lastSprite);
        setX(x);
        setY(y);
        setWidth(i);
        setHeight(j);
        setDepth(k);
        setRotation(rot);
        setScale(xsc, ysc);
        type = objtype;
        initialize();
    }

    // MAIN METHODS
    public void updatePosition()
    {
        // Collision Detection
        freeLeft = true;
        freeRight = true;
        freeTop = true;
        freeBottom = true;
        
        for (AbstractObject other : Components.getAllObjects())
        {
            if (Collision.SolidCol(this, other))
            {
                colliders.add(other);
                if (other.getMaskRight() <= getMaskLeft())
                    freeLeft = false;
                if (other.getMaskLeft() >= getMaskRight())
                    freeRight = false;
                if (other.getMaskBottom() <= getMaskTop())
                    freeTop = false;
                if (other.getMaskTop() >= getMaskBottom())
                    freeBottom = false;
            }
            else if (colliders.contains(other))
                colliders.remove(other);
        }
        
        // Controller Movement
        move();
        
        // Horizontal & Vertical speed
        if (hspeed != 0)
        {
            if ((hspeed > 0 && freeRight == true) || (hspeed < 0 && freeLeft == true))
                setX((double)(getX() + hspeed));
            else
                hspeed = 0;
        }
            
        if (vspeed != 0)
        {
            if ((vspeed > 0 && freeBottom == true) || (vspeed < 0 && freeTop == true))
                setY((double)(getY() + vspeed));
            else
                vspeed = 0;
        }
        
        // Gravity
        if (gravity != 0 && vspeed < max_gravity && gravity > friction && freeBottom == true)
            vspeed += gravity;
        
        // Friction
        if (hspeed < 0 && !(VirtualInput.getKeyState(Controller.CTR_LEFT) && hspeed == movelspeed))
        {
            if (hspeed + friction < 0)
                hspeed += friction;
            else
                hspeed = 0;
        }
        if (hspeed > 0 && !(VirtualInput.getKeyState(Controller.CTR_RIGHT) && hspeed == moverspeed))
        {
            if (hspeed - friction > 0)
                hspeed -= friction;
            else
                hspeed = 0;
        }
        if (vspeed < 0)
            vspeed += friction;
        if (vspeed > 0)
            vspeed -= friction;
    }
    
    public void initialize()
    {
        maxlspeed = -25;
        maxrspeed = 25;
        maxuspeed = -25;
        maxrspeed = 25;
        
        movelspeed = -5;
        moverspeed = 5;
        moveuspeed = -5;
        movedspeed = 5;
        
        move_lincr = 1;
        move_rincr = 1;
        move_uincr = 1;
        move_dincr = 1;
        
        hspeed = 0;
        vspeed = 0;
        
        friction = 0.0;
        gravity = 0.0;
        max_gravity = 0.0;
        gravity_direction = 0;
        
        solid = false;
        visible = true;
        mask = new CollisionMask(this);
    }
    
    // SET METHODS
    
    public void setMaxSpeeds(double lspeed, double rspeed, double uspeed, double dspeed)
    {
        maxlspeed = lspeed;
        maxrspeed = rspeed;
        maxuspeed = uspeed;
        maxdspeed = dspeed;
    }
    
    public void setMoveSpeeds(double lspeed, double rspeed, double uspeed, double dspeed)
    {
        movelspeed = lspeed;
        moverspeed = rspeed;
        moveuspeed = uspeed;
        movedspeed = dspeed;
    }
    
    public void setMoveIncrements(double lspeed, double rspeed, double uspeed, double dspeed)
    {
        move_lincr = lspeed;
        move_rincr = rspeed;
        move_uincr = uspeed;
        move_dincr = dspeed;
    }
    
    public void setHspeed(double p_hspeed)
    {
        hspeed = p_hspeed;
    }
    
    public void setVspeed(double p_vspeed)
    {
        vspeed = p_vspeed;
    }
    
    public void setSpeed(double p_hspeed, double p_vspeed)
    {
        hspeed = p_hspeed;
        vspeed = p_vspeed;
    }
    
    public void setFriction(double p_friction)
    {
        friction = p_friction;
    }
    
    public void setGravity(double p_gravity)
    {
        gravity = p_gravity;
    }
    
    public void setMaxGravity(double p_max_gravity)
    {
        max_gravity = p_max_gravity;
    }
    
    public void setGravityDirection(int p_dir)
    {
        gravity_direction = p_dir;
    }
    
    public void setGravity(double p_gravity, double p_max_gravity, int p_dir)
    {
        gravity = p_gravity;
        max_gravity = p_max_gravity;
        gravity_direction = p_dir;
    }
    
    public void setSolid(boolean state)
    {
        solid = state;
    }
    
    public void setVisible(boolean state)
    {
        visible = state;
    }
    
    public void setType(String t)
    {
        /* Types include:
         * "Standard Object"
         * "Standard Player"
         */
        type = t;
    }
    
    public void setCollisionMask(int p_width, int p_height)
    {
        mask = new CollisionMask(p_width, p_height);
    }
    
    public void setCollisionMask(CollisionMask c)
    {
        mask = c;
    }
    
    public void setCollisionMaskWidth(int p_width)
    {
        mask.setWidth(p_width);
    }
    
    public void setCollisionMaskHeight(int p_height)
    {
        mask.setHeight(p_height);
    }
    
    public void setCollisionMaskSize(int p_width, int p_height)
    {
        mask.setSize(p_width, p_height);
    }
    
    // GET METHODS
    
    public double getMaxlspeed()
    {
        return maxlspeed;
    }
    
    public double getMaxrspeed()
    {
        return maxrspeed;
    }
    
    public double getMaxuspeed()
    {
        return maxuspeed;
    }
    
    public double getMaxdspeed()
    {
        return maxdspeed;
    }
    
    public double getMovelspeed()
    {
        return movelspeed;
    }
    
    public double getMoverspeed()
    {
        return moverspeed;
    }
    
    public double getMoveuspeed()
    {
        return moveuspeed;
    }
    
    public double getMovedspeed()
    {
        return movedspeed;
    }
    
    public double getMovelincr()
    {
        return move_lincr;
    }
    
    public double getMoverincr()
    {
        return move_rincr;
    }
    
    public double getMoveuincr()
    {
        return move_uincr;
    }
    
    public double getMovedincr()
    {
        return move_dincr;
    }
    
    public double getHspeed()
    {
        return hspeed;
    }
    
    public double getVspeed()
    {
        return vspeed;
    }
    
    public double getFriction()
    {
        return friction;
    }
    
    public double getGravity()
    {
        return gravity;
    }
    
    public int getGravityDirection()
    {
        return gravity_direction;
    }
    
    public boolean getSolid()
    {
        return solid;
    }
    
    public boolean getVisible()
    {
        return visible;
    }
    
    public String getType()
    {
        return type;
    }
    
    public CollisionMask getCollisionMask()
    {
        return mask;
    }
    
    public int getMaskWidth()
    {
        return mask.getWidth();
    }
    
    public int getMaskHeight()
    {
        return mask.getHeight();
    }
    
    public double getMaskLeft()
    {
        return (getX() - (mask.getWidth() / 2));
    }
    
    public double getMaskRight()
    {
        return (getX() + (mask.getWidth() / 2));
    }
    
    public double getMaskTop()
    {
        return (getY() - (mask.getHeight() / 2));
    }
    
    public double getMaskBottom()
    {
        return (getY() + (mask.getHeight() / 2));
    }

    @Override
    public void move()
    {
        if (type.equals("Standard Player"))
        {
            if (VirtualInput.getKeyState(Controller.CTR_LEFT) == true)
            {
                if (hspeed > movelspeed + move_lincr)
                    hspeed -= move_lincr;
                else
                    hspeed = movelspeed;
            }
            else if (VirtualInput.getKeyState(Controller.CTR_RIGHT) == true)
            {
                if (hspeed < moverspeed - move_rincr)
                    hspeed += move_rincr;
                else
                    hspeed = moverspeed;
            }
        }
    }
}
