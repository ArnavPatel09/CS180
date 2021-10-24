package homework_6;

public class Loan { 
	// fields
	private int duration;
    private double rate;
    private double amount;
    private double monthlyPayment;
    
    // constructor
    public Loan(int duration, double rate, double amount) { 
    	this.duration = duration;
    	this.rate = rate;
    	this.amount = amount;
    	this.monthlyPayment = calculateMonthlyPayment();
    }
    
    // getters
    public int getDuration() { 
    	return duration;
    }
    public double getRate() { 
    	return rate;
    } 
    public double getAmount() { 
    	return amount;
    }
    
    // setters
    public void setDuration(int duration) { 
    	this.duration = duration;
    }
    public void setRate(double rate) { 
    	this.rate = rate;
    }
    public void setAmount(double amount) { 
    	this.amount = amount;
    }
    
    //methods
    public double calculateMonthlyPayment() {
    	double payment = amount * ( (rate / 12) * Math.pow( 1 + (rate / 12), duration ) ) / (Math.pow((1 + rate / 12), duration) - 1);
    	return payment;
    }
    
    public double calculateTotalInterst(boolean output) { 
    	double bal = amount;
    	double interest = 0;
    	double total = 0;
    	double principal = 0;
  
    	for(int i = 0; i < duration; i++) {
    		interest = bal*rate / 12;
    		principal = calculateMonthlyPayment() - interest;
    		bal -= principal;
    		total += interest;
    		if(output)
    			System.out.println("Payment: " + (i+1) + " Principal: " + String.format("%.2f",principal) + " - Interest: "
    					+ String.format("%.2f", interest) + " - Remaining: " + String.format("%.2f",bal));
    	}
    	
    	return total;
    }
    
    public String toString() {
    	return "Amount: " + String.format("%.2f", amount) + " - Rate: "+ String.format("%.2f", rate) + " - Duration: " + duration 
    			+ " - Payment: " + String.format("%.2f", monthlyPayment);
    }  
    
}
