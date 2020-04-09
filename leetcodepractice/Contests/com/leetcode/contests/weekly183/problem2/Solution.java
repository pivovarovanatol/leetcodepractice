package com.leetcode.contests.weekly183.problem2;

import java.util.Stack;

class Solution {
    public int numSteps(String s) {
        int steps = 0;
        
        //long n = Long.parseLong(s, 2);
        
        while (s.length() > 1) {
        	if (s.charAt(s.length()-1) == '0') s = s.substring(0, s.length()-1);
        	else s = increment(s);
        	steps++;
        }
     
        return steps;
    }

    String increment(String str) {
    	Stack<Character> st = new Stack<Character>();
    	String res = "";
    	StringBuilder sb = new StringBuilder();
    	int carry = 1;
    	
    	for (int i=str.length()-1;i>=0;i--) {
    		if (str.charAt(i)=='0') {
    			if (carry==0) {
        			st.push('0');
    			} else {
    				st.push('1');
    				carry=0;
    			}
    			
    		} else {
    			if (carry==0) {
        			st.push('1');
    			} else {
    				st.push('0');
    				carry=1;
    			}
    		}
    	}
    	if (carry==1) st.push('1');
    	
    	while (st.size()>0) {
    		sb.append(st.pop());
    	}
    	return sb.toString();
    }


}