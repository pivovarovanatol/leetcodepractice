package com.leetcode.algors.MergeSortedArray;
// https://leetcode.com/problems/merge-sorted-array/

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if (n==0) {
    		return;
    	}
    	
    	if (m==0 && n==0) {
    		return;
    	}
    	
    	if (m==0 && n!=0) {
    		for (int i=0;i<n;i++) {
    			nums1[i]=nums2[i];
    		}
    	}
    	
    	int tail=m + n - 1;
    	int ind1 = m-1;
    	int ind2 = n-1;
    	
    	for (int i = tail; i>=0;i--) {
    		
    		if (ind2 >=0) {
    			if (ind1 >=0) {
            		if (nums1[ind1]<nums2[ind2]) {
            			nums1[tail] = nums2[ind2];
            			ind2--;
            			tail--;
            		} else {
            			nums1[tail] = nums1[ind1];
            			ind1--;
            			tail--;
            		}
    			} else {
        			nums1[tail] = nums2[ind2];
        			ind2--;
        			tail--;
    			}
        	} else {
        			nums1[tail] = nums1[ind1];
        			ind1--;
        			tail--;
        		}
    	}
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        
  
    	int[] res = new int[nums1.length];
    	int i=0, j=0, k=0;
    	
    	while (j < n && i < m) {
    		if (nums1[i]<nums2[j]) {
    			res[k] = nums1[i];
    			i++; 
    			k++;
    		} else {
    			res[k] = nums2[j];
    			j++; 
    			k++;
    		}
    	}
    	    	
    	for (int index=i;index<m;index++) {
    		res[index+i]=nums1[index];
    	}
    	for (int index=j;index<n;index++) {
    		res[index+j]=nums2[index];
    	}
    	
    	for (int index=0;index<nums1.length;index++) {
        	nums1[index] = res[index];
    	}
    }

}
