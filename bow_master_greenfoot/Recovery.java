import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Recovery extends Target
{
    public Recovery() { setImage("recovery.png"); }
    
    public void getHit() 
    {
        // Increase health by one
        ((Gameplay)getWorld()).recovery();
        ((CustomWorld)getWorld()).sfx.playSound("blop.mp3", 70);
        super.getHit();
    }
}
