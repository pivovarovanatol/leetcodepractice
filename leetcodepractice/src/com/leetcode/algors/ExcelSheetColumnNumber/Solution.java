package com.leetcode.algors.ExcelSheetColumnNumber;
// https://leetcode.com/problems/excel-sheet-column-number/

class Solution {
    public int titleToNumber(String s) {
        
        int len = s.length();
        int result = 0;
        char[] ch = s.toCharArray();
        int curr = 0;
        for (int i=len-1;i>=0;i--){
        	int tmp = (int) Math.pow(26, len - i - 1);
        	int tmp2 = (ch[i] - 64); 
            curr = (tmp-1)*tmp2  + tmp2;
            result +=curr;
        }
        
        return result;
    }
}