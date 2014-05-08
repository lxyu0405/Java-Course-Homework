package _7Homework;

import java.io.*;
public class _19_17_BitOutputStream {
	
	private FileOutputStream output;
	private byte[] buffer = new byte[8];
	private int count;
	
	public _19_17_BitOutputStream(){}
	public _19_17_BitOutputStream(File file){
		for(int i = 0;i < buffer.length;i++)
			buffer[i] = '0';
		count = 0;
		try{
			output = new FileOutputStream(file);
		}catch(FileNotFoundException ex){
			System.out.println("File Not Found");
		}
	}
	public void writeBit(char bit){
		try{
			buffer[count++] = (byte)bit;
			if(count == 7){
				count = 0;
				output.write(buffer);
			}
		}catch(IOException ex){
			System.out.println("IOException");
		}
	}
	public void writeBit(String bit){
		try{
			char[] temp = bit.toCharArray();
			for(int i = 0;i < temp.length;i++){
				buffer[count++] = (byte)temp[i];
				if(count == 7){
					count = 0;
					output.write(buffer);
					//output.write('/');
				}
			}
		}catch(IOException ex){
			System.out.println("IOException");
		}
	}
	public void close(){
		try{
			while(count < 7){
				output.write('0');
				count++;
			}
			output.close();
		}catch(IOException ex){
			System.out.println("IOException");
		}
	}
}
