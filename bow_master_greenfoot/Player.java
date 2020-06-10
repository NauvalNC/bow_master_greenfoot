
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Player extends Image
{
    public Health health;
    
    int moveSpeed = 8;
    
    // Delay properties for shooting
    int delay = 0;
    int shotDelay = 30;
    
    boolean isFrenzyMode = false;
    int frenzyShotDelay = 20;
    
    public Player() 
    {
        setImage("bow_ready.png");
        setSize(120, 93); 
    }
    
    public void setupHealth() 
    {
        // Initiate the health object after player is initiated
        health = new Health(3);
        getWorld().addObject(health, getWorld().getWidth() - 25, 20);
        health.setup();
    }
    
    void control() 
    {
        // Move the player left or right direction according to left arrow or right arrow keyboard input
        if (Greenfoot.isKeyDown("left")) setLocation(getX() - moveSpeed, getY());
        else if (Greenfoot.isKeyDown("right")) setLocation(getX() + moveSpeed, getY());
        
        // Shoot if space keyboard input after shooting delay
        if (delay > 0) delay--;
        if (delay == 0 && Greenfoot.isKeyDown("space")) 
        {
            delay = shotDelay;
            getWorld().addObject(new Arrow(), getX(), getY());
            ((CustomWorld)getWorld()).sfx.playSound("shoot.mp3", 80);
            
            // If frenzy mode, spawn three different directions of arrow (left, right, and front) 
            if (isFrenzyMode) 
            {
                delay = frenzyShotDelay;
                getWorld().addObject(new Arrow(45), getX(), getY());
                getWorld().addObject(new Arrow(-45), getX(), getY());
            }
        }
    }
    
    // Update player behaviour
    public void onFrame() 
    {
        // Set image to no arrow bow if its in shoot delay, otherwise set it to bow with arrow
        if (delay == 0) setImage("bow_ready.png");
        else setImage("bow.png");
        
        control();
    }
}
