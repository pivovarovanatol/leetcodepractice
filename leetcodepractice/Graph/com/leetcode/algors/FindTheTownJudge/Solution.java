package com.leetcode.algors.FindTheTownJudge;
// https://leetcode.com/problems/find-the-town-judge/

import java.util.HashMap;
import java.util.Map;

class Solution {
	
	// From discussion with one array and two loops. 2ms(<100%) 57.7MB(<100%)
    public int findJudge(int N, int[][] trust) {
        
    	// Create an array to keep track of number of people who trust given person
        int arr[]=new int[N];
        
        // Fill the array. Check if person trusts anyone -> can't be a judge, set to -1 and increment the trustee count for other person
        for(int i=0;i<trust.length;i++){
            arr[trust[i][0]-1]=-1;
            if(arr[trust[i][1]-1]!=-1) arr[trust[i][1]-1]+=1;
        }
        
        // Scan thru the array and check for the person with trustees count == N-1
        for(int i=0;i<N;i++){
            if(arr[i]==N-1) return (i+1);
        }
        
        // Else return -1
        return -1;
    }
	
	
	// Let's try to solve with a Graph via Adjacency Matrix. 5ms(<35%) 59.7MB(<87%)
    public int findJudge1(int N, int[][] trust) {
        boolean[][] matrix = new boolean[N][N];
        // Fill in the adjacency matrix
        for (int i=0;i<trust.length;i++){
            matrix[trust[i][0]-1][trust[i][1]-1] = true;
        }
        
        // Scan Matrix for empty row and if found - check corresponding column
        for (int i=0;i<N;i++){
            boolean trustSomeone = false;
            for (int j=0; j<N;j++){
                if (matrix[i][j]){
                    trustSomeone = true;
                    break;
                }
            }
            if (trustSomeone) {
                continue;
            } else {
                int countTrustees = 0;
                for (int j=0;j<N;j++){
                    if (matrix[j][i]){
                        countTrustees ++;  
                    } 
                }
                if (countTrustees == N-1){
                    return i+1;
                }
            }
        }
        
        return -1;    
    }

	
	
	
	// Solved with HashTables in 28ms(<17%) 60.2MB(<70%)
    public int findJudge2(int N, int[][] trust) {
        //Let's try to solve with HashMap. Iterate ove the array of trust and maintain the map (2 passes).
        // After that - go over the map and return the one with TrustCount == number of people - 1. If none - return -1.
        if (N==1){
            return 1;
        } 
        
        // Create the map with all people labels and 0 as trust. O(N)
        HashMap<Integer, Integer> trustMap = new HashMap<>();
        for (int i=0;i<trust.length;i++){
            trustMap.put(trust[i][0], 0);
            trustMap.put(trust[i][1], 0);
        }
        
        // Iterate again and update the trust count. O(N)
        for (int i=0;i<trust.length;i++){
            int tmp = trustMap.get(trust[i][1]);
            tmp++;
            trustMap.put(trust[i][1], tmp);
        }
        
        int totalCount = 0;
        // Count total people count. O(K), where K - number of distinct people
        for (Map.Entry<Integer, Integer> entry : trustMap.entrySet()){
            totalCount++;
        }
        totalCount--;
        
        // Iterate third time and remove the entries, who trust someone. O(N)
        for (int i=0;i<trust.length;i++){
            trustMap.remove(trust[i][0]);
        }

        //System.out.println(totalCount);
        // Iterate over a map and find the entry with exact trust count. Shouldn't be more than once.
        for (Map.Entry<Integer, Integer> entry : trustMap.entrySet()){
            if (entry.getValue() == totalCount){
                return entry.getKey();
            }
        }

        // Otherwise return -1
        return -1;    
    }
}


