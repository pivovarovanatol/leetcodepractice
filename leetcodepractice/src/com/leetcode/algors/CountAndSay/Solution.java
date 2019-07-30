package com.leetcode.algors.CountAndSay;

class Solution {
    public String countAndSay(int n) {
    	String str = "1";
    	
    	int count = 1;
    	n--;
    	while (count <= n) {
    		str = normalize(str);
    		count++;
    	}
    	
    	return str;
    }
    
    String normalize(String str ) {
    	
    	char[] arr = str.toCharArray();
    	int n= arr.length;
    	int index = 1;
    	char curr = arr[0];
    	int count = 1;
    	String result = "";
    	
    	if (str.equals("1")) {
    		return "11";
    	}
    	else {
        	while (index < n) {
        		if (arr[index]!=curr) {
        			result = result.concat(Integer.toString(count).concat(Character.toString(curr)));
        			curr= arr[index];
        			count=1;
        			index++;
        		} else {
        			count++;
        			index++;
        		}
        	}
        	result = result.concat(Integer.toString(count)).concat(Character.toString(curr));
        	return result;
    	}
    }
}

