package com.savingaccount;

public class Account {
	String acountNumber;
	static int count=0;
	
    public Account(int balance) {
		count++;
		this.acountNumber = "GB"+count;
		this.balance = balance;
	}

	private int balance;

	public int getBalance() {
		return balance;
	}

	public void credit(int amount) {
		if(amount>0)
		balance+=amount;
	}
	public void debit(int amount) {
		if(amount<=this.balance) {
			balance-=amount;
		}   
		else
			System.out.println("Insufficient Balance!!!");
	}
}
