package com.leetcode.algors.ValidParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        
    	int n= s.length();
    	Stack<Character> st = new Stack<Character>();
    	char[] arr = s.toCharArray();
    	
    	for (int i=0;i<n;i++) {
    		
    		if (arr[i]!=' ') {
    			char symbol = arr[i];
    			if (symbol == '{' || symbol == '[' || symbol == '(') {
    				st.push(symbol);
    			} else {
    				
    				if(st.size()==0) {
    					return false;
    				}
    				
    				char symbol2 = st.pop();
    				if (symbol=='}' && symbol2 !='{') {
    					return false;
    				}
    				if (symbol==')' && symbol2 !='(') {
    					return false;
    				}
    				if (symbol==']' && symbol2 !='[') {
    					return false;
    				}
    			} 
    		}
    	}
    	
    	if (st.size() == 0) {
        	return true;
    	}
    	return false;
    }
}