package com.leetcode.algors.RectangleArea;
// https://leetcode.com/problems/rectangle-area/

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;
        //int area1 = Math.abs(C-A) * Math.abs(D-B);
        //int area2 = Math.abs(G-E) * Math.abs(H-F);
        // get the X diff
        if (A < E) {
            startX = E;
        } else {
            startX = A;
        }
            
        if (C < G) {
            endX = C;
        } else {
            endX = G;
        }
            
        // get the Y diff
        if (B < F) {
            startY = F;
        } else {
            startY = B;
        }
            
        if (D < H) {
            endY = D;
        } else {
            endY = H;
        }
        
        //System.out.println("Start X: " + startX + " Start Y: " + startY + " End X: " + endX + " End Y: " + endY);
        int overlap = 0;
        
        if (startX < endX && startY < endY) {
            overlap = Math.abs(endX-startX) * Math.abs(endY - startY);
        }
        //System.out.println("Area 1: " + area1 + " Area 2: " + area2 + " Overlap: " + overlap);
        
        overlap = overlap < 0 ? 0 : overlap;
        // Multiply to get diff
        int area = Math.abs(C-A) * Math.abs(D-B) + Math.abs(G-E) * Math.abs(H-F) - overlap;
        
        return area;
    }
}
