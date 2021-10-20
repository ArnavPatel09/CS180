package homework_9;

public class FiveDollar extends DollarBill{
	
	public FiveDollar() {
		super(5, "Abraham Lincoln");
	}
	
	//override
	public boolean acceptedVending() {
        return true;
    }
	
	
}
