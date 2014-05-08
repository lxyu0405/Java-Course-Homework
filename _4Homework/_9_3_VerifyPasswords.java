package _4Homework;

import java.util.Scanner;
import java.util.regex.*;
public class _9_3_VerifyPasswords {

	public static boolean verify2Num(String a){
		char[] temp = a.toCharArray();
		int count = 0;
		for(int i = 0;i < temp.length;i++){
			if(temp[i] >= '0' && temp[i] <= '9')
				count++;
		}
		if(count >= 2)
			return true;
		else
			return false;
				
	}
	public static boolean verifyFormat(String a){
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]{8}$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input your Passwords: ");
		String inputPassword = scan.nextLine();
		if(verifyFormat(inputPassword) && verify2Num(inputPassword))
			System.out.println("Valid Password");
		else
			System.out.println("Invalid Password");
		scan.close();
	}

}
