package _3Homework;

public class _10_11_Circle2DTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_10_11_Circle2D c1 = new _10_11_Circle2D(2,2,5.5);
		System.out.println("Area: "+ c1.getArea()+",Perimeter: "+c1.getPerimeter());
		System.out.println(c1.contains(3, 3));
		System.out.println(c1.contains(new _10_11_Circle2D(4,5,10.5)));
		System.out.println(c1.overlaps(new _10_11_Circle2D(3,5,2.3)));
	}

}
