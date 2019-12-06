package com.leetcode.algors.LastStoneWeight;
// https://leetcode.com/problems/last-stone-weight/
import java.util.*;

// Solved with PriorityQueue. 1ms(<99%) 33.9MB(<100%) 
class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
        
        for (int e : stones){
            pq.add(e);
        }
        
        while (pq.size() > 1){
            
            int y = pq.poll();
            int x = pq.poll();
            
            if (x != y) {
                y = y - x;
                pq.add(y);   
            }
            
        }
        if (pq.size() > 0 ){ 
            return pq.poll();
        } else {
            return 0;
        }
    }
    
}