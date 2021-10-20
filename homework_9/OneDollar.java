package homework_9;

public class OneDollar extends DollarBill{
	public OneDollar() {
		super(1, "George Washington");
	}
	
	//override
	public boolean acceptedVending() {
        return true;
    }

}
