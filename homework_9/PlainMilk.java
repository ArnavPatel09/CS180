package homework_9;


public class PlainMilk extends Milk {
    /*
     * Indicates whether store aims to make plain milk more 
     * accessible than flavored milk or not (false by default)
     */
    private boolean moreAccessible;
    
    /*
     * Constructor that calls default constructor in milk superclass and sets 
     * moreAccessible instance variable to false
     */
    public PlainMilk() {
    	super();
        moreAccessible = false;
        
    }

    /*
     * Constructor that calls default constructor in milk superclass and sets
     * moreAccessible instance variable to value of the input parameter
     */
    public PlainMilk(boolean moreAccessible) {
    	super();
        this.moreAccessible = moreAccessible;
    }

    //Returns moreAccessible instance variable
    public boolean isMoreAccessible() {
        return moreAccessible;
    }

}
