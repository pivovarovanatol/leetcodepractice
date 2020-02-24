package com.leetcode.algors.GoogleCanTrransform;

import java.util.HashMap;

class Solution {
	
	public boolean canTransform(String source, String destination) {
		char[] sourceChar = source.toCharArray();
		char[] destinationChar = destination.toCharArray();
		int n = source.length();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i=0;i<n;i++) {
			if (sourceChar[i]!=destinationChar[i]) {
				if (map.containsKey(sourceChar[i]-'a')) {
					if (map.get(sourceChar[i]-'a') != destinationChar[i]-'a') return false;
				} else {
					map.put(sourceChar[i]-'a', destinationChar[i]-'a');
				}
			}
		}
		
		if (map.size()==26) 
			return false;
		else 
			return true;
	}
	
}