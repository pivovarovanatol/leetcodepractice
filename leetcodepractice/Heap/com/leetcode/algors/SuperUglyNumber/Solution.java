package com.leetcode.algors.SuperUglyNumber;
//https://leetcode.com/problems/super-ugly-number/

import java.util.*;

class Solution {
	
	// With PrirityQueue.   
	public int nthSuperUglyNumber(int n, int[] primes) {
	    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
	      public int compare(int[] e1, int[] e2) {
	        return e1[0] - e2[0];
	      }
	    });
	    for (int p: primes) pq.add(new int[] {p, 1, p});
	    int[] ugly = new int[n];
	    ugly[0] = 1;
	    for (int i = 1; i < n; i++) {
	      ugly[i] = pq.peek()[0];
	      while (ugly[i] == pq.peek()[0]) {
	        int[] e = pq.poll();
	        pq.add(new int[] {e[2] * ugly[e[1]], e[1] + 1, e[2]});
	      }
	    }
	    return ugly[n - 1];
  }
	
	// With arrays and math.
	public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] index = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[index[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[index[j]] == ugly[i]) index[j]++;
            }
        }

        return ugly[n - 1];
    }
}

