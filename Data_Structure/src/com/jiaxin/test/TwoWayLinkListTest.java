package com.jiaxin.test;

import com.jiaxin.linear.LinkList;
import com.jiaxin.linear.TwoWayLinkList;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        TwoWayLinkList<String> s1 = new TwoWayLinkList<>();
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1, "詹姆斯");

        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("-----------------------");
        System.out.println("反转后的元素是:");
        s1.reverse();
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("第一个元素是:" + s1.getFirst());
        System.out.println("最后一个元素是:" + s1.getLast());
        System.out.println("----------------------------");
        String getResult = s1.get(1);
        System.out.println("索引1处的结果为:" + getResult);
        String removeResult = s1.remove(0);
        System.out.println("删除的元素是:" + removeResult);
        s1.clear();
        System.out.println("清空后的链表元素个数为:" + s1.length());
        System.out.println("-----------------------------");


    }
}
