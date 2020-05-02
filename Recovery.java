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
        ((Gameplay)getWorld()).player.health.addHealth();
        super.getHit();
    }
}
