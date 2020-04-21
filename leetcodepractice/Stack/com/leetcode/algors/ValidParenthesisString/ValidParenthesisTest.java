package com.leetcode.algors.ValidParenthesisString;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesisTest {

	@Test
	public void validParenthesisTest1() {
		String s = "(((******))"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void validParenthesisTest2() {
		String s = "()"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void validParenthesisTest3() {
		String s = "(*)"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void validParenthesisTest4() {
		String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*"; // false
		boolean actual = new Solution().checkValidString(s);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void validParenthesisTest5() {
		String s = "(*))"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}

	
	@Test
	public void validParenthesisTest6() {
		String s = "((*)(*))((*"; // false
		boolean actual = new Solution().checkValidString(s);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void validParenthesisTest7() {
		String s = "(*()"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void validParenthesisTest8() {
		String s = "((()))()(())(*()()())**(())()()()()((*()*))((*()*)"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void validParenthesisTest9() {
		String s = "(((()*())))((()(((()(()))()**(*)())))())()()*"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
		
	@Test
	public void validParenthesisTest10() {
		
		String s = "(()(())()())*((()(())))*()(*)()()(*((()((*(*))))()*()(()((()(*((()))*(((())(())))*))(()*))(()*)"; // true
		boolean actual = new Solution().checkValidString(s);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
		
					
	
}
