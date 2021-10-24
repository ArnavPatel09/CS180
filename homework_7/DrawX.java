package homework_7;

/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Fall 2021</p>
 *
 * @author Purdue CS 
 * @version August 23, 2021
 */
public class DrawX {
 
    private int size; 
    
    public DrawX(int size) {
        this.size = size; 
    }
       
    public char[][] generateArray() {
        
        char[][] xArray = new char[size][size]; 
        
        for(int i = 0; i < xArray.length; i++) { 
        	xArray [i] [0 + i] = '*';
        	xArray [i] [xArray.length - 1 - i] = '*';
        }
        
        return xArray; 
    }
}
