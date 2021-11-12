package com.jiaxin.graph;

import com.jiaxin.linear.Queue;

public class Graph {
    private final  int V;
    private int E;
    private Queue<Integer>[] adj;
    public Graph(int v){
        //初始化顶点数量
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for(int i = 0; i  < adj.length; i++){
            adj[i] = new Queue<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v, int w){
        adj[v].enqueuq(w);
        adj[w].enqueuq(v);
        E++;
    }
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
