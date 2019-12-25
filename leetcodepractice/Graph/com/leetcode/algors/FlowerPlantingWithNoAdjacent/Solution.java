package com.leetcode.algors.FlowerPlantingWithNoAdjacent;
// https://leetcode.com/problems/flower-planting-with-no-adjacent/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;


class Solution {
	
	// From discussions2: Need to understand on example. 10ms(<97%) 46MB(<100%)
	public int[] gardenNoAdj(int n, int[][] paths) {
        int[] result = new int[n];
        Arrays.fill(result, 1);
        boolean stop = false;
        do {
            stop = true;
            for(int[] edge: paths) {
                int u = Math.min(edge[0], edge[1]);
                int v = Math.max(edge[0], edge[1]);
                if (result[u - 1] == result[v - 1]) {
                    stop = false;
                    result[v - 1] = result[v - 1] == 4 ? 1 : result[v - 1] + 1;
                }
            }
        }
        while(!stop);
        return result;
    }	

	
	// From discussions. 23ms(<75%) 47MB(<100%)
	    int[] flowers;
	    ArrayList<Integer>[] graph;
	    
	    public int[] gardenNoAdj3(int N, int[][] paths) {
	        flowers = new int[N + 1];
	        graph = new ArrayList[N + 1];
	        // initialize
	        for (int i = 1; i <= N; i++) {
	            graph[i] = new ArrayList<>();
	        }
	        // build graph
	        for (int[] path : paths) {
	            graph[path[0]].add(path[1]);
	            graph[path[1]].add(path[0]);
	        }
	        // traverse
	        for (int i = 1; i <= N; i++) {
	            plantFlower(i);
	        }
	        // gardens start at index 1 instead of 0 so shift before returning
	        int[] r = new int[N];
	        for (int i = 1; i <= N; i++) {
	            r[i - 1] = flowers[i];
	        }
	        return r;
	    }
	    
	    private void plantFlower(int gardenNum) {
	        // base case
	        if (flowers[gardenNum] != 0) return;
	        
	        List<Integer> garden = graph[gardenNum];
	        List<Integer> edgeFlowers = new ArrayList<>();
	        // get the flowers already planted in neighboring gardens
	        for (Integer edge : garden) {
	            edgeFlowers.add(flowers[edge]);
	        }
	        // plant unused flower in current garden
	        for (int i = 1; i <= 4; i++) {
	            if (!edgeFlowers.contains(i)) flowers[gardenNum] = i;
	        }
	        // dfs
	        for (Integer edge : garden) {
	            plantFlower(edge);
	        }
	    }
	
	
	// Solved with Adj List as a HashMap and DFS. 34ms(<57%) 55MB(<100%)
    public int[] gardenNoAdj2(int N, int[][] paths) {
        // Lets try to solve it with adj list (HashMap) and array of colors
        // First - create adj list
        
        HashMap<Integer, List<Integer>> gardens = new HashMap<>();
        
        for (int i=1;i<=N;i++){
            gardens.put(i, new ArrayList<Integer>());
        }
        
        for (int i=0;i<paths.length;i++){
            gardens.get(paths[i][0]).add(paths[i][1]);
            gardens.get(paths[i][1]).add(paths[i][0]);
        }        
        
        int[] result = new int[N];
        Map<Integer, Integer> colors = new HashMap<>();
        for (int i=1; i<=N; i++) {
            dfs(i, gardens, colors, result);    
        }
        
        return result;
    }
    
    public void dfs(int garden, HashMap<Integer, List<Integer>> gardens, Map<Integer, Integer> colors, int[] result){
        // base case - check if garden already has a color - return
        if (result[garden-1] > 0) return;
        
        if (gardens == null){
            return;
        }
        
        // Check what colors are used by neighbors. Iterate over neighbors and put the color in the Set
        boolean[] used = new boolean[4];
        for (int neighbor : gardens.get(garden)) {
            if (result[neighbor-1]>0) {
                used[result[neighbor-1]-1]=true;
            }
        }
        
        // Check what color hasn't been used so far and put that as a color for current garden
        for (int i=1; i<=4; i++) {
            if (!used[i-1]) {
                result[garden-1] = i;
                break;
            }
        }
        
        // Recurse for every neighbor
        for (int neighbor: gardens.get(garden)) {
            if (result[neighbor-1]==0) {
                dfs(neighbor, gardens, colors, result);
            }
        }
    }
    
}
