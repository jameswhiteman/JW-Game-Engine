package mfe.engine.components;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import mfe.engine.init.Controller;
import mfe.engine.init.Playable;
import mfe.engine.init.Transformable;
import mfe.engine.init.VirtualInput;

public class Object extends AbstractObject implements Transformable, Playable, Serializable
{
    private static final long serialVersionUID = 1L;
    
    private double maxlspeed;
    private double maxrspeed;
    private double maxuspeed;
    private double maxdspeed;
    
    private double movelspeed;
    private double moverspeed;
    private double moveuspeed;
    private double movedspeed;
    
    private double move_lincr;
    private double move_rincr;
    private double move_uincr;
    private double move_dincr;
    
    private double hspeed;
    private double vspeed;
    
    private double friction;
    private double gravity;
    private int gravity_direction;
    
    private boolean solid;
    private boolean visible;
    private String type;

    private int rotation = 0;
    private double xscale = 1;
    private double yscale = 1;

    @Override
    public void setRotation(int rot)
    {
        rotation = rot;
    }

    @Override
    public void setXscale(double scale)
    {
        xscale = scale;
    }

    @Override
    public void setYscale(double scale)
    {
        yscale = scale;
    }

    @Override
    public void setScale(double x, double y)
    {
        xscale = x;
        yscale = y;
    }

    @Override
    public int getRotation()
    {
        return rotation;
    }

    @Override
    public double getXscale()
    {
        return xscale;
    }

    @Override
    public double getYscale()
    {
        return yscale;
    }
    
    public Object(String name, BufferedImage sprite, int x, int y)
    {
        super(name, sprite, x, y, sprite.getWidth(), sprite.getHeight(), 0);
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
        gravity_direction = 0;
        
        solid = false;
        visible = true;
        type = "Standard Object";
    }
    
    public Object()
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
        gravity_direction = 0;
        
        solid = false;
        visible = true;
        type = "Standard Object";
    }
    
    public Object(String name, BufferedImage lastSprite, int x, int y, int i,
            int j, int k, int rot, double xsc, double ysc)
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
        type = "Standard Object";
        initialize();
    }
    
    public Object(String name, BufferedImage lastSprite, int x, int y, int i,
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
        move();
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
        gravity_direction = 0;
        
        solid = false;
        visible = true;
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
    
    public void setGravity(double p_gravity, int p_gravity_direction)
    {
        gravity = p_gravity;
        gravity_direction = p_gravity_direction;
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

    @Override
    public void move()
    {
        if (hspeed != 0)
            setX((int)(getX() + hspeed));
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

    public String getType() {
        return type;
    }
}
