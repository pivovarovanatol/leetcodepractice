package com.leetcode.algors.MinStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class MinStack {

	private Stack<Integer> stack;
	private List<Integer> sorted;
	//private int min;

	
    /** initialize your data structure here. */
    public MinStack() {
        Stack<Integer> s = new Stack<Integer>();
        List<Integer> sr = new ArrayList<Integer>();
        stack = s;
        sorted = sr;
    }
    
    public void push(int x) {
    	stack.push(x);
    	sorted.add(x);
    }
    
    public void pop() {
        int tmp = stack.pop();
        sorted.remove((Object) tmp);
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        Collections.sort(sorted);
        return sorted.get(0);
    }
}