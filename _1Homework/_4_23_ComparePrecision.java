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
		/**�ȽϿɵã��Ӻ������Ҫ����ȷ����Ϊ��ǰ�����ʱ����һ���ϴ������(1/50000)���ӷ�ʱ��(1/50000)����ֱ�ӱ�����*/
		/**Ȼ�����Ӻ������Ϳ��Ա������֡�������С�����ļ������Ӷ��������ȷ*/
	}

}
