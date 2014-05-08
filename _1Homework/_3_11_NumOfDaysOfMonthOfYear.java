package _1Homework;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
public class _3_11_NumOfDaysOfMonthOfYear {
	/**show days*/
	private static boolean isLeap(int a){
		if((a % 4 == 0 && a % 100 != 0)||a % 400 == 0)
			return true;
		else
			return false;
	}

	public static boolean verifyYear(String a){
		Pattern pattern = Pattern.compile("^\\+?[1-9][0-9]*$");/**positive Integer*/
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	
	public static boolean verifyMonth(String a){
		Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
		Matcher matcher = pattern.matcher(a);
		if(matcher.matches()){
			int zoneOffset = Integer.parseInt(a);
			if(zoneOffset >= 1 && zoneOffset <= 12)
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
			getinfo1 = JOptionPane.showInputDialog(null,"请输入年份（>0）","Year",JOptionPane.QUESTION_MESSAGE);
		}while(!verifyYear(getinfo1));
		int year = Integer.parseInt(getinfo1);
		String getinfo2 = "information2";
		do{
			getinfo2 = JOptionPane.showInputDialog(null,"请输入月份（1-12）","Month",JOptionPane.QUESTION_MESSAGE);
		}while(!verifyMonth(getinfo2));
		int month = Integer.parseInt(getinfo2);
		/**count certain days*/
		int days = 0;
		if(month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12)
			days = 31;
		else if(month == 2){
			if(isLeap(year))
				days = 29;
			else
				days = 28;
		}
		else
			days = 30;
		/**prepare month in English*/
		String resultMonth = "month";
		switch(month){
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
		JOptionPane.showMessageDialog(null,resultMonth +" "+year+" has "+days+" days","Result",JOptionPane.INFORMATION_MESSAGE);	
	}
}
