import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Nauval Muhammad Firdaus)
 * NIM: 2301906331
 * Kelas Besar: CA04
 * Kelas Kecil: LB04
 */
public class Text extends Actor
{
    String text;
    Color color;
    int size;
    
    public Text() { setText("Hello World!", 30, Color.WHITE); }
    
    public void setText(String text, int size, Color color) 
    {
        this.text = text;
        this.color = color;
        this.size = size;
    }
    
    void drawText() { setImage(new GreenfootImage(text, size, color, null)); }
    
    public void act() {  drawText(); }
}
