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
    private int points;
    private boolean pause = false;

    /**
     * Constructor for objects of class PlayField.
     * 
     */
    public Ball()
    {
        speed = 4;
        setRotation(Greenfoot.getRandomNumber(180));
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        PlayField world = (PlayField) getWorld();
        pause = world.pause;
        if(pause == false)
        {

            lives = getWorld().getObjects(Heart.class).size();
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
                ( (PlayField)getWorld()).updateTwo();
            }
            if(getY() >= 690)
            {
                getWorld().removeObject(getWorld().getObjects(Heart.class).get(getWorld().getObjects(Heart.class).size() - 1));
                getWorld().removeObject(this);
                world.addBall();
            }
        }
        /**Speed Increaser and Decreaser
         * 
         *  if(Greenfoot.isKeyDown("e"))
         *  {   
         *     if(speed > 0)
         *     {
         *         speed++;
         *      }
         *      else
         *      {
         *          speed--;
         *      }
         *  }
         *  if(Greenfoot.isKeyDown("d"))
         *  {
         *      if(speed < 0)
         *      {
         *          speed++;
         *      }
         *      else
         *      {
         *          speed--;
         *      }
         *  }
         */
    }

    private void rotate()
    {
        setRotation(getRotation() * -1);
        setRotation(getRotation() + Greenfoot.getRandomNumber(30) - 15);
    }
}
