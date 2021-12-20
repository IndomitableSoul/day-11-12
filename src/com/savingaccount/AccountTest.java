package com.savingaccount;

public class AccountTest {
	public static void main(String[] args) {
		Account a1 = new Account(2000);
		a1.credit(3000);
		System.out.println(a1.getBalance());
		a1.debit(2000);
		System.out.println(a1.getBalance());
		a1.debit(4000);
		System.out.println(a1.getBalance());
	}
}
