package _3Homework;

//import java.lang.Math.*;
public class _10_11_Circle2D {
	final static double PI = 3.14;
	private double x;
	private double y;
	private double radius;
	
	public _10_11_Circle2D(){}
	public _10_11_Circle2D(double x,double y,double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getRadius(){
		return radius;
	}
	public double getArea(){
		return radius*radius*PI;
	}
	public double getPerimeter(){
		return 2*PI*radius;
	}
	public boolean contains(double x,double y){
		if((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y) < radius*radius)
			return true;
		else
			return false;
	}
	public boolean contains(_10_11_Circle2D circle){
		double temp = radius - circle.radius;
		if(temp < 0)
			return false;
		if(temp*temp >= (x-circle.x)*(x-circle.x)+(y-circle.y)*(y-circle.y))
			return true;
		else
			return false;
	}
	public boolean overlaps(_10_11_Circle2D circle){
		double temp0 = Math.abs(radius - circle.radius);
		double temp1 = radius + circle.radius;
		if(temp0*temp0 < (x-circle.x)*(x-circle.x)+(y-circle.y)*(y-circle.y)
				&&(x-circle.x)*(x-circle.x)+(y-circle.y)*(y-circle.y) < temp1*temp1)
			return true;
		else
			return false;
	}
}
