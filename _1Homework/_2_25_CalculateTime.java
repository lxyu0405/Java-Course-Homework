package _1Homework;
import javax.swing.JOptionPane;
import java.util.regex.*;
import java.lang.Math;
public class _2_25_CalculateTime {
	/**show current time*/
	
	/**use regex to avoid an illegal input & subscribe the number to a range of -12~12*/
	public static boolean verifyInt(String a){
		Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
		Matcher matcher = pattern.matcher(a);
		if(matcher.matches()){
			int zoneOffset = Integer.parseInt(a);
			if(Math.abs(zoneOffset) <= 12)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**obtain the total milliseconds since midnight,Jan 1,1970*/
		long totalMilliSeconds = System.currentTimeMillis();
		/**obtain seconds*/
		long totalSeconds = totalMilliSeconds / 1000;
		/**compute current seconds*/
		long currentSeconds = totalSeconds % 60;
		/**obtain minutes*/
		long totalMinutes = totalSeconds / 60;
		/**compute current minutes*/
		long currentMinutes = totalMinutes % 60;
		/**obtain hours*/
		long totalHours = totalMinutes / 60;
		/**computer current hours*/
		long currentHours = totalHours % 24;
		
		/**interaction*/
		String askOffset = JOptionPane.showInputDialog(null,"Enter the time zone offset to GMT:","Time Calculator",JOptionPane.QUESTION_MESSAGE);
		do{
			askOffset = JOptionPane.showInputDialog(null,"Enter the time zone offset to GMT(Please input an INTEGER(-12~12)!):","Time Calculator",JOptionPane.QUESTION_MESSAGE);
		}while(!verifyInt(askOffset));
		int zoneOffset = Integer.parseInt(askOffset);
		long localHours = (currentHours + zoneOffset) % 24;
		JOptionPane.showMessageDialog(null,"The current time is " + localHours+":"+currentMinutes+":"+currentSeconds,"Local Time",JOptionPane.QUESTION_MESSAGE);
	
	}

}
