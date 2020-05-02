import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Point extends Target
{
    String[] icons =
    {
        "apple.png",
        "strawberry.png",
        "grape.png",
        "lemon.png",
        "carrot.png"
    };
    
    public Point() 
    {
        int rand = Greenfoot.getRandomNumber(icons.length);
        setImage(icons[rand]);
    }
    
    public void getHit() 
    {
        ((Gameplay)getWorld()).addScore();
        super.getHit();
    }
}
