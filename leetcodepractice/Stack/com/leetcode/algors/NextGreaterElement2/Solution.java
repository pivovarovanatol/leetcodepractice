package com.leetcode.algors.NextGreaterElement2;
// https://leetcode.com/problems/next-greater-element-ii/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	// solved with two stacks. 12ms(<90%) 50MB(<7%)
    public int[] nextGreaterElements(int[] nums) {
        // solution with two stacks
        int n = nums.length;
        int[] res = new int[n];
        if (n==0){
            return res;
        }
        Deque<Integer> stackVals = new ArrayDeque<>();
        Deque<Integer> stackPositions = new ArrayDeque<>();
        // if decreasing order sequence and then big number, e.g. 5->4->3->2->8, then for every number in the sequence the 8 is going to be a next greater element. 
        // if increasing sequence, e.g. 1->2->3->4->5, just need to check if prevVal<currVal, if yes - then add the curVal to the index of rev.
        // mixed: 7->9->5->3->4->8
        // looping the search: 
        
        // filling first part of the array before the split.
        int index=0;
        
        for (int i=0;i<n;i++) {
            while (!stackVals.isEmpty() && nums[i] > stackVals.peek()){
                index = stackPositions.pop();
                stackVals.pop();
                res[index]=nums[i];
            }    
            stackVals.push(nums[i]);
            stackPositions.push(i);
        }
        
        int curIndex = 0;
        int curVal = 0;
        int nextBig = Integer.MIN_VALUE;
        while (!stackPositions.isEmpty()){
            curIndex = stackPositions.pop();
            curVal = stackVals.pop();
            //System.out.println("Running second part for " + curIndex + " " + curVal);
            int i = curIndex;
            if (nextBig > curVal){
                res[curIndex]= nextBig;
            } else {
                while (i < curIndex + n){
                    if (nums[i%n] > curVal){
                        nextBig = nums[i%n];
                        break;
                    }
                    i++;
                }
                res[curIndex]= nextBig > curVal ? nextBig : -1;
            }
        }
        return res;
    }

	
	// solved with two pointers. 56ms(<11%) 54MB(<7%)
	public int[] nextGreaterElements2(int[] nums) {
        // brute force solution with two pointers.
        int n = nums.length;
        int[] res = new int[n];
        if (n==0){
            return res;
        }
        
        for (int i=0;i<n;i++){
            boolean loop = false;
            int curVal = nums[i];
            int index = i+1;
            while ((!loop && index > i) || (loop && index < i)){
            //while (true){
                if (index >= n){
                    loop = true;
                    index = index % n;
                }
                
                if (nums[index] > curVal){
                    res[i]=nums[index];
                    break;
                } else {
                    index++;
                    if (loop && index >= i){
                        res[i]=-1;
                        break;
                    }
                }
            }
        }
        
        return res;
    }
}
