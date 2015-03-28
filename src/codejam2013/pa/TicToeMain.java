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
			// 1. 4���� �о 2���� char �迭�� ����� ����
			array = makeArray(4, 4, scanner);
			scanner.nextLine(); // ���� �Һ���.
			printArray(array, System.out);
			// 2. 2���� �迭�� �޼ҵ�� �����ؼ� ����� ����Ѵ� ����
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
	 * �� �ٿ��� ������ ���� ��������̴ϴ�.
	 * 1. ���ڱ� �������� �Ʒ��� ���� ������ �־�� �ϰ�
	 * [x... T] : x won
	 * [o... T] : o won
	 * [x.....] : x won
	 * [o.....] : o won
	 * 
	 * 2. ���ڰ� ���� 
	 * 2.1 empty character�� �ִ�.
	 * 2.2 empty character�� ����. - �����.
	 * @param array
	 * @param out
	 */
	static void printWinner ( char [][] array , PrintStream out, int number ) {
		
		int emptyLine = 0;
		int drawLine = 0;
		// �຤�� - 1���� �迭
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
		// ������ - 1���� �迭
		
		// �밢�� 
		/*
		 * 0
		 *  1
		 *   2
		 *    3
		 */
		for ( int i = 0 ; i < array.length ; i++) {
//			array[i][i] ;
		}
		
		// �밢��
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
	 * @return 'X' or 'O' - �̱� ���
	 *         'E' - �����ٿ� ������ ����(�ȳ��� ��)
	 *         'D' - �� ���� ���ڰ� ����.
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
				throw new RuntimeException("�̰� ����?");
			}
		}
		
		if ( cntX > 0 && cntO > 0 ) {
			return 'D';
		}
		// x�Ǵ� o �� 0 �� ����.
		
		if ( cntE > 0 ) {
			return 'E';
		}
		// ���� ���� �� ä���� ����
		// [x...t] [o...t]
		if ( cntX > 0 ) {
			return 'X';
		} else if ( cntO > 0 ) {
			return 'O';
		} else {
			// �������� ���� �ʾƾ� ��.
			throw new RuntimeException("�̰� �� ����?");
		}
		
		
		
		// [x..t]
		/*if ( cntE == 0 ) {
			// X O T �� �� ������.
			if ( cntO == 0 ) {
				return 'X';
			} else if ( cntX == 0 ) {
				return 'O';
			} else {
				return 'D';
			}
		} else {
			// ������� ����.
			if ( cntX > 0 && cntO > 0 ) {
				// x�� o�� ��������.
				return 'D';
			} else {
				// �� ������ ����.
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

