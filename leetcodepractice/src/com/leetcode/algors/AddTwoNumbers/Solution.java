package com.leetcode.algors.AddTwoNumbers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carryOver=0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        while (l1 != null || l2 != null) {
            int currNumber1 = 0;
            int currNumber2 = 0;
            
            if (l1 != null) {
                currNumber1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                currNumber2 = l2.val;
                l2 = l2.next;
            }
            
            int sum = (currNumber1 + currNumber2 + carryOver) % 10;
            carryOver = (currNumber1 + currNumber2 + carryOver) / 10;
            
            stack.push(sum);
            
        }
        
        if (carryOver !=0){
            stack.push(carryOver);
        }
        
        while (!stack.isEmpty()){
            ListNode temp = new ListNode(stack.pop());
            temp.next = result;
            result = temp;
        }
                
        // Return
        return result;
    }

}


