package homework_11;

import java.io.IOException;

import javax.swing.*;

public class OrderFormGUI {
	
	
    public static void main(String[] args) {
    	boolean goAgain = true;
        while (goAgain) { 
	        /** DO NOT CHANGE VALUES BELOW **/
	        boolean hoodieInStock = true;
	        boolean tshirtInStock = false;
	        boolean longsleeveInStock = true;
	        String item = "";
	        int quantity = 0;
	        String name = "";
	        /** DO NOT CHANGE VALUES ABOVE **/
	        boolean isInStock = false;
        	
	        while (!isInStock) { 
                String[] options = {"Hoodie", "T-shirt", "Long sleeve"};
                item = (String) JOptionPane.showInputDialog(null, "Select item style ", "Order Form",
                        JOptionPane.PLAIN_MESSAGE, null, options, null);
                switch (item) { 
                	case "Hoodie":
                		isInStock = hoodieInStock;
                		break;
                	case "T-shirt":
                		isInStock = tshirtInStock;
                		break;
                	case "Long sleeve":
                		isInStock = longsleeveInStock;
                		break;
                	
                }
                if (!isInStock) { 
                	JOptionPane.showMessageDialog(null, "Out of Stock", "Out of Stock", JOptionPane.ERROR_MESSAGE);
                }
        	}
        	while (quantity < 1) { 
        		try { 
        			quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity", "Order Form", 
        					JOptionPane.QUESTION_MESSAGE));
        			if (quantity < 1) { 
        				JOptionPane.showMessageDialog(null, "Enter a number greater than 0", "Enter a number greater than 0", JOptionPane.ERROR_MESSAGE);
        			}
        		} catch (NumberFormatException e) { 
        			JOptionPane.showMessageDialog(null, "Enter an integer", "Enter an integer", JOptionPane.ERROR_MESSAGE);
        		}
        		
        	}
            
            
        	while (!name.contains(" ") ) { 
        		name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
                        JOptionPane.QUESTION_MESSAGE);
                if (!name.contains(" ")) { 
                	JOptionPane.showMessageDialog(null, "Enter first and last name", "Enter first and last name", JOptionPane.ERROR_MESSAGE);
                }
        	}

            /** Order Confirmation Message **/
            String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
            JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

            //JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);
            String again = JOptionPane.showInputDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);
            if (again.equalsIgnoreCase("yes") )
            	goAgain = true;
            else
            	goAgain = false;
            
        }
    }
}
