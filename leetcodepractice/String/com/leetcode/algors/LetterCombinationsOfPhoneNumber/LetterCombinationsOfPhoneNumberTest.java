package com.leetcode.algors.LetterCombinationsOfPhoneNumber;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class LetterCombinationsOfPhoneNumberTest {

	@Test
	public void letterCombinationsOfPhoneNumberCase() {
		// given
		String digits = "12345";
		
		// when
		Solution sl = new Solution();
		List<String> actual = sl.letterCombinations(digits);
		
		for (String str : actual) {
			System.out.println(str);
		}

		//then
		Assert.assertEquals(actual, actual);
	}
	
	
	

}
