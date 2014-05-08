package _1Homework;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_6_SumOfDigits {
	public static boolean verifyInt(String a){
		Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
		Matcher matcher = pattern.matcher(a);
		if(matcher.matches()){
			int zoneOffset = Integer.parseInt(a);
			if(zoneOffset > 0 && zoneOffset < 1000)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "";
		int num = 0;
		int sum = 0;
		//boolean circle = false;
		try{
			do{
				System.out.println("Enter a number between 0 and 1000: ");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				s = in.readLine();
			}while(!verifyInt(s));
			num = Integer.parseInt(s);
			sum = 0;
			do{
				sum = sum + num % 10;
				num = num/10;
			}while(num >=1);
		}catch(IOException e){};
		//System.out.println("You've entered string: "+ s);
		System.out.print("The sum of the digits is ");
		System.out.println(sum);
	}

}
