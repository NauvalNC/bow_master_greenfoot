import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class GameOver extends CustomWorld
{
    // Score variables
    int score = 0;
    Text scoreTxt;
    
    // Buttons
    Button playAgain;
    Button mainMenu;
    
    public GameOver(int score) 
    { 
        this.score = score;
        prepare(); 
    }
    
    private void prepare()
    {
        GameOverPanel gameOverPanel = new GameOverPanel();
        addObject(gameOverPanel, getWidth() / 2, getHeight() / 2 - 30);

        playAgain = new Button();
        mainMenu = new Button();

        playAgain.setImage("play_again_btn.png");
        mainMenu.setImage("main_menu_btn.png");

        addObject(playAgain, getWidth() / 2, 400);
        addObject(mainMenu, getWidth() / 2, 440);

        playAgain.setSize(150, 35);
        mainMenu.setSize(150, 35);

        scoreTxt = new Text();
        addObject(scoreTxt, getWidth() / 2,352);
        scoreTxt.setText(score + "", 35, Color.BLACK);
    }
    
    public void act() 
    {
        if (playAgain.isClicked()) 
        {
            Greenfoot.setWorld(new Gameplay());
        } else if (mainMenu.isClicked()) 
        {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
