package _1Homework;
import javax.swing.JOptionPane;
public class _4_23_ComparePrecision {
/**compare for a more precise method*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float sum1 = 0;
		float sum2 = 0;
		for(float i = 1;i < 50001;i++)
			sum1 = sum1 + (float)(1.0/i);
		for(float i = 50000;i > 0;i--)
			sum2 = sum2 + (float)(1.0/i);
		JOptionPane.showMessageDialog(null,"From head: "+sum1+"    From tail: "+sum2,"Comparsion",JOptionPane.INFORMATION_MESSAGE);
		/**比较可得，从后面计算要更精确，因为从前面计算时，当一个较大的数与(1/50000)做加法时，(1/50000)往往直接被忽略*/
		/**然而，从后面计算就可以避免这种“大数吃小数”的计算误差，从而结果跟精确*/
	}

}
