package com.leetcode.algors.AlphabetBoardPath;
// https://leetcode.com/problems/alphabet-board-path/

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class Solution {
	
	
	// from discussion: work with indexes. 1 ms (<53%)
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int prevX = 0, prevY = 0;
        char prevC = 'a';
        for(char c : target.toCharArray()) {
            int curY = (c - 'a')/5, curX = (c - 'a')%5;
            int deltaX = curX - prevX, deltaY = curY - prevY;
            String mX = "", mY = "";
            for(int i = 0; i < Math.abs(deltaY); i++) mY += deltaY > 0 ? "D" : "U";
            for(int i = 0; i < Math.abs(deltaX); i++) mX += deltaX > 0 ? "R" : "L";
            sb.append(prevC == 'z' ? mY + mX : mX + mY).append("!");
            prevX = curX;
            prevY = curY;
            prevC = c;
        }
        return sb.toString();
    }
	
	// Solved with BFS and shortest path. 10 ms(<9%)
    public String alphabetBoardPath2(String target) {
        char[][] board = {{'a','b','c','d','e'},
                           {'f','g','h','i','j'},
                           {'k','l','m','n','o'},
                           {'p','q','r','s','t'},
                           {'u','v','w','x','y'},
                           {'z','-','-','-','-'},
                          };
        int[] a = {0,0};
        String path = findPath(board, a, target);
        
        return path;
    }
    
    String findPath(char[][] board, int[] start, String target){
        String path = "";
        for (int i=0;i<target.length();i++){
            boolean[][] visited = new boolean[6][5];
            path += bfs(board, start, target.charAt(i), visited);
        }
        return path;
    }
    
    String bfs(char[][] board, int[] start, char ch, boolean[][] visited){
        String path = "";
        int length = 0;
        Queue<Integer> rows = new ArrayDeque<Integer>();
        Queue<Integer> cols = new ArrayDeque<Integer>();
        HashMap<Character, Character> prevCh = new HashMap<>();
        HashMap<Character, Character> direction = new HashMap<>();
        
        int r=start[0];
        int c=start[1];
        char[] prev = new char[26];
        int[] colsAdd = {0,1,0,-1};
        int[] rowsAdd = {1,0,-1,0};
        char startCh = board[r][c];
        rows.add(r);
        cols.add(c);
        visited[r][c]=true;
        prevCh.put(board[r][c], board[r][c]);
        
        while (rows.size()>0){
            int currRow = rows.remove();
            int currCol = cols.remove();
            
            // if found - exit loop!
            if (board[currRow][currCol] == ch){
                start[0]=currRow;
                start[1]=currCol;
                break;
            }
            
            for (int i=0;i<colsAdd.length;i++) {
            	int newRow = currRow + rowsAdd[i];
            	int newCol = currCol + colsAdd[i];
            	if (newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length || board[newRow][newCol] == '-') continue;
                if (!visited[newRow][newCol]) {
                    rows.add(newRow);
                    cols.add(newCol);
                    visited[newRow][newCol]=true;
                    //prev[board[newRow][newCol]-'a'] =  board[currRow][currCol];
                    prevCh.put(board[newRow][newCol], board[currRow][currCol]);
                    char dir=' ';
                    if (rowsAdd[i]==1) dir = 'D';
                    else if (rowsAdd[i]==-1) dir = 'U';
                    else if (colsAdd[i]==-1) dir = 'L';
                    else if (colsAdd[i]==1) dir = 'R';
                    direction.put(board[newRow][newCol], dir);
                }
            }
        }

        
        //System.out.println("Found path from " + startCh + " to " + ch + " with length=" + length);
        StringBuilder sb = new StringBuilder();
        sb.append('!');
        while (ch != startCh && prevCh.containsKey(ch)) {
        	path += ch + " <-";
        	char dir = direction.get(ch);
        	sb.append(dir);
        	ch = prevCh.get(ch);
        }
        path += ch;    
        //sb.append(direction.get(ch));
        //System.out.println("Reverse path is " + path);
        path = sb.reverse().toString();
        //System.out.println("Directions are " + path);
        
        return path;
    }
    
}