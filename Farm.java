import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farm extends World
{
    Animal test;
    Chicken testChicken;
    MouseInfo mouse;
    boolean button1 = false;
    boolean button2 = false;
    boolean button3 = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Farm()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        //make the test Animal
        
        test = new Animal();
        addObject(test, 300,300);
        testChicken = new Chicken();
        addObject(testChicken, 700,300);
    }
    
    public void act(){
        //get the mouse info
        mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            if(mouse.getButton()==1){
                if(button1 == false){
                    button1 = true;
                    Animal temp = (Animal)mouse.getActor();
                    if(temp != null){
                       temp.hit(); 
                    }
                }
            }
            else{
                button1 = false;
            }
            if(mouse.getButton()==2){
                if(button2 == false){
                    button2 = true;
                    Animal temp = (Animal)mouse.getActor();
                    if(temp != null){
                       temp.play(); 
                    }
                }
            }
            else{
                button2 = false;
            }
            if(mouse.getButton()==3){
                if(button3 == false){
                    button3 = true;
                    Animal temp = (Animal)mouse.getActor();
                    if(temp != null){
                       temp.feed(); 
                    }
                }
            }
            else{
                button3 = false;
            }
        }
    }
    
}
