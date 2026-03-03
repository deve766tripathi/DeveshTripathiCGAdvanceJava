package practice.m1;

public class VehicalLoan extends Loan{
	String vehicalType;
	int vehicalCost;
	

	public VehicalLoan(int loanId, String customerName, int creaditScore, String vehicalType, int vehicalCost) {
		super(loanId, customerName, creaditScore);
		this.vehicalType = vehicalType;
		this.vehicalCost = vehicalCost;
	}


	@Override
	public double calculateInterest() {
		return 0.12*vehicalCost;
	}

	@Override
	public double calculateTotalAmount() {
		return vehicalCost+calculateInterest();
		
	}

}
