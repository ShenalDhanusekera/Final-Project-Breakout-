import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayField extends World
{
    private Scoreboard score;
    
    /**
     * Constructor for objects of class PlayField.
     * 
     */
    public PlayField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        prepare();
        
        score = new Scoreboard();
        addObject( score, 150, 580);
        
        addBall();
    }
    
    /**
     * Act - do whatever the PlayField wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }  
    
    /**
     * prepare method adds all the Square, 
     */
    private void prepare()
    {
        addObject( new Paddles(), getWidth()/2 +140, 650);
        
        addObject(new Heart(), 34, 666);
        addObject(new Heart(), 84, 666);
        addObject(new Heart(), 134, 666);
        addObject(new Heart(), 184, 666);
        addObject(new Heart(), 234, 666);
        
        for(int y = 0; y < 7; y++)
        {   
            for(int x = 0; x < 14; x++)
            {
                addObject( new Square(), 310 + (x * 50) , 60 + (y * 30));
            }
        }
    }
    
    public void addBall()
    {
        if(getObjects(Heart.class).isEmpty() == false)
        {
            addObject( new Ball(), getWidth()/2 +140, getHeight()/2 +75);
            Greenfoot.delay(100);
        }
        else
        {
            Greenfoot.stop();
            showText("You Lost :(", getWidth()/2 + 140, getHeight()/2);
        }
    }
    
    public void update()
    {
        score.addToScore();
    }
}
