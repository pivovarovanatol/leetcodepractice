package com.leetcode.algors.CourseScheduleII;
// https://leetcode.com/problems/course-schedule-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {
	// solved with topological sort. 57ms(not too fast, <6%). Perhaps worth combining checking for cycles and actual DFS.   
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Idea: topological sort. 
        int[] order =  new int[numCourses];
        
        // build a grapha as an adjacency list
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        // detect cycles. If any -> return empty array;
        for (int i=0;i<numCourses;i++){
            boolean[] added = new boolean[numCourses];
            boolean hasCycle = hasCycle(i, graph, added);
            if (!hasCycle) {
                //System.out.println("Has cycle!");
                return new int[0];
            };
        }
        
        Queue<Integer> list = new LinkedList<>();
        
        boolean[] visited = new boolean[numCourses];
        for (int i=0;i<numCourses;i++){
            if (visited[i]) continue;
            dfs(i, graph, visited, list);
        }
        
        int index=0;
        while(!list.isEmpty()){
            //System.out.println(list.remove());
            order[index] = list.remove();
            index++;
        }
        
        return order;
    }
    
    boolean hasCycle(int root, List[] graph, boolean[] added){
        if (added[root]) return false;
        added[root] = true;
        if (graph[root] != null){
            List<Integer> children = graph[root];
            for (int child : children){
                boolean hasCycle = hasCycle(child, graph, added);
                if (!hasCycle) return false;
            }
        }
        added[root] = false;
        return true;
    }
    
    void dfs(int root, List[] graph, boolean[] visited, Queue<Integer> list){
        if (visited[root]) return;
        visited[root] = true;
        List<Integer> children = graph[root];
        if (children != null){
            for (int child : children){
                dfs(child, graph, visited, list);
            }
        } 
        list.add(root);
    }
    
}

