package _1Homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
public class _3_5_AdditionQuiz {
	/**addition quiz*/
	public static boolean verifyInt(String a){
		Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = (int)(System.currentTimeMillis() % 10);
		int number2 = (int)(System.currentTimeMillis()*3 % 10);
		int number3 = (int)(System.currentTimeMillis()*7 % 10);
		int addition = number1+number2+number3;
		//Scanner in = new Scanner(System.in);
		String getinfo = JOptionPane.showInputDialog(null,"what is "+number1+"+"+number2+"+"+number3+"?","Addition Quiz",JOptionPane.QUESTION_MESSAGE);
		do{
			getinfo = JOptionPane.showInputDialog(null,"(Again!)what is "+number1+"+"+number2+"+"+number3+"?","Addition Quiz",JOptionPane.QUESTION_MESSAGE);
		}while(!verifyInt(getinfo));
		int answer = Integer.parseInt(getinfo);
		JOptionPane.showMessageDialog(null,number1+"+"+number2+"+"+number3+" = "+answer+" "+(answer == addition),"Answer",JOptionPane.INFORMATION_MESSAGE);
		
	}

}
