package codejam2013.pa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTTTMain {

	@Test
	public void test_checkAnswer() {
		char [] ach = new char[]{'T', 'X', 'X', 'X'};
		// 1. �� ���� �̱��� - 'X' or 'O'�� ��ȯ�ϵ�����.
		// 2. ������� ���� ��� - 'E' �� ��ȯ {'.', 'X', 'X', 'O' }
		// 3. ������� ���� ��� - 'D' �� ��ȯ { O, X, X, O}
		
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
