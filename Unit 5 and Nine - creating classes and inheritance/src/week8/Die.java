package week8;

public class Die{
    //attricbutes define the state of an instance of the class at any particular time
    private int numSides;   //private means they can onl be accessible inside the class
    //(only visible inside the class)
    private int topSide;

    /* constructor
    has the same name as the class
    initializes the state of the class(attributes)
    return the object(although we do not say return) 
    */

    /**
     * if we do not EXPLICITLY create our own constructor JAVA will suplu a NO ARGUMENT constructor that DOES
     * NOT initialise the state fo the class (attributes)
     */
    public Die(){
        numSides = 6;
        roll();
    }
    public Die(int numSides){
        this.numSides = numSides;
        roll();
    }
    
    public int getTopSide(){
        return topSide;
    }

    public void roll(){
        topSide = (int)(Math.random() * numSides) + 1;
    }

    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }
        if (obj instanceof Die){
            return this.topSide == ((Die)obj).topSide;
        } else {
            return false;
        }
    }
}