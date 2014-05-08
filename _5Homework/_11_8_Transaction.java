package _5Homework;

import java.util.Date;

public class _11_8_Transaction {
	public Date date = new Date(System.currentTimeMillis());
	public char type;
	public double amount;
	public double balance;
	public String description;
	public _11_8_Transaction(){}
	public _11_8_Transaction(char type,double amount,double balance,String description){
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}
}
