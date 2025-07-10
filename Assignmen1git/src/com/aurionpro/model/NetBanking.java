package com.aurionpro.model;

public class NetBanking implements PaymentGateway {
	double amount;
	
	public NetBanking(double amount) {
		this.amount = amount;
	}
	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		
		if(amount>0) {
		System.out.println("Amount payable through Netbanking "+amount);
		
		
	}
		else {
			System.out.println("Invalid amount");
		}
	
	}

	@Override
	public void refund(double amount) {
		// TODO Auto-generated method stub
		double refundamount;
		if(amount>0) {
			
		refundamount= (0.05*amount);
		System.out.println("Refund through Netbanking " +refundamount);
		
	}
		else {
			System.out.println("Refund not valid");
		}

}
}
