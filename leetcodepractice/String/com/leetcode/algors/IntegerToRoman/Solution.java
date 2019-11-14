package com.leetcode.algors.IntegerToRoman;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    
	
	// No loop, no mod, no division, no setting up a complicated table, just some ifs and subtraction. 3ms(<100%) 36MB(<100%)
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= 2000){ sb.append("MM"); num -= 2000;}
        if(num >= 1000){ sb.append("M"); num -= 1000;}
        if(num >= 900){ sb.append("CM"); num -= 900;}
        if(num >= 500){ sb.append("D"); num -=500;}
        if(num >= 400){ sb.append("CD"); num -=400;}
        if(num >= 200){ sb.append("CC"); num -=200;}
        if(num >= 100){ sb.append("C"); num -=100;}
        if(num >= 90){ sb.append("XC"); num -=90;}
        if(num >= 50){ sb.append("L"); num -=50;}
        if(num >= 40){ sb.append("XL"); num -=40;}
        if(num >= 20){ sb.append("XX"); num -=20;}
        if(num >= 10){ sb.append("X"); num -=10;}
        if(num >= 9){ sb.append("IX"); num -=9;}
        if(num >= 5){ sb.append("V"); num -=5;}
        if(num >= 4){ sb.append("IV"); num -=4;}
        if(num >= 2){ sb.append("II"); num -=2;}
        if(num == 1){ sb.append("I"); num -=1;}
        return sb.toString();
    }
	
	// Solution with StringBuilder;
    public String intToRoman0(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            sb.append("M");
            num -= 1000;
        } 
        if (num >= 900) {
            sb.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            sb.append("D");
            num -= 500;
        }
        while (num >= 400) {
            sb.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            sb.append("C");
            num  -= 100;
        }
        while (num >= 90) {
            sb.append("XC");
            num  -= 90;
        }
        while (num >= 50) {
            sb.append("L");
            num  -= 50;
        }
        while (num >= 40) {
            sb.append("XL");
            num  -= 40;
        } 
        while (num >= 10) {
            sb.append("X");
            num  -= 10;
        }
        while (num >= 9) {
            sb.append("IX");
            num  -= 9;
        }
        while (num >= 5) {
            sb.append("V");
            num  -= 5;
        }
        while (num >= 4) {
            sb.append("IV");
            num  -= 4;
        }
        while (num >= 1) {
            sb.append("I");
            num  -= 1;
        }
        return new String(sb);
    }
    
    
    // Solution with map and loop -> 13 ms (<5.50%) 42MB(<10%)
    public String intToRoman1(int num) {
        String result="";
        Map<Integer, String> mp = new HashMap<>();
        mp.put(1000, "M");
        mp.put(900, "CM");
        mp.put(500, "D");
        mp.put(400, "CD");
        mp.put(100, "C");
        mp.put(90, "XC");
        mp.put(50, "L");
        mp.put(40, "XL");
        mp.put(10, "X");
        mp.put(9, "IX");
        mp.put(5, "V");
        mp.put(4, "IV");
        mp.put(1, "I");
        
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(1, 1000);
        numbers.put(2, 900);
        numbers.put(3, 500);
        numbers.put(4, 400);
        numbers.put(5, 100);
        numbers.put(6, 90);
        numbers.put(7, 50);
        numbers.put(8, 40);
        numbers.put(9, 10);
        numbers.put(10, 9);
        numbers.put(11, 5);
        numbers.put(12, 4);
        numbers.put(13, 1);
        
        for (int count : numbers.keySet()){
            
            int key = numbers.get(count);
            int n = num / key;
            
            for (int i=0;i<n;i++){
                result+=mp.get(key);                
            }
            num%=key;
        }
        return result;
    }
    
    
    
    
    // Naive solution - 29ms (<5.49%) 39MB(<22.5%)    
    public String intToRoman2(int num) {
        
        String result="";

        int n = num / 1000;
        result = result + IntStream.range(0, n).mapToObj(i->"M").collect(Collectors.joining(""));
        num%=1000;
        
        //System.out.println(n);
        
        n = num / 900;
        result = result + IntStream.range(0, n).mapToObj(i->"CM").collect(Collectors.joining(""));
        num%=900;
        
        n = num / 500;
        result = result + IntStream.range(0, n).mapToObj(i->"D").collect(Collectors.joining(""));
        num%=500;
        
        n = num / 400;
        result = result + IntStream.range(0, n).mapToObj(i->"CD").collect(Collectors.joining(""));
        num%=400;
        
        n = num / 100;
        result = result + IntStream.range(0, n).mapToObj(i->"C").collect(Collectors.joining(""));
        num%=100;
        
        n = num / 90;
        result = result + IntStream.range(0, n).mapToObj(i->"XC").collect(Collectors.joining(""));
        num%=90;
        
        n = num / 50;
        result = result + IntStream.range(0, n).mapToObj(i->"L").collect(Collectors.joining(""));
        num%=50;
        
        n = num / 40;
        result = result + IntStream.range(0, n).mapToObj(i->"XL").collect(Collectors.joining(""));
        num%=40;
        
        n = num / 10;
        result = result + IntStream.range(0, n).mapToObj(i->"X").collect(Collectors.joining(""));
        num%=10;
        
        n = num / 9;
        result = result + IntStream.range(0, n).mapToObj(i->"IX").collect(Collectors.joining(""));
        num%=9;
        
        n = num / 5;
        result = result + IntStream.range(0, n).mapToObj(i->"V").collect(Collectors.joining(""));
        num%=5;
        
        n = num / 4;
        result = result + IntStream.range(0, n).mapToObj(i->"IV").collect(Collectors.joining(""));
        num%=4;
        
        n = num / 1;
        result = result + IntStream.range(0, n).mapToObj(i->"I").collect(Collectors.joining(""));
        

        
        return result;
    }
}

