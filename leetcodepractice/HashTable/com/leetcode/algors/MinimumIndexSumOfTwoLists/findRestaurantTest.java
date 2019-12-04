package com.leetcode.algors.MinimumIndexSumOfTwoLists;
// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class findRestaurantTest {

	@Test
	public void findRestaurantCase1() {
		// Case 1
		//System.out.println("Test Case #1");
		// given
    	String[] arr1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    	String[] arr2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		Solution sl = new Solution();
		
		// when
        String[] result = sl.findRestaurant(arr1, arr2); 
		String[] target = {"Shogun"};
        		
		// then
        //System.out.print(result);
		Arrays.sort(result);
		Arrays.sort(target);
		
		Assert.assertArrayEquals(target, result);
	}

	@Test
	public void findRestaurantCase2() {
		// Case 1
		//System.out.println("Test Case #1");
		// given
    	String[] arr1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    	String[] arr2 = {"KFC", "Shogun", "Burger King"};
		Solution sl = new Solution();
		
		// when
        String[] result = sl.findRestaurant(arr1, arr2); 
		String[] target = {"Shogun"};
        		
		// then
        //System.out.print(result);
		Arrays.sort(result);
		Arrays.sort(target);
		
		Assert.assertArrayEquals(target, result);
	}


	
}
