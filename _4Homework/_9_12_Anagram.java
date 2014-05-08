package _4Homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _9_12_Anagram {

	/**
	 * @param args
	 */
	public static boolean verifyWord(String a){
		Pattern pattern = Pattern.compile("[a-z]+");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static boolean isContain(char[] array,char c){
		for(int i = 0;i < array.length;i++)
			if(c == array[i])
				return true;
		return false;
	}
	public static boolean isAnagram(String s1,String s2){
		char[] s1Elements = s1.toCharArray();
		char[] s2Elements = s2.toCharArray();
		if(s1Elements.length != s2Elements.length)
			return false;
		else{
			for(int i = 0;i < s1Elements.length ;i++){
				if(!isContain(s1Elements,s2Elements[i]) || 
						!isContain(s2Elements,s1Elements[i]))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("input two words,confirm each word with 'enter' key");
		System.out.print("word1: ");
		String word1 = scan.nextLine();
		System.out.print("word2: ");
		String word2 = scan.nextLine();
		if(!verifyWord(word1)||!verifyWord(word2))
			System.out.println("Not words format");
		if(isAnagram(word1,word2))
			System.out.println("Anagram");
		else
			System.out.println("Not anagram");
		scan.close();
	}

}
