import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Demerit extends Target
{
    public void Demerit() { setImage("bomb.png"); }
    
    public void getHit() 
    {
        ((Gameplay)getWorld()).demerit();
        ((CustomWorld)getWorld()).sfx.playSound("break.mp3", 90);
        super.getHit();
    }
}
