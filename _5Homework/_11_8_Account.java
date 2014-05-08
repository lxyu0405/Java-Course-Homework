package _5Homework;

import java.util.Date;
import java.util.ArrayList;
public class _11_8_Account {

	private int id;
	private String name;
	private double balance;
	static private double annualInterestRate;
	private Date dateCreated = new Date(System.currentTimeMillis());
	private ArrayList<_11_8_Transaction> transactions = new ArrayList<_11_8_Transaction>();
	public _11_8_Account(){}
	public _11_8_Account(int id,double rest){
		this.id = id;
		this.balance = rest;
	}
	public _11_8_Account(String name,int id,double rest){
		this.name = name;
		this.id = id;
		this.balance = rest;
	}
	public int getID(){
		return id;
	}
	public void setID(int id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public ArrayList<_11_8_Transaction> getArrayList(){
		return transactions;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public static double getAnnualInterest(){
		return annualInterestRate;
	}
	public static void setAnnualInterest(double interest){
		annualInterestRate = interest;
	}
	public String getCreateDate(){
		return dateCreated.toString();
	}
	public double getMonthlyInterestRate(){
		return (double)annualInterestRate/12;
	}
	public void withDraw(double money){
		this.balance -= money;
		_11_8_Transaction temp = new _11_8_Transaction('W',money,this.balance,"Withdraw $"+money);
		transactions.add(temp);
	}
	public void deposit(double money){
		this.balance += money;
		_11_8_Transaction temp1 = new _11_8_Transaction('D',money,this.balance,"Deposit $"+money);
		transactions.add(temp1);
	}
}
