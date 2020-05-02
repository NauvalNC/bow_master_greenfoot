import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Gameplay extends CustomWorld
{
    // Scoring variables
    Text scoreTxt;
    int score;
    
    // Scoring Method
    public void addScore() { score += 1; }
    
    // Player variable
    public Player player;
    
    // Target Spawner
    TargetSpawner targetSpawner;
    
    public Gameplay() 
    {
        // Initialize start value
        score = 0;
        prepare();
    }
    
    boolean isGameOver() 
    {
        if (player.health.getHealth() <= 0) return true;
        return false;
    }
    
    // Prepare the UI and pre-actors
    void prepare() 
    {
        scoreTxt = new Text();
        addObject(scoreTxt, scoreTxt.getImage().getHeight() / 2 + 50, scoreTxt.getImage().getHeight() / 2 + 15);
        
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() - 50);
        player.setup();
        
        targetSpawner = new TargetSpawner();
        addObject(targetSpawner, getWidth() / 2, 0);
    }
    
    public void act() 
    {
        if (isGameOver()) 
        {
            Greenfoot.setWorld(new GameOver(score));
            return;
        }
        
        // Set score
        scoreTxt.setText("Score: " + score, 30, Color.WHITE);
        
        // Call player behaviour frame per frame
        player.onFrame();
        
        // Spawn target
        targetSpawner.spawn();
    }
}
