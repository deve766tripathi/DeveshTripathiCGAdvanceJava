package practice.m1;

abstract public class Loan {
	int loanId;
	String customerName;
	int creaditScore;
	abstract public double calculateInterest();
	abstract public double calculateTotalAmount();
	public Loan(int loanId, String customerName, int creaditScore) {
		super();
		this.loanId = loanId;
		this.customerName = customerName;
		this.creaditScore = creaditScore;
	}

}
