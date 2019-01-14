import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private int speed;
    private int lives;
    
    /**
     * Constructor for objects of class PlayField.
     * 
     */
    public Ball()
    {
        speed = 4;
        setRotation(Greenfoot.getRandomNumber(180));
        lives = 5;
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        if(getX() >= getWorld().getWidth()-10)
        {
            rotate();
            speed = -speed;
            move(speed);
        }
        if(isTouching(Paddles.class))
        {
            rotate();
            setLocation(getX(), getY() - 5);
        }
        if(getX() <= 290)
        {
            speed = -speed;
            rotate();
            setRotation(getRotation() + Greenfoot.getRandomNumber(10));
        }
        if(getY() <= 10)
        {
            speed = speed;
            rotate();
        }
        if(isTouching(Square.class))
        {
            getWorld().removeObjects(getIntersectingObjects(Square.class));
            rotate();
            ( (PlayField)getWorld()).update();
        }
        if(getY() >= 690)
        {
            lives--;
            getWorld().removeObject(this);
        }
    }

    private void rotate()
    {
        setRotation(getRotation() * -1);
    }
}
