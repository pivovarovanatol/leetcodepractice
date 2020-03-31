package com.leetcode.contests.weekly182.problem4;
// https://leetcode.com/contest/weekly-contest-182/problems/find-all-good-strings/

import java.util.Arrays;

class Solution {
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
        public int findGoodStrings(int n, String s1, String s2, String evil) {
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
