package com.leetcode.algors.NextGreaterNodeInLinkedList;
// https://leetcode.com/problems/next-greater-node-in-linked-list/

import java.util.ArrayList;
import java.util.Stack;

class Solution {

    public int[] nextLargerNodes(ListNode head) {
        // Solution with 2 stacks -> one for values and another for indexes. Need to rewrite from the beginning to remember. 28ms(<65%)  
        ArrayList<Integer> nums = new ArrayList<>();
        
        // create an ArrayList with all elements
        while (head != null){
            nums.add(head.val);
            head = head.next;
        }

        int[] result = new int[nums.size()];

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        stack.push(nums.get(0));
        indexStack.push(0);
        int index = 0;
        int element = -1;
        
        for (int i = 1; i<nums.size();i++){
            int next =  nums.get(i);
            if (!stack.isEmpty()){
                // stack is not empty -> pop element form a stack
                element = stack.pop();
                index = indexStack.pop();
                //System.out.println("Element: " + element + " Next: " + next);
                
                while(element < next){
                    //System.out.println("For the element: " + element + " next greater is: " + next);
                    result[index] = next;
                    if (stack.isEmpty()) break;
                    element = stack.pop();
                    index = indexStack.pop();
                }
                
                if (element >= next){
                    stack.push(element);
                    indexStack.push(index);
                }
            }
            stack.push(next);
            indexStack.push(i);
        }
        
        while (!stack.isEmpty()){
            stack.pop();
            index = indexStack.pop();
            result[index]=0;
        }
        
        return result;
    }
    
    
    public int[] nextLargerNodes2(ListNode head) {
        // brute force with ArrayList. N^2 time complexity.
        ArrayList<Integer> nums = new ArrayList<>();
        
        // create an ArrayList with all elements
        while (head != null){
            nums.add(head.val);
            head = head.next;
        }
        int[] result = new int[nums.size()];
        // traverse and get bigger element
        for (int i=0;i<nums.size()-1;i++){
            int nextLarger = 0;
            for (int j=i+1;j<nums.size();j++){
                if (nums.get(i)<nums.get(j)){
                    nextLarger = nums.get(j);
                    break;
                }
            }
            result[i] = nextLarger;
        }
        
        return result;
    }
}
