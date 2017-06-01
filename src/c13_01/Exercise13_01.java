package c13_01;
import java.util.Scanner;


public class Exercise13_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    System.out.print("Enter three sides: ");
	    double side1 = input.nextDouble();
	    double side2 = input.nextDouble();
	    double side3 = input.nextDouble();
	    
	    Triangle triangle = new Triangle(side1, side2, side3);
	    
	    System.out.print("Enter the color: ");
	    String color = input.next();
	    triangle.setColor(color);
	    
	    System.out.print("Enter a boolean value for filled: ");
	    boolean filled = input.nextBoolean();
	    triangle.setFilled(filled);

	    System.out.println("The area is " + triangle.getArea());
	    System.out.println("The perimeter is "
	      + triangle.getPerimeter());
	    System.out.println(triangle);
	    System.out.println("Color is: " + triangle.getColor());
	    System.out.println("Filled Status: " + triangle.isFilled());
	    input.close();

	}

}

abstract class GeometricObject{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	public GeometricObject(){
		dateCreated = new java.util.Date();
		
	}
	public GeometricObject(String color, boolean filled){
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor(){
		return color;
		
	}
	public void setColor(String color){
		this.color = color;
		
	}
	public boolean isFilled(){
		return filled;
		
	}
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	public String toString(){
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
}

class Triangle extends GeometricObject{
	
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	Triangle(){
		//super();
		
	}
	public Triangle(double side1, double side2, double side3){
		//super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	public double getSide1(){
		return this.side1;
	}
	public double getSide2(){
		return this.side2;
	}
	public double getSide3(){
		return this.side3;
	}
	public double getArea(){
		double p = getPerimeter() / 2;
		return Math.sqrt((p * (p - getSide1()) * (p - getSide2()) * (p - getSide3())));
		
	}
	public double getPerimeter(){
		return (getSide1() + getSide2() + getSide3()) ;
		
	}
	@Override
	public String toString(){
		return "Triangle: side 1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + side3;	
		
		
	}
}
