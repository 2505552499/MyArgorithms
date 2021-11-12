package com.jiaxin.symbol;

import java.util.Iterator;

public class SymbolTable<Key, Value> implements Iterable<Key>{
    private Node head;
    private int N;



    private class Node{
        public Key key;
        public Value value;
        public Node next;
        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SymbolTable(){
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public void put(Key key, Value value){
        Node n = head;
        while(n.next != null){
            n = n.next;
            if(n.key.equals(key)){
                n.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;
        N++;
    }

    public void delete(Key key){
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value get(Key key){
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

    @Override
    public Iterator<Key> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private Node n;

        public SIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.value;
        }
    }
}
