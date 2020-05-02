import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Health extends Actor
{
    int maxHealth;
    int health;
 
    String iconPath = "heart.png";
    int iconSize = 30;
    int iconOffset = 3;
    Deque<Image> icons = new LinkedList<Image>();
    
    public Health(int health) { this.maxHealth = health; }
    
    public void setup() { for (int i = 0; i < maxHealth; i++) addHealth(); }
    
    Image makeIcon() 
    {
        Image icon = new Image();
        icon.setImage(iconPath);
        icon.setSize(iconSize, iconSize);
        return icon;
    }
    
    void drawHealth() 
    { 
        if (health > icons.size()) 
        {
            for (int i = 0; i < health - icons.size(); i++) 
            {
                icons.add(makeIcon());
                getWorld().addObject(icons.peekLast(), getX() - ((icons.size() - 1) * (iconOffset + iconSize)), getY());
            }
        } else if (health < icons.size()) 
        {
            for (int i = 0; i < icons.size() - health; i++) getWorld().removeObject(icons.pollLast());
        }
    }
    
    // Add one health
    public void addHealth() 
    {
        if (health + 1 > maxHealth) return;
        health += 1;
        drawHealth();
    }
    
    // Substract one health
    public void subHealth()
    {
        if (health - 1 < 0) return;
        health -= 1;
        drawHealth();
    }
    
    int getHealth() { return health; }
}
