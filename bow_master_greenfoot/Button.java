import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Button extends Image
{
    public boolean isClicked() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            ((CustomWorld)getWorld()).sfx.playSound("click.mp3", 90);
            return true;
        }
        return false;
    }
}
