package _4Homework;

import java.io.*;
//import java.util.*;

public class _9_20_ReplaceOldString {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		if(args.length != 3){
			System.out.println(
					"Usage: java _9_20_ReplaceOldString file oldString newString");
			System.exit(0);
		}
		File file = new File(args[0]);
		if(!file.exists()){
			System.out.println("File "+args[0]+" does not exist");
			System.exit(0);
		}
		StringBuffer res = new StringBuffer();
		String temp = null;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while((temp = reader.readLine()) != null)
			res.append(temp + "\n");
		String txt = res.toString();
		txt = txt.replaceAll(args[1], args[2]);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(txt);
		writer.flush();
		writer.close();
		reader.close();
	}

}
