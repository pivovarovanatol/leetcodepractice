package com.leetcode.algors.LastStoneWeight;
// https://leetcode.com/problems/last-stone-weight/

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
	
	Solution sl;
	
	public SolutionTest(){
		sl = new Solution();
	}
	
	@Test
	public void lastStoneWeightTestCase1(){
		// given
		int[] arr = {2,7,4,1,8,1}; 
		// when
		int result = sl.lastStoneWeight(arr);   // returns 1

		// then
		int expected = 1;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}


    
}
