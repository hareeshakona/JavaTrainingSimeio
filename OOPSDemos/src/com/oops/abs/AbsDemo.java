package com.oops.abs;

public class AbsDemo {

	public static void main(String[] args) {
		
		Bank bank1 = new Branch1();
		Branch1 branch1 = (Branch1)bank1;
		
		branch1.educationLoan();
		branch1.vehicleLoan();
		branch1.houseLoan();
		branch1.staffDetails();
		
		
		Bank bank2 = new SubBranch();
		SubBranch branch2 = (SubBranch)bank2;
		branch2.houseLoan();
		branch2.educationLoan();
		branch2.vehicleLoan();
		branch2.payDetails();
		branch2.loanDetails();

	}

}
