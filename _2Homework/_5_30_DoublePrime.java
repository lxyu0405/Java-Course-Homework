package _2Homework;

public class _5_30_DoublePrime {
	/**double Prime*/
	public static boolean isPrime(int a){
		for(int i = 2;i<= a/2;i++)
			if(a % i == 0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 2;i < 1000;i++)
			if(isPrime(i) && isPrime(i+2))
				System.out.println("("+i+", "+(i+2)+")");
	}

}
