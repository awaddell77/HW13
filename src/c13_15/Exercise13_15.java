package c13_15;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise13_15 {
	  public static void main(String[] args) {
		    // Prompt the user to enter two RationalUsingBigInteger numbers
		    Scanner input = new Scanner(System.in);
		    System.out.print("Enter RationalUsingBigInteger number1 with numerator and denominator seperated by a space: ");
		    String n1 = input.next();
		    String d1 = input.next();

		    System.out.print("Enter RationalUsingBigInteger number2 with numerator and denominator seperated by a space: ");
		    String n2 = input.next();
		    String d2 = input.next();

		    RationalUsingBigInteger r1 = new RationalUsingBigInteger(new BigInteger(n1), new BigInteger(d1));
		    RationalUsingBigInteger r2 = new RationalUsingBigInteger(new BigInteger(n2), new BigInteger(d2));

		    // Display results
		    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		    System.out.println(r2 + " is " + r2.doubleValue());
		  }
		}


class RationalUsingBigInteger extends Number implements Comparable<RationalUsingBigInteger>{
	private BigInteger numerator = new BigInteger("0");
	private BigInteger denominator = new BigInteger("0");
	public RationalUsingBigInteger(){
		
	}
	
	public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator){
		BigInteger gcd = gcd(numerator, denominator);
		this.numerator =  (((denominator.compareTo(new BigInteger("0")) == 1) ? new BigInteger("1") : new BigInteger("-1")).multiply(numerator.divide(gcd)));
		
		this.denominator = denominator.abs().divide(gcd);
		
	}
	private static BigInteger gcd(BigInteger n, BigInteger d){
		BigInteger n1 = n.abs();
		BigInteger n2 = d.abs();
		BigInteger gcd = new BigInteger("0");
		for (BigInteger k = new BigInteger("1"); k.compareTo(n1) == 0 || k.compareTo(n1) == -1 && (k.compareTo(n2) == 0 || k.compareTo(n2) == -1); k.add(new BigInteger("1"))){
			if (n1.mod(k).equals(new BigInteger("0")) && n2.mod(k).equals(new BigInteger("0")))
				gcd = k;
		
		}
		return gcd;
	}
	public BigInteger getNumerator(){
		return numerator;
	}
	public BigInteger getDenominator(){
		return denominator;
	}
	public RationalUsingBigInteger add(RationalUsingBigInteger secondRational){
		BigInteger n = numerator.multiply(secondRational.getDenominator()).add((denominator.multiply(secondRational.getNumerator())));
		BigInteger d = denominator.multiply(secondRational.getNumerator());
		return new RationalUsingBigInteger(n, d);
	}
	public RationalUsingBigInteger subtract (RationalUsingBigInteger secondRational){
		BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract((denominator.multiply(secondRational.getNumerator())));
		BigInteger d = denominator.multiply(secondRational.getNumerator());
		return new RationalUsingBigInteger(n, d);
	}
	public RationalUsingBigInteger multiply(RationalUsingBigInteger secondRational){
		BigInteger n = numerator.multiply(secondRational.getNumerator());
		BigInteger d = denominator.multiply(secondRational.getDenominator());
		return new RationalUsingBigInteger(n, d);
		
	}
	public RationalUsingBigInteger divide(RationalUsingBigInteger secondRational){
		BigInteger n = numerator.multiply(secondRational.getDenominator());
		BigInteger d = denominator.multiply(secondRational.numerator);
		return new RationalUsingBigInteger(n, d);
		
	}
	@Override
	public String toString(){
		if (denominator.equals(new BigInteger("1")))
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}
	@Override
	public boolean equals(Object other){
		if ((this.subtract((RationalUsingBigInteger)(other))).getNumerator().equals(new BigInteger("0")))
			return true;
		else
			return false;
	}
	@Override
	public int intValue(){
		return (int) doubleValue();
		
	}
	@Override
	public float floatValue(){
		return (float)doubleValue();
	}
	@Override
	public double doubleValue(){
		return (long) doubleValue();
	}
	@Override
	public long longValue(){
		return (long)doubleValue();
	}
	@Override
	public int compareTo(RationalUsingBigInteger o){
		if (this.subtract(o).getNumerator().signum() > 0)
			return 1;
		else if(this.subtract(o).getNumerator().signum() < 0)
			return -1;
		else
			return 0;
	}
	
	
}
