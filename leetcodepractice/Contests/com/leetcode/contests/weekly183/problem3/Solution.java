package com.leetcode.contests.weekly183.problem3;

import java.util.PriorityQueue;

class Solution {
	
	// 100% from discussions.
    int a1, b1, c1;
    String res = "";
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder("");
        a1 = a;
        b1 = b;
        c1 = c;
        helper(sb, 0);
        
        return res;
    }
    
    public void helper(StringBuilder sb, int index){
        if(sb.length() > res.length()){
            res = sb.toString();
        }
        if(index < 2 || sb.charAt(index - 1) != sb.charAt(index - 2)){
            if(a1 > 0 && a1 >= Math.max(b1, c1)){
                sb.append("a");
                a1--;
                helper(sb, index + 1);
                sb.setLength(sb.length() - 1);
                a1++;
            }else if(b1 > 0 && b1 >= Math.max(a1, c1)){
                sb.append("b");
                b1--;
                helper(sb, index + 1);
                sb.setLength(sb.length() - 1);
                b1++;
            }else if(c1 > 0 && c1 >= Math.max(a1, b1)){
                sb.append("c");
                c1--;
                helper(sb, index + 1);
                sb.setLength(sb.length() - 1);
                c1++;
            }
        }else{
            char lastChar = sb.charAt(sb.length() - 1);
            if(lastChar == 'a'){
                if(b1 > 0 && b1 >= c1){
                    sb.append("b");
                    b1--;
                    helper(sb, index + 1);
                    sb.setLength(sb.length() - 1);
                    b1++;
                }else if(c1 > 0){
                    sb.append("c");
                    c1--;
                    helper(sb, index + 1);
                    sb.setLength(sb.length() - 1);
                    c1++;
                }
            }else if(lastChar == 'b'){
                if(a1 > 0 && a1 >= c1){
                    sb.append("a");
                    a1--;
                    helper(sb, index + 1);
                    sb.setLength(sb.length() - 1);
                    a1++;
                }else if(c1 > 0){
                    sb.append("c");
                    c1--;
                    helper(sb, index + 1);
                    sb.setLength(sb.length() - 1);
                    c1++;
                }
            }else if(lastChar == 'c'){
                if(a1 > 0 && a1 >= b1){
                    sb.append("a");
                    a1--;
                    helper(sb, index + 1);
                    sb.setLength(sb.length() - 1);
                    a1++;
                }else if(b1 > 0){
                    sb.append("b");
                    b1--;
                    helper(sb, index + 1);
                    sb.setLength(sb.length() - 1);
                    b1++;
                }
            }
        }
    }
	
    public String longestDiverseString1(int a, int b, int c) {
        PriorityQueue<char[]> pq= new PriorityQueue<>((l,m)->(l[1]-'0'==m[1]-'0'?l[0]-m[0]:(m[1]-'0')-(l[1]-'0')));
        if(a!=0)pq.offer(new char[]{'a',(char)(a+'0')});
        if(b!=0)pq.offer(new char[]{'b',(char)(b+'0')});
        if(c!=0)pq.offer(new char[]{'c',(char)(c+'0')});
        String string = "";
        int count=0;
        while(!pq.isEmpty()){
            char[] first = pq.poll();
			//This is a flag that is used to check whether the same character is at the end or not.
			//If it is the same character then we can't append this character two more times,
			//since that will create three consecutive alphates of the same characters. Otherwise we can!
            boolean dont = false;
            if(string.length()!=0&&string.charAt(string.length()-1)==first[0])dont=true;
            string +=first[0];
            int temp = first[1]-'0';
            temp--;
            count++;
            if(!dont&&temp>0){
                 string +=first[0];
                temp--;count++;
            }
            first[1]=(char)(temp+'0');
            if(pq.isEmpty())break;
            char[] second = pq.poll();
            string +=second[0];
            temp = second[1]-'0';
            temp--;
            count++;
            second[1]=(char)(temp+'0');
            char[] third = new char[]{'0','0'};
            if(!pq.isEmpty()&&count!=3){
                third = pq.poll();
                System.out.println(third[0]+" "+third[1]+" "+count);
                string +=third[0];
                temp = third[1]-'0';
                temp--;
                third[1]=(char)(temp+'0');
            }
            count=0;
            if(first[1]-'0'!=0){
                pq.offer(first);
            }
            if(second[1]-'0'!=0){
                pq.offer(second);
            }
            if(third[1]-'0'!=0){
                pq.offer(third);
            }
        }
        return string;
    }
}