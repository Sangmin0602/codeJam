package codejam2013.pa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTTTMain {

	@Test
	public void test_checkAnswer() {
		char [] ach = new char[]{'T', 'X', 'X', 'X'};
		// 1. 한 명이 이긴경우 - 'X' or 'O'를 반환하도록함.
		// 2. 빈공백이 있을 경우 - 'E' 를 반환 {'.', 'X', 'X', 'O' }
		// 3. 빈공백이 없을 경우 - 'D' 를 반환 { O, X, X, O}
		
		char ch = TicToeMain.checkAnswer(new char[]{'T', 'X', 'X', 'X'});
		assertEquals ( 'X', ch);
		
		ch = TicToeMain.checkAnswer(new char[]{'O', 'X', '.', 'X'});
		assertEquals ( 'D', ch);
		
		ch = TicToeMain.checkAnswer(new char[]{'T', 'X', '.', 'X'});
		assertEquals ( 'E', ch);

		ch = TicToeMain.checkAnswer(new char[]{'X', 'T', 'T', 'T'});
		assertEquals ( 'X', ch);
		
		ch = TicToeMain.checkAnswer(new char[]{'O', 'O', 'O', 'O'});
		assertEquals ( 'O', ch);
		
	}

}
