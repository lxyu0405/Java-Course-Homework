package _2Homework;
/**public class _6_20 {//二维数组方法，后来发现直接用一维数组就可以解决问题
//eight queens
	final static int numOfQueens = 8;

	public static void queen(int n,int[] array,int[][] chessBoard){
		if(n == numOfQueens){
			for(int a:array)
				printPane(a);
			System.out.println("=================");
		}
		else{
			for(int i = 0;i < numOfQueens;i++){
				if(isSafe(n,i,chessBoard)){
					occupy(n,i,chessBoard);
					array[n] = i;
					queen(n+1,array,chessBoard);
					chessBoard[n][i] = 0;
				}
			}
		}
		
	}
	public static void occupy(int x,int y,int[][] chessBoard){
		chessBoard[x][y] = 1;
	}
	public static boolean isSafe(int x,int y,int[][] chessBoard){
		for(int i = 0;i < 8;i++){
			if(chessBoard[x][i] == 1 || chessBoard[i][y] == 1)
				return false;;
			if((x - i >= 0)&&(y - i >= 0)&&chessBoard[x-i][y-i] == 1)
				return false;
			if((x - i >= 0)&&(y + i <= 7)&&chessBoard[x-i][y+i] == 1)
				return false;
			if((x + i <= 7)&&(y - i >= 0)&&chessBoard[x+i][y-i] == 1)
				return false;
			if((x + i <= 7)&&(y + i <= 7)&&chessBoard[x+i][y+i] == 1)
				return false;
		}
		return true;
	}
	public static void printFormer(int a){//print
		for(int i = 0;i < a;i++)
			System.out.print("| ");
	}
	public static void printLater(int a){
		for(int i = 0;i < a;i++)
			System.out.print(" |");
	}
	public static void printPane(int a){
		printFormer(a);
		System.out.print("|Q|");
		printLater(7-a);
		System.out.println();
	}
	public static void main(String[] args) {

		int[] array = new int[8];
		int[][] chessBoard = new int[8][8];
		
		for(int i = 0;i < numOfQueens;i++){
			for(int j = 0;j < numOfQueens;j++)
				chessBoard[i][j] = 0;
			array[i] = -1;
		}
		queen(0,array,chessBoard);
	}
}*/

 import java.lang.Math;
 public class _6_20_EightQueens {
  	final static int numOfQueens=8;
	public static void queen(int[] array,int m){
		if(m == numOfQueens){
			for(int i = 0;i < numOfQueens;i++){
				printPane(array[i]);
				System.out.println();
			}
			System.out.println("=================");
		}else{
			for(int i = 1;i <= numOfQueens;i++){
				array[m] = i;
				if(isSafe(array,m))
					queen(array,m+1);
			}
		}
	}
	public static void printFormer(int a){//print
		for(int i = 0;i < a;i++)
			System.out.print("| ");
	}
	public static void printLater(int a){
		for(int i = 0;i < a;i++)
			System.out.print(" |");
	}
	public static void printPane(int a){
		printFormer(a-1);
		System.out.print("|Q|");
		printLater(8-a);
	}
	
	public static boolean isSafe(int[] array,int x){
		for(int i = 0;i < x;i++)
			if(array[i] == array[x] || (x-i) == Math.abs(array[x]-array[i]))
				return false;
		return true;
	}
	public static void main(String[] args) {
		int[] array = new int[numOfQueens];
		queen(array,0);
	}
 }



