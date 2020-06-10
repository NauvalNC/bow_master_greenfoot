import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Frenzy extends Gameplay
{
    Text timerTxt;
    int countDown = 60 * 60;
    
    Image frenzyImg;
    Image frenzyBar;
    Image frenzySlide;
    int xSlide = 66, ySlide = 7;
    
    boolean isFrenzyMode = false;
    int pointToFrenzy = 5;
    int frenzyPoint = 0;
    int frenzyCountDown = 60 * 5;
    int frenzyTime = 0;
    
    int defSpawnDelay = 25;
    int frenzySpawnDelay = 5;
    
    public Frenzy() 
    {
        setBackground(new GreenfootImage("background.png"));
        getBackground().scale(super.getWidth(), super.getHeight());
    }
    
    public void prepare() 
    {
        manager = new GameManager();
        addObject(manager, 0, 0);
        manager.prepare(true);
        
        timerTxt = new Text();
        addObject(timerTxt, getWidth() - timerTxt.getImage().getWidth() - 30, timerTxt.getImage().getHeight() / 2 + 30);
        
        frenzyImg = new Image();
        frenzyImg.setImage("frenzy.png");
        addObject(frenzyImg, getWidth() / 2, getHeight() / 2);
        frenzyImg.setSize(250, 86);
        frenzyImg.hide();
        
        frenzyBar = new Image();
        frenzyBar.setImage("frenzy_bar.png");
        addObject(frenzyBar, getWidth() / 2, 25);
        frenzyBar.setSize(80, 19);
        frenzyBar.turn(-90);
        
        frenzySlide = new Image();
        frenzySlide.setImage("frenzy_slide.png");
        addObject(frenzySlide, getWidth() / 2, 25);
        frenzySlide.setSize(xSlide, ySlide);
        frenzySlide.hide();
        frenzySlide.turn(-90);
    }
    
    public void act() 
    {
        manager.player.isFrenzyMode = isFrenzyMode;
        if (isFrenzyMode) 
        {
            if (frenzyTime > 0) frenzyTime--;
            else 
            {
                isFrenzyMode = false;
                frenzyImg.hide();
                frenzySlide.hide();
            }
        } else manager.targetSpawner.setSpawnDelay(defSpawnDelay);
        
        timerTxt.setText("Timer:\n" + (countDown / 60)+"s", 30, Color.WHITE);
        if (countDown > 0) countDown--;
        else manager.setGameOver();
        
        frenzyBar.setLocation(manager.player.getX() + 70, manager.player.getY());
        frenzySlide.setLocation(manager.player.getX() + 70, manager.player.getY());
    }
    
    public void point() 
    {
        if (isFrenzyMode == false)
        {
            frenzyPoint++;
            int slideW = (xSlide / pointToFrenzy) * frenzyPoint;
            if (slideW > 0) 
            {
                frenzySlide.show();
                frenzySlide.setSize(slideW, ySlide);
            } else frenzySlide.hide();
        }
        
        if (frenzyPoint >= pointToFrenzy && !isFrenzyMode) 
        {
            isFrenzyMode = true;
            frenzyPoint = 0;
            frenzyTime = frenzyCountDown;
            manager.targetSpawner.setSpawnDelay(frenzySpawnDelay);
            frenzyImg.show();
            sfx.playSound("frenzy.mp3", 90);
        }
        
        manager.addScore(5);
    }
    
    public void demerit() 
    {
        manager.addScore(-3);
    }
}
