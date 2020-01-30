package com.leetcode.algors.CountOfRangeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

// https://leetcode.com/problems/count-of-range-sum/


class Solution {
	// From discussions: 5ms(<100%). Some mix between divide and conquer and merge sort. Really optimal.   
	   public int countRangeSum(int[] nums, int lower, int upper) {
	        if (nums.length == 0) {
	            return 0;
	        }
	        long[] sums = new long[nums.length + 1];
	        for (int i = 1; i < nums.length + 1; i++) {
	            sums[i] = sums[i - 1] + nums[i - 1];
	        }
	        return countRangeSumWithMergeSort(sums, lower, upper, 0, nums.length);
	    }

	    private int countRangeSumWithMergeSort(long[] sums, int lower, int upper, int start, int end) {
	        if (end == start) {
	            return 0;
	        }

	        int mid = (start + end) / 2;
	        int cnt = countRangeSumWithMergeSort(sums, lower, upper, start, mid) + countRangeSumWithMergeSort(sums, lower
	                , upper, mid + 1, end);

	        int i = mid + 1;
	        int j = mid + 1;

	        int s = start;
	        int right = mid + 1;
	        long[] copy = new long[end - start + 1];
	        int copyIndex = 0;
	        while (s <= mid) {
	            while (i <= end) {
	                if (sums[i] - sums[s] < lower) {
	                    i++;
	                } else {
	                    break;
	                }
	            }
	            while (j <= end) {
	                if (sums[j] - sums[s] <= upper) {
	                    j++;
	                } else {
	                    break;
	                }
	            }

	            cnt += j - i;

	            while (right <= end && sums[right] < sums[s]) {
	                copy[copyIndex] = sums[right];
	                copyIndex++;
	                right++;
	            }

	            copy[copyIndex] = sums[s];
	            copyIndex++;
	            s++;
	        }

	        System.arraycopy(copy, 0, sums, start, right - start);

	        return cnt;
	    }
	
	// from discussions: 26ms(<41%). Uses binary search. Need to review the solution to understand it. 
    public int countRangeSum4(int[] nums, int lower, int upper) {
        if(nums==null||nums.length==0) return 0;
        int res=0;
        List<Long> list=new ArrayList<>();
        list.add((long)0);
        long sum=0;
        for(int i=1;i<=nums.length;i++){
            sum=sum+nums[i-1];
            int lowerindex=search1(list,sum-lower);
            int upperindex=search2(list,sum-upper);
            res+=Math.max(0,lowerindex-upperindex+1);
            int insertindex=Collections.binarySearch(list, sum);
            if(insertindex<0) insertindex=-(insertindex+1);
            list.add(insertindex,sum);
        }
        return res;
    }
    
    public int search1(List<Long> list, long target){
        int l=0, r=list.size()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(list.get(mid)>target) r=mid-1;
            else l=mid+1;
        }
        if(list.get(l)<=target) return l;
        else return l-1;
    }
    
    public int search2(List<Long> list, long target){
        int l=0, r=list.size()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(list.get(mid)<target) l=mid+1;
            else r=mid-1;
        }
        if(list.get(l)>=target) return l;
        else return l+1;
    } 

    // from discussions: using SegmentTree. 14ms(<50%)
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;
        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }
    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if(low > high) return null;
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        if(low == high) return stn;
        int mid = (low + high)/2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid+1, high);
        return stn;
    }
    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if(stn == null) return;
        if(val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }
    private int getCount(SegmentTreeNode stn, long min, long max) {
        if(stn == null) return 0;
        if(min > stn.max || max < stn.min) return 0;
        if(min <= stn.min && max >= stn.max) return stn.count;
        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }

    public int countRangeSum3(int[] nums, int lower, int upper) {

        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> valSet = new HashSet<Long>();
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet.add(sum);
        }

        Long[] valArr = valSet.toArray(new Long[0]);

        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length-1);

        for(int i = nums.length-1; i >=0; i--) {
            updateSegmentTree(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long)lower+sum, (long)upper+sum);
        }
        return ans;
    }

	
	
	// from discussion: using TreeMap. 46ms(<24%)
    public int countRangeSum0(int[] nums, int lower, int upper) {
        int count = 0;
        long[] sum = new long[nums.length+1];
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>(); 
        map.put(0L, 1);
        for(int i=0; i<nums.length; i++){
            sum[i+1] = sum[i]+nums[i];
            map.put(sum[i+1], map.containsKey(sum[i+1])? map.get(sum[i+1])+1: 1);
        }
        for(int i=0; i<nums.length; i++){
            map.put(sum[i], map.get(sum[i])-1);
            if(map.get(sum[i]) == 0) map.remove(sum[i]);
            for(Entry<Long, Integer> entry: map.subMap(sum[i]+lower, sum[i]+upper+1).entrySet())
                count += entry.getValue();
        }
        return count;
    }
	
	
    // idea: total number of intervals = intervals on the left + intervals on the right + intersecting intervals. Solved in 150ms(<5%) 41MB(<17%)  
    public int countRangeSum1(int[] nums, int lower, int upper) {
        int n=nums.length;
        int count=0;
        
    	count = countIntervals(nums,0,n-1,lower,upper);
        return count;
    }

    public int countIntervals(int[] nums, int start, int end, int lower, int upper) {
    	if (start>end) {
    		return 0;
    	}
    	if (start==end) {
    		if (nums[start]>=lower && nums[start]<=upper ) return 1;
    		else return 0;
    	}
    	// counting left and right halves. 
    	int mid=start+(end-start)/2;
    	int countLeft = countIntervals(nums,start,mid,lower,upper);
    	int countRight = countIntervals(nums,mid+1,end,lower,upper);

    	if (end-start==1) {
    		long tmp = (nums[mid]+nums[mid+1]);
    		int c = tmp >= lower && tmp <= upper?1:0;
    		return countLeft + countRight + c;  
    	}
    	
    	
    	// counting intersections with two pointers:
    	int pointer1 = mid;
    	int countMiddle=0;
    	long sum1=0;
    	
    	// for odd arrays
    	while (pointer1>=start) {
        	int pointer2 = mid+1;
        	sum1+=nums[pointer1];
        	
        	long sum2 = sum1;
    		while (pointer2<=end) {
    			sum2+=nums[pointer2];
    			if (sum2>=lower && sum2<=upper) {
    				countMiddle++;
    			}
    			pointer2++;
    		}
    		pointer1--;
    	}
    	
    	return countLeft + countRight + countMiddle;
    }
	
	
	// start with naive brute force -> calculate running sum from the beginning and tore in array
    // after - go thru array and mark all sequences with sum in the range
	// solved in 161ms(<5%) 41MB(<17%)
    public int countRangeSum2(int[] nums, int lower, int upper) {
        int n=nums.length;
        long sums[] = new long[n+1];
        sums[0]=0;
        int count=0;
        
        for (int i=0;i<n;i++){
            sums[i+1]=sums[i]+nums[i];
        }
        
        for (int i=0;i<n;i++){
            for (int j=i+1;j<=n;j++){
            	long curSum=sums[j]-sums[i];
                if (curSum>=lower && curSum<=upper){
                    //System.out.println(i+"-"+j+"="+sums[j]+"-"+sums[i]+"="+curSum);
                    count++;
                }
            }
        }
        
        return count;
    }
    
}