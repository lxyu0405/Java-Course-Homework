package _9Homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _29_9ShowConcurrentModificationException {

	private static Set<Integer> test = new HashSet<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable(){
			@Override
			public void run() {
				try{
					int i = 0;
					for(;i < 100;i++){
						Thread.sleep(1000);
						test.add(i);
						System.out.println("Thread 1 is running...");
					}
				}catch(InterruptedException e1){
					e1.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try{
					while(true){
						Thread.sleep(1000);
						Iterator<Integer> temp = test.iterator();
						while(temp.hasNext()){
							int hello = (Integer)temp.next();
							System.out.println(hello);
						}
						System.out.println("Thread 2 is running...");
					}
				}catch(InterruptedException e2){
					e2.printStackTrace();
				}
			}
		}).start();
	}
}
