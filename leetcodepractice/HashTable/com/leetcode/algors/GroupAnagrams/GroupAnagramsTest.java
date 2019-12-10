package com.leetcode.algors.GroupAnagrams;
//https://leetcode.com/problems/group-anagrams/


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GroupAnagramsTest {

	@Test
	public void groupAnagramsCase1() {
		// given
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		// when
		List<List<String>> expected = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		
		list1.add("eat");
		list1.add("tea");
		list1.add("ate");
		expected.add(list1);
		
		List<String> list2 = new ArrayList<>();
		list2.add("bat");
		expected.add(list2);

		List<String> list3 = new ArrayList<>();
		list3.clear();
		list3.add("tan");
		list3.add("nat");
		expected.add(list3);

		List<List<String>> result = new Solution().groupAnagrams(input);
		
		// then
		Assert.assertEquals(expected, result);
		
	}
	
	
}
