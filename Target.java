import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Target extends Image
{
    int gravity = 2;
    int targetSize = 40;
    
    public Target() { setSize(targetSize, targetSize); }
    
    public void setGravity(int gravity) { this.gravity = gravity; }
    
    void checkBoundaries() 
    {
        if (getY() > getWorld().getHeight() - 10) getWorld().removeObject(this);
    }
    
    void collision() 
    {
        Actor arrow = getOneIntersectingObject(Arrow.class);
        if (arrow != null) 
        {
            getWorld().removeObject(arrow);
            getHit();
        } else checkBoundaries();
    }
    
    public void getHit() { getWorld().removeObject(this); }
    
    public void act() 
    {
        setLocation(getX(), getY() + gravity);
        collision();
    }    
}
