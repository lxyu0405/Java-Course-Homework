package _5Homework;

import java.util.ArrayList;
public class _11_8_AccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_11_8_Account.setAnnualInterest(0.015);
		_11_8_Account customer = new _11_8_Account("George",1122,1000);
		//customer.withDraw(2500);
		//customer.deposit(3000);
		customer.deposit(30);
		customer.deposit(40);
		customer.deposit(50);
		customer.withDraw(5);
		customer.withDraw(4);
		customer.withDraw(2);
		System.out.println(" Account: "+customer.getID()
				+"\n Name: "+customer.getName()
				+"\n Rest Money: "+customer.getBalance()
				+"\n Monthly Interest: "+customer.getMonthlyInterestRate()
				+"\n Account Create Date: "+customer.getCreateDate());
		ArrayList<_11_8_Transaction> record = customer.getArrayList();
		for(int i = 0;i < record.size();i++){
			System.out.println("\n============= Check "+i+" ============");
			System.out.println(" Date: "+record.get(i).date.toString()
					+"\n Bill: $"+record.get(i).amount
					+"\n Rest Money: $"+record.get(i).balance
					+"\n Description: "+record.get(i).description);
		}

	}

}
