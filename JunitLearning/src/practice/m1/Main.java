package practice.m1;

public class Main {
	public static void main(String[] args) {
		HomeLoan h=new HomeLoan(101,"Devesh", 750, 100000, 2);
		VehicalLoan v=new VehicalLoan(102, "Soumya", 850,"Maruti", 2500000);
		h.calculateInterest();
		System.out.println("Total amount of home: "+h.calculateTotalAmount());
		v.calculateInterest();
		System.out.println("Total amount of vehical: "+v.calculateTotalAmount());
	}

}
