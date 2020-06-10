import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class CustomWorld extends World
{
    public static Sound bgm = new Sound(50, true);
    public Sound sfx = new Sound(100, false);
    
    boolean isStart = false;
    
    public CustomWorld()
    {
        // Set world dimension
        super(350, 622, 1);
        
        // Scale the world background according the world dimension
        setBackground(new GreenfootImage("background.png"));
        getBackground().scale(super.getWidth(), super.getHeight());
    }
    
    // Virtual method to call when the object is initiated
    public void prepare (){}
    
    // Method to call when the Scenario is started
    public void onStart() 
    {
        // Play BGM
        if (!bgm.isPlaying()) bgm.playSound("bgm.mp3");
        isStart = true;
    }
    
    public void act() { if (!isStart) onStart(); }
}
