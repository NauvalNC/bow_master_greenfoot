
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Image extends Actor
{
    int xSize, ySize;
    
    public void setSize(int x, int y) 
    { 
        if (x == 0 || y == 0) return;
        getImage().scale(x, y);
        xSize = x;
        ySize = y;
    }
    
    public void setImage(String path) 
    {
        GreenfootImage img = new GreenfootImage(path);
        if (xSize == 0 && ySize == 0 && getImage() == null) 
        {
            setImage(img);
        } else if (getImage() != img) 
        {
            setImage(img);
            setSize(xSize, ySize);
        }
        
    }
}
