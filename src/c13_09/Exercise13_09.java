package c13_09;
/*
 Circle
=============
-radius: double
================
+Circle()
+Circle(radius:double)
+getRadius(): double
+setRadius(radius: double): void
+getDiameter():double
+getArea():double
+getPerimeter(): double
+printCircle():void
+compareTo(c1: Circle): int
+equals(circle: Object): boolean



Comparable
============
================
+/compareTo(object: Object): int/

GeometricObject
======================
-color: String
-filled: boolean
-dateCreated: java.util.Date
===============================
+GeometricObject()
+GeometricObject(color:String, filled:boolean)
+getColor():String
+setColor(color:String): void
+isFilled():boolean
+setFilled(filled:boolean):void
+getDateCreated():java.util.Date
+toString():String
+/getArea():double/
+/getPerimeter():double/
 */
 
public class Exercise13_09 {

}

class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;

    public Circle(){
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled){
    	this.radius = radius;
    	setColor(color);
    	setFilled(filled);
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
    	this.radius = radius;
    }
    public double getDiameter(){
    	return 2 * radius;
    }
    @Override
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    public void printCircle(){
    	System.out.println("The circle is created " + getDateCreated() + 
    			" and the radius is " + radius);
    }
    @Override
    public boolean equals(Object circle){
    	if (((Circle)(circle)).getRadius() == this.radius){
    		return true;
    	}
    	else{
    		return false;
    	}
    	
    }
    @Override
    public int compareTo(Circle c1){
    	if (c1.getRadius() > this.radius){
    		return -1;
    	}
    	else if (c1.getRadius() < this.radius ){
    		return 1;
    	}
    	else{
    		return 0;
    	}
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