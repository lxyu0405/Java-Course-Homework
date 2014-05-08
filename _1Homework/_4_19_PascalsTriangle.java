package _1Homework;

public class _4_19_PascalsTriangle {
	/**2 pyramid*/
	public static void printVoid(int a){
		for(int i = 0;i<a;i++)
			System.out.print("\t");
	}
	
	public static void printSequence(int a){
		for(int i = 0;i<a;i++){
			System.out.print(powerOf2(i));
			System.out.print("\t");
		}
		for(int i = a-2;i>=0;i--){
			System.out.print(powerOf2(i));
			System.out.print("\t");
		}
	}
	public static int powerOf2(int a){
		int res = 1;
		for(int i = 0;i<a;i++)
			res = res*2;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0;i < 9;i++){
			printVoid(9-i);
			printSequence(i);
			System.out.println();
		}
	}

}
