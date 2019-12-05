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
        
        int pointerA = 0;
        int pointerB = 0;
        int diff = (sumA - sumB)/2;
        
//        if (sumA > sumB) {
//        	diff = diff * -1;
//        }
        
        while (pointerA < A.length && pointerB < B.length) {
        	int valA = A[pointerA];
        	int valB = B[pointerB];
        	if (valA - valB == diff) {
        		res[0]=A[pointerA];
        		res[1]=B[pointerB];
        		return res;
        	} 
        	
        	if (sumA > sumB) {
        		if (A[pointerA] < B[pointerB]) {
        			pointerA++;
        			pointerB=0;
        		} else {
        			pointerB++;
        		}
        	} else {
        		if (B[pointerB] < A[pointerA]) {
        			pointerB++;
        			pointerA=0;
        		} else {
        			pointerA++;
        		}
        	}
        	
        }
        
        return res;
    }

	
	
	
	
	
    public int[] fairCandySwap2(int[] A, int[] B) {
        
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

