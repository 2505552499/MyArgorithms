package com.jiaxin.graph;

import com.jiaxin.linear.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;
    int count = 0;
    private Queue<Integer> waitSearch;
    public BreadthFirstSearch(Graph G, int s){
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new Queue<>();
        bfs(G, s);
    }
    private void bfs(Graph G, int v){
        marked[v] = true;
        waitSearch.enqueuq(v);
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            for (Integer w : G.adj(wait)) {
                if(!marked[w]){
                    bfs(G, w);
                }
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
