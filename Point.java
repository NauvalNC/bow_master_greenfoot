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
        
        // Randomize the image source
        setImage(icons[rand]);
    }
    
    public void getHit() 
    {
        // When get hit, add score
        ((Gameplay)getWorld()).addScore();
        ((CustomWorld)getWorld()).sfx.playSound("splash.mp3", 50);
        super.getHit();
    }
}
