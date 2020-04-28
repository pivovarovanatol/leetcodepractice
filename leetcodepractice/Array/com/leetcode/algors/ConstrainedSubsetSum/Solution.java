package com.leetcode.algors.ConstrainedSubsetSum;
// https://leetcode.com/problems/constrained-subset-sum/


import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	
	// from discussions. 15ms (<86%)
    // `deque` stores dp[i - k], dp[i-k+1], .., dp[i - 1] whose values are larger than 0 in a decreasing order
    // Note that the length of `deque` is not necessarily `k`. The values smaller than dp[i-1] will be discarded. If u r confused, go on and come back later. 
    public int constrainedSubsetSum(int[] A, int k) {
        int res = A[0];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < A.length; ++i) {
            A[i] += !q.isEmpty() ? q.peek() : 0;

//            # deque[0] is the max of (0, dp[i - k], dp[i-k+1], .., dp[i - 1])            
            res = Math.max(res, A[i]);
            
//            # 1. We always want to retrieve the max of (0, dp[i - k], dp[i-k+1], .., dp[i - 1]) from `deque`
//            # 2. We expect dp[i] to be added to `deque` so that we can compute dp[i + 1] in the next iteration
//            # 3. So, if dp[i] is larger than some old values, we can discard them safely.
//            # 4. As a result, the length of `deque` is not necessarily `k`
            
            while (!q.isEmpty() && A[i] > q.peekLast())
                q.pollLast();
            if (A[i] > 0)
                q.offer(A[i]);
//            # we do not need the value of A[i - k] when computing dp[i+1] in the next iteration, because `j - i <= k` has to be satisfied.
            if (i >= k && !q.isEmpty() && q.peek() == A[i - k])
                q.poll();
        }
        return res;
    }
    
}