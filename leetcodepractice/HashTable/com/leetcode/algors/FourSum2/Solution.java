package com.leetcode.algors.FourSum2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	
	// from discussions: Same idea, diff implementation. 61ms(<96%) 59.8MB(<32%)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                count += map.getOrDefault(-sum, 0);
            }
        }
        return count;
    }
	
	// solved with HashMaps for A and B and counting number of combinations for every sum. Then iterating over C and D and for every sum looking for corresponding sum in the HashMap. 63ms(<94%) 60MB(<24%) 
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int n= A.length;
        Arrays.sort(D);
        HashMap<Integer, Integer> mapAB = new HashMap<>();
        
        int count = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
            	int tmp = A[i]+B[j];
            	if (mapAB.containsKey(tmp)) {
            		mapAB.put(tmp, mapAB.get(tmp)+1);
            	} else {
            		mapAB.put(tmp, 1);
            	}
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
            	int tmp = C[i]+D[j];
            	if (mapAB.containsKey(0-tmp)) {
                	int count2 = mapAB.get(0-tmp);
                	count += count2;
            	}
            }
        }
        
        return count;
    }
	
	
	// solved with HashMap and counting number of combinations for every sum - then multiplying counts for AB and CD. 135ms(<15%) 83MB(<8%) 
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int n= A.length;
        Arrays.sort(D);
        HashMap<Integer, Integer> mapAB = new HashMap<>();
        HashMap<Integer, Integer> mapCD = new HashMap<>();
        
        int count = 0;
        
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
            	int tmp = A[i]+B[j];
            	if (mapAB.containsKey(tmp)) {
            		mapAB.put(tmp, mapAB.get(tmp)+1);
            	} else {
            		mapAB.put(tmp, 1);
            	}
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
            	int tmp = C[i]+D[j];
            	if (mapCD.containsKey(tmp)) {
            		mapCD.put(tmp, mapCD.get(tmp)+1);
            	} else {
            		mapCD.put(tmp, 1);
            	}
            }
        }
        
        for (int key : mapAB.keySet()) {
        	int count1 = mapAB.get(key);
        	if (mapCD.containsKey(0-key)) {
            	int count2 = mapCD.get(0-key);
            	count += (count1*count2);
        	}
        }
        
        return count;
    }
    
    boolean binarySearch(int[] arr, int lo, int hi, int target){
        
        if (lo>hi) return false;
        
        int mid = (hi+lo)/2;
        
        if (arr[mid]==target) return true;
        
        if (target > arr[mid]) return binarySearch(arr,mid+1,hi,target);
        else return binarySearch(arr,lo,mid-1,target);
    }
    
    
}

