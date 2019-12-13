package com.leetcode.algors.Triangle;
//https://leetcode.com/problems/triangle/

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void triangleCase1() {
		// Given
		List<Integer> l1 = new ArrayList<>() ;
		l1.add(2);
		
		List<Integer> l2 = new ArrayList<>() ;
		l2.add(3);
		l2.add(4);
		
		List<Integer> l3 = new ArrayList<>() ;
		l3.add(6);
		l3.add(5);
		l3.add(7);
		
		List<Integer> l4 = new ArrayList<>() ;
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		
		List<List<Integer>> l = new ArrayList<>() ;
		l.add(l1);
		l.add(l2);
		l.add(l3);
		l.add(l4);

		// When
		Solution sl = new Solution();
		int result = sl.minimumTotal(l);
		
		int expected = 11;
		
		// Then
		Assert.assertEquals(expected, result);
		//System.out.println(result);
	}
	
	

	
	
}
