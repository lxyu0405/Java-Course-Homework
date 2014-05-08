package _2Homework;
import javax.swing.JOptionPane;

import java.lang.Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class _5_22_ImitateSqrtFunction {
//virtual sqrt
	public static void virtualSqrt(float num,float lastGuess,float[] tube){
		float nextGuess = (lastGuess + (num / lastGuess))/(float)2.0;
		if(Math.abs(nextGuess-lastGuess) > 0.0001)
			virtualSqrt(num,nextGuess,tube);
		else
			tube[0] = nextGuess;
	}
	public static boolean verifyPositiveNum(String a){
		Pattern pattern = Pattern.compile("^\\+?[0-9]+\\.{0,1}[0-9]{0,2}$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] tube = new float[1];
		String inputInfo1 = "information1";
		do{
			inputInfo1 = JOptionPane.showInputDialog(null, "Input a number(>0)", "Sqrt Calculator", JOptionPane.QUESTION_MESSAGE);
		}while(!verifyPositiveNum(inputInfo1));
		float inputNum = Float.parseFloat(inputInfo1);
		virtualSqrt(inputNum,1,tube);
		JOptionPane.showMessageDialog(null, "The answer is "+tube[0],"Sqrt Result",JOptionPane.INFORMATION_MESSAGE);
	}

}
