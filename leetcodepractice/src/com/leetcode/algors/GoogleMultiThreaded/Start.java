package com.leetcode.algors.GoogleMultiThreaded;

import java.util.Stack;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int n = 5;
		
		System.out.println("=========================== Started: ");
		long startTime = System.currentTimeMillis();
		Stack<Thread> stack = new Stack<>(); 
		Solution sl = new Solution();
		
		for (int i=0;i<n;i++) {
			Thread t = new Thread(sl);
			stack.push(t);
			t.start();
		}
		
		while (!stack.isEmpty()) {
			stack.pop().join();
		}

		long finishTime = System.currentTimeMillis();
		System.out.println("=========================== Finished in " + (finishTime - startTime) + "ms");
		
	}
}
