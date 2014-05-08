package _6Homework;

import java.math.*;
//import java.util.*;
public class _14_14_LongMaxValuePrime {

	/**
	 * @param args
	 */
	/*public static boolean isPrime(BigInteger a){
		if(a == new BigInteger("2"))
			return true;
		BigInteger i = new BigInteger("2");
		BigInteger pivot = i.nextProbablePrime();
		while(i.compareTo(){
			
		}
		
	}*/
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		BigInteger max = BigInteger.valueOf(Long.MAX_VALUE);
		//BigInteger check;
		//Random rnd = new Random();
		for(int i = 0;i < 5;i++){
			max = max.nextProbablePrime();
			System.out.println(max);
		}
	}

}

