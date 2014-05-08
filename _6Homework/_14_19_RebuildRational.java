package _6Homework;

import java.math.*;
public class _14_19_RebuildRational {

	private BigInteger numerator;
	private BigInteger denominator;
	
	
	public _14_19_RebuildRational(){
		numerator = BigInteger.ZERO;
		denominator = BigInteger.ONE;
	}
	public _14_19_RebuildRational(BigInteger numerator,BigInteger denominator){
		this.numerator = numerator;
		this.denominator = denominator;
		simplify(this);
	}
	public BigInteger getNumerator(){
		return numerator;
	}
	public BigInteger getDenominator(){
		return denominator;
	}
	private void simplify(_14_19_RebuildRational number){
		BigInteger gcd = number.numerator.gcd(number.denominator);
		if(gcd != BigInteger.ONE){
			number.numerator = number.numerator.divide(gcd);
			number.denominator = number.denominator.divide(gcd);
		}
	}
	public _14_19_RebuildRational add(_14_19_RebuildRational number){
		_14_19_RebuildRational temp = new _14_19_RebuildRational();
		temp.denominator = number.denominator.multiply(this.denominator);
		temp.numerator = number.denominator.multiply(this.numerator).add(
				number.numerator.multiply(this.denominator));
		simplify(temp);
		return temp;
	}
	public _14_19_RebuildRational subtract(_14_19_RebuildRational number){
		_14_19_RebuildRational temp = new _14_19_RebuildRational();
		temp.denominator = number.denominator.multiply(this.denominator);
		temp.numerator = number.denominator.multiply(this.numerator).subtract(
				number.numerator.multiply(this.denominator));
		simplify(temp);
		return temp;
	}
	public _14_19_RebuildRational multiply(_14_19_RebuildRational number){
		_14_19_RebuildRational temp = new _14_19_RebuildRational();
		temp.numerator = number.numerator.multiply(this.numerator);
		temp.denominator = number.denominator.multiply(this.denominator);
		simplify(temp);
		return temp;
	}
	public _14_19_RebuildRational divide(_14_19_RebuildRational number){
		_14_19_RebuildRational temp = new _14_19_RebuildRational();
		temp.numerator = number.denominator.multiply(this.numerator);
		temp.denominator = number.numerator.multiply(this.denominator);
		simplify(temp);
		return temp;
	}
	public String toString(){
		if(this.numerator.divideAndRemainder(this.denominator)[1] == BigInteger.ZERO){
			//System.out.println("Denominator 1");
			return numerator.toString();
		}
		else
			return numerator.toString() + "/" + denominator.toString();
	}
	public double doubleValue(){
		double numerator = this.numerator.doubleValue();
		double denominator  = this.denominator.doubleValue();
		return (double)numerator/denominator;
	}
}
