import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class CustomWorld extends World
{
    public CustomWorld()
    {
        // Set world dimension
        super(350, 622, 1);
        
        // Set world background image
        getBackground().scale(super.getWidth(), super.getHeight());
    }
}
