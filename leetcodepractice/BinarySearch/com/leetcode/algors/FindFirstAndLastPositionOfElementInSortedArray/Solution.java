package com.leetcode.algors.FindFirstAndLastPositionOfElementInSortedArray;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
	// solved with binary search and the two pointers afterwards. 0ms(<100%) 42.7MB(<100%)
	
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]=-1;
        result[1]=-1;
        int n=nums.length;

        if (nums==null || nums.length==0){
            return result;
        }
        
        int index = binarySearch(nums, 0, n-1, target);
        
        if (index==-1){
            return result;
        } else {
          int pointer1 = index;
          int pointer2 = index;

         while (pointer1>=0){
              if (nums[pointer1]!=target){
                pointer1++;
                break;
              } else if (pointer1==0 && nums[pointer1]==target){
                  break;
              }
              pointer1--;
          }
         while (pointer2<n){
              if (nums[pointer2]!=target){
                pointer2--;
                break;
              } else if (pointer2==n-1 && nums[pointer2]==target){
                  break;
              }
              pointer2++;
          }
            result[0]=pointer1;
            result[1]=pointer2;
            return result;
        }
    }

        public int binarySearch(int[] nums, int lo, int hi, int target){
        if (lo>hi){
            return -1;
        }
        int mid = (lo + hi)/2;
        if (nums[mid]==target) return mid;
            
        if (target < nums[mid]) return binarySearch(nums, lo,mid-1, target);
        if (target > nums[mid]) return binarySearch(nums, mid+1, hi, target);
        return -1;
    }

    
    
    public int binarySearch1(int[] nums, int lo, int hi, int target){
        System.out.println(lo + "-"+hi);
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
        if (target <= nums[mid]) return binarySearch1(nums, lo,mid-1, target);
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


