import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayMode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayMode extends CustomWorld
{
    Button classicBtn, frenzyBtn, backBtn;
    
    public PlayMode()
    {
        prepare();
    }
    
    public void prepare() 
    {
        classicBtn = new Button();
        frenzyBtn = new Button();
        backBtn = new Button();
        
        // Add object to the world, and set its position
        addObject(classicBtn, getWidth() / 2, 305);
        addObject(frenzyBtn, getWidth() / 2, 360);
        addObject(backBtn, getWidth() / 2, 415);
        
        classicBtn.setImage("classic_btn.png");
        frenzyBtn.setImage("frenzy_btn.png");
        backBtn.setImage("back_btn.png");
        
        classicBtn.setSize(200, 46);
        frenzyBtn.setSize(200, 46);
        backBtn.setSize(200, 46);
    }
    
    public void act() 
    {
        super.act();
        
        if (classicBtn.isClicked()) Greenfoot.setWorld(new Tutorial("Classic"));
        else if (frenzyBtn.isClicked()) Greenfoot.setWorld(new Tutorial("Frenzy"));
        else if (backBtn.isClicked()) Greenfoot.setWorld(new MainMenu());
    }
}
