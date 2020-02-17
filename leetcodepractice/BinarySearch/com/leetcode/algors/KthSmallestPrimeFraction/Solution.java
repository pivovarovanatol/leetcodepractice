package com.leetcode.algors.KthSmallestPrimeFraction;
// https://leetcode.com/problems/k-th-smallest-prime-fraction/

import java.util.PriorityQueue;
import java.util.Comparator;
class Solution {
    
    // From discussions: solved with Binary Search. 3 ms (<98%)  
	public int[] kthSmallestPrimeFraction(int[] A, int K) {
	    int n = A.length, x = 0, y = 0, total = 0;
	    double l = 0, r = 1;
	    
	    while(total != K) {
	        total = 0;
	        double m = (l + r) /2.0, max = 0.0;
	        for(int i = 0, j = 1; i < n; i++) {
	            while(j < n && A[i] > m * A[j])
	                j++;
	            if (j == n || (total += n - j) > K)
	                break;
	            if (A[i] > max * A[j]) {
	                max = A[i] / (double) A[j] ;
	                x = A[i];
	                y = A[j];
	            }
	        }
	        if (total > K)
	            r = m;
	        else 
	            l = m;
	    }
	    return new int[] {x, y};
	}    
    
    // trying to solve with PriorityQueue. TimeLimit exceeded.
    public int[] kthSmallestPrimeFraction2(int[] A, int K) {
        //PriorityQueue<Pair> pq = new PriorityQueue<Pair>(K, new Comparator<Pair>(){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return a.fraction >= b.fraction ? 1 : -1;
            }
        });
        
        for (int i=0;i<A.length-1;i++){
            for (int j=i+1;j<A.length;j++){
                Pair p = new Pair(A[i],A[j],(float)A[i]/A[j]);
                pq.add(p);
            }
        }
        Pair result = new Pair();
        K--;
        while (K>=0){
            result = pq.poll();
            K--;
        }
//        while (!pq.isEmpty()) {
//        	Pair p = pq.poll();
//        	System.out.println(p.left + "/" + p.right + "="+p.fraction);
//        }
        
        int[] res = new int[2];
        if (result==null){
            return res;
        } else {
            res[0]=result.left;
            res[1]=result.right;
            return res;
        }
    }
    

class Pair{
    int left;
    int right;
    float fraction;
    public Pair(){};
    public Pair(int l, int r, float fract){
        //System.out.println("Creating the pair with: " + l + "/" + r + " = " + fract);
        this.left =l;
        this.right=r;
        this.fraction=fract;
    }
}
    
}