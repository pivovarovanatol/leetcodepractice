package com.leetcode.algors.FindSmallestLetterGreaterThanTarget;
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/


class Solution {

    // solved with binary search. 0ms(<100%) 40MB(<69%).  
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (n==1){
            return letters[0];
        }
        int start =0;
        int end = n-1;
        
        int mid = (start+end)/2;
        
        while (start <= end){
            mid = (start+end)/2;
            
            if (letters[mid] == target){
                if (mid == end){
                    return letters[0];
                } else {
                    start=mid+1;;
                }
            }
            
            if (letters[mid] < target) {
                if (mid==n-1){
                    return letters[0];
                }
                if (letters[mid+1] > target){
                    return letters[mid+1];
                } else {
                    start=mid+1; 
                }
            }
            
            if (letters[mid] > target) {
                if (mid==0){
                    return letters[0];
                } else if(letters[mid-1] <= target) {
                	return letters[mid];
                }
                end = mid;
            }
        }

        return letters[0];
    }
	
	
	
    // solved with simple scan thru array. 0ms(<100%) 39.3MB(<100%)
    public char nextGreatestLetter2(char[] letters, char target) {
        int n = letters.length;
        if (n==1){
            return letters[0];
        }
        
        for (int i=1;i<n;i++){
            if (letters[i-1]<=target && letters[i]>target){
                return letters[i];
            }
        }
        
        return letters[0];
    }
    
    
}
