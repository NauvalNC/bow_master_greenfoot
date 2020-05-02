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
    
    int delay = 0;
    int shotDelay = 30;
    
    public Player() { setSize(120, 93); }
    
    public void setup() 
    {
        health = new Health(3);
        getWorld().addObject(health, getWorld().getWidth() - 25, 20);
        health.setup();
    }
    
    void control() 
    {
        if (Greenfoot.isKeyDown("left")) setLocation(getX() - moveSpeed, getY());
        else if (Greenfoot.isKeyDown("right")) setLocation(getX() + moveSpeed, getY());
        
        if (delay > 0) delay--;
        if (delay == 0 && Greenfoot.isKeyDown("space")) 
        {
            delay = shotDelay;
            getWorld().addObject(new Arrow(), getX(), getY());
        }
    }
    
    public void onFrame() 
    {
        if (delay == 0) setImage("bow_ready.png");
        else setImage("bow.png");
        
        control();
    }
}
