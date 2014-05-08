package _8Homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class _22_9TextWords {


	public static void main(String[] args){
		// TODO Auto-generated method stub
		if(args[0] == null || args[0] == ""){
			System.out.println("请输入有效的文件路径名:");
			System.exit(-1);
		}
		Map<String,Integer> words = new TreeMap<String,Integer>();
		//C:\\Users\\Xiaoyu.lu\\Desktop\\TextTest.txt
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
				String[] tempWords = readLine.toLowerCase().split("[\\s+|,|;|.|:|=|?|(|)|{|}|'|\"|\t|\n]");
				for(String a:tempWords){
					//System.out.println(a);
					if(a.length() > 0){
						if(!words.containsKey(a))
							words.put(a, 1);
						else
							words.put(a, words.get(a)+1);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Reader Exception");
			e.printStackTrace();
		}
		System.out.println(words);
	}
} 
