import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddles extends Actor
{
    private boolean pause = false;

    /**
     * Constructor for objects of class Paddles.
     * 
     */
    public Paddles()
    {
    }

    /**
     * Act - do whatever the Paddles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        PlayField world = (PlayField) getWorld();
        pause = world.pause;
        if(pause == false)
        {
            move();
            if(getX() < 335)
            {
                setLocation(335, getY());
            }
            if(getX() > 937)
            {
                setLocation(937, getY());
            }
        }
    }    

    private void move()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(4);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
        }
    }
}
