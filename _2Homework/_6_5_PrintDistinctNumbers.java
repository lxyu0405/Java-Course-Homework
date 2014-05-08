package _2Homework;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class _6_5_PrintDistinctNumbers {

	private static int count = 0;
	public static boolean isContain(int a,int[] array){
		for(int i = 0;i < array.length;i++)
			if(a == array[i])
				return true;
		return false;
	}
	public static boolean verifyArray(String[] a){//检验输入一行数的格式
		Pattern pattern = Pattern.compile("^[+-]?[1-9][0-9]*$");
		for(int i = 0;i < a.length;i++){
			Matcher matcher = pattern.matcher(a[i]);
			if(!matcher.matches())
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10];
		System.out.println("Please input ten numbers:(int)");
		Scanner scan = new Scanner(System.in);
		String initial = scan.nextLine();
		String[] element = initial.split(" +");
		while(!verifyArray(element) || element.length != 10){
			System.out.println("Illegal input!Please input again!");
			initial = scan.nextLine();
			element = initial.split(" +");
		}
		scan.close();	
		for(int i = 0;i < element.length;i++)
			if(!isContain(Integer.parseInt(element[i]),array))
				array[count++] = Integer.parseInt(element[i]);
		System.out.print("The distinct numbers are: ");
		for(int i = 0;i < array.length-1;i++)
			if(array[i] != 0)
				System.out.print(array[i]+",");
		scan.close();
	}

}
