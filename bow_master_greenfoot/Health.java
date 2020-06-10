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
 
    // Heart icon attributtes
    String iconPath = "heart.png";
    int iconSize = 30;
    int iconOffset = 3;
    Deque<Image> icons = new LinkedList<Image>();
    
    // On constructor, set the maximum health
    public Health(int health) { this.maxHealth = health; }
    
    // Method to initiate initial heart icons, just after the object is being added to the world
    public void setup() { for (int i = 0; i < maxHealth; i++) addHealth(); }
    
    // Initiate new heart icon image
    Image makeIcon() 
    {
        Image icon = new Image();
        icon.setImage(iconPath);
        icon.setSize(iconSize, iconSize);
        return icon;
    }
    
    void drawHealth() 
    { 
        // If the health point is greater than available icons, then add new additional icons to match the health point
        if (health > icons.size()) 
        {
            for (int i = 0; i < health - icons.size(); i++) 
            {
                icons.add(makeIcon());
                getWorld().addObject(icons.peekLast(), getX() - ((icons.size() - 1) * (iconOffset + iconSize)), getY());
            }
        } 
        // If the health is less than available icons, then remove unintended additional icons
        else if (health < icons.size()) 
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
