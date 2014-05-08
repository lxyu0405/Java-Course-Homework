package _7Homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class additional_AddressBookActivator {

	/**
	 * @param args
	 */
	
	//public static AddressItem[] items = new AddressItem[30];
	public static int itemCount = 0;
	public static int pointer = -1;
	public static ObjectOutputStream output;
	public static ObjectInputStream input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			output = new ObjectOutputStream(new FileOutputStream("address.txt"));
			input = new ObjectInputStream(new FileInputStream("address.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unused")
		additional_AddressBookFrame tempFrame = new additional_AddressBookFrame();
	}
}
