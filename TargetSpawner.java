import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class TargetSpawner extends Actor
{
    // Spawn position offset
    int offset = 10;
    
    // Spawn delay properties
    int spawnDelay = 60;
    int delay = 0;
    
    public void setSpawnDelay(int delay) { spawnDelay = delay; }
    
    public void spawn() 
    {
        if (delay == 0) 
        {
            delay = spawnDelay;
            int spawnPos = Greenfoot.getRandomNumber(getWorld().getWidth() - (offset * 2)) + offset;
            
            // Randomize the spawn objects
            int targetType = Greenfoot.getRandomNumber(7);
            if (targetType <= 4) 
            {
                getWorld().addObject(new Point(), spawnPos, 0);
            } else if (targetType == 5) 
            {
                getWorld().addObject(new Demerit(), spawnPos, 0);
            } else if (targetType == 6) 
            {
                getWorld().addObject(new Recovery(), spawnPos, 0);
            }
            
        } else if (delay > 0) delay--;
    }  
}
