package com.leetcode.algors.GeneralHeapImplementation;

import org.junit.Assert;
import org.junit.Test;
import com.leetcode.algors.GeneralHeapImplementation.Heap;

public class HeapTest {
	
	@Test
	public void HeapTest1(){
		// given
		int[] arr = {4,5,8,2,33,56,19,7,23,99,13,65,7876};
		Heap heap = new Heap();
	
		// when
		for (int k : arr) {
			heap.addElement(k);
		}

		// then
		int expected = 2;
		int result = heap.peek();
		Assert.assertEquals(expected, result);
	}


	
}
