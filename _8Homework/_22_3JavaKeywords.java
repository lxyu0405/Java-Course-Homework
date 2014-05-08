package _8Homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class _22_3JavaKeywords {


	public static void main(String[] args){
		// TODO Auto-generated method stub
		if(args[0] == null || args[0] == ""){
			System.out.println("请输入有效的文件路径名:");
			System.exit(-1);
		}
		ArrayList<String> keywords = new ArrayList<String>();
		//C:\Users\Xiaoyu.lu\Desktop\SetTest.java
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found Exception");
			e.printStackTrace();
		}
		String readLine = null;
		try {
			while((readLine = reader.readLine()) != null){
				String[] tempWords = readLine.split("[ ,;.(){}=?\"\t]");
				for(String a:tempWords){
					if(a.length() > 1)
						keywords.add(a);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Reader Exception");
			e.printStackTrace();
		}
		int nullint = 0;
		int trueint = 0;
		int falseint = 0;
		for(String a:keywords){
			System.out.println(a);
			if(a.equals("null"))
				nullint++;
			else if(a.equals("true"))
				trueint++;
			else if(a.equals("false"))
				falseint++;
		}
		System.out.println("null: "+nullint);
		System.out.println("true: "+trueint);
		System.out.println("false: "+falseint);
	}
}
