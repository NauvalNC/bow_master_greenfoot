import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class GameManager extends Actor
{
    // Scoring variables
    Text scoreTxt;
    int score;
    
    // Scoring Method
    public void addScore() { score += 1; }
    
    public void addScore(int n) 
    { 
        if (score + n >= 0) score += n; 
        else score = 0;
    }
    
    public int getScore() { return score; }
    
    // Player variable
    public Player player;
    
    // Target Spawner
    public TargetSpawner targetSpawner;
    boolean withReccovery;
    
    public GameManager() 
    {
        // Initialize start value
        score = 0;
    }
    
    public void setGameOver() 
    {
        Greenfoot.setWorld(new GameOver(getWorld(), score));
    }
    
    // Prepare the UI and pre-actors
    public void prepare(boolean isFrenzyMode) 
    {
        scoreTxt = new Text();
        getWorld().addObject(scoreTxt, scoreTxt.getImage().getWidth() / 2 + 15, scoreTxt.getImage().getHeight() / 2 + 15);
        
        player = new Player();
        getWorld().addObject(player, getWorld().getWidth() / 2, getWorld().getHeight() - 50);
        if (isFrenzyMode == false) 
        {
            player.setup();
        }
        
        targetSpawner = new TargetSpawner((isFrenzyMode) ? false : true);
        getWorld().addObject(targetSpawner, getWorld().getWidth() / 2, 0);
    }
    
    public void act() 
    {
        super.act();
        
        // Set score
        scoreTxt.setText("Score: " + score, 30, Color.WHITE);
        scoreTxt.setLocation(scoreTxt.getImage().getWidth() / 2 + 15, scoreTxt.getImage().getHeight() / 2 + 15);
        
        // Call player behaviour frame per frame
        player.onFrame();
        
        // Spawn target
        targetSpawner.spawn();
    }  
}
