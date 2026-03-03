package practice.m1;

public class HomeLoan extends Loan {
	int propertyValue;
	int tenure;
	

	public HomeLoan(int loanId, String customerName, int creaditScore, int propertyvalue, int tenure) {
		super(loanId, customerName, creaditScore);
		this.propertyValue=propertyvalue;
		this.tenure=tenure;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateInterest() {
		return 0.1*propertyValue *tenure;
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculateTotalAmount() {
		return propertyValue+calculateInterest();
		// TODO Auto-generated method stub
		
	}

}
