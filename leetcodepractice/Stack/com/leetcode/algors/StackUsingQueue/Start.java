package com.leetcode.algors.StackUsingQueue;
// https://leetcode.com/problems/happy-number/


public class Start {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
		
	}

}
