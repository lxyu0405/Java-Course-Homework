package _4Homework;

import java.util.Scanner;

public class _9_31_GuessWord {

	final static String[] words = {
		"endurance",
		"embroidery",
		"censor",
		"barometer",
		"wander",
		"venture",
		"singular",
		"remark",
		"mutter",
		"nasty"};
	static int count = 0;
	public static boolean isContain(char[] array,char c){
		for(int i = 0;i < array.length;i++)
			if(c == array[i])
				return true;
		return false;
	}
	
	public static String randomWords(){
		int index = (int)(Math.random()*10);
		return words[index];
	}
	
	public static char[] guessCharacter(char[] src,char[] word,char a){
		if(!isContain(src,a)){
			count++;
			System.out.println(a + " is not in the word ");
		}
		else if(isContain(word,a))
			System.out.println(a + " is already in the word");
		else
			for(int i = 0;i < word.length;i++)
				if(src[i] == a)
					word[i] = a;
		return word;
	}
	
	public static void printWord(char[] word){
		for(int i = 0;i < word.length;i++)
			System.out.print(word[i]);
		System.out.print(" > ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		char choose = 'y';
		while(choose == 'y'){
			String wordGuess = randomWords();
			char[] elements = wordGuess.toCharArray();
			char[] tempElements = new char[elements.length];
			for(int i = 0;i < tempElements.length;i++)
				tempElements[i] = '*';
			while(isContain(tempElements,'*')){
				System.out.print("(Guess) Enter a letter in word ");
				printWord(tempElements);
				char guessChar = scan.next().charAt(0);
				guessCharacter(elements,tempElements,guessChar);
			}
			System.out.println("The word is "+wordGuess+". You missed "+count+" time");
			System.out.println();
			System.out.print("Do you want to guess for another word?" +
					"Enter y or n>");
			choose = scan.next().charAt(0);
			//System.out.print(choose);
		}
		scan.close();
	}

}
