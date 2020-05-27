import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Tutorial extends CustomWorld
{
    Image tutorialPanel;
    Button okBtn;
    String mode;
    
    public Tutorial(String mode)
    {
        this.mode = mode;
        prepare();
    }
    
    public void prepare() 
    {
        tutorialPanel = new Image();
        
        if (mode == "Classic") tutorialPanel.setImage("classic_mode.png");
        else if (mode == "Frenzy") tutorialPanel.setImage("frenzy_mode.png");
        
        addObject(tutorialPanel, getWidth() / 2, getHeight() / 2);
        tutorialPanel.setSize(320, 481);
        
        okBtn = new Button();
        okBtn.setImage("ok_btn.png");
        addObject(okBtn, getWidth() / 2, getHeight() - 78);
        okBtn.setSize(200, 46);
    }
    
    public void act() 
    {
        super.act();
        
        if (okBtn.isClicked()) 
        {
            if (mode == "Classic") Greenfoot.setWorld(new Classic());
            else if (mode == "Frenzy") Greenfoot.setWorld(new Frenzy());
        }
    }
}
