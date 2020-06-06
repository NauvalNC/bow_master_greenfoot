import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Sound extends Actor
{
    int volume;
    boolean isLooping;
  
    GreenfootSound sound;
    
    public Sound(int volume, boolean isLooping) 
    {
        this.volume = volume;
        this.isLooping = isLooping;
    }
    
    public void setVolume(int volume) { this.volume = volume; }
    
    public void setLooping(boolean isLooping) { this.isLooping = isLooping; }
    
    public boolean isPlaying() 
    {
        if (sound == null) return false;
        return sound.isPlaying();
    }
    
    public void playSound(String path)
    {
        sound = new GreenfootSound(path);  
        sound.setVolume(volume);
        
        if (isLooping) sound.playLoop();
        else sound.play();
    }
    
    public void playSound(String path, int volume) 
    {
        setVolume(volume);
        playSound(path);
    }
    
    public void stop() 
    {
        sound.stop();
    }
}
