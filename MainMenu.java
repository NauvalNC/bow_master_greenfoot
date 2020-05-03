import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class MainMenu extends CustomWorld
{
    Button playBtn;
    Button exitBtn;
    
    public MainMenu() { prepare(); }
    
    public void prepare() 
    {
        playBtn = new Button();
        exitBtn = new Button();
        
        // Add object to the world, and set its position
        addObject(playBtn, getWidth() / 2, 355);
        addObject(exitBtn, getWidth() / 2, 410);
        
        playBtn.setImage("play_btn.png");
        exitBtn.setImage("exit_btn.png");
        
        playBtn.setSize(200, 46);
        exitBtn.setSize(200, 46);
    }
    
    public void act() 
    {
        super.act();
        
        if (playBtn.isClicked()) Greenfoot.setWorld(new Gameplay());
        else if (exitBtn.isClicked()) System.out.println("Exit!");
    }
}
