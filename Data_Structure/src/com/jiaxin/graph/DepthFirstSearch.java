package com.jiaxin.graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph G, int s){
        //初始化marked数组
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G, s);
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G, w);
            }
        }
        count++;
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
}
