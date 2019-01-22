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
    private Money money;
    //Integer that hold more digits (Longer Integer)
    private long startTime = System.currentTimeMillis();
    public boolean pause = false;

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
        addObject( score, 105, 580);
        
        money = new Money();
        addObject( money, 185, 510);

        startTime = System.currentTimeMillis();

    }
   
    /**
     * Act - do whatever the PlayField wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        startDelay();
        
        if(getObjects(Square.class).isEmpty() == true)
        {
            Greenfoot.setWorld(new WinScreen());
        }
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
        addObject(new MoneyIcon(), 60, 515);
        addObject(new ScoreIcon(), 200, 582);
        addObject(new PlayButton(), 70, 30);
        addObject(new PauseButton(), 198, 30);
        addObject(new HomeButton(), 70, 75);
        addObject(new ResetButton(), 198, 75);
        
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
            //Greenfoot.stop();
            //showText("You Lost :(", getWidth()/2 + 140, getHeight()/2);
            Greenfoot.setWorld(new GameOverScreen());
        }
    }
    
    private void startDelay()
    {
        //This makes it so it wont run all the time
        if(System.currentTimeMillis() - startTime < 1000)
        {
            //Makes the ball delayed so it wont spawn right when the game is started
            while((System.currentTimeMillis() - startTime) < 1000)
            {  
            }
            
            addBall();
        }
    }

    public void update()
    {
        score.addToScore();
    }
    
    public void updateTwo()
    {
        money.addToMoney();    
    }
}
