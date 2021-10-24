package homework_6;

public class testing {

	public static void main(String[] args) {
		int d = 12;
		double rate = .12;
		double a = 1000;
		//System.out.println(rate*d);
		//System.out.println(1 + Math.pow(rate, d));
		double payment = a * ( (rate / 12) * Math.pow( 1 + (rate / 12), d ) ) / (Math.pow((1 + rate / 12), d) - 1);
		System.out.println(payment);
	}

}
