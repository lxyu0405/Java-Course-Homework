package _2Homework;

public class _7_4_EmployeeWorkTime {
	
	public static int maxIndex(int[] array){
		int index = 0;
		for(int i = 0;i < array.length;i++)
			if(array[i] > array[index])
				index = i;
		return index;
	}
	public static void main(String[] args){
		int[][] workTime = {
				{2,4,3,4,5,8,8},
				{7,3,4,3,3,4,4},
				{3,3,4,3,3,2,2},
				{9,3,4,7,3,4,1},
				{3,5,4,3,6,3,8},
				{3,4,4,6,3,4,4},
				{3,7,4,8,3,8,4},
				{6,3,5,9,2,7,9}};
		int[] array = new int[8];
		for(int i = 0;i < 8;i++)
			for(int j = 0;j < 7;j++)
				array[i] = array[i] + workTime[i][j];
		for(int i = 0;i < 8;i++){
			System.out.println("Employee "+maxIndex(array)+",total worktime is  "+array[maxIndex(array)]+"h");
			array[maxIndex(array)] = 0;
		}
	}
}
