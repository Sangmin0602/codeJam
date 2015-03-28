package codeJam2014.pa;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestArrayCompare {

	@Test
	public void test() {
		// 1. 일치하는 숫자가 1개인 경우.
		int [] a0 = {2, 13, 1, 4};
		int [] a1 = {10, 12, 5, 2};
		List<Integer> matched = MagicTrickMain.countMatchedInt(a0, a1) ;
		
		assertEquals ( 1, matched.size());
		assertEquals ( 2, matched.get(0).intValue());
		
		// 2. 일치하는 숫자가 없는 경우
		int[] a3 = {1,2,3,4};
		int[] a4 = {5,6,7,8};
		
		List<Integer> misMatched = MagicTrickMain.countMatchedInt(a3, a4);
		
		assertEquals(0, misMatched.size());
		
		
	}
	
	@Test
	public void test_output () throws IOException {
		FileOutputStream fs = new FileOutputStream("o.out");
		MagicTrickMain.printAnswer(new ArrayList<>(), 1, new PrintStream(fs));
		fs.close();
		
		
	}

}
