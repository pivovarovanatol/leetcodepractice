package com.leetcode.algors.LongestCommonPrefix;

class Solution {

	public String longestCommonPrefix(String[] arr) {
		int index = findShortestString(arr) - 1;
		int n = arr.length;
		String prefix="";
		if (n==0) {
			return "";
		}
		
		int low=0, high=index;
		while (low <= high) { 
            int mid = low + (high - low) / 2; 
  
            if (containsAll(arr, n, arr[0], low, mid)) 
            { 
                prefix = prefix + arr[0].substring(low, mid+1); 
                low = mid + 1; 
            }  
            else 
            { 
                high = mid - 1; 
            } 
        } 
		
		
		return prefix;
    }

	private int findShortestString(String[] arr) {
		int n = arr.length;
		int len = Integer.MAX_VALUE;
		for (int i=0;i<n;i++) {
			if (arr[i].length() < len) {
				len =arr[i].length();
			}
		}
		return len;
	}

	private boolean containsAll(String arr[], int n, String str, int start, int end) {
		
		for (int i=0;i<n;i++) {
			String arr_i = arr[i];
			
			for (int j=start;j<=end;j++) {
				if (arr_i.charAt(j) != str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

}