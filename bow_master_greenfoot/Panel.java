import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Panel extends CustomWorld
{
    Image panel;
    Button okBtn;
    String mode;
    
    public Panel(String mode)
    {
        setBackground(new GreenfootImage("background.png"));
        getBackground().scale(super.getWidth(), super.getHeight());
        
        this.mode = mode;
        prepare();
    }
    
    public void prepare() 
    {
        panel = new Image();
        
        if (mode == "Classic") panel.setImage("classic_mode.png");
        else if (mode == "Frenzy") panel.setImage("frenzy_mode.png");
        else if (mode == "Credit") panel.setImage("credit.png");
        
        addObject(panel, getWidth() / 2, getHeight() / 2);
        panel.setSize(320, 481);
        
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
            else if (mode == "Credit") Greenfoot.setWorld(new MainMenu());
        }
    }
}
