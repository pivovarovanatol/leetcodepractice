package com.leetcode.algors.CanMakePalindromeFromSubstring;
// https://leetcode.com/problems/can-make-palindrome-from-substring/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


class Solution {
	
	// Same idea from discussions: 64ms (<42%) 111MB(<100%)
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = s.length();
        int[][] cnt = new int[n + 1][26];
        for (int i = 0; i < n; ++i) {
            cnt[i + 1] = cnt[i].clone(); // copy previous sum.
            ++cnt[i + 1][chars[i] - 'a'];
        }
        for (int j=0; j<queries.length;j++) {
            int sum = 0; 
            for (int i = 0; i < 26; ++i) {
                sum += (cnt[queries[j][1] + 1][i] - cnt[queries[j][0]][i]) % 2;
            }
            ans.add(sum / 2 <= queries[j][2]);
        }
        return ans;
    }
	
	/*
	 * Calculate the previous char count for every char in the string
	 * Use that information later by getting the difference between left and right pointers and then check the number of odd letters -> should be even and > 1 and < k*2 
	 * solved in 94ms (<9%)
	 */
    public List<Boolean> canMakePaliQueries4(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>(); 
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] arr = new int[26];
        char[] str = s.toCharArray();
        map.put(0, arr);
        
        for (int i=0;i<s.length();i++) {
        	arr[str[i]-'a']++;
        	int[] chars = arr.clone();
        	map.put(i, chars);
        }
        
        for (int[] q : queries) {
        	int left = q[0];
        	int right = q[1];
        	int k = q[2];
        	int[] empty = new int[26];
        	
        	int[] leftChars = map.get(left-1);
        	int[] rightChars = map.get(right);

        	if (leftChars==null) leftChars=empty;
        	if (rightChars==null) rightChars=empty;
        	int odd = 0;
        	
        	for (int j=0;j<26;j++) {
        		if ((rightChars[j]-leftChars[j])%2==1) odd++;
        	}
        	ans.add(odd / 2 <= k);
        }
        return ans;
    }
	
// from discussions using TreeMap. 	
    HashMap<Character, TreeMap<Integer, Integer>> map;
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        List<Boolean> ret = new ArrayList<>();
        map = new HashMap<>();
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        for (int c=0; c<26; c++){
            map.put((char)(c+'a'), new TreeMap<>());
        }
        for (int i=0; i<cs.length; i++){
            count[cs[i]-'a']++;
            map.get(cs[i]).put(i, count[cs[i]-'a']);
        }
        for (int[] q: queries){
            int sum = 0;
            for (int i=(int)'a'; i<=(int)'z'; i++){
                if (map.get((char)i).floorEntry(q[1])==null || map.get((char)i).ceilingEntry(q[0])==null) continue;
                int right = map.get((char)i).floorEntry(q[1]).getValue();
                int left = map.get((char)i).ceilingEntry(q[0]).getValue();
                sum += (Math.max(right-left+1,0))%2;
                // System.out.println((char)i+" "+right+" "+left+" "+sum+" "+q[2]);
            }
            ret.add(sum/2<=q[2]);
        }
        return ret;
    }
	
	// solved, but has TLE. 
    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
        int n = queries.length;
        List<Boolean> answer = new ArrayList<>();
        char[] str = s.toCharArray();
        for (int i=0;i<n;i++){
            getAnswer(str, queries, i, answer);
        }
        
        return answer;
    }


    void getAnswer(char[] str, int[][] queries, int index, List<Boolean> answer){
        int left = queries[index][0];
        int right = queries[index][1];
        int k = queries[index][2];
        if (k>=13) {
            answer.add(true);
            return;
        }
        // create new array and copy elements from original string
        // check if word is a palindrome with k replacements
        // since we can rearange the string, then we need to count the number of every letter.
        int[] letters = new int[26];
        char[] word = new char[right-left+1];
        for (int j=left, i=0;j<=right;j++, i++){
            word[i] = str[j];
            letters[str[j]-'a']++;
        }
        
        // check the number of odd letters -> should be even and > 1 and < k*2
        int oddLetters = 0;
        for (int i=0;i<26;i++){
            if (letters[i]%2 ==1){
                oddLetters++;
            }    
        }
        
        if (oddLetters <= 1) {
            answer.add(true);
            return;
        } else if (oddLetters <= k*2+1) {
            answer.add(true);
            return;
        }
        {
            answer.add(false);    
            return;
        }
    }




}