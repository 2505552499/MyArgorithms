package com.jiaxin.Heap;

public class HeapSort {
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void exch(Comparable[] heap, int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    private static void createHeap(Comparable[] source, Comparable[] heap){
        System.arraycopy(source, 0, heap, 1, source.length);
        for(int i = (heap.length / 2); i > 0; i--){
            sink(heap, i, heap.length - 1);
        }
    }

    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length +1];
        createHeap(source, heap);
        int N = heap.length - 1;
        while (N != 1){
            exch(heap, 1, N);
            N--;
            sink(heap, 1, N);
        }
        //把heap中的数据复制到源数据source中
        System.arraycopy(heap, 1, source, 0, source.length);

        //定义一个变量，记录未排序的元素中最大的索引

        //排序交换后最大元素所在的索引，让它不要参与堆的下沉调整

        //需要堆索引1出的元素进行堆的下沉调整
    }

    private static void sink(Comparable[] heap, int target, int range){
        while(2 * target <= range){
            int max;
            if(2 * target + 1 <= range){
                if(less(heap, 2 * target, 2 * target + 1)){
                    max = 2 * target + 1;
                }else{
                    max = 2 * target;
                }
            }else {
                max = 2 * target;
            }
            if(!less(heap, target, max)){
                break;
            }
            exch(heap, target, max);
            target = max;
        }
    }
}
