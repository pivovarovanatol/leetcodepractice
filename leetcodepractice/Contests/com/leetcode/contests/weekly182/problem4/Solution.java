package com.leetcode.contests.weekly182.problem4;
// https://leetcode.com/contest/weekly-contest-182/problems/find-all-good-strings/

import java.util.Arrays;

class Solution {
	// from discussions: 16ms(<100%) 39.9MB(<100%)
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int[] memo = new int[1 << 17]; // Need total 17 bits, can check getKey() function
        Arrays.fill(memo, -1);
        return dfs(0, 0, true, true,
                n, s1.toCharArray(), s2.toCharArray(), evil.toCharArray(), computeLPS(evil.toCharArray()), memo);
    }
    int dfs(int i, int evilMatched, boolean leftBound, boolean rightBound,
            int n, char[] s1, char[] s2, char[] evil, int[] lps, int[] memo) {
        if (evilMatched == evil.length) return 0; // contain `evil` as a substring -> not good string
        if (i == n) return 1; // it's a good string
        int key = getKey(i, evilMatched, leftBound, rightBound);
        if (memo[key] != -1) return memo[key];
        char from = leftBound ? s1[i] : 'a';
        char to = rightBound ? s2[i] : 'z';
        int res = 0;
        for (char c = from; c <= to; c++) {
            int j = evilMatched; // j means the next match between current string (end at char `c`) and `evil` string
            while (j > 0 && evil[j] != c) j = lps[j - 1];
            if (c == evil[j]) j++;
            res += dfs(i + 1, j, leftBound && (c == from), rightBound && (c == to),
                    n, s1, s2, evil, lps, memo);
            res %= 1000000007;
        }
        return memo[key] = res;
    }
    int getKey(int n, int m, boolean b1, boolean b2) {
        // Need 9 bits store n (2^9=512), 6 bits store m (2^6=64), 1 bit store b1, 1 bit store b2
        return (n << 8) | (m << 2) | ((b1 ? 1 : 0) << 1) | (b2 ? 1 : 0);
    }
    int[] computeLPS(char[] str) { // Longest Prefix also Suffix
        int n = str.length;
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && str[i] != str[j]) j = lps[j - 1];
            if (str[i] == str[j]) lps[i] = ++j;
        }
        return lps;
    }	
	
	
	
    int mod = 1_000_000_007;
        public int[] prefixFunction(String s) {
            int[] p = new int[s.length()];
            int k = 0;
            for (int i = 1; i < s.length(); i++) {
                while (k > 0 && s.charAt(k) != s.charAt(i))
                    k = p[k - 1];
                if (s.charAt(k) == s.charAt(i))
                    ++k;
                p[i] = k;
            }
            return p;
        }
        public int findGoodStrings2(int n, String s1, String s2, String evil) {
            if (s1.compareTo(s2) > 0) return 0;
            int[] P = prefixFunction(evil);
//            System.err.println(Arrays.toString(P));
            dp = new int[evil.length() + 1][n + 1];
            for (int[] a: dp) Arrays.fill(a, -1);
            int c1 = findStringsBelow(n, s1.toCharArray(), evil.toCharArray(), P, 0, 0, true);
//            System.err.println(c1);
            for (int[] a: dp) Arrays.fill(a, -1);
            int c2 = findStringsBelow(n, s2.toCharArray(), evil.toCharArray(), P, 0, 0, true);
//            System.err.println(c2);
            int C = add(mod - c1, c2);
            if (!s1.contains(evil)) C++;
            return C;
        }
        
        int add (int a, int b) {
            int c = a + b;
            if (c >= mod) return c - mod;
            return c;
        }
        
        int[][] dp;
        public int findStringsBelow(int n, char[] s, char[] p, int[] prefixFunction, int atP, int atN, boolean same) {
            if (!same && dp[atP][atN] != -1) return dp[atP][atN];
            if (atP == p.length) return 0;
            if (atN == n) return 1;
            int start = 'a', end = same ? s[atN]: 'z';
            int ans = 0;
            for (int i = start; i <= end; i++) {
                if (i == p[atP]) {
                    ans = add(ans, findStringsBelow(n, s, p, prefixFunction, atP + 1, atN + 1, same && i == end));
                } else {
                    int nextAtP = atP;
                    while (nextAtP > 0 && i != p[nextAtP]) nextAtP = prefixFunction[nextAtP - 1];
                    if (i == p[nextAtP]) nextAtP++;
                    ans = add(ans, findStringsBelow(n, s, p, prefixFunction, nextAtP, atN + 1, same && i == end));
                }
            }
            return dp[atP][atN] = ans;
        }
}
