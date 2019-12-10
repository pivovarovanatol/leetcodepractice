package com.leetcode.algors.GroupAnagrams;
// https://leetcode.com/problems/group-anagrams/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		
		String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Solution sl = new Solution();
		List<List<String>> result = sl.groupAnagrams2(arr);
		System.out.println(result);
	}

}
