package com.leetcode.algors.ZigzagConversion;
// https://leetcode.com/problems/zigzag-conversion/

class Solution {
    public String convert(String s, int numRows) {
        // idea is to create nuRows X s.length char matrix and fill it with symbols. Then go row by row and create an output string
        // Improvement: to create an array of Strings with length of numRows and add character to corresponding array element when we calculate the Y. Save some time to not traverse thru matrix. 
        int len = s.length();
        
        if (numRows < 2) {
            return s;
        }
        
        //char[][] matrix = new char[numRows][len];
        
        char[] arr = s.toCharArray();
        int direction = 1;
        int maxY = numRows-1;
        int y = -1;
        String[] strArray = new String[numRows];
        
        //for(int j=0;j<numRows;j++){
        //    for (int i=0;i<len;i++){
        //        matrix[j][i] = ' ';
        //    }
        //}
        
        for (int i=0;i<len;i++){
            int x = i;
            
            if (i!=0 && ((i-1)/maxY) % 2 == 1) {
                direction = -1;
            } else {
                direction = 1;
            }
            y = y + direction;
            
            // matrix[y][x] = arr[i];
            if (strArray[y] == null) {
                strArray[y] = Character.toString(arr[i]);
            } else {
                strArray[y] += Character.toString(arr[i]);
            }
        }
        
        //StringBuilder sb = new StringBuilder();
        
        //for(int j=0;j<numRows;j++){
        //    for (int i=0;i<len;i++){
        //        char tmp = matrix[j][i];
        //        if (tmp != 0) {
        //            sb.append(tmp);
        //        }
        //    }
        //}
        // String result = sb.toString();
        
        String result = "";
        
        for (int i=0;i<numRows;i++){
            if (strArray[i] != null) {
                result += strArray[i];
            }
        }
        
        return result;
    }
    
    // Solution in O(n)? (3ms and 38MB)
    public String convert2(String s, int numRows) {
        char[] chars = new char[s.length()];
        int index = 0;
        int circle = numRows + (numRows > 2 ? numRows - 2 : 0);
        for (int n = 0, offset = 0; n < numRows; n++, offset++) {
            for (int i = 0; ; i += circle) {
                int left = offset == numRows - 1 ? s.length() : i - offset;
                int right = i + offset;
                if (left >= s.length() && right >= s.length()) {
                    break;
                }
                if (left == right) {
                    chars[index++] = s.charAt(right);
                } else {
                    if (left > 0 && left < s.length()) {
                        chars[index++] = s.charAt(left);
                    }
                    if (right < s.length()) {
                        chars[index++] = s.charAt(right);
                    }
                }
            }
        }
        return new String(chars);
    }
    
    
    
    
}