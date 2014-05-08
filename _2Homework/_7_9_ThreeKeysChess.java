package _2Homework;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class _7_9_ThreeKeysChess {

	static int[][] chessBoard = new int[3][3];
	public static void initialization(){
		for(int i = 0;i < 3;i++)
			for(int j = 0;j < 3;j++)
				chessBoard[i][j] = -1;
	}
	public static boolean verifyRowCol(String a){
		Pattern pattern = Pattern.compile("^[1-3]$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static boolean putChessO(int[] a){
		if(chessBoard[a[0]-1][a[1]-1] == -1){
			chessBoard[a[0]-1][a[1]-1] = 2;
			return true;
		}
		else
			return false;
	} 
	public static boolean putChessX(int[] a){
		if(chessBoard[a[0]-1][a[1]-1] == -1){
			chessBoard[a[0]-1][a[1]-1] = 1;
			return true;
		}
		else
			return false;
	}
	public static boolean full(){
		for(int i = 0;i < 3;i++)
			for(int j = 0;j < 3;j++)
				if(chessBoard[i][j] == -1)
					return false;
		return true;
	}
	public static int victoryOrNot(){//-1,还未结束;0,平局;1,X获胜;2,O获胜
		for(int i = 0;i < 3;i++){
			if(chessBoard[i][0] == chessBoard[i][2] 
					&& chessBoard[i][2] == chessBoard[i][1]){
				if(chessBoard[i][1] == 1)
					return 1;
				else if(chessBoard[i][1] == 2)
					return 2;
			}
			else if(chessBoard[0][i] == chessBoard[1][i] 
					&& chessBoard[0][i] == chessBoard[2][i]){
				if(chessBoard[1][i] == 1)
					return 1;
				else if(chessBoard[1][i] == 2)
					return 2;
			}
			else if(chessBoard[0][0] == chessBoard[1][1] && chessBoard[0][0] == chessBoard[2][2]){
				if(chessBoard[1][1] == 1)
					return 1;
				else if(chessBoard[1][1] == 2)
					return 2;
			}
			else if(chessBoard[2][0] == chessBoard[1][1] && chessBoard[1][1] == chessBoard[0][2]){
				if(chessBoard[1][1] == 1)
					return 1;
				else if(chessBoard[1][1] == 2)
					return 2;
			}
		}
		if(full())
			return 0;
		else
			return -1;
	}
	public static void printChessBoard(){
		System.out.println("———————");
		for(int i = 0;i < 3;i++){
			System.out.print("|");
			for(int j = 0;j < 3;j++)
				if(chessBoard[i][j] == -1)
					System.out.print(" |");
				else if(chessBoard[i][j] == 1)
					System.out.print("X|");
				else if(chessBoard[i][j] == 2)
					System.out.print("O|");
			System.out.println();
			System.out.println("———————");
		}

	}

	static Scanner in = new Scanner(System.in);
	public static int[] playerO(){//游戏结束前，不断获得用户O输入
		int[] position = new int[2];	
		//OOOOOOOOOOOOOOOOOOOOOOOOOO
		System.out.print("Enter a row (1,2,or3) for player O: ");
		//Scanner in = new Scanner(System.in);
		String row2 = in.next();
		while(!verifyRowCol(row2)){
			System.out.println("Illegel input!Please input row again!");
			row2 = in.next();
		}
		position[0] = Integer.parseInt(row2);
		System.out.print("Enter a col (1,2,or3) for player O: ");
		String col2 = in.next();
		while(!verifyRowCol(col2)){
			System.out.println("Illegel input!Please input col again!");
			col2 = in.next();
		}
		position[1] = Integer.parseInt(col2);
		//in.close();
		return position;
	}
	public static int[] playerX(){//游戏结束前，不断获得用户X输入
		int[] position = new int[2];
		//XXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.print("Enter a row (1,2,or3) for player X: ");
		//Scanner in = new Scanner(System.in);
		String row1 = in.next();
		while(!verifyRowCol(row1)){
			System.out.println("Illegel input!Please input row again!");
			row1 = in.next();
		}
		position[0] = Integer.parseInt(row1);
		System.out.print("Enter a col (1,2,or3) for player X: ");
		String col1 = in.next();
		while(!verifyRowCol(col1)){
			System.out.println("Illegel input!Please input col again!");
			col1 = in.next();
		}
		position[1] = Integer.parseInt(col1);
		//in.close();
		return position;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		initialization();
		int end = -1;
		int[] playerXPut = new int[2];
		int[] playerOPut = new int[2];
		while(end == -1){
			printChessBoard();	
			playerXPut = playerX();
			while(!putChessX(playerXPut)){
				System.out.println("Unable to put on this point!");
				playerXPut = playerX();
			}
			if(victoryOrNot() != -1)
				break;
			printChessBoard();
			playerOPut = playerO();
			while(!putChessO(playerOPut)){
				System.out.println("Unable to put on this point!");
				playerOPut = playerO();
			}
			if(victoryOrNot() != -1)
				break;
			end = victoryOrNot();
		}
		printChessBoard();
		end = victoryOrNot();
		switch(end){
		case 0:System.out.println("Play Even");break;
		case 1:System.out.println("X Player Won");break;
		case 2:System.out.println("O Player Won");break;
		}
	}

}
