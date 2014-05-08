package _6Homework;

import java.math.BigInteger;

public class _14_19_RationalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_14_19_RebuildRational r1 = new _14_19_RebuildRational(BigInteger.valueOf(4),BigInteger.valueOf(2));
		_14_19_RebuildRational r2 = new _14_19_RebuildRational(BigInteger.valueOf(2),BigInteger.valueOf(3));
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r2 + " is " + r2.doubleValue());
	}

}
