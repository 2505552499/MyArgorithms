package com.jiaxin.test;

import com.jiaxin.symbol.OrderSymbolTable;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> os = new OrderSymbolTable<>();
        os.put(1, "张三");
        os.put(2, "李四");
        os.put(4, "赵六");
        os.put(7, "田七");
        os.put(3, "王五");
    }
}
