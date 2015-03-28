package codejam2013.pa;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 'X', 'O', '.', 'T'
 * 
 * 
 * int [][] array = new int [][] ;
 * 
 * final public static O = 0x1;  001
 * final public static X = 0x2;  010
 * final public static T = 0x3;  011
 * 
 * @author min
 *
 */
public class TicToeMain {
//	public enum CH {X, O, E, T};
	static String templet = "Case #%d: %s";
	static String FILE_NAME = "sample.in";
	public static void main(String[] args) {
		InputStream in = TicToeMain.class.getResourceAsStream(FILE_NAME);
		Scanner scanner = new Scanner(in);
//		int T = Integer.parseInt(scanner.nextLine());
		int T = scanner.nextInt();
		scanner.nextLine();
		
		char [][] array = null;
		
		for (int i = 0; i < T; i++) {
			// 1. 4줄을 읽어서 2차웡 char 배열을 만드는 과정
			array = makeArray(4, 4, scanner);
			scanner.nextLine(); // 빈줄 소비함.
			printArray(array, System.out);
			// 2. 2차원 배열을 메소드로 전달해서 결과를 출력한는 과정
			printWinner(array, System.out, (i+1));
			
		}
		
	}
	
	private static void printArray(char[][] array, PrintStream out) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---");
		
	}

	/**
	 * 각 줄에는 다음과 같이 들어있을겁니다.
	 * 1. 승자기 있으려면 아래와 같은 패턴이 있어야 하고
	 * [x... T] : x won
	 * [o... T] : o won
	 * [x.....] : x won
	 * [o.....] : o won
	 * 
	 * 2. 승자가 없다 
	 * 2.1 empty character가 있다.
	 * 2.2 empty character가 없다. - 비긴경우.
	 * @param array
	 * @param out
	 */
	static void printWinner ( char [][] array , PrintStream out, int number ) {
		
		int emptyLine = 0;
		int drawLine = 0;
		// 행벡터 - 1차원 배열
		for (int i = 0; i < array.length; i++) {
			char ch = checkAnswer(array[i]);
			if(ch == 'O') {
				String.format(templet, number, "O won");
				return;
			} else if(ch == 'X') {
				String.format(templet, number, "X won");
				return ;
			} else if(ch == 'D') {
				drawLine ++ ;
			} else if ( ch == 'E') {
				emptyLine ++ ;
			}
		}
		// 열벡터 - 1차원 배열
		
		// 대각성 
		/*
		 * 0
		 *  1
		 *   2
		 *    3
		 */
		for ( int i = 0 ; i < array.length ; i++) {
//			array[i][i] ;
		}
		
		// 대각선
		/*
		 *        0
		 *      1
		 *    2
		 *  3 
		 */
		for ( int ir = 0 ; ir < array.length ; ir++) {
			int ic = (array.length -1) - ir; // 0,3 : 1,2 : 2,1 : 3,0
			
		}
	}
	
	/**
	 * 'X', 'O', 'T', '.'
	 * @param arr
	 * @return 'X' or 'O' - 이긴 사람
	 *         'E' - 현재줄에 공백이 있음(안끝난 줄)
	 *         'D' - 이 줄은 승자가 없음.
	 */
	static char checkAnswer ( char [] arr ) {
		char ch = 'Q';
		int cntO = 0 , cntX = 0 , cntT = 0, cntE = 0 ;
		
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 'O':
				cntO ++ ;
				break;
			case 'X':
				cntX ++ ;
				break;
			case '.':
				cntE ++ ;
				break;
			case 'T':
				cntT ++ ;
				break;
			default:
				throw new RuntimeException("이건 뭐냐?");
			}
		}
		
		if ( cntX > 0 && cntO > 0 ) {
			return 'D';
		}
		// x또는 o 가 0 인 상태.
		
		if ( cntE > 0 ) {
			return 'E';
		}
		// 공백 없이 다 채워진 상태
		// [x...t] [o...t]
		if ( cntX > 0 ) {
			return 'X';
		} else if ( cntO > 0 ) {
			return 'O';
		} else {
			// 이쪽으로 오지 않아야 함.
			throw new RuntimeException("이건 또 뭐냐?");
		}
		
		
		
		// [x..t]
		/*if ( cntE == 0 ) {
			// X O T 로 다 차있음.
			if ( cntO == 0 ) {
				return 'X';
			} else if ( cntX == 0 ) {
				return 'O';
			} else {
				return 'D';
			}
		} else {
			// 빈공백이 있음.
			if ( cntX > 0 && cntO > 0 ) {
				// x와 o가 섞여있음.
				return 'D';
			} else {
				// 빈 공백이 있음.
				return 'E';
			}
		}*/
//		return 'a';
	}
	
	private static char[][] makeArray(int irow, int icol, Scanner scanner) {
		char[][] array = new char[4][4];
		for (int i = 0; i < irow; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < line.length(); j++) {
				array[i][j] = line.charAt(j);
			}
		}
		return array;
	}
	

}

