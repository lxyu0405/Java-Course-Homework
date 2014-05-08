package _2Homework;
import java.lang.Math;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class _6_21_ProbabilityStatistics {
	/**final LEFT & RIGHT*/
	final static int LEFT = 0;
	final static int RIGHT = 1;
	
	public static boolean verifyPositiveInt(String a){
		Pattern pattern = Pattern.compile("^\\+?[1-9][0-9]*$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	
	public static int maxBeans(int[] array){
		int max = 0;
		for(int i = 0;i < array.length ;i++)
			if(array[i] > max)
				max = array[i];
		return max;
	}
	public static int randomDirection(){
		int randNum = (int)(1+Math.random()*(100-1+1));
		if(randNum % 2 == 1)
			return LEFT;
		else
			return RIGHT;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String ballsString = "balls";
		String slotsString = "slots";
		do{
			System.out.println("Enter the number of balls to drop:(+int) ");
			ballsString = scan.nextLine();
		}while(!verifyPositiveInt(ballsString));
		int numOfBalls = Integer.parseInt(ballsString);
		do{
			System.out.println("Enter the number of slots in the bean machine:(+int) ");
			slotsString = scan.nextLine();
		}while(!verifyPositiveInt(slotsString));
		int numOfSlots = Integer.parseInt(slotsString);
		scan.close();
		int[] slots = new int[numOfSlots];
		for(int i = 0;i < numOfBalls;i++){
			int position = 0;
			for(int j = 0;j < numOfSlots-1;j++){
				int direction = randomDirection();
				if(direction == LEFT)
					System.out.print("L");
				else{
					position++;
					System.out.print("R");
				}
			}
			slots[position]++;
			System.out.println();
		}
		char[][] chart = new char[maxBeans(slots)][slots.length];
		for(int i = 0;i < maxBeans(slots) ;i++)
			for(int j = 0;j < slots.length;j++)
				chart[i][j] = ' ';
		for(int i = 0;i < slots.length ;i++)
			for(int j = 0;j < slots[i];j++)
				chart[maxBeans(slots)-1-j][i] = '0';
		for(int i = 0;i < maxBeans(slots) ;i++){
			for(int j = 0;j < slots.length;j++)
				System.out.print(chart[i][j]);
			System.out.println();
		}
	}
}
