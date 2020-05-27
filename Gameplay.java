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
    public GameManager manager;
    
    int spawnDelay = 60;
    int minSpawnDelay = 5;
    int spawnReducer = 5;
    
    int delaySpace = 10;
    
    public Gameplay() 
    {
        prepare();
    }
    
    // Prepare the UI and pre-actors
    public void prepare() 
    {
        manager = new GameManager();
        addObject(manager, 0, 0);
        manager.prepare(false);
        manager.targetSpawner.setSpawnDelay(spawnDelay);
    }
    
    public void act() 
    {
        if (manager.getScore() == delaySpace && spawnDelay > minSpawnDelay) 
        {
            delaySpace += delaySpace;
            spawnDelay -= spawnReducer;
            manager.targetSpawner.setSpawnDelay(spawnDelay);
        }
    }
    
    public void point() 
    {
        manager.addScore();
    }
    
    public void recovery() 
    {
        if (manager.player.health != null) manager.player.health.addHealth();
    }
    
    public void demerit() 
    {
        if (manager.player.health != null) manager.player.health.subHealth();
    }
}
