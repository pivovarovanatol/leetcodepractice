package com.leetcode.algors.FairCandySwap;
// https://leetcode.com/problems/fair-candy-swap/

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;


class Solution {
	
	
    public int[] fairCandySwap(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        int[] res = new int[2];
        int sumB = 0;
        int sumA = 0;
        
        for (int i=0;i<A.length;i++){
            sumA+=A[i];    
        }
        
        for (int i=0;i<B.length;i++){
            sumB+=B[i];    
        }
        
        
        for (int i=0;i<A.length;i++){
            
            for (int j=0;j<B.length;j++){
                //System.out.println("1. SumA=" + sumA + " SumB="+sumB);
                sumA -=A[i];
                sumA +=B[j];
                
                sumB -=B[j];
                sumB +=A[i];
                
                //System.out.println("2. SumA=" + sumA + " SumB="+sumB);
                
                if (sumA == sumB){
                    res[0] = A[i];
                    res[1] = B[j];
                    return res;
                } else {
                sumA +=A[i];
                sumA -=B[j];
                
                sumB +=B[j];
                sumB -=A[i];
                
                }
            }
            
        }
        
        return res;
    }
}

