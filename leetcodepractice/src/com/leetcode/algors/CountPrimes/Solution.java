package com.leetcode.algors.CountPrimes;

import java.util.Arrays;

//https://leetcode.com/problems/count-primes/


class Solution {
    
public int countPrimes(int n) {
   boolean[] isPrime = new boolean[n];
   for (int i = 2; i < n; i++) {
      isPrime[i] = true;
   }
   // Loop's ending condition is i * i < n instead of i < sqrt(n)
   // to avoid repeatedly calling an expensive function sqrt().
   for (int i = 2; i * i < n; i++) {
      if (!isPrime[i]) continue;
      for (int j = i * i; j < n; j += i) {
         isPrime[j] = false;
      }
   }
   int count = 0;
   for (int i = 2; i < n; i++) {
      if (isPrime[i]) count++;
   }
   return count;
    }    


    public int countPrimes2(int n) {
        
        int count=0;
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        
        for(int i=2;i<n;i++){
            for(int j=2; i*j < n;j++){
                arr[i*j] = 0;
            }
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i] == 1){
                count++;
            }
        }
        return count;
    }
}
