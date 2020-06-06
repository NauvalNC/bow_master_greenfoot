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
    Button creditBtn;
    Button exitBtn;
    
    public MainMenu() 
    { 
        setBackground(new GreenfootImage("main_menu.png"));
        getBackground().scale(super.getWidth(), super.getHeight());
        
        prepare();
    }
    
    public void prepare() 
    {
        playBtn = new Button();
        creditBtn = new Button();
        exitBtn = new Button();

        // Add object to the world, and set its position
        addObject(playBtn, getWidth() / 2, 325);
        addObject(creditBtn, getWidth() / 2, 380);
        addObject(exitBtn, getWidth() / 2, 435);

        playBtn.setImage("play_btn.png");
        creditBtn.setImage("credit_btn.png");
        exitBtn.setImage("exit_btn.png");

        playBtn.setSize(200, 46);
        creditBtn.setSize(200, 46);
        exitBtn.setSize(200, 46);
    }
    
    public void act() 
    {
        super.act();
        
        if (playBtn.isClicked()) Greenfoot.setWorld(new PlayMode());
        else if (creditBtn.isClicked()) Greenfoot.setWorld(new Panel("Credit"));
        else if (exitBtn.isClicked()) 
        {
            bgm.stop();
            Greenfoot.setWorld(new MainMenu());
            Greenfoot.stop();
            // System.exit(0);
        }
    }
}
