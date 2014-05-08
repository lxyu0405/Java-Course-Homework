package _2Homework;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class _7_20_FailingDownChess {

	static char[][] chessBoard = new char[7][7];
	static int[] array = new int[7];
	public static void initialization(){
		for(int i = 0;i < 7;i++){
			for(int j = 0;j < 7;j++)
				chessBoard[i][j] = ' ';
			array[i] = 0;
		}
	}
	public static boolean verifyRowCol(String a){
		Pattern pattern = Pattern.compile("^[0-6]$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static void putChessRed(int a){
		array[a]++;
		chessBoard[7-array[a]][a] = 'R';
	} 
	public static void putChessYellow(int a){
		array[a]++;
		chessBoard[7-array[a]][a] = 'Y';
	}
	public static boolean full(){
		for(int i = 0;i < 7;i++)
			for(int j = 0;j < 7;j++)
				if(chessBoard[i][j] == ' ')
					return false;
		return true;
	}
	public static int victoryOrNot(){//-1,继续;0,平局;1,Red获胜;2,Yellow获胜
		for(int i = 0;i < 7;i++)
			for(int j = 0;j < 7;j++){
				if((j + 3 < 7)&&chessBoard[i][j] == chessBoard[i][j+1]&&
						chessBoard[i][j+1] == chessBoard[i][j+2]&&
						chessBoard[i][2] == chessBoard[i][j+3]){
					if(chessBoard[i][j] == 'R')
						return 1;
					else if(chessBoard[i][j] == 'Y')
						return 2;
				}
				else if((i + 3 < 7)&&chessBoard[i][j] == chessBoard[i+1][j]&&
						chessBoard[i+1][j] == chessBoard[i+2][j]&&
						chessBoard[i+2][j] == chessBoard[i+3][j]){
					if(chessBoard[i][j] == 'R')
						return 1;
					else if(chessBoard[i][j] == 'Y')
						return 2;
				}
				else if((i + 3 < 7)&&(j + 3 < 7)&&chessBoard[i][j] == chessBoard[i+1][j+1]&&
						chessBoard[i+1][j+1] == chessBoard[i+2][j+2]&&
						chessBoard[i+2][j+2] == chessBoard[i+3][j+3]){
					if(chessBoard[i][j] == 'R')
						return 1;
					else if(chessBoard[i][j] == 'Y')
						return 2;
				}
				else if((i - 3 < 7)&&(j + 3 < 7)&&chessBoard[i][j] == chessBoard[i-1][j+1]&&
						chessBoard[i-1][j+1] == chessBoard[i-2][j+2]&&
						chessBoard[i-2][j+2] == chessBoard[i-3][j+3]){
					if(chessBoard[i][j] == 'R')
						return 1;
					else if(chessBoard[i][j] == 'Y')
						return 2;
				}
			}
		if(full())
			return 0;
		else
			return -1;
	}
	public static void printChessBoard(){
		for(int i = 0;i < 7;i++){
			System.out.print("|");
			for(int j = 0;j < 7;j++)
				System.out.print(chessBoard[i][j]+"|");
			System.out.println();
		}
	}

	static Scanner in = new Scanner(System.in);
	public static int playerRed(){//游戏结束前，不断获得用户Red输入
		int position = 0;	
		System.out.print("Drop a red disk at column (0-6): ");
		//Scanner in = new Scanner(System.in);
		String colRed = in.next();
		while(!verifyRowCol(colRed)){
			System.out.println("Illegel input!Please input col again!");
			colRed = in.next();
		}
		position = Integer.parseInt(colRed);
		//in.close();
		return position;
	}
	public static int playerYellow(){//游戏结束前，不断获得用户Yellow输入
		int position = 0;
		//XXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.print("Drop a Yellow disk at column (0-6): ");
		//Scanner in = new Scanner(System.in);
		String colYellow = in.next();
		while(!verifyRowCol(colYellow)){
			System.out.println("Illegel input!Please input col again!");
			colYellow = in.next();
		}
		position = Integer.parseInt(colYellow);
		//in.close();
		return position;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		initialization();
		int playerRedPut = 0;
		int playerYellowPut = 0;
		while(true){
			printChessBoard();	
			playerRedPut = playerRed();
			putChessRed(playerRedPut);
			if(victoryOrNot() != -1)
				break;
			printChessBoard();
			playerYellowPut = playerYellow();
			putChessYellow(playerYellowPut);
			if(victoryOrNot() != -1)
				break;
		}
		printChessBoard();
		switch(victoryOrNot()){
		case 0:System.out.println("Play Even");break;
		case 1:System.out.println("Red Player Won");break;
		case 2:System.out.println("Yellow Player Won");break;
		}
	}
}
