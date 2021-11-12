package com.jiaxin.test;

import com.jiaxin.linear.LinkList;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> s1 = new LinkList<>();
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1, "詹姆斯");

        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("----------------------------");
        String getResult = s1.get(1);
        System.out.println("索引1处的结果为:" + getResult);
        String removeResult = s1.remove(0);
        System.out.println("删除的元素是:" + removeResult);
        s1.clear();
        System.out.println("清空后的链表元素个数为:" + s1.length());

    }
}
