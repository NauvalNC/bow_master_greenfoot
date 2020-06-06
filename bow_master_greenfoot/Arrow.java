import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Arrow extends Image
{
    int speed = 10;
    int offset = 5;
    int normalRot = -90;
    
    public Arrow() 
    {
        setSize(99, 22);
        setImage("arrow.png");
        
        // Turn the arrow's point to up direction
        turn(normalRot);
    }
    
    public Arrow(int deg) 
    {
        setSize(99, 22);
        setImage("arrow.png");
        
        // Turn the arrow's point to up direction
        turn(normalRot + deg);
    }
    
    // Destroy arrow if it is out of world bound
    public void checkBoundaries() 
    { 
        if (getRotation() != 270) 
        {
            if (getX() > getWorld().getWidth() - offset) turn(normalRot);
            else if (getX() < 0 + offset) turn(-normalRot);  
        }
        
        if (getY() < offset || getY() > getWorld().getHeight() - offset) getWorld().removeObject(this); 
    }
    
    public void act()
    {
        checkBoundaries();
        move(speed);
    } 
}
