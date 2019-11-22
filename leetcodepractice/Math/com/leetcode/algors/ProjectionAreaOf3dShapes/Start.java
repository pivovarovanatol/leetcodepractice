package com.leetcode.algors.ProjectionAreaOf3dShapes;
// https://leetcode.com/problems/count-primes/


import java.io.IOException;

public class Start {

    
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    		int[][] arr = new int[10][10];
            
            int ret = new Solution().projectionArea(arr);
            // String out = listNodeToString(ret);
            System.out.print(ret);
    }
}

/* 
 * 000001
 *   1111
 * 010000
 * 
 * 
 * */
