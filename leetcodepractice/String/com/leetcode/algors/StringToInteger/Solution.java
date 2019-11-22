package com.leetcode.algors.StringToInteger;
// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
	
	// Same idea, different implementation -> 1 ms (<100%) 36MB (<100%)
    public int myAtoi(String str) {
        
        //  case 1: Remove white spaces
        str = str.trim();
        if(str == null || str.length() == 0) return 0;
        
        //double can store larger value
        double result = 0;       
        
        // case 2: Handle -tv / +ve sign
        boolean isNegative = false;
        int startIndex = 0;
        
        if(str.charAt(0) == '+'||str.charAt(0) == '-') {
            startIndex++;
        }
        if(str.charAt(0) == '-') {
            isNegative = true;
        }
        
        // case 3 :Handle normal case
        for(int i=startIndex;i<str.length();i++) {
            
            //if non numerical character is coming
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            //find the askii value of the digit by subtracting it with 0
            int digitValue = (int)(str.charAt(i) - '0');
            result = result * 10 + digitValue;
        }
        
        // while returning if it is a -ve number then append -ve and return 
        if(isNegative) {
            result = -result;
        }
        
        //case 4: handle inter out of range 
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        // handle if integer is less than min value
        if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)result;
    }

	
	// My initial idea -> 2 ms (<50%) 36MB(<100%) 
    public int myAtoi2(String str) {
        
        // To implement:
        // 1. Convert to charArray
        // 2. Traverse thru array
        // 3. Check if symbol is ' ' if yes - skip
        // 4. if not - check if it's a sign symbol (+/-). If yes - store it
        // 5. If not ' ' - then check if can be parsed as int. If not - return 0
        // 6. If symbol is a digit - put that in the string/chararray
        // 7. if new symbol is ' ' - exit the loop
        // 8. Check if number stored in chararray is bigger than INT_MAX or less than INT_MIN. If yes - return INT_MAX/INT_MIN
        // 9. otherwise return number
        
        char[] arr = str.toCharArray();
        //int len = str.length();
        

        boolean numberFound = false;
        boolean signFound = false;
        boolean nonZeroFound = false;
        int sign = 1;
        StringBuilder sb = new StringBuilder();
        
        for (char ch : arr){

            if (((ch <'0')||(ch>'9')) && ch != ' ' && ch != '-' && ch != '+' && !numberFound) {
                return 0;
            }

            if (((ch <'0')||(ch>'9')) && numberFound) {
                break;
            }
            
            if (((ch <'0')||(ch>'9')) && signFound) {
                return 0;
            }
            
            if ((ch == ' ') && !numberFound) {
                continue;
            }
            
            if (((ch == '-' || ch == '+')) && !signFound) {
                sign = ch == '-' ? -1 : 1;
                signFound = true;
            }
            
            if ((ch >='0') && (ch<='9')) {
                numberFound=true;
                if (ch != '0') nonZeroFound = true;
                if (nonZeroFound) sb.append(ch);
            }
        }

        String result = sb.toString();
        //System.out.println("Final string is: " + result);
        
        if (result.length()==0){
            return 0;
        }

        if (result.length() > 11) {
            return sign >=0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } 
        
        
        long res = Long.parseLong(result);
        res *= sign;
        //System.out.println(res);
        
        
        if (res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if (res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int) res;
    }
    
    
    // Another interesting solution: 2ms 36MB
    public int myAtoi3(String s) {
        char[] a = s.trim().toCharArray();
        if (a.length == 0) return 0;
        int number = 0, n = a.length;
        int sign = a[0] == '+' ? 1 : a[0] == '-' ? -1 : 0;
        int i = sign == 1 || sign == -1 ? 1 : 0;
        for (; i<n; i++) {
            if (!Character.isDigit(a[i])) break;
            if (number > (Integer.MAX_VALUE + '0' -a[i]) / 10) return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            number = number * 10 + a[i] - '0';
        }
        return sign == -1 ? -number : number;
    }
    
    
    
}
