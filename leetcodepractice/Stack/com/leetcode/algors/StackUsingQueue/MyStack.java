package com.leetcode.algors.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    
    Queue<Integer> stack;
    int tail;
    
        
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        tail++;
        stack.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i=1;i<tail;i++){
            stack.add(stack.remove());
        }
        tail--;
        return stack.remove();
    }
    
    /** Get the top element. */
    public int top() {
        for (int i=1;i<tail;i++){
            stack.add(stack.remove());
        }
        int tmp = stack.remove();
        stack.add(tmp);
        return tmp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */