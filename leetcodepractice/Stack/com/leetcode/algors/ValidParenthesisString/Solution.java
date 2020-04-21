package com.leetcode.algors.ValidParenthesisString;
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/

import java.util.Stack;

class Solution {
	// from discussions: Same logic, but extra check for position of the asterisc. If before opening bracket -> means there is a opening parenthesis with no closing 'star' -> false. 0ms(<100%)
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> ast = new Stack();
        char[] chars = new char[s.length()];
        chars= s.toCharArray();
        for(int i=0; i< chars.length; i++){
            switch(chars[i]){
                case '(':
                    stack.push(i);
                    break;
                case '*':
                    ast.push(i);
                    break;
                case ')':
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else if(!ast.isEmpty()){
                        ast.pop();
                    }
                    else{
                        return false;
                    }
            }
        }
        while(!stack.isEmpty() && !ast.isEmpty()){
            if(stack.pop()>ast.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}