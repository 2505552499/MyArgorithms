package com.jiaxin.test;

import com.jiaxin.symbol.SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> s = new SymbolTable();
        s.put(1, "乔峰");
        s.put(2, "虚竹");
        s.put(3, "段誉");
        System.out.println("插入完毕后，元素个数为：" + s.size());

        s.put(2, "慕容复");
        System.out.println("替换完毕后，键2对应的值为：" + s.get(2));
        s.delete(2);
        System.out.println("删除完毕后，元素的个数为：" + s.size());
    }
}
