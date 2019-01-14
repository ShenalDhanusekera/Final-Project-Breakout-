import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class aquaBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Actor
{
    private String[] imageNames = {"Aqua Block.png", "Black Block.png", "Green Block.png", "Orange Block.png", "Pink Block.png", "Purple Block.png", "Red Block.png"};
    /**
     * Constructor for objects of class Square.
     * 
     */
    public Square()
    {
        GreenfootImage blockImage = new GreenfootImage(imageNames[Greenfoot.getRandomNumber(7)]);
        setImage(blockImage);
    }
    
    /**
     * Act - do whatever the Square wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }  
}
