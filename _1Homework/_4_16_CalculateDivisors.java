package _1Homework;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class _4_16_CalculateDivisors {
	/**Integer divisor*/
	private static int indexCount = 0;
	public static boolean isPrime(int a){
		for(int i = 2;i<= a/2;i++)
			if(a % i == 0)
				return false;
		return true;
	}
	public static void divide(int a,int[] array){
		int i = 2;
		for(;i < a;i++)
			if(a % i == 0){
				array[indexCount++] = i;
					divide(a/i,array);
					break;/**cost me more than 2 hours to figure this bug out!*/
			}
	}
	public static boolean verifyInt(String a){
		Pattern pattern = Pattern.compile("^\\+?[1-9][0-9]*$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] divisors = new int[50];
		String num = "number";
		do{
			num = JOptionPane.showInputDialog(null,"Input a positive number( > 0)","Number",JOptionPane.QUESTION_MESSAGE);
		}while(!verifyInt(num));
		int inputNum = Integer.parseInt(num);
		if(isPrime(inputNum))
			System.out.println("The number is Prime");
		else{
			int tools = 1;
			divide(inputNum,divisors);
			System.out.print("The divisors of "+inputNum+" are ");
			for(int i = 0;divisors[i]!=0;i++){
				System.out.print(divisors[i]+",");
				tools = tools*divisors[i];
			}
			System.out.print(inputNum/tools);
		}
	}

}
