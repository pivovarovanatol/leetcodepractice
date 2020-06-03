package com.leetcode.algors.CourseScheduleIV;
//https://leetcode.com/problems/course-schedule-iv/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class Solution {
	// from disc: DP + memoization. 14ms (<98%)
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] bb = new boolean[n][n];
        for(int[] p:prerequisites){
            bb[p[0]][p[1]] = true;
            for(int i=0; i<n; i++){
                if(bb[p[1]][i]) bb[p[0]][i]=true;
                if(bb[i][p[0]]) bb[i][p[1]]=true;
            }
        }
        List<Boolean> rst = new ArrayList<>();
        for(int[] q:queries)
            rst.add(bb[q[0]][q[1]]);   
        return rst;
    }
	
	// from disc: Topological Sort + Cache all prerequisites (similar idea)
    public List<Boolean> checkIfPrerequisite0(int n, int[][] prerequisites, int[][] queries) {
        int[] in = new int[n];
        HashSet<Integer>[] data = new HashSet[n];
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList();
            data[i] = new HashSet();
        }
        for(int[] e : prerequisites){
            graph[e[0]].add(e[1]);
            in[e[1]]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<n; i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                data[next].add(cur);
                data[next].addAll(data[cur]);
                if(--in[next]==0){
                    q.offer(next);
                }
            }
        }
        
        List<Boolean> res= new ArrayList();
        for(int[] query : queries){
            res.add(data[query[1]].contains(query[0]));
        }
        return res;
    }

    
	// from disc: Java Floyd-Warshal, 53ms (<74%)
	public List<Boolean> checkIfPrerequisite1(int n, int[][] prqs, int[][] qs) {
        boolean[][] prq = new boolean[n][n];
        for (int[] c : prqs) prq[c[0]][c[1]] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    prq[j][k] = prq[j][k] || (prq[j][i] && prq[i][k]);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : qs) res.add(prq[q[0]][q[1]]);
        return res;
    }
	
	
	// solved with graph, HashMap and dfs. 57ms(<59%)
    public List<Boolean> checkIfPrerequisite2(int n, int[][] prerequisites, int[][] queries) {
        // map of prerequisites as <Course, Set<Prerequisites>>
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        buildMap(prerequisites, map, n);
        List<Boolean> res = new ArrayList<>();
        
        for (int i=0;i<queries.length;i++){
            if (map.containsKey(queries[i][1])){
                if (map.get(queries[i][1]).contains(queries[i][0])) res.add(true);
                else res.add(false);
            } else {
                res.add(false);
            }
        }
        
        return res;
    }
    
    void buildMap(int[][] prerequisites, HashMap<Integer, HashSet<Integer>> map, int n){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        
        for (int i=0;i<prerequisites.length;i++){
            if (graph.containsKey(prerequisites[i][1])){
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], set);
            }
        }
        for (int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            dfs(i,set, graph);
            map.put(i,set);
        }
        return;
    }
    
    
    void dfs(int node, HashSet<Integer> set, HashMap<Integer, HashSet<Integer>> graph){
        if (!graph.containsKey(node)) return;
        //if (!set.contains(node)) {
        if (true) {
            HashSet<Integer> children = graph.get(node);
            for (int child : children){
            	if (!set.contains(child)) {
                    set.add(child);
                    dfs(child,set,graph);
            	}
            }
        }
        return;
    }
    
}