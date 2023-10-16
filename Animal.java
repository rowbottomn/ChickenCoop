import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal extends Actor
{
    private int health;
    private int maxHealth = 3;
    private double seed;
    private double maxSeed = 2;
    private double seedDecay = 0.001;
    private int age;
    private int maxAge = 200;
    private boolean happiness;
    private boolean isAlive = true;
    
    protected SimpleTimer moveTimer;
    private int restDuration = 300; //this is the amount of timer between hops
    private int hopSize = 50;
    private int hopX;
    private int hopY;
    
    
    public Animal(){
        health = maxHealth;
        seed = 1;
        age = 0;
        happiness = true;
        moveTimer = new SimpleTimer();
    }
    
    
    /**
     * Act - do whatever the Animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //don't do anything if its dead
        if(isAlive == false){
            return;
        }
        // if the enough time has passed 
        if(moveTimer.millisElapsed()>restDuration){
            //get a new random hopX and hopY
            hopX = (int)((float)hopX*0.8 + (double)(Greenfoot.getRandomNumber(hopSize+1)-hopSize/2)*0.2);
            hopY = Greenfoot.getRandomNumber(hopSize+1)-hopSize/2;
            //move location by hopX and hopY
            setLocation(getX()+hopX,getY()+hopY);
            //reset the timer
            moveTimer.mark();
            age();
        }
            
    }
    
    private void age(){
        age++;
        if(age>maxAge){
            die();
        }
        
    }
    
    public void hit(){
        health --;
        happiness  = false;
        if(isAlive && health <= 0){
            die();
        }
    }
    
    public void play(){
        happiness = true;
    }
    
    public void feed(){
       seed+=0.1;//increase the seed amt 
       health+=1;//increase health
       //make sure its not past the max health
       if(health > maxHealth){
           health = maxHealth;
       }
       //if overfed, kill chicken
       if(seed>maxSeed){
           die();
       }
    }
    
    protected void die(){
        isAlive = false;
    }
}
