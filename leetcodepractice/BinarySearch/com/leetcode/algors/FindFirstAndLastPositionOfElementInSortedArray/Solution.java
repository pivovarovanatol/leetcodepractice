package com.leetcode.algors.FindFirstAndLastPositionOfElementInSortedArray;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/



class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        // idea - do two binary searches. First will find the element from bottom second - form top. 
        // Then return indexes. 
        
        int[] result = new int[2];
        result[0]=-1;
        result[1]=-1;
        int n=nums.length;

        if (nums==null || nums.length==0){
            return result;
        }
        
        // int lowerBound = binarySearch1(nums, 0, n-1, target);
        //int upperBound = binarySearch2(nums, 0, n-1, target);
        
        //if (lowerBound > upperBound){
        //    int tmp = upperBound;
        //    upperBound = lowerBound;
        //    lowerBound = tmp;
        // }
        
        //result[0]=lowerBound;
        //result[1]=upperBound;
        
        
        int index = binarySearch(nums, 0, n-1, target);
        
        if (index==-1){
            return result;
        } else {
          int pointer1 = index;
          int pointer2 = index;
          while ((pointer1>=0 && pointer2<n)&&(nums[pointer1]==target || nums[pointer2]==target)){
              if (nums[pointer1]==target){
                  result[0]=pointer1;
              }
              if (nums[pointer2]==target){
                  result[1]=pointer2;
              }
              if (pointer1>=0) pointer1--;
              if (pointer2<n) pointer2++;
          }
            //result[0]=pointer1;
            //result[1]=pointer2;
            return result;
            
        }
        
        //System.out.println(lowerBound);
        //System.out.println(upperBound);
        
        //return result;
    }

        public int binarySearch(int[] nums, int lo, int hi, int target){
        if (lo>hi){
            return -1;
        }
        int mid = (lo + hi)/2;
        if (nums[mid]==target) return mid;
            
        if (target < nums[mid]) return binarySearch1(nums, lo,mid-1, target);
        if (target > nums[mid]) return binarySearch1(nums, mid+1, hi, target);
        return -1;
    }

    
    
    public int binarySearch1(int[] nums, int lo, int hi, int target){
        if (lo==hi){
            if (nums[lo]==target) return lo;
            else return -1;
        }
        int mid = (lo + hi)/2;
        if (nums[mid]==target){
            if (mid==hi){
                return mid;
            } else {
                if (nums[mid+1]!=target){
                    return mid;
                }
            }
        }
        if (target <= nums[mid]) return binarySearch1(nums, lo,mid, target);
        if (target > nums[mid]) return binarySearch1(nums, mid+1, hi, target);
        return -1;
    }

    
    public int binarySearch2(int[] nums, int lo, int hi, int target){
        if (lo==hi){
            if (nums[lo]==target) return lo;
            else return -1;
        }
        int mid = (lo + hi)/2;
        if (nums[mid]==target){
            if (mid==lo){
                return mid;
            } else {
                if (nums[mid-1]!=target){
                    return mid;
                }
            }
        }
        if (target < nums[mid]) return binarySearch2(nums, lo,mid-1, target);
        if (target >= nums[mid]) return binarySearch2(nums, mid, hi, target);
        return -1;
    }
    
}