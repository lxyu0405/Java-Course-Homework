package _1Homework;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
public class _4_29_Calender {
	/**show days*/
	private static boolean isLeap(int a){
		if((a % 4 == 0 && a % 100 != 0)||a % 400 == 0)
			return true;
		else
			return false;
	}
	private static void printWeekday(){/**打印日历头星期一~星期日*/
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
	}
	private static void printMonth(int a,int year){/**打印日历头，年月*/
		String resultMonth =  "Month";
		switch(a){
		case 1:resultMonth = "January";break;
		case 2:resultMonth = "February";break;
		case 3:resultMonth = "March";break;
		case 4:resultMonth = "April";break;
		case 5:resultMonth = "May";break;
		case 6:resultMonth = "June";break;
		case 7:resultMonth = "July";break;
		case 8:resultMonth = "August";break;
		case 9:resultMonth = "September";break;
		case 10:resultMonth = "October";break;
		case 11:resultMonth = "November";break;
		case 12:resultMonth = "December";break;
		default:System.out.println("Wrongly Input");	
		}
		System.out.println("\t\t   "+resultMonth +" "+year);
		System.out.println("———————————————————————————————————————————————————");
	}
	private static int countDay(int month,int year,int date,int[] monthDays){
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
		for(int i = 0;i < month-1;i++)
			count = count + monthDays[i];
		return (count + date)%7;
	}
	private static void printFormat(int n){
		for(int i = 0;i < n;i++)
			System.out.print("\t");
	}
	public static boolean verifyYear(String a){
		Pattern pattern = Pattern.compile("^\\+?[1-9][0-9]*$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static boolean verifyDay(String a){
		Pattern pattern = Pattern.compile("^\\+?[1-9][0-9]*$");
		Matcher matcher = pattern.matcher(a);
		if(matcher.matches()){
			int day = Integer.parseInt(a);
			if(day >= 0 && day <= 6)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String getinfo1 = "information1";
		do{
			getinfo1 = JOptionPane.showInputDialog(null,"请输入年份(>0)","Year",JOptionPane.QUESTION_MESSAGE);
		}while(!verifyYear(getinfo1));
		int year = Integer.parseInt(getinfo1);
		String getinfo2 = "information2";
		do{
			getinfo2 = JOptionPane.showInputDialog(null,"该年的第一天是星期几(0-Sun,1-Mon,...,6-Sat)","Day",JOptionPane.QUESTION_MESSAGE);
		}while(!verifyDay(getinfo2));
		int date = Integer.parseInt(getinfo2);
		/**count certain days*/
		int[] monthDays = new int[12];
		for(int i = 1;i <= 12;i++){
			printMonth(i,year);
			printWeekday();
			int firstDayOfMonth = countDay(i,year,date,monthDays);
			printFormat(firstDayOfMonth);
			for(int j = 0;j < monthDays[i-1];j++){
				System.out.print((j+1)+"\t");
				if((j+1+firstDayOfMonth)%7 == 0)
					System.out.println();
			}
			System.out.println();
		}
	}
}
