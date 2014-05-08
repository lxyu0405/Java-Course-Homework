package _6Homework;

import java.util.Date;

public class _14_9_ComparableMax {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static Object max(@SuppressWarnings("rawtypes") Comparable[] a){
		int max = 0;
		for(int i = 0;i < a.length;i++){
			if(a[i].compareTo(a[max]) > 0)
				max = i;
		}
		return a[max];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[] = {1,4,6,8,23,56,87};
		String s[] = {
				"Monday",
				"Tuesday",
				"Wednesday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"};
		Date date[] = new Date[2];
		date[0] = new Date(System.currentTimeMillis());
		date[1] = new Date(System.currentTimeMillis());
		Integer intMax = (Integer)max(a);
		String stringMax = (String)max(s);
		Date dateMax = (Date)max(date);
		
		System.out.println("\nmax int "+intMax
				+"\nmax string "+stringMax
				+"\nmax date "+dateMax);
	}

}
