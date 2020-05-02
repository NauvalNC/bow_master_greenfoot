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
        turn(normalRot);
    }
    
    public void checkBoundaries()
    {
        if (getX() < offset || getY() < offset ||
            getX() > getWorld().getWidth() - offset ||
            getY() > getWorld().getHeight() - offset) 
        {
            getWorld().removeObject(this);
        }
    }
    
    public void act()
    {
        checkBoundaries();
        move(speed);
    } 
}
