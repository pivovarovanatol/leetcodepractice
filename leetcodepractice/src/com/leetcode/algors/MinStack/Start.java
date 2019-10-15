package com.leetcode.algors.MinStack;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sl = new Solution();
		MinStack minStack = new MinStack();
		
		/*
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		*/
		
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   
		minStack.pop();
		System.out.println(minStack.top());      
		System.out.println(minStack.getMin());   
		
		
		
	}

}
