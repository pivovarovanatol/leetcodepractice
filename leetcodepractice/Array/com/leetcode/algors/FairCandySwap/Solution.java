package com.leetcode.algors.FairCandySwap;
// https://leetcode.com/problems/fair-candy-swap/

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;


class Solution {
	
	// From discussions (I had the same thoughts). Calc sum for both arrays and find the average. For every element in A search in array B to find a + diffA = b.  11ms(<95%) 40.6MB(<96%) With my Binarysearch -> same performance 
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for(int a : A) {
            sumA+=a;
        }
        
        for(int b : B) {
            sumB+=b;
        }
        
//        int pointer = 0;
//        
//        while (pointer < A.length || pointer < B.length) {
//        	if (pointer < A.length)
//                sumA+=A[pointer];
//        		
//        	if (pointer < B.length)
//                sumB+=B[pointer];
//        	pointer++;
//        }
        
        int avg = (sumA+sumB)/2;
        int targetA = avg-sumA;
        
        Arrays.sort(B);
        
        for(int a:A){
        	
            if(binarySearch(B, 0, B.length-1, a+targetA))
                return new int[]{a,a+targetA};
        }
        
        return null;
    }
	
	
	
	// Some solution. Not all test cases pass
    public int[] fairCandySwap3(int[] A, int[] B) {
        
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
    
    boolean binarySearch(int[] arr, int start, int end, int x) {

		while (start <= end) {
			
			int middle = (start + end) / 2;
			
			if (x < arr[middle]) {
				end = middle - 1;
			}

			if (x > arr[middle]) {
				start = middle + 1;
			}
			
			if (x == arr[middle]) {
				return true;
			}
		}
		return false;
		
    }
    
}


