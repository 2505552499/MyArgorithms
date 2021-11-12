package com.jiaxin.Heap;

public class Heap<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }
    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    private void swim(int k){
        //通过循环不断的比较当前结点的值和其父节点的值，如果发现父结点的值比
        while(k > 1){
            //比较当前节点和其父节点
            if(less(k / 2, k)){
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    public T delMax(){
        T max = items[1];
        //交换索引1出的元素和最大索引出的元素，让完全二叉树中最右侧的元素变为临时根节点
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    private void sink(int k){
        //通过循环不断的对比当前结点和左子节点和右子结点中的较大值
        while(2 * k <= N){
            int max;
            if(2 * k + 1 <= N){
                if(less(2 * k, 2 * k + 1)){
                    max = 2 * k + 1;
                }else{
                    max = 2 * k;
                }
            }else{
                max = 2 * k;
            }
            if(!less(k, max)){
                break;
            }
            exch(k, max);
            k = max;
        }
    }

}
