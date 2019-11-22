package com.leetcode.algors.MinStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class MinStack {

	private Deque<Integer> stack;
	int min; // = Integer.MAX_VALUE;;
	
	/** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<Integer>(); 
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
    	stack.push(x);
    	if (x < min) {
    		min = x;
    	}
    }
    
    public void pop() {
        if (min == stack.pop()) {
        	min = Integer.MAX_VALUE;
        	for (int t : stack) {
        		if (t < min) {
        			this.min = t;
        		}
        	}
        }
    }
    
    public int top() {
        return stack.peek();

    }
    
    public int getMin() {
        return min;
    }
}