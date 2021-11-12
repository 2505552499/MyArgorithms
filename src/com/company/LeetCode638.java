package com.company;

import java.util.*;
import java.util.stream.Collector;

public class LeetCode638 {
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<Integer>();
        Collections.addAll(price,1,1,1);

        List<List<Integer>> special = new ArrayList<>();
        List<Integer> special0 = new ArrayList<Integer>();
        List<Integer> special1 = new ArrayList<Integer>();
        Collections.addAll(special0,1,1,0,0);
        Collections.addAll(special1,2,2,1,0);
        Collections.addAll(special, special0, special1);

        List<Integer> needs = new ArrayList<>();
        Collections.addAll(needs, 1,1,1);

        int result = shoppingOffers(price, special, needs);


        System.out.println(price);
        System.out.println(special);
        System.out.println(needs);
        System.out.println(result);
    }

    static Map<List<Integer>, Integer> memo = new HashMap<>();
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        int n = price.size();
        List<List<Integer>> filterSpecial = new ArrayList<>();
        for(List<Integer> sp : special){
            int totalCount = 0, totalPrice = 0;
            for(int i = 0; i < n; ++i){
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if(totalCount > 0 && totalPrice > sp.get(n)){
                filterSpecial.add(sp);
            }
        }
        return dfs(price, special, needs, filterSpecial, n);
    }

    public static int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n){
        if(!memo.containsKey(curNeeds)){
            int minPrice = 0;
            for(int i = 0; i < n; ++i){
                minPrice += curNeeds.get(i) * price.get(i);
            }
            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nxtNeeds = new ArrayList<>();
                for (int i = 0; i < n; ++i) {
                    if(curSpecial.get(i) > curNeeds.get(i))
                        break;
                    nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if(nxtNeeds.size() == n){
                    minPrice = Math.min(minPrice, dfs(price, special, nxtNeeds, filterSpecial, n) + specialPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }
}

