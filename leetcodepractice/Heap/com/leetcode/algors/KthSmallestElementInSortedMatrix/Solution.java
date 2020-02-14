package com.leetcode.algors.KthSmallestElementInSortedMatrix;
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

import java.util.PriorityQueue;

class Solution {
	// from discussions: solved with Binary Search. Need to review to get the idea. 0ms(<100%) 48MB(<5%)
    public int kthSmallest(int[][] matrix, int k) {
       if(matrix == null || matrix[0].length == 0) return 0;
       
       int n = matrix.length-1;
       int lo = matrix[0][0]; // lowest number in the matrix
       int hi = matrix[n][n]; // biggest number in the matrix
       
		// Intuition is when we know lower and upper bound, and the problem is to find the kth smallest number
		// This means can we count i....k....m   count[i,k-1] numbers that are smaller than kth number. 
		// That would require binary search.
       while(lo <= hi)
       {
           int mid = lo + (hi - lo)/2;
           int num = count(matrix, mid);
           if(num < k) lo = mid + 1;
           else hi = mid - 1;
       }
       return lo;
   }
   
   private int count(int[][] m, int mid)
   {
       int i = m.length-1;
       int j = 0;
       int res = 0;
       
       while(i >= 0 && j < m[0].length)
       {
           if(m[i][j] > mid) // since columns and rows are sorted in ascending order if [i,j] > mid then we don't need to increment  j but decrement i to find smaller number counts. 
           {
               i--;
           }
           else
           {
               res += i+1; 
               j++;  // if we found smaller then keep going right as numbers are ascending order. 
           }
       }
       return res;
   }
   
   
   // Solution with PriorityQueue. 23ms(<20%) 
   public int kthSmallest1(int[][] matrix, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       
       for (int i=0;i<matrix.length;i++){
           for (int j=0;j<matrix[0].length;j++){
               pq.add(matrix[i][j]);
           }
       }
       int result = Integer.MIN_VALUE;
       for (int i=0;i<k;i++){
           result = pq.poll();
       }
       
       return result;
   }
}
