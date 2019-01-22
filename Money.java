import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money extends Actor
{
    private int money;
    private Font myFont = new Font("Comic Sans MS", true, false, 24);
    
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }
    
    public Money()
    {
        money = 0;
        GreenfootImage img = new GreenfootImage(150,30);
        img.setFont( myFont );
        img.setColor(Color.WHITE);
        img.drawString("Money: " + money + "$", 5,25);
        setImage(img);
    }
    
    public void addToMoney() 
    {
        money += Greenfoot.getRandomNumber(9)+1;
        GreenfootImage img = getImage();
        img.setColor(Color.WHITE);
        img.clear();
        img.drawString("Money: " + money, 5,25); 
    }  
}
