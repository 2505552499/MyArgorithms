package com.jiaxin.test;

import com.jiaxin.graph.BreadthFirstSearch;
import com.jiaxin.graph.DepthFirstSearch;
import com.jiaxin.graph.Graph;

public class BreadthFirstSearchTest {
    public static void main(String[] args) {
        Graph G = new Graph(13);
        G.addEdge(0, 5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 6);
        G.addEdge(5, 3);
        G.addEdge(5, 4);
        G.addEdge(3, 4);
        G.addEdge(4, 6);
        G.addEdge(7, 8);
        G.addEdge(9, 11);
        G.addEdge(9, 10);
        G.addEdge(9, 12);
        G.addEdge(11, 12);
        BreadthFirstSearch search = new BreadthFirstSearch(G, 0);
        int count = search.count();
        System.out.println("与起点0想通的顶点数量为：" + count);
        boolean marked1 = search.marked(5);
        System.out.println(marked1);
        boolean marked2 = search.marked(7);
        System.out.println(marked2);
    }
}
