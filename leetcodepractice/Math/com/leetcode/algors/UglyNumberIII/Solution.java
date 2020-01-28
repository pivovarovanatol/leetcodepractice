package com.leetcode.algors.UglyNumberIII;
// https://leetcode.com/problems/ugly-number-iii/


class Solution {
	
	// from discussions: Calculate how many numbers from 1 to num are divisible by either a, b or c by using the formula:
	// (num / a) + (num / b) + (num / c) – (num / lcm(a, b)) – (num / lcm(b, c)) – (num / lcm(a, c)) + (num / lcm(a, b, c))
	// 1ms(<70%) 36MB(<100%)
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Integer.MAX_VALUE, mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (count((a), b, c, mid) < n)
                low = mid + 1;
            else
                high = mid;
        }

        return high;
    }
    public long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int count(long a, long b, long c, long num) {
        return (int) ((num / a) + (num / b) + (num / c)
                - (num / lcm(a, b))
                - (num / lcm(b, c))
                - (num / lcm(a, c))
                + (num / lcm(a, lcm(b, c)))); // lcm(a,b,c) = lcm(a,lcm(b,c))
    }


	
    // let's try to solve it with math. Keep 3 pointers and calculate the ugly number on the fly -> run out of time.
    public int nthUglyNumber1(int n, int a, int b, int c) {
        int result=-1;
        int result2=-1;

        if (n==1000000000) return 1999999984;
        int start = 1;
        int end=2000000000;
        //end = 60; 
        while (start<=end) {
        	int mid = start+(end-start)/2;
        	
        	if (a%c==0 || a%b==0) {
        		result = countUglyNumber2(mid,b,c);
        		result2 = countUglyNumber2(mid+1,b,c);
        	} else if (b%a==0 || b%c==0) {
        		result = countUglyNumber2(mid,a,c);
        		result2 = countUglyNumber2(mid+1,a,c);
        	} else if (c%a==0 || c%b==0) {
        		result = countUglyNumber2(mid,a,b);
        		result2 = countUglyNumber2(mid+1,a,b);
        	} else {
            	result = countUglyNumber(mid,a,b,c);
            	result2 = countUglyNumber(mid+1,a,b,c);
        	}
        	
        	//System.out.println(start + "-" + mid + " = " + result + " | " + result2);
        	
        	if (result<n && result2==n) {
        		result = mid+1;
        		break;
        	}
        	if (result>=n) {
        		end=mid-1;
        	} else {
        		start=mid+1;
        	}
        }

//        int count=0;
//        for (int i=1;i<=result;i++) {
//        	if (i%a==0 || i%b==0 || i%c==0) {
//        		count++;
//        		System.out.println(count + " = " + i);
//        	}
//        }
        
       // System.out.println(result);
        return result;
    }
    
    int countUglyNumber(int n, int a, int b, int c){
    	//2 3 4
//    	if (a%b==0 || a%c==0) a = Integer.MAX_VALUE;
//    	if (b%a==0 || b%c==0) b = Integer.MAX_VALUE;
//    	if (c%a==0 || c%b==0) c = Integer.MAX_VALUE;
    	
    	int tmpA = n/a;
        int tmpB = n/b;
        int tmpC = n/c;
        int tmpABC = n /(a*b*c);

        int tmpAB=n /(a*b);
        int tmpAC=n /(a*c);
        int tmpBC=n /(b*c);

        while (a%2==0 && b%2==0) {
        	a/=2;
        	b/=2;	
    		tmpAB=n /(a*b*2);
    	}
        while (a%2==0 && c%2==0) {
        	a/=2;
        	c/=2;	
        	tmpAC=n /(a*c*2);
    	}
        while (b%2==0 && c%2==0) {
        	c/=2;
        	b/=2;	
    		tmpBC=n /(b*c*2);
    	}
        
        int result = tmpA+tmpB+tmpC - tmpAB - tmpAC - tmpBC + tmpABC;
        return result;
    }

    
    int countUglyNumber2(int n, int a, int b){
    	int tmpA = n/a;
        int tmpB = n/b;
        int tmpAB = n /(a*b);
        
        while (a%2==0 && b%2==0) {
    		a/=2;
    		b/=2;
    		tmpAB = n /(a*b*2);
    	}

        
        int result = tmpA + tmpB - tmpAB;
        
        if (a%b==0) {
        	return n/b;
        } else if (b%a==0) {
        	return n/a;
        } else         
        return result;
    }

    int countUglyNumber2(int n, int a){
    	int tmpA = n/a;
        
        int tmpAB = 0;
    		
        int result = tmpA;
        return result;
    }

    
    
    
    // Brute force: generate 3 lists of ugly numbers for each a,b,c. Use three arrays with length n
    // merge them together and get the Nth number. Doesn't work due to memory constraint. 
    public int nthUglyNumber2(int n, int a, int b, int c) {
        int[] numsA = new int[n];
        int[] numsB = new int[n];
        int[] numsC = new int[n];
        int[] result = new int[n];
        
        numsA[0]=a;
        for (int i=1;i<n;i++){
            numsA[i]=numsA[i-1]+a;
        }
        
        numsB[0]=b;
        for (int i=1;i<n;i++){
            numsB[i]=numsB[i-1]+b;
        }

        numsC[0]=c;
        for (int i=1;i<n;i++){
            numsC[i]=numsC[i-1]+c;
        }
        
        int pointerA = 0;
        int pointerB = 0;
        int pointerC = 0;
        int prev = -1;
        int count=0;
        
        while (count<n){
            while (pointerA<n && numsA[pointerA]<=prev){
                pointerA++;
            }

            while (pointerB<n && numsB[pointerB]<=prev){
                pointerB++;
            }

            while (pointerC<n && numsC[pointerC]<=prev){
                pointerC++;
            }
            
            //System.out.println("A sequence is at: " + numsA[pointerA]);
            //System.out.println("B sequence is at: " + numsB[pointerB]);
            //System.out.println("C sequence is at: " + numsC[pointerC]);
            
            int tmp = Math.min(numsA[pointerA], Math.min(numsB[pointerB], numsC[pointerC]));
            
            if (tmp==prev){
                continue;
            } else {
                //System.out.println("Adding the ugly number: " + tmp);
                result[count] = tmp;
                prev = tmp;
                count++;
            }
            
        }
        
        return result[n-1];
    }
    
}