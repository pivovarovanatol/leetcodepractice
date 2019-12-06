package com.leetcode.algors.KthLargestElementInStream;
// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInStreamTest {
	
	KthLargest kthLargest;
	
	public KthLargestElementInStreamTest(){
		int[] arr = {4,5,8,2};
		kthLargest = new KthLargest(3, arr);
	}
	
	@Test
	public void KthLargestElement1(){
		// given
		
		// when
		int result = kthLargest.add(3);   // returns 4

		// then
		int expected = 4;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void KthLargestElement2(){
		// given
		kthLargest.add(3);   // returns 4
		
		// when
		int result = kthLargest.add(5);   // returns 5

		// then
		int expected = 5;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void KthLargestElement3(){
		// given
		kthLargest.add(3);   // returns 4
		kthLargest.add(5);   // returns 5

		// when
		int result = kthLargest.add(10);   // returns 5

		// then
		int expected = 5;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

			
	@Test
	public void KthLargestElement4(){
		// given
		kthLargest.add(3);   // returns 4
		kthLargest.add(5);   // returns 5
		kthLargest.add(10);  // returns 5
		// when
		int result = kthLargest.add(9);   // returns 8

		// then
		int expected = 8;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void KthLargestElement5(){
		// given
		kthLargest.add(3);   // returns 4
		kthLargest.add(5);   // returns 5
		kthLargest.add(10);  // returns 5
		kthLargest.add(9);   // returns 8
		// when
		int result = kthLargest.add(4);   // returns 8

		// then
		int expected = 8;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

    
}
