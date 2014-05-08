package _3Homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _8_13_FindMaxValue {

	static int row;
	static int col;
	/**
	 * @param args
	 */
	public static boolean verifyRowCol(String a){//检验输入行数和列数格式
		Pattern pattern = Pattern.compile("^([1-9][0-9]*)\\s+([1-9][0-9]*)\\s*$");
		//Pattern pattern = Pattern.compile("^([+-]?[0-9]+\\.{0,1}[0-9]{0,2})\\s+([+-]?[0-9]+\\.{0,1}[0-9]{0,2})\\s*$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
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
	
	public static _8_13_Location locateLargest(double[][] a){
		_8_13_Location temp = new _8_13_Location();
		temp.maxValue = 0;
		for(int i = 0;i < row;i++)
			for(int j = 0;j < col;j++)
				if(a[i][j] > temp.maxValue){
					temp.row = i;
					temp.column = j;
					temp.maxValue = a[i][j];
				}
		return temp;
	}
	
	public static double[][] act(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns of the array: ");
		String rowAndCol = in.nextLine();
		while(!verifyRowCol(rowAndCol)){
			System.out.print("Illegal input!Please input again:(Both +int) ");
			rowAndCol = in.nextLine();
		}
		String[] rowCol = rowAndCol.split(" +");
		row = Integer.parseInt(rowCol[0]);
		col = Integer.parseInt(rowCol[1]);
		double[][] array = new double[row][col];
		System.out.println("Enter the array:");
		for(int i = 0;i < row;i++){
			String line = in.nextLine();
			String[] element = line.split(" +");
			while(!verifyArray(element)||element.length != col){
				System.out.println("Illegal input!Please input this line again!");
				line = in.nextLine();
				element = line.split(" +");
			}
			for(int j = 0;j < col;j++)
				array[i][j] = Double.parseDouble(element[j]);
		}
		in.close();
		return array;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] array = act();
		_8_13_Location locateResult = new _8_13_Location();
		locateResult = locateLargest(array);
		//findMaxValue test = new findMaxValue();
		//locateResult = test.locateLargest(test.act());
		System.out.println("The location of the largest element is "+locateResult.maxValue
				+"at ("+locateResult.row +", "+locateResult.column +")");
	}

}
