package com.leetcode.algors.CountTripletsThatCanFormTwoArraysEqualXOR;
// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

import java.util.HashMap;
import java.util.Map;

class Solution {
	// from discussions: 1ms (<99%)
	// 
    public int countTriplets(int[] A) {
        int n = A.length, res = 0, prefix = 0, c, t;
        Map<Integer, Integer> count = new HashMap<>(), total = new HashMap<>();
        count.put(0, 1);
        for (int i = 0; i < n; ++i) {
            prefix ^= A[i];
            c = count.getOrDefault(prefix, 0);
            t = total.getOrDefault(prefix, 0);
            res += c * i - t;
            count.put(prefix, c + 1);
            total.put(prefix, t + i + 1);
        }
        return res;
    }

    /*
    Solution 2: Brute Force with prefix
    Calculate all prefix of bitwise-xor operation.
    prefix[0] = 0
    prefix[i] = A[0]^A[1]^...^A[i - 1]
    So that for each (i, j),
    we can get A[i]^A[i+1]^...^A[j] by prefix[j+1]^prefix[i]
    in O(1) time

    Time O(N^3)
    Space O(N)
    Space O(1) if changing the input


    Solution 3: Prefix XOR
    a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
    b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]

    Assume a == b, thus
    a ^ a = b ^ a, thus
    0 = b ^ a, thus
    arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] ^ arr[j] ^ arr[j + 1] ^ ... ^ arr[k] = 0
    prefix[k+1] = prefix[i]

    We only need to find out how many pair (i, k) of prefix value are equal.
    So we can calculate the prefix array first,
    then brute force count the pair.

    Because we once we determine the pair (i,k),
    j can be any number that i < j <= k,
    so we need to plus k - i - 1 to the result res.

    Time O(N^2)
    Space O(N)
    Space O(1) if changing the input
    
    Solution 4: Prefix XOR, O(N)
    The problem now is, given an array,
    find out the sum of index distance with A[i] = A[j].
    Let me know if there is a duplicate problem on LeetCode,
    so I can attach a link to help explain.

    Basicly, for the same value in the array,
    we need to count the frequncy and the total value at the same time.

*/
    
	// solved in  44ms (<35%) 
	// with HashMap<int, HashMap<int, int>> for left sums and traverse over right side
    public int countTriplets2(int[] arr) {
        int count = 0;
        int n = arr.length;
        printArr(arr);
        HashMap<Integer, HashMap<Integer, Integer>> mapLeft = new HashMap<>();
        
        int[][] sumsLeft = new int[n][n];
        for(int i=0;i<n-1;i++) {
        	sumsLeft[i][i] = arr[i];
        	HashMap<Integer, Integer> m = new HashMap<>();
    		m.put(sumsLeft[i][i],1);
        	for (int j=i-1;j>=0;j--) {
        		sumsLeft[i][j] = sumsLeft[i][j+1] ^ arr[j];
        		if (m.containsKey(sumsLeft[i][j])) {
        			m.put(sumsLeft[i][j], m.get(sumsLeft[i][j])+1);
        		} else {
        			m.put(sumsLeft[i][j], 1);
        		}
        	}
        	mapLeft.put(i, m);
        }
        //printMatrix(sumsLeft);

        int[][] sumsRight = new int[n][n];
        for(int i=1;i<n;i++) {
        	sumsRight[i][i] = arr[i];
        	if (mapLeft.containsKey(i-1)) {
        		if (mapLeft.get(i-1).containsKey(sumsRight[i][i])) {
        			count += (mapLeft.get(i-1).get(sumsRight[i][i]));
        			//System.out.println("0 Found sum " + sumsRight[i][i]);
        		}
        	}
        	for (int j=i+1;j<n;j++) {
        		sumsRight[i][j] = sumsRight[i][j-1] ^ arr[j];
            	if (mapLeft.containsKey(i-1)) {
            		if (mapLeft.get(i-1).containsKey(sumsRight[i][j])) {
            			count += (mapLeft.get(i-1).get(sumsRight[i][j]));
            			//System.out.println("1 Found sum " + sumsRight[i][j]);
            		}
            	}
        	}
        }
        //printMatrix(sumsRight);
        
        
        return count;
    }
    
    void printMatrix(int[][] m) {
    	
    	for (int i=0;i<m.length;i++) {
    		for (int j=0;j<m[0].length;j++)
    		{
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    
    
    void printArr(int[] arr) {
    	for (int e : arr) {
    		System.out.print(e + " ");
    	}
    	System.out.println();
    	System.out.println();
    }
    
}