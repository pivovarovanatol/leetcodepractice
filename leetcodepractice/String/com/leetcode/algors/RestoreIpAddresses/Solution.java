package com.leetcode.algors.RestoreIpAddresses;
// https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

class Solution {
	
	
	// Solution from discussions with char[] and backtracking - 1ms (<100%) and 36MB(<100%)
	public List<String> restoreIpAddresses(String s) {
        int n = 4;
        char[] chars = s.toCharArray();
        int cutPointIndex[] = new int[n + 2];
        cutPointIndex[1] = chars.length;
        cutPointIndex[n + 1] = 0;
        List<String> ret = new ArrayList<>();
        restoreIpAddresses(chars, n, cutPointIndex, ret);
        return ret;
    }

    private void restoreIpAddresses(char[] chars, int n, int[] cutPointIndex, List<String> ret) {
        if (n == 1) {
            if (isIpField(chars, cutPointIndex[2], cutPointIndex[1] - cutPointIndex[2] )) {
                StringBuilder sb = new StringBuilder(chars.length + cutPointIndex.length - 1);
                for (int i = cutPointIndex.length - 2; i > 0; i--) {
                    sb.append(chars, cutPointIndex[i + 1], cutPointIndex[i] - cutPointIndex[i + 1]);
                    if (i != 1) sb.append(".");
                }
                ret.add(sb.toString());
            }
        } else {
            int offset = cutPointIndex[n + 1];
            for (int i = 1; i <= 3; i++) {
                if (isIpField(chars, offset, i)) {
                    cutPointIndex[n] = offset + i;
                    restoreIpAddresses(chars, n - 1, cutPointIndex, ret);
                }
            }
        }
    }

    boolean isIpField(char[] arr, int offset, int len) {
        if (offset + len > arr.length) return false;
        if (len == 1 || len == 2) {
            return len == 1 || arr[offset] != '0';
        } else if (len == 3) {
            if (arr[offset] == '1') {
                return true;
            } if (arr[offset] == '2') {
                return arr[offset + 1] < '5' || (arr[offset + 1] == '5' && arr[offset + 2] <= '5');
            }  else {
                return false;
            }
        } else {
            return false;
        }
    }
	
	
	
	// original solution with Strings and backtracking - 3ms(<27%) and 39MB(<9%)
    public List<String> restoreIpAddresses2(String s) {
        
        int n = s.length();
        
        List<String> ls = new ArrayList<>();

        if (n<=0 || n > 12) {
            return ls;
        }
        //System.out.println(s);
        restoreIpHelper(s, 0, n, "", 4, ls);
        return ls;
    
    }
    
    void restoreIpHelper(String s, int start, int end, String str, int dots, List<String> ls){
        
        if (start > end) {
            return;
        }
        
        String dot = ".";
        if (dots == 4) {
            dot = "";
        }
        
        int newEnd;
        String tmp;
        
        for (int i=0;i<3;i++){
            newEnd = start + i;
            if (newEnd >= s.length()){
                return;
            }
            tmp = s.substring(start, newEnd+1);
            int tmpInt = Integer.parseInt(tmp);
            //tmp = ""+tmpInt;
            if (tmp.length() > 0) {
                if (tmpInt> 255) {
                    //System.out.println(tmp + " is greater than 255 " + tmp.compareTo("25"));
                    continue;
                }
                if (i > 0 && tmp.charAt(0) == '0') {
                    //System.out.println(tmp + " -> corner case - Leading Zero -> skip! ");
                    continue;
                }
            }

            if ((dots == 1) && (newEnd == s.length()-1)) {
                String ip = str + dot + tmp;
                ls.add(ip);
            }

            restoreIpHelper(s, newEnd+1,end,str + dot + tmp,dots -1, ls);
        }
    }
}
