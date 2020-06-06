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
    
    // Destory target if it hits the ground
    void checkBoundaries() 
    {
        if (getY() > getWorld().getHeight() - 10) getWorld().removeObject(this);
    }
    
    // On target collision with something
    void collision() 
    {
        // If target hitted by arrow
        Actor arrow = getOneIntersectingObject(Arrow.class);
        if (arrow != null) 
        {
            getWorld().removeObject(arrow);
            getHit();
        } 
        // Else check if the boundaries
        else checkBoundaries();
    }
    
    // Virtual method that invoke when target gets hit
    public void getHit() { getWorld().removeObject(this); }
    
    public void act() 
    {
        setLocation(getX(), getY() + gravity);
        collision();
    }    
}
