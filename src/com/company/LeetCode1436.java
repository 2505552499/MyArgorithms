package com.company;

import java.util.*;

public class LeetCode1436 {
    public static void main(String[] args) {
        List<String> path1 = new ArrayList<>();
        path1.add("B");
        path1.add("C");
        List<String> path2 = new ArrayList<>();
        path2.add("D");
        path2.add("B");
        List<String> path3 = new ArrayList<>();
        path3.add("C");
        path3.add("A");
        List<List<String>> paths = new ArrayList<>();
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        String ans = destCity(paths);
        System.out.println(ans);
    }

    public static String destCity(List<List<String>> paths){
        HashMap<String, String> hm = new HashMap<>();
        String ans = "";
        for (List<String> path : paths) {
            hm.put(path.get(0), path.get(1));
        }
        Set<String> keySet = hm.keySet();
        for (String key : keySet) {
            if(!keySet.contains(hm.get(key))){
                ans = ans + hm.get(key);
            }
        }
        return ans;
    }
}
