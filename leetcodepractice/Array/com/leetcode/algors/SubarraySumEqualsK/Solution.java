package com.leetcode.algors.SubarraySumEqualsK;
// https://leetcode.com/problems/subarray-sum-equals-k/ttps://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/

import java.util.HashMap;
/*
Using Hashmap. Algorithm
The idea behind this approach is as follows: If the cumulative sum(repreesnted by sum[i]sum[i] for sum upto i^{th}ith index) upto two indices is the same, 
the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum upto two indices, 
say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i] - sum[j]=k, the sum of elements lying between indices ii and jj is kk.
Based on these thoughts, we make use of a hashmap mapmap which is used to store the cumulative sum upto all the indices possible along with the number of times the same sum occurs. 
We store the data in the form: (sum_i, no. of occurences of sum_i)(sum i  ,no.ofoccurencesofsum i  ). 
We traverse over the array numsnums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. 
If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine the number of times the sum sum-ksum - k has occurred already, 
since it will determine the number of times a subarray with sum kk has occured upto the current index. We increment the countcount by the same amount.
After the complete array has been traversed, the countcount gives the required result.
 */

public class Solution {
	// solved in 11ms (<95%)
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}