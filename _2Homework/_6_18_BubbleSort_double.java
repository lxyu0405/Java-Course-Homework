package _2Homework;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class _6_18_BubbleSort_double {
/**bubble sort*/
	public static void bubbleSort(double[] array){
		int length = array.length;
		for(int j = 0;j < array.length-1;j++){
			for(int i = 0;i < length-1;i++){
				if(array[i] > array[i+1]){
					double temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			length--;
		}
	}
	public static boolean verifyArray(String[] a){//检验输入一行数的格式
		Pattern pattern = Pattern.compile("^[+-]?[0-9]+\\.{0,1}[0-9]{0,2}$");
		for(int i = 0;i < a.length;i++){
			Matcher matcher = pattern.matcher(a[i]);
			if(!matcher.matches())
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] array = new double[10];
		System.out.println("Please input ten numbers:");
		Scanner scan = new Scanner(System.in);
		String initial = scan.nextLine();
		String[] element = initial.split(" +");
		while(!verifyArray(element) || element.length != 10){
			System.out.println("Illegal input!Please input again!");
			initial = scan.nextLine();
			element = initial.split(" +");
		}
		scan.close();	
		for(int i = 0;i < array.length;i++)
			array[i] = Double.parseDouble(element[i]);
		bubbleSort(array);
		for(double a:array)
			System.out.print(a+",");
	}
}
