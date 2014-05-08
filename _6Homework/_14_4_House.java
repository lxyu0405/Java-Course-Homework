package _6Homework;

//import java.lang.*;
public class _14_4_House implements Cloneable,Comparable<Object>{
	private int id;
	private double area;
	private java.util.Date whenBuilt;
	
	public _14_4_House(){}
	public _14_4_House(int id,double area){
		this.id = id;
		this.area = area;
		this.whenBuilt = new java.util.Date(System.currentTimeMillis());
	}
	public int getID(){
		return id;
	}
	public double getArea(){
		return area;
	}
	public java.util.Date getWhenBuilt(){
		return whenBuilt;
	}
	public Object clone() throws CloneNotSupportedException{
		Object o = super.clone();
		((_14_4_House)o).whenBuilt = (java.util.Date)whenBuilt.clone();
		return o;
	}
	public int compareTo(Object o){
		if(area > ((_14_4_House)o).getArea())
			return 1;
		else if(area < ((_14_4_House)o).getArea())
			return -1;
		else
			return 0;
	}
}
