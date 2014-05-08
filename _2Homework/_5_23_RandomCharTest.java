package _2Homework;

public class _5_23_RandomCharTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char printUpperCharacter = 'A';
		char printDigitCharacter = '3';
		for(int i = 1;i <= 100;i++){
			printUpperCharacter = _5_23_RandomCharacter.getRandomUpperCaseLetter();
			System.out.print(printUpperCharacter);
			if(i % 10 == 0)
				System.out.println();
		}
		for(int i = 1;i <= 100;i++){
			printDigitCharacter = _5_23_RandomCharacter.getRandomDigitCharacter();
			System.out.print(printDigitCharacter);
			if(i % 10 == 0)
				System.out.println();
		}
	}

}
