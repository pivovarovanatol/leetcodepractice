package com.leetcode.algors.KthLargestElementInStream;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInStreamTest {
	
	@Test
	public void KthLargestElement1(){
		// given
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
	
		// when
		int result = kthLargest.add(3);   // returns 4
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8


		// then
		int expected = 4;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void KthLargestElement2(){
		// given
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
	
		// when
		int result = kthLargest.add(5);   // returns 4

		// then
		int expected = 5;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void KthLargestElement3(){
		// given
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
	
		// when
		int result = kthLargest.add(10);   // returns 4

		// then
		int expected = 5;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

			
	@Test
	public void KthLargestElement4(){
		// given
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
	
		// when
		int result = kthLargest.add(9);   // returns 4

		// then
		int expected = 8;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

	@Test
	public void KthLargestElement5(){
		// given
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
	
		// when
		int result = kthLargest.add(4);   // returns 4

		// then
		int expected = 8;
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}

    
}
