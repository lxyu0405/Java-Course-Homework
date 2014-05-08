package _7Homework;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class additional_AddressItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String street;
	String city;
	String state;
	String zip;
	public additional_AddressItem(){}
	public additional_AddressItem(String name,String street,String city,String state,String zip){
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public static boolean verifyZip(String a){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public void setName(String name){
		this.name = name;
	}
	public void setStreet(String street){
		this.street = street;
	}
	public void setCity(String city){
		this.city = city;
	}
	public void setState(String state){
		this.state = state;
	}
	public void setZip(String zip)throws Exception{
		if(verifyZip(zip))
			this.zip = zip;
		else
			throw new Exception("Illegal Format!");
	}
}
