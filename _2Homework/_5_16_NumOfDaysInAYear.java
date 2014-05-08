package _2Homework;

public class _5_16_NumOfDaysInAYear {
	//number of days in a year
	private static boolean isLeap(int a){
		if((a % 4 == 0 && a % 100 != 0)||a % 400 == 0)
			return true;
		else
			return false;
	}
	
	private static int numberOfDaysInAYear(int year){
		int[] monthDays = new int[12];
		int count = 0;
		monthDays[0] = 31;
		if(isLeap(year))
			monthDays[1] = 29;
		else
			monthDays[1]  =28;
		monthDays[2] = 31;
		monthDays[3] = 30;
		monthDays[4] = 31;
		monthDays[5] = 30;
		monthDays[6] = 31;
		monthDays[7] = 31;
		monthDays[8] = 30;
		monthDays[9] = 31;
		monthDays[10] = 30;
		monthDays[11] = 31;
		for(int i = 0;i < 12;i++)
			count = count + monthDays[i];
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 2000;i < 2011;i++)
			System.out.println("The number of the Year "+i+" is "+numberOfDaysInAYear(i));
	}
}
