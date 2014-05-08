package _7Homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class addtional_WriteObjectTst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		additional_AddressItem item1 = new additional_AddressItem("Joy","Queen Road","New York","no idea","1");
		additional_AddressItem item2 = new additional_AddressItem("Joy","Queen Road","New York","no idea","2");
		additional_AddressItem item3 = new additional_AddressItem("Joy","Queen Road","New York","no idea","3");
		additional_AddressItem item4 = new additional_AddressItem("Joy","Queen Road","New York","no idea","4");
		additional_AddressItem item5 = new additional_AddressItem("Joy","Queen Road","New York","no idea","5");
		additional_AddressItem item6 = new additional_AddressItem("Joy","Queen Road","New York","no idea","6");
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("address.txt"));
			
			output.writeObject(item1);
			output.writeObject(item2);
			output.writeObject(item3);
			output.writeObject(item4);
			output.writeObject(item5);
			output.writeObject(item6);
			output.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ObjectInputStream input;
		try {
			input = new ObjectInputStream(new FileInputStream("address.txt"));
			
			additional_AddressItem itemBack1 = (additional_AddressItem)input.readObject();
			additional_AddressItem itemBack2 = (additional_AddressItem)input.readObject();
			additional_AddressItem itemBack3 = (additional_AddressItem)input.readObject();
			additional_AddressItem itemBack4 = (additional_AddressItem)input.readObject();
			additional_AddressItem itemBack5 = (additional_AddressItem)input.readObject();
			System.out.println(itemBack1.zip);
			System.out.println(itemBack2.zip);
			System.out.println(itemBack3.zip);
			System.out.println(itemBack4.zip);
			System.out.println(itemBack5.zip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		
	}

}
