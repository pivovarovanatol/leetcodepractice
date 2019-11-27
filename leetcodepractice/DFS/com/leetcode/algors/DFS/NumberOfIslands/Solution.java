package com.leetcode.algors.DFS.NumberOfIslands;
// https://leetcode.com/problems/number-of-islands/

class Solution {
	
	// from discussions. Same idea, but modifies initial grid. 1ms (<100%) 41.1MB(<72%)
    int island_number = 0;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid,m,n);
                    island_number++;
                }
            }
        }
        return island_number;
    }
    
    public void dfs(int i,int j,char[][] grid,int m,int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1') return;
        grid[i][j]='2';
        //up
        dfs(i-1,j,grid,m,n);
        //down
        dfs(i+1,j,grid,m,n);
        //left
        dfs(i,j-1,grid,m,n);
        //right
        dfs(i,j+1,grid,m,n);
    }
	
	
	
	
	// solved in 2ms (<44%) 41MB(<74%)
    public int numIslands2(char[][] grid) {
        //scan over the grid for not visited nodes and for each node check all 4 dimensions if they are ending with water. 
        // If yes - then current node is part of the island - increase the counter by one and go to the next node. 
        // Since every node will be visited exactly one time, therefore complexity should be O(MxN)

        if (grid.length == 0){
            return 0;
        }
        
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[height][width];
        int count = 0;
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if (visited[i][j]){
                    continue;
                }
                //System.out.println("Checking node at: " + i + " and " + j);
                //start checking for the land
                if (grid[i][j] == '1'){
                    if (checkNodeHelper(grid, i, j, height, width, visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    boolean checkNodeHelper(char[][] grid, int y, int x, int height, int width, boolean[][] visited){
        // if current coordinates is out of bounds -> water -> return TRUE
        if (y<0 || y > height-1 || x < 0 || x > width-1){
            return true;
        }
        if (visited[y][x]){
            return true;
        }
        
        visited[y][x]=true;
        // if current coordinates is in the water -> water -> return TRUE
        if (grid[y][x] == '0'){
            return true;
        } else {
            boolean up = checkNodeHelper(grid, y-1, x, height, width, visited);
            boolean down = checkNodeHelper(grid, y+1, x, height, width, visited);
            boolean left = checkNodeHelper(grid, y, x-1, height, width, visited);
            boolean right = checkNodeHelper(grid, y, x+1, height, width, visited);
            return up || down || left || right;
        }
    }
}