package codeJam2014.pa;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicTrickMain {
	static String INPUT_PATH = "A-small-practice.in";
	static String templet = "Case #%d: %s";
	public static void main(String[] args) {
		
		InputStream in = MagicTrickMain.class.getResourceAsStream(INPUT_PATH);
		Scanner scanner = new Scanner(in);
		
		int T = scanner.nextInt();
//		System.out.println(T);
		
		int firstRow, secondRow ;
		int [][] firstArray, secondArray ;
		List<Integer> mathced = null;
		for ( int i = 0 ; i < T ; i++) {
			firstRow = scanner.nextInt(); // 2
			firstArray = makeArray(4, 4, scanner );
//			printArray("FIRST", firstArray);
			secondRow = scanner.nextInt(); // 3
			secondArray = makeArray(4, 4, scanner);
//			printArray("SECOND", secondArray);
			mathced = countMatchedInt(firstArray[firstRow-1], secondArray[secondRow-1]);
			printAnswer(mathced, i+1, System.out);
		}
		scanner.close();

	}
	
	/**
	 * list 안의 숫자가 하나이면 그 숫자를 출력해줍니다.
	 * 숫자가 둘 이상이면 Bad magician!,
	 * 일치하는 숫자가 없으면 Volunteer cheated!
	 * 
	 * 를 출력합니다.
	 * 
	 * @param matched
	 */
	static void printAnswer(List<Integer> matched, 
			int tcNumber, 
			PrintStream out) {
		
		String result = null;
		if (matched.size() == 1) {
			result = String.format(templet, tcNumber, "" + matched.get(0));
		} else if(matched.size() >= 2) {
			result = String.format(templet, tcNumber, "Bad magician!");
		} else {
			result = String.format(templet, tcNumber, "Volunteer cheated!");			
		}
		out.println(result);
	}

	/**
	 * 두 배열안에 일치하는 숫자들을 담아서 반환합니다.
	 * 
	 * @param array0
	 * @param array1
	 */
	static List<Integer> countMatchedInt( int [] a0, int [] a1) {
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		// a0 = [ 2, 5, 12, 3], a1 = [ 5, 10, 2, 12]
		for (int i = 0; i < a0.length; i++) {
			for (int j = 0; j < a1.length; j++) {
				if(a0[i] == a1[j]) {
					list.add(a0[i]);
					count++;
				}
			}
		}
		return list;
		
	}
	
	private static void printArray(String string, int[][] firstArray) {
		for (int i = 0; i < firstArray.length; i++) {
			for (int j = 0; j < firstArray.length; j++) {
				System.out.print(firstArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int [][] makeArray(int row, int col, Scanner scanner) {
		int [][] arr = new int[row][col];
		for ( int ir = 0 ; ir < row ; ir ++ ) {
			for( int ic = 0 ; ic < col ; ic ++ ) {
				arr[ir][ic] = scanner.nextInt();
			}
		}
		return arr;
	}

}
