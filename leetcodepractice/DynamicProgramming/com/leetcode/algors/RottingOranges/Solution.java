package com.leetcode.algors.RottingOranges;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	// from discussions: 3ms(<53%)
    public int orangesRotting(int[][] g) {
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < g[0].length; j++) {
                if(g[i][j] == 2) q.offer(new int[]{i, j});
                if(g[i][j] == 1) freshCount++;
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int t = -1;
        while(!q.isEmpty()) {
            t++;
            for(int size = q.size(); size > 0; size--) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if(x >= 0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] == 1) {
                        q.offer(new int[]{x, y});
                        g[x][y] = 2;
                        freshCount--;
                    }
                }
            }
        }
        
        if(freshCount > 0) return -1;
        return t == -1 ? 0 : t;
    }
    
    // solved with BFS. 4ms(<30%) 39MB(<81%)
    public int orangesRotting2(int[][] grid) {
        // idea: search for 1 and perform BFS from there to get the shortest path to 2 -> time needed totun rotten. Get the max shortest path.
        int maxPath=0;        
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    int shortestPath = bfs(grid, i, j);
                    //System.out.println("From " + i + "|"+j + " = " + shortestPath);
                    if (shortestPath==-1) return -1;
                    if (shortestPath > maxPath) maxPath = shortestPath;
                }
            }
        }
        return maxPath;
    }
    
    int bfs(int[][] grid, int row, int column){
        int count = -1;
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        queue1.add(row);
        queue1.add(column);
        boolean[] visited = new boolean[grid.length * grid[0].length];
        
        while (!queue1.isEmpty()){
            int r = queue1.remove();
            int c = queue1.remove();
            
            if (grid[r][c]==2) return count+1;
            if (grid[r][c]==0) continue;
            
            // top
            if ((r-1>=0) && (!visited[(r-1)*grid[0].length+c]) && (grid[r-1][c]!=0)) {
                queue2.add(r-1); 
                queue2.add(c); 
                visited[(r-1)*grid[0].length+c]=true;
            }
            // left
            if ((c-1>=0) && (!visited[(r)*grid[0].length+c-1]) && (grid[r][c-1]!=0)) {
                queue2.add(r); 
                queue2.add(c-1); 
                visited[(r)*grid[0].length+c-1]=true;
            }
            // down
            if ((r+1<grid.length) && (!visited[(r+1)*grid[0].length+c]) && (grid[r+1][c]!=0)) {
                queue2.add(r+1); 
                queue2.add(c); 
                visited[(r+1)*grid[0].length+c]=true;
            }
            // right
            if ((c+1<grid[0].length) && (!visited[(r)*grid[0].length+c+1]) && (grid[r][c+1]!=0)) {
                queue2.add(r); 
                queue2.add(c+1); 
                visited[(r)*grid[0].length+c+1]=true;
            }           
        	
            if (queue1.isEmpty()){
                count++;
                queue1=queue2;
                queue2 = new ArrayDeque<Integer>();
            }
        }
        
        return -1;
    }
}

